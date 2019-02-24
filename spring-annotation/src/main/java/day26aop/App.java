package day26aop;

import org.springframework.aop.TargetSource;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * aop 可以在程序运行期间，动态的将某段代码插入到指定方法中，日志等
 * 使用步骤:
 * 1.定义有方法的bean，写上方法
 * 2.定义一个切面类
 * 3.指出切面类的切点，切的方法何时运行
 * 4.定义的这两个都加入到容器中
 * 5.告诉spring哪个类是切面类
 * 6.开启基于直接的aop,@EnableAspectJAutoProxy
 * 
 * Aop原理的:
 * 从注解开始看,注解@EnableAspectJAutoProxy，他引入的组件AspectJAutoProxyRegistrar实现了接口ImportBeanDefinitionRegistrar
 * 这个接口的返回值将被动态加载到spring容器中去的，具体参考day09 IMPORT
 * 1.给容器中注册(import注解)一个组件AnnotationAwareAspectJAutoProxyCreator，也就是自动代理创建器
 * 2。这个组件什么时候工作，有什么功能，来看一下关系树
 *    AnnotationAwareAspectJAutoProxyCreator extends AspectJAwareAdvisorAutoProxyCreator
 *                                                   AspectJAwareAdvisorAutoProxyCreator extends AbstractAdvisorAutoProxyCreator
 *                                                               AbstractAdvisorAutoProxyCreator extends AbstractAutoProxyCreator
 *                                                                  class AbstractAutoProxyCreator extends ProxyProcessorSupport
		implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *
 * 理清继承关系后，主要实现是SmartInstantiationAwareBeanPostProcessor（后置处理器），BeanFactoryAware(自动注入beanFactory)
 * 能够让这个类参与到bean初始化功能,并为bean添加代理功能的还是因为它实现了BeanPostProcessor这个接口
 * 
 * AbstractAutoProxyCreator有哪些呢？
 * 有后置处理器逻辑:
 * public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
 * 有setbeanfactory
 * 
 * AbstractAdvisorAutoProxyCreator有哪些？
 * 重写了setbeanfactory：
 * public void setBeanFactory(BeanFactory beanFactory) {
		super.setBeanFactory(beanFactory);
		if (!(beanFactory instanceof ConfigurableListableBeanFactory)) {
			throw new IllegalStateException("Cannot use AdvisorAutoProxyCreator without a ConfigurableListableBeanFactory");
		}
		initBeanFactory((ConfigurableListableBeanFactory) beanFactory);
	}
 * 
 * AspectJAwareAdvisorAutoProxyCreator有那些呢？没有
 * AnnotationAwareAspectJAutoProxyCreator有哪些呢?
 * 
 * 
 * aop原理主要流程有:
 * 创建ioc容器
 * 注册配置类
 * refush()刷新容器 中有 注册拦截bean创建的bean处理器步骤
 * bean的装在过程
 *   其中有创建bean的实例
 *   给bean的属性赋值
 *   初始化bean
 *     1)invokeAwareMethods 如果bean实现了Aware接口则对其进行处理
 *     2）applyBeanPostProcessorsBeforeInitialization 在bean初始化之前调用后置处理器
 *     3）invokeinitMethods 执行自定义的初始化方法
 *     4) applyBeanPostProcessorsAfterInitialization bean初始化后执行后置处理的方法
 *   bean创建成功
 *   把bean注册到beanFactory中
 * ======以上是创建和注册的过程======
 * 
 * public static void registerBeanPostProcessors(
			ConfigurableListableBeanFactory beanFactory, AbstractApplicationContext applicationContext) {
		//获取ioc容器按照类型所有需要创建的后置处理器，其中就有org.springframework.aop.config.internalAutoProxyCreator
		String[] postProcessorNames = beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);

		// Register BeanPostProcessorChecker that logs an info message when
		// a bean is created during BeanPostProcessor instantiation, i.e. when
		// a bean is not eligible for getting processed by all BeanPostProcessors.
		int beanProcessorTargetCount = beanFactory.getBeanPostProcessorCount() + 1 + postProcessorNames.length;
		beanFactory.addBeanPostProcessor(new BeanPostProcessorChecker(beanFactory, beanProcessorTargetCount));

	    //对捕获到的BeanPostProcessors做一些处理，实现了PriorityOrdered的和实现了Ordered和都没有实现的
		List<BeanPostProcessor> priorityOrderedPostProcessors = new ArrayList<BeanPostProcessor>();
		List<BeanPostProcessor> internalPostProcessors = new ArrayList<BeanPostProcessor>();
		List<String> orderedPostProcessorNames = new ArrayList<String>();
		List<String> nonOrderedPostProcessorNames = new ArrayList<String>();
		for (String ppName : postProcessorNames) {
			if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
				BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class);
				priorityOrderedPostProcessors.add(pp);
				if (pp instanceof MergedBeanDefinitionPostProcessor) {
					internalPostProcessors.add(pp);
				}
			}
			else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
				orderedPostProcessorNames.add(ppName);
			}
			else {
				nonOrderedPostProcessorNames.add(ppName);
			}
		}

		// 首先，注册实现PriorityOrdered的BeanPostProcessors。
		sortPostProcessors(beanFactory, priorityOrderedPostProcessors);
		registerBeanPostProcessors(beanFactory, priorityOrderedPostProcessors);

		// 接下来，注册实现Ordered的BeanPostProcessors。如果不存在名字(org.springframework.aop.config.internalAutoProxyCreator)的bean就创建bean
		List<BeanPostProcessor> orderedPostProcessors = new ArrayList<BeanPostProcessor>();
		for (String ppName : orderedPostProcessorNames) {
			BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class);
			orderedPostProcessors.add(pp);
			if (pp instanceof MergedBeanDefinitionPostProcessor) {
				internalPostProcessors.add(pp);
			}
		}
		sortPostProcessors(beanFactory, orderedPostProcessors);
		registerBeanPostProcessors(beanFactory, orderedPostProcessors);

		// 现在，注册所有常规BeanPostProcessors。
		List<BeanPostProcessor> nonOrderedPostProcessors = new ArrayList<BeanPostProcessor>();
		for (String ppName : nonOrderedPostProcessorNames) {
			BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class);
			nonOrderedPostProcessors.add(pp);
			if (pp instanceof MergedBeanDefinitionPostProcessor) {
				internalPostProcessors.add(pp);
			}
		}
		registerBeanPostProcessors(beanFactory, nonOrderedPostProcessors);

		// 最后，重新注册所有内部BeanPostProcessors。
		sortPostProcessors(beanFactory, internalPostProcessors);
		registerBeanPostProcessors(beanFactory, internalPostProcessors);

		beanFactory.addBeanPostProcessor(new ApplicationListenerDetector(applicationContext));
	}
 * 
 * 
 * public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

	    //参加下面注释1：实际实现方法（如果不存在bean就创建AnnotationAwareAspectJAutoProxyCreator（自动代理创建器））
		AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);

		//EnableAspectJAutoProxy 类所在的注解属性,@EnableAspectJAutoProxy有两个属性proxyTargetClass exposeProxy
		AnnotationAttributes enableAspectJAutoProxy =
				AnnotationConfigUtils.attributesFor(importingClassMetadata, EnableAspectJAutoProxy.class);
		if (enableAspectJAutoProxy.getBoolean("proxyTargetClass")) {
			AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
		}
		if (enableAspectJAutoProxy.getBoolean("exposeProxy")) {
			AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
		}
	}
	
	//注释1：
	private static BeanDefinition registerOrEscalateApcAsRequired(Class<?> cls, BeanDefinitionRegistry registry, Object source) {
		Assert.notNull(registry, "BeanDefinitionRegistry must not be null");
		//如果包含名字的bean
		if (registry.containsBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME)) {
			BeanDefinition apcDefinition = registry.getBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME);
			if (!cls.getName().equals(apcDefinition.getBeanClassName())) {
				int currentPriority = findPriorityForClass(apcDefinition.getBeanClassName());
				int requiredPriority = findPriorityForClass(cls);
				if (currentPriority < requiredPriority) {
					apcDefinition.setBeanClassName(cls.getName());
				}
			}
			return null;
		}
		//创建AnnotationAwareAspectJAutoProxyCreator.class，注册到registry中
		RootBeanDefinition beanDefinition = new RootBeanDefinition(cls);
		beanDefinition.setSource(source);
		beanDefinition.getPropertyValues().add("order", Ordered.HIGHEST_PRECEDENCE);
		beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		registry.registerBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME, beanDefinition);
		return beanDefinition;
	}
 */

