package day49ForMybatisDiscriminator;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

import day49ForMybatisDiscriminator.entity.AccDiscriminator;
import day49ForMybatisDiscriminator.enums.EnabledEnum;


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
	
	功能点2:mybatis枚举适配器
	1.xml写法
	<result column="person_type" property="personType"/>
	直接使用报错：
	Caused by: java.lang.IllegalArgumentException: No enum constant day49ForMybatisDiscriminator.EnabledEnum.0
	需要做的方法一：mybatis自带的枚举处理器推荐！！
	 1.mybatis-config配置文件添加适配器
	<typeHandlers>
		<typeHandler javaType="day49ForMybatisDiscriminator.EnabledEnum" handler="org.apache.ibatis.type.EnumOrdinalTypeHandler"/>
	</typeHandlers>
	2.spring 引入mybatis-config配置文件，注释掉mybatis配置文件的<mappers>,否则提示重复引入了xml文件！！
	<property name="configLocation" value="classpath:mybatisConfig.xml"/>
	3.不需要修改任何原生的xml文件，resultmap和更新接口都不需要修改
	
	需要做的方法二：自定义的枚举器，不推荐！！
	想在mapper.xml中使用我们自定义的枚举处理器那么就需要在每一个用到枚举的地方都得加一个typeHandler="com.chrhc.mybatis.handler.EnumHandler",相当的不方便
	1.spring的配置文件中不引入mybatis配置文件，不需要删除mappers配置
	2.修改xml，添加typeHandler 和 javaType
	<result column="person_type" 
	  typeHandler="org.apache.ibatis.type.EnumOrdinalTypeHandler" 
      javaType="day49ForMybatisDiscriminator.EnabledEnum" 
      jdbcType="VARCHAR" />
    3.修改更新接口的typeHandler
    update acc_discriminator
    <set>
    <if test="personType != null">
        person_type = #{personType,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler},
    </if>
	
	功能点3:万能适配器
	mybatis本身提供了EnumTypeHandler和EnumOrdinalTypeHandler用来做枚举类型处理，但是不是很灵活，
	EnumTypeHandler是把枚举的名字和枚举之间做了一个映射，
	EnumOrdinalTypeHandler是把枚举的ordinary也就是顺序和枚举之间做了一个映射。
	超出这两种情况，就需要自己动手了，但是自定义的枚举适配器有需要修改原生的xml文件，在每个用到person_type的地方加一个typeHandler很不方便！
    需要做的：
    1.xml不修改：<result column="person_type" property="personType"/>
    2.不引入mybatis-config配置文件
    3.自己重写一个sqlsessionFactory
    4.配置自己sqlsessionFactory的属性
    
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
//		System.out.println(JSONObject.toJSONString(accDiscriminatorMapper.selectByPrimaryKey(1L)));
//		System.out.println(JSONObject.toJSONString(accDiscriminatorMapper.selectByPrimaryKey(2L)));
		
		AccDiscriminator model = accDiscriminatorMapper.selectByPrimaryKey(1L);
		model.setName("方法333345");
		model.setPersonType(EnabledEnum.WX);
		accDiscriminatorMapper.updateByPrimaryKeySelective(model);
		context.close();
        
	}
}
