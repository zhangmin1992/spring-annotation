package day49ForMybatisDiscriminator;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

import day45ForMyvatisSource.dao.AccTable2Mapper;
import day45ForMyvatisSource.service.impl.AccTableServiceImpl;

/**
 *   功能点1:mybatis 鉴别器，数据库中包含了男性和女性的所有字段，根据性别判断，
 *   发现是男性的时候，输出男性字段信息，女性的时候，输出女性字段信息
 *   
 *   1.主️实体中有共性name，女性实体继承主实体，男性实体继承主实体有男性特征
 *   2.xml文件使用鉴别器
 *   <discriminator javaType="int" column="person_type">
			<case value="0" resultMap="manResult"/>
			<case value="1" resultMap="womanResult"/>
	 </discriminator>
	 3.resultMap中的值是：
	 <resultMap id="manResult" type="day49ForMybatisDiscriminator.AccDiscriminatorMan">
		<result property="prostate" column="prostate" />
	</resultMap>
	<resultMap id="womanResult" type="day49ForMybatisDiscriminator.AccDiscriminatorWoman">
		<result property="womb" column="womb"/>
	</resultMap>
	4.查询语句是select  * from acc_discriminator
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 22, 2019 3:48:19 PM
 */
public class App {

	public static void main(String[] args) throws IOException {
		//1.加载spring配置文件
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextForDay49.xml");
		System.out.println(JSONObject.toJSONString(context.getBeanDefinitionNames()));
		
		//2.获取bean，相当于controlelr层注入AccTableServiceImpl的操作
		AccDiscriminatorMapper accDiscriminatorMapper = context.getBean(AccDiscriminatorMapper.class);
		System.out.println(JSONObject.toJSONString(accDiscriminatorMapper.selectByPrimaryKey(1L)));
		System.out.println(JSONObject.toJSONString(accDiscriminatorMapper.selectByPrimaryKey(2L)));
		context.close();
        
	}
}
