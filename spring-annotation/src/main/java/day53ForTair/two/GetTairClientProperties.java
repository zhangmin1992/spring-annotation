package day53ForTair.two;

public class GetTairClientProperties {

	private TairClientProperties tairClientProperties;
	
	public GetTairClientProperties(TairClientProperties tairClientProperties) {
		System.out.println("GetTairClientProperties" + tairClientProperties.getLocalAppKey());
		this.tairClientProperties = tairClientProperties;
	}
	public void show() {
		System.out.println("show" + tairClientProperties.getLocalAppKey());
	}
}
