package day53ForTair.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bizImpl {

	/**
	 * xml方式的属性注入：
	 * <bean id="bizImpl" class="day53ForTair.two.bizImpl">
		<property name="simpleTairClientImpl" ref="tairClient"></property>
	   </bean>
	   
	    对应代码：
	    private TairClient simpleTairClientImpl;
    
		public TairClient getSimpleTairClientImpl() {
			return simpleTairClientImpl;
		}
	
		public void setSimpleTairClientImpl(TairClient simpleTairClientImpl) {
			this.simpleTairClientImpl = simpleTairClientImpl;
		}
	 */
	
	/**
	 * xml方式的构造器注入：
	 * 
	 *  <bean id="bizImpl" class="day53ForTair.two.bizImpl">
		<constructor-arg name="simpleTairClientImpl" ref="tairClient" />
		</bean>
		
	 *  private TairClient simpleTairClientImpl;

		public bizImpl(TairClient simpleTairClientImpl) {
			super();
			this.simpleTairClientImpl = simpleTairClientImpl;
		}
	 * 
	*/
	
	/**
	 * 注解方式
	 */
	@Autowired
	private TairClient simpleTairClientImpl;

	public void put() {
		simpleTairClientImpl.put("key1111", "vvv",60000,60000);
	}
	
	public String get() {
		return simpleTairClientImpl.get("key1111", String.class,60000);
	}
	
	public void put2() {
		BizAccount bizAccount = new BizAccount(1L, "小明同学");
		simpleTairClientImpl.put("key2222", bizAccount,60000);
	}
	
	public BizAccount get2() {
		return simpleTairClientImpl.get("key2222", BizAccount.class);
	}
	
	public void show() {
		System.out.println(" i am ok");
	}
}
