package day53ForTair.one;

public class bizImpl {

	/**
	 * xml方式的set注入tairHelper
	 * <bean id="bizImpl" class="day53ForTair.bizImpl">
		<property name="tairHelper" ref="tairHelper"></property>
	  </bean>
	 */
    private TairHelper tairHelper;
	
    
	public TairHelper getTairHelper() {
		return tairHelper;
	}

	public void setTairHelper(TairHelper tairHelper) {
		this.tairHelper = tairHelper;
	}

	public void put() {
		tairHelper.put("key1111", "vvv",60000);
	}
	
	public String get() {
		return tairHelper.get("key1111", String.class);
	}
	
	public void show() {
		System.out.println(" i am ok");
	}
}
