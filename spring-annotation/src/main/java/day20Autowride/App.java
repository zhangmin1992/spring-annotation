package day20Autowride;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;

/**
 * 包扫描的方式
 * 1.有多个 UserDao,UserSerivce 注入这个UserDao的时候，有2个怎么解决?
 * @Autowired 先根据类型从组建中查找，如果找到多个，在根据id查找beanname,找到就返回
 * 找不到就返回多个错误:expected single matching bean but found 2: createUserDao,createUserDao2
 * 
 * 2.@Qualifier使用它来制定要装配的beanname而不是默认使用id的方式
 * @Autowired
   @Qualifier("createUserDao")
   
 *  3. @Primary 在配置类中指定最好加载哪个？
 *  4.使用continal注解，存在A就不创建B,存在B就不创建A
 *  5.@Resource(name="createUserDao2") private UserDao userDao;
 *    默认是id名，可以通过name指定加载的bean，注意有了Resource 注解就会按照指定名称来，不会按照@Primary来
 *  
 *  6.inject 和Autowired功能一致，两者都可以自动装配，就是inject没有属性required等
 *  Autowired 是spring的，inject 和Resource 是java规范，需要引入别的包javax.inject
 *  
 *   7.有就装配，没有就不装配
 *   @Autowired(required=false)
 *   
 *   8.@Autowired可以标记的位置，
 *   属性
 *   属性的set方法
 *   service的构造器上,只有一个有参数构造器的时候，@Autowired是可以省略了
 *   @Autowired
	 public UserSerivce(UserDao userDao) {
		this.createUserDao = userDao;
	 }
	 只有一个有参数构造器的时候，@Autowired是可以省略了
	 //@Autowired
	 public UserSerivce(UserDao userDao) {
		this.createUserDao = userDao;
	 }
 * 
 * Autowired 可以标记的地方是属性，方法，构造器，参数上
 * 方式一：构造器参数获取：如果组件只有一个有参构造器，这个有参构造器的第一个bean从容器中获取，参数上的Autowired可以省略
 * private car car;
 * public color(car car) {
 * this.car = car
 * }
 * 方式二：@bean标记的获取：
 * @bean
 * public color(car car) {
 *  color color = new Color()；
 *  color.setcar(car);
 *  return color;
 * }
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
		UserSerivce userSerivce = (UserSerivce)context.getBean(UserSerivce.class);
//		UserDao userDao = (UserDao)context.getBean("createUserDao2");
//		userDao.hello();
		userSerivce.show();
	}
}
