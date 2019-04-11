package day09import;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportSelector implements ImportSelector {

	/**
	 * 返回值会被注入到spring容器中,注入的名字是类的全路径day09import.Dog
	 */
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{Dog.class.getName()};
	}
}
