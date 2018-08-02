package day00ForCicleDependOn;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * spring 的循环依赖有两种方式，属性循环引用和构造器循环依赖
 * 属性循环引用是可以自动被spring容器解决的，这取决于bean的三级缓存和提前曝光，比如 a->b>c->a依赖中
 * getSingleton(A,true)部分代码看下:
 * protected Object getSingleton(String beanName, boolean allowEarlyReference) {
		Object singletonObject = this.singletonObjects.get(beanName);
		if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
			synchronized (this.singletonObjects) {
				singletonObject = this.earlySingletonObjects.get(beanName);
				if (singletonObject == null && allowEarlyReference) {
					ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
					if (singletonFactory != null) {
						singletonObject = singletonFactory.getObject();
						this.earlySingletonObjects.put(beanName, singletonObject);
						this.singletonFactories.remove(beanName);
					}
				}
			}
		}
		return (singletonObject != NULL_OBJECT ? singletonObject : null);
	}
 * A doGetBean->一级缓存中获取A为null,A没有正在创建，直接返回null，->标记A正在被创建-》获取null的代理对象-》
 *   doCreateBean(beanName, mbdToUse, args);-》createBeanInstance()创建bean实例-》将bean实例提前曝光到三级缓存中-》属性赋值，发现自己依赖B
 *   
 * B doGetBean一级缓存中获取A为null,B没有正在创建，直接返回null，->标记B正在被创建-》获取null的代理对象-》
 *   doCreateBean(beanName, mbdToUse, args);-》bean实例-》将bean实例提前曝光到三级缓存中-》属性赋值，发现自己依赖C
 *   
 * C doGetBean一级缓存中获取A为null,C没有正在创建，直接返回null，->标记B正在被创建-》获取null的代理对象-》
 *   doCreateBean(beanName, mbdToUse, args);-》bean实例-》将bean实例提前曝光到三级缓存中-》属性赋值，发现自己依赖A，
 *   于是尝试get(A)，一级缓存二级缓存都没有，但是三级缓存中有A，拿到了A不再重新创建-》-》进行C的初始化操作-
 *   》完全初始化之后将自己放入到一级缓存singletonObjects中,三级缓存移除
 *   
 * 此时返回B中，B此时能拿到C的对象顺利完成自己的初始化阶段2、3，最终B也完成了初始化，进去了一级缓存singletonObjects中
 * 此时返回A中，A此时能拿到C的对象顺利完成自己的初始化阶段2、3，最终A也完成了初始化，进去了一级缓存singletonObjects中
 * 
 * 属性依赖是调用默认构造器进行bean的实例化操作，在属性赋值阶段发现依赖对象，从而创建其依赖对象的
 * 构造器依赖将不会使用默认构造器，根本无法完成各个bean的实例化，会报错bean循环依赖
 * org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'a': 
 * Requested bean is currently in creation: Is there an unresolvable circular reference?
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("day00ForCicleDependOn");
		/*String[] namesString = context.getBeanDefinitionNames();
    	for (String name : namesString) {
			System.out.println("----------"+name);
		}*/
//		System.out.println("----"+context.getApplicationName());
		Controller result = context.findAnnotationOnBean("myController", Controller.class);
		Controller result2 = context.findAnnotationOnBean("88", Controller.class);
		System.out.println("----end-----");
    	
    	
	}
}
