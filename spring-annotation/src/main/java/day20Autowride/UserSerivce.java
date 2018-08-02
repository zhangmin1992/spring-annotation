package day20Autowride;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserSerivce {

	/**
	 * 在配置类中注册多个，解决2个对象context.getBean(UserDao.class)报错的问题的2中方式二
	 */
	/*@Autowired
	@Qualifier("createUserDao")*/
	
	/**
	 * @Autowired 先根据类型从组建中查找，如果找到多个，在根据id查找beanname,找到就返回
	 * 找不到就返回多个错误:expected single matching bean but found 2: createUserDao,createUserDao2
	 * 
	 */
	/*@Autowired
	private UserDao createUserDao;*/
	
	/**
	 * 有就装配，没有就不装配
	 */
	//@Autowired(required=false)
	
	/**
	 * 默认是id名，可以通过name指定加载的bean，注意有了Resource 注解就会按照指定名称来，不会按照@Primary来
	 */
	/*@Resource(name="createUserDao2")*/
	
	/**
	 * inject 和Autowired功能一致，两者都可以自动装配，就是inject没有属性required等
	 * Autowired 是spring的，inject 和Resource 是java规范，需要引入别的包javax.inject
	 */
	
	private UserDao createUserDao;
	
	//@Autowired
	public UserSerivce(UserDao userDao) {
		this.createUserDao = userDao;
	}
	
	public void show() {
		createUserDao.hello();
	}
}
