package day25Transaction.test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackages="day25Transaction.test")
@Configurable
@EnableAspectJAutoProxy
//@Import(MyImportBeanDefinitionRegistrar.class)
@ImportResource("classpath:beans.xml")
public class BeanConfig {

}
