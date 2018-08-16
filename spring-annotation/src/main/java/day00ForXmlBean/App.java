package day00ForXmlBean;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * xml方式让bean加入到spring容器中的源码解析
 * 主要步骤猜测：
 * 1.读取配置文件
 * 2.根据配置文件的配置找到对应的类的位置，并实例化
 * 3.调用实例化后的实例
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {
		/**
		 * 使用xml方式来获取bean，bean的名字和xml中定义的名字要一致
		 */
		/*ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
		Person bean = (Person) applicationContext.getBean("xmlPersonName");
		bean.sayName();*/
		
		/**
		 * spring把资源文件封装成统一的Resource进行管理，和提供一些基本的方法
		 * 对于不同来源的资源文件都有相应的Resource实现：
				文件                   ：FileSystemResource.class
				Classpath资源     ：ClassPathResource.class
				URL资源             ：UrlResource.class
				InputStream资源 ：InputStreamResource.class
				Byte数组            ：ByteArrayResource.class
		 */
		/**
		 * ApplicationContext是在XmlBeanFactory基础上的扩展,前者拥有后者的全部功能,而且在其基础上做了封装.
		 * 在ApplicationContext初始化的过程中,它是获得了BeanFactory的示例
		 */
		Resource resource = new ClassPathResource("/beans.xml",App.class);
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
		Person bean = (Person) xmlBeanFactory.getBean("xmlPersonName");
		bean.sayName();
		
	}

}
