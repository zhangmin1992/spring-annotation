package day03ComponentScan;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import day04TypeFilter.MyTypeFilter;

/**
 * 配置类==配置文件，注意要在spring容器加载的包下
 * @author yp-tc-m-7129
 *
 */
@Configurable
/**
 * 默认扫描当钱包和子包下的文件
 */
//@ComponentScan

//@ComponentScan(value="day03ComponentScan")
/**
 * 即使在包下也不扫描包下的指定文件,排除注解,注解类型是@Controller
 * @author yp-tc-m-7129
 *
 */
//@ComponentScan(value="day03ComponentScan",excludeFilters={@Filter(type=FilterType.ANNOTATION,classes={Controller.class})})

/**
 * includeFilters只扫描包下的指定@Controller的文件,注意这个时候需要关掉自动过滤器useDefaultFilters=false
 * @author yp-tc-m-7129
 */
//@ComponentScan(value="day03ComponentScan",includeFilters={@Filter(type=FilterType.ANNOTATION,classes={Controller.class})},useDefaultFilters=false)

/**
 * 试图使用@ComponentScans失败，发现不管用，而且这种方式看起来好麻烦，那我还是用哪个jdk版本都支持的,分割方式吧
 * @author yp-tc-m-7129
 *
 */
//@ComponentScans(value={@ComponentScan(value="day03ComponentScan")
////,@ComponentScan(value="day04TypeFilter")
//})
//@ComponentScan(value="day03ComponentScan,day04TypeFilter")

/**
 * day04详细讲解FilterType的类型
    ANNOTATION,
	ASSIGNABLE_TYPE,
	ASPECTJ,
	REGEX,
	CUSTOM
	
 * ANNOTATION @Controller加入
 * ASSIGNABLE_TYPE 指定类型加入
 * CUSTOM自定义规则
 * @author yp-tc-m-7129
 *
 */
//@ComponentScan(value="day03ComponentScan",includeFilters={
//				@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
//				@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookDao.class}),
//				@Filter(type=FilterType.CUSTOM,classes=MyTypeFilter.class)
//			}
//,useDefaultFilters=false)
public class BeanConfig {

	 
}
