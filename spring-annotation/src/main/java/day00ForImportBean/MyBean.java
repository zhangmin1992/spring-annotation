package day00ForImportBean;

import org.springframework.stereotype.Component;

@Component
public class MyBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
