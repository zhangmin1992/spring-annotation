package day04TypeFilter;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import day03ComponentScan.BookDao;

/**
 * 自定义过滤规则
 * @author yp-tc-m-7129
 *
 */
public class MyTypeFilter implements TypeFilter {

	/**
	 * MetadataReader读取到的当前正在扫描的类的信息
	 * MetadataReaderFactory 可以获取其他任何类的信息
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory factory)
			throws IOException {
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata =  metadataReader.getAnnotationMetadata();
		
		//获取当前类的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		//获取类资源信息，比如路径
		Resource resource = metadataReader.getResource();
		
//		MetadataReader otherReader = factory.getMetadataReader(BookDao.class);
//		System.out.println(otherReader.getAnnotationMetadata().getClassName());
		
		String className = classMetadata.getClassName();
		System.out.println("在包下可以被扫描的类:"+ className + "当前扫描类的父类:"+ classMetadata.getSuperClassName());
		
		if(className.contains("Dao")) {
			return true;
		}
		return false;
	}

}