/**
 * SmartInstantiationAwareBeanPostProcessor 最终继承了BeanPostProcessor，里面有2个方法
 * Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;
 * Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
 * 
 * 4.完成beanfactory的初始化工作步骤:
 *  1)遍历获取容器中所有bean,依次创建对象
 *  2)getbean()-》dogetbean()-》getsingle()->创建bean
 *    从缓存中获取bean，如果获取到说明bean已经被创建了直接使用，否则再创建，这样保证了单实例bean只会被创建一次，所有单实例bean都会被缓存起来
 *    希望后置处理器能返回一个代理对象，如果不能返回再dogetbean，创建一个真正的bean实例
 * 
 * @author yp-tc-m-7129
 *
 */
/**
 *  1.获取ioc容器中已经定义的需要创建的所有后置处理器，会获取到之前定义的AnnotationAwareAspectJAutoProxyCreator
	2.给容器中加一些其他的后置处理器
	3.对所有的后置处理器做分类
	3.1先对实现了PriorityOrdered接口的处理器保存在internalPostProcessors中
	3.2对实现了Ordered接口的处理器保存在orderedPostProcessorNames中，其中		AnnotationAwareAspectJAutoProxyCreator实现了order接口
	3.3其他处理器添加到nonOrderedPostProcessorNames中
	4.对实现了PriorityOrdered接口的处理器排序，注册到beanFactory中
	5.对实现了Ordered接口的处理器排序，注册到beanFactory中
	6.注册普通处理器
	注册后置处理器实际上就是创建后置处理器对象保存在容器中
 */
