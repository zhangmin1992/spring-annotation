package day51mybatis.yuanma.my2;

public class MyConfiguration {

	private String scanPath;
	
	private MapperRegistroy mapperRegistroy = new MapperRegistroy();

	public String getScanPath() {
		return scanPath;
	}

	public void setScanPath(String scanPath) {
		this.scanPath = scanPath;
	}
	
	public void build() {
		if(scanPath == null || scanPath.length()<1) {
			throw new RuntimeException("scanPath 必填非空");
		}
	}
	
	
}
