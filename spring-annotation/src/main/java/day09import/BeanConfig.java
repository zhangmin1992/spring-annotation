package day09import;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

/**
 * 配置类==配置文件，注意要在spring容器加载的包下
 * @author yp-tc-m-7129
 *
 */
@Configurable
/**
 * 使用Import的3中方法
 * @author yp-tc-m-7129
 *
 */
//@Import({Dog.class})
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistrar.class)
public class BeanConfig {

	/*@Conditional(MyCondition.class)
	@Bean
	public Dog dog() {
		return new Dog();
	}*/
}