/**
 *  在每一个bean创建之前都会调用postProcessBeforeInstantiation，进入到顶层AbstractAutoProxyCreator的postProcessBeforeInstantiation方法
 *  步骤:这里只关注配置类定义的bean，1-3参见注释前置，5参加注释后置
 *  1.判断bean是否包含在targetSourcedBeans中，targetSourcedBeans包含了所有需要增强的bean
 *  2.判断这个bean是否是实现了接口Advice，Pointcut，AopInfrastructureBean，Advisor或者是有Aspect注解
 *  3.是否跳过
 *    3.1 获取所有的增强器
 *    3.2判断增强器是否是AspectJPointcutAdvisor类型，是true，否则返回false
 *  4.创建对象
 *  5.postProcessAfterInitialization bean对象创建后的后置处理
 *   5.1 获取所有可用的增强器，也就是通知方法
 *       5.1.1 获取所有候选的增强器
 *       5.1.2 获取可应用到当前bean的增强器
 *       5.1.3 对增强器排序
 *   5.2将当前bean加入缓存advisedBeans
 *   5.3创建代理对象
 *     5.3.1获取所有增强器
 *     5.3.2增强器加入到proxyFactory
 *     5.3.3 创建代理对象(jdk或者cglib要看你的类是否实现了接口)
 *   5.4给容器返回当前组件使用cglib增强了的代理对象
 *   5.5以后容器中使用的就是这个代理对象，使用目标方法的时候就会使用代理对象的通知方法
 *   
 *   
 *  
 *  //注释前置 
 * 	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		Object cacheKey = getCacheKey(beanClass, beanName);

		if (beanName == null || !this.targetSourcedBeans.contains(beanName)) {
			if (this.advisedBeans.containsKey(cacheKey)) {
				return null;
			}
			if (isInfrastructureClass(beanClass) || shouldSkip(beanClass, beanName)) {
				this.advisedBeans.put(cacheKey, Boolean.FALSE);
				return null;
			}
		}

		// Create proxy here if we have a custom TargetSource.
		// Suppresses unnecessary default instantiation of the target bean:
		// The TargetSource will handle target instances in a custom fashion.
		if (beanName != null) {
			TargetSource targetSource = getCustomTargetSource(beanClass, beanName);
			if (targetSource != null) {
				this.targetSourcedBeans.add(beanName);
				Object[] specificInterceptors = getAdvicesAndAdvisorsForBean(beanClass, beanName, targetSource);
				Object proxy = createProxy(beanClass, beanName, specificInterceptors, targetSource);
				this.proxyTypes.put(cacheKey, proxy.getClass());
				return proxy;
			}
		}

		return null;
	}
	
	    //注释后置
		protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
		if (beanName != null && this.targetSourcedBeans.contains(beanName)) {
			return bean;
		}
		if (Boolean.FALSE.equals(this.advisedBeans.get(cacheKey))) {
			return bean;
		}
		if (isInfrastructureClass(bean.getClass()) || shouldSkip(bean.getClass(), beanName)) {
			this.advisedBeans.put(cacheKey, Boolean.FALSE);
			return bean;
		}

		// Create proxy if we have advice.
		Object[] specificInterceptors = getAdvicesAndAdvisorsForBean(bean.getClass(), beanName, null);
		if (specificInterceptors != DO_NOT_PROXY) {
			this.advisedBeans.put(cacheKey, Boolean.TRUE);
			Object proxy = createProxy(
					bean.getClass(), beanName, specificInterceptors, new SingletonTargetSource(bean));
			this.proxyTypes.put(cacheKey, proxy.getClass());
			return proxy;
		}

		this.advisedBeans.put(cacheKey, Boolean.FALSE);
		return bean;
	}
 * @author yp-tc-m-7129
 *
 */
/**
 * 目标方法的执行顺序
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
		MethodBean MethodBean = context.getBean(MethodBean.class);
		MethodBean.getNum(2);
	}
}
