package day48ForMybatisLayzyLoad;

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
 * 功能点1:mybatis懒加载，在需要实体A中的实体B的时候才展示实体B的信息，貌似还没有get过了会他自己就有了
 * 
 * 1.没有使用懒加载，sql语句做了一个left join resultmap 多了一个映射的关联
 *  <!-- 欠套查询部分写法一：没有使用懒加载 -->
   <resultMap id="getOrderMap2" type="day48ForMybatisLayzyLoad.AccOrders">
     <id column="id" property="id"/>
     <result column="order_name" property="orderName"/>
     <collection property="accUser" 
     resultMap="day48ForMybatisLayzyLoad.AccUserMapper.BaseResultMap"/>
  </resultMap>
  <select id="getOrderByPrimaryKey2" parameterType="java.lang.Integer"
   resultMap="getOrderMap2">
    select 
    mm.*,nn.*
    from acc_orders mm
    LEFT join acc_user nn on mm.user_id=nn.id
    where mm.id = #{id,jdbcType=INTEGER}
  </select>
  引入的是另一个xml文件中的resultmap
  <mapper namespace="day48ForMybatisLayzyLoad.AccUserMapper">
  <resultMap id="BaseResultMap" type="day48ForMybatisLayzyLoad.AccUser">
    <constructor>
      <idArg column="id" javaType="java.lang.Integer" jdbcType="INTEGER" />
      <arg column="sex" javaType="java.lang.String" jdbcType="VARCHAR" />
      <arg column="name" javaType="java.lang.String" jdbcType="VARCHAR" />
    </constructor>
  </resultMap>
  
  2.使用懒加载，关联字段是一个user_id的时候，采用association标签实现懒加载
  <!-- 懒加载部分 -->
  <sql id="mylist">
    id, order_name, user_id
  </sql>
  <resultMap id="getOrderMap" type="day48ForMybatisLayzyLoad.AccOrders">
     <id column="id" property="id"/>
     <result column="order_name" property="orderName"/>
     <association 
     fetchType="lazy" 
     property="accUser" 
     javaType="day48ForMybatisLayzyLoad.AccUser"  
     column="user_id" 
     select="day48ForMybatisLayzyLoad.AccUserMapper.selectByPrimaryKey"></association>
  </resultMap>
  <select id="getOrderByPrimaryKey" parameterType="java.lang.Integer" resultMap="getOrderMap">
    select 
    <include refid="mylist" />
    from acc_orders
    where id = #{id,jdbcType=INTEGER}
  </select>
  
  3.使用懒加载，关联字段是一个user_id的时候，采用association标签实现懒加载
  <resultMap id="getOrderMap3" type="day48ForMybatisLayzyLoad.AccOrders">
     <id column="id" property="id"/>
     <result column="order_name" property="orderName"/>
     <collection
     property="accUser" 
     ofType="day48ForMybatisLayzyLoad.AccUser"
     column="user_id" 
     select="day48ForMybatisLayzyLoad.AccUserMapper.selectByPrimaryKey"/>
  </resultMap>
  
  4.使用懒加载，关联字段是多个字段的时候user_id的时候，采用association标签实现懒加载
  <!-- column="{id=user_id,name=order_name}" 中表示
  id，name表示 调用的select的查询的参数值， #{name,jdbcType=VARCHAR}
  user_id，order_name 表示调用的AccOrdersMapper xml中的数据库字段
   -->
  <resultMap id="getOrderMap4" type="day48ForMybatisLayzyLoad.AccOrders">
     <id column="id" property="id"/>
     <result column="order_name" property="orderName"/>
     <collection
     property="accUser" 
     ofType="day48ForMybatisLayzyLoad.AccUser"
     column="{id=user_id,name=order_name}" 
     select="day48ForMybatisLayzyLoad.AccUserMapper.selectByName"/>
  </resultMap>
   <select id="selectByName" resultMap="BaseResultMap" >
    select 
    <include refid="Base_Column_List" />
    from acc_user
    where id = #{id,jdbcType=INTEGER}
    and name = #{name,jdbcType=VARCHAR}
  </select>
  
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 22, 2019 3:48:19 PM
 */
public class App {

	public static void main(String[] args) throws IOException {
		//1.加载spring配置文件
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextForDay48.xml");
		System.out.println(JSONObject.toJSONString(context.getBeanDefinitionNames()));
		
		//2.获取bean，相当于controlelr层注入AccTableServiceImpl的操作
		AccUserMapper accUserMapper = context.getBean(AccUserMapper.class);
		System.out.println(JSONObject.toJSONString(accUserMapper.selectByPrimaryKey(1)));
		AccOrdersMapper accOrdersMapper = context.getBean(AccOrdersMapper.class);
		//System.out.println(JSONObject.toJSONString(accOrdersMapper.selectByPrimaryKey(1)));
		
		//3.查询订单1得到 订单1是谁的订单--association 标签
//		AccOrders accOrders = accOrdersMapper.getOrderByPrimaryKey(1);
//		System.out.println("你别出来了！");
//		System.out.println(accOrders.getAccUser());
//		System.out.println(JSONObject.toJSONString(accOrders));
		
		//4.欠套查询，只有一个字段的情况，没有使用懒加载
//		AccOrders accOrders = accOrdersMapper.getOrderByPrimaryKey2(1);
//		System.out.println(JSONObject.toJSONString(accOrders));
		
		//5.欠套查询，只有一个字段的情况，使用懒加载--collection
//		AccOrders accOrders = accOrdersMapper.getOrderByPrimaryKey3(1);
//		System.out.println(JSONObject.toJSONString(accOrders));
		
		//6.欠套查询，多个字段的情况，使用懒加载--collection
		/**
		 * column="{id=user_id,name=order_name}"  中表示
		   id，name表示 调用的select的查询的参数值
		   user_id，order_name 表示查询的语句getOrderByPrimaryKey4 中的返回的字段值
		 */
//		System.out.println(accUserMapper.selectByName(1, "王海兴订单"));
//		AccOrders accOrders = accOrdersMapper.getOrderByPrimaryKey4(1);
//		System.out.println(JSONObject.toJSONString(accOrders));
		context.close();
        
	}
}
