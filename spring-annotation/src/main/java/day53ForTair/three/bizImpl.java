package day53ForTair.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bizImpl {

	@Autowired
	private NewMTairClient tairClient;

	public void put() {
		tairClient.put("key1111", "vvv",60000,60000);
	}
	
	public String get() {
		return tairClient.get("key1111", String.class,60000);
	}
	
//	public void put2() {
//		BizAccount bizAccount = new BizAccount(1L, "小明同学");
//		simpleTairClientImpl.put("key2222", bizAccount,60000);
//	}
//	
//	public BizAccount get2() {
//		return simpleTairClientImpl.get("key2222", BizAccount.class);
//	}
	
	public void show() {
		System.out.println(" i am ok");
	}
}
