package day11ForJidong;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor  implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("--------------MyBeanFactoryPostProcessor---------------");
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("profile.properties");
		Properties  prop = new Properties();
        try {
			prop.load(is);
			System.out.println("-----"+prop.getProperty("redis"));
		} catch (IOException e) {
		}
	}

}
