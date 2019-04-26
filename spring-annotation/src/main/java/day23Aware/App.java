package day23Aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 自定义组件想要使用spring底层，比如applicationContext或者自定义名称BeanNameAware或者解析指定内容的解析器EmbeddedValueResolverAware
 * 只需要实现对应的接口后，就会把我们的bean转成这个接口的，然后注入了ApplicationContext应用上下文
 * xxxAware 功能使用xxxProcessor
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
		context.getBean(MyAware.class);
	}
}
