package day45ForMyvatisSource;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

import day45ForMyvatisSource.dao.AccTable2Mapper;
import day45ForMyvatisSource.entity.AccTable2;
import day45ForMyvatisSource.service.impl.AccTableServiceImpl;

/**
 * 功能点1: mybaits 整合Spring功能，带有语句打印日志功能
 *  1.编写applicationContext.xml，需要修改数据库datasource类型和连接
 *  2.引入log4j.properties，设置语句类型是DEBUG，log4j.logger.day45ForMyvatisSource.dao =TRACE
 *  3app测试
 *  
 *  企图通过加载log4j-2.properties来实现日志打印功能，发现不可以，
 *  名称必须是log4j.properties，
 *  并且log4j.logger.day45ForMyvatisSource.dao其中的包必须为当前包
 *  
 *  功能2:spring整合mybatis自动转化驼峰
 *  1.mybatisConfig配置中加了一句话
 *  2.加载了mybatisConfig.xml文件，INFO [org.springframework.beans.factory.xml.XmlBeanDefinitionReader] -Loading XML bean definitions from class path resource [mybatisConfig.xml]
 *  3.这句话单独使用可以自动转驼峰，但是spring整合的时候不管用吧
 *  
 *  功能点3:foreach 的数组和集合的批量插入
 *  
 *  功能点4:批量插入返回主键
 *  条件 
 *  1.mybatis版本号3.4以上
 *  2.dao 层不能有注解
 *  3.xml有这两句话
 *  parameterType="java.util.List" useGeneratedKeys="true" keyProperty="id" >   
 *  <foreach collection="list" item="acc" separator=",">
 *  
 *  功能点5：mapper中直接返回map，
 *  实现方式一：注解@MapKey
 *  返回值是Map<Date,Map<Date,String>>，需要用@MapKey("holiday_date")注解指定谁是额外的那个key即可
 *  方式二：使用注解，返回结果是map的实体
 *  方式三：返回list<map>不推荐！
 *  同时需要map中获取date的key的时候，new date()是当前时间戳，是获取不到的，需要转化为指定日期格式的去查询
 *  DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date dd1 =  sdf.parse("2019-05-07");
	
	功能点6：批量更新
 *  
 *  
 *  
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 19, 2019 3:16:59 PM
 */
public class App {

	public static void main(String[] args) throws IOException, ParseException {
		//1.加载spring配置文件
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(JSONObject.toJSONString(context.getBeanDefinitionNames()));
		//2.获取bean，相当于controlelr层注入AccTableServiceImpl的操作
		AccTableServiceImpl accTableService = context.getBean(AccTableServiceImpl.class);
		AccTable2Mapper accTable2Mapper = context.getBean(AccTable2Mapper.class);
		
		//3.调用，打印sql语句日志
//		AccTable2 accTable = accTableService.getById(1);
//		System.out.println(JSONObject.toJSONString(accTable));
		
		//4.插入返回主键
		//AccTable2 accTable2 = new AccTable2(new Date(), "6666");
		//int result = accTableService.insert(accTable2);
		//System.out.println(JSONObject.toJSONString(accTable2));
		//System.out.println("返回的数据是"+result);
		
		//5.多参数查询方式一
		//AccTable2 accTable3 = accTableService.selectByActivityName("888", 1);
		//System.out.println("--"+JSONObject.toJSONString(accTable3));
		
		//6.foreach标签的使用-数组-同一个xml
		//List<AccTable2> list = accTable2Mapper.selectByIds(new String[] {"10","71","77"});
		//System.out.println(JSONObject.toJSONString(list));
		
		//7.foreach标签的使用-集合-同一个xml
//		ArrayList<String> tempArrayList = new ArrayList<String>();
//		tempArrayList.add("10");
//		tempArrayList.add("71");
//		tempArrayList.add("77");
//		List<AccTable2> list2 = accTable2Mapper.selectByIds(tempArrayList);
//		System.out.println(JSONObject.toJSONString(list2));
		
		//8批量插入
//		ArrayList<AccTable2> list3 = new ArrayList<AccTable2>();
//		list3.add(new AccTable2(new Date(), "113"));
//		list3.add(new AccTable2(new Date(), "114"));
//		int result = accTable2Mapper.batchInsert(list3);
//		System.out.println("result="+ result);
		
		//9.批量插入返回主键
//		ArrayList<AccTable2> list3 = new ArrayList<AccTable2>();
//		list3.add(new AccTable2(new Date(), "113"));
//		list3.add(new AccTable2(new Date(), "114"));
//		int result = accTable2Mapper.batchInsert2(list3);
//		System.out.println("result="+ result);
//		System.out.println("批量插入后返回主键列表是 " + JSONObject.toJSONString(list3));
		
		//10.分组然后返回map，只推荐方式二，方式一获取map中的数据不方便，方式三返回list<map>不推荐，方式二获取数据好
		//方式三：返回List<Map<String,String>>，map无法根据key获取不推荐！！
//		List<Map<String,String>> map = accTable2Mapper.groupByAndReturnMap();
//		System.out.println("是 " + JSONObject.toJSONString(map));
		//方式一注解，结果是Map<Date,Map<Date,String>>
//		Map<Date,Map<Date,String>> map = accTable2Mapper.groupByAndReturnMap2();
//		System.out.println("是 " + JSONObject.toJSONString(map));
//		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date dd1 =  sdf.parse("2019-05-17");
//		System.out.println(dd1.getTime());
//		System.out.println(JSONObject.toJSONString(map.get(dd1)));
//		System.out.println(map.get(dd1).get("activity_name"));
		//方式二注解，结果是多条map
//		Map<Date,AccTableTemp> map = accTable2Mapper.groupByAndReturnMap3();
//		System.out.println("是 " + JSONObject.toJSONString(map));
//		System.out.println(map.get("2019-05-17").getName());
		
		//批量更新
		List<AccTable2> lists = accTable2Mapper.selectByIds(new String[] {"10","71","77"});
		lists.get(0).setActivityName("112221name");
		lists.get(1).setActivityName("222222name");
		lists.get(2).setActivityName("3222233name");
		accTable2Mapper.batchUpdateByPrimaryKey(lists);
		List<AccTable2> lists2 = accTable2Mapper.selectByIds(new String[] {"10","71","77"});
		System.out.println(JSONObject.toJSONString(lists2));
		
//		AccTable2 accTable2 = accTable2Mapper.selectByChar("cccc");
//		System.out.println(JSONObject.toJSONString(accTable2));
//		System.out.println(accTable2.getActivityName2().equals("cccc"));
//		System.out.println(accTable2.getActivityName2().trim().equals("cccc"));
		context.close();
	}
}
