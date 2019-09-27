package day52ForElasticSearch;

import org.springframework.stereotype.Component;

@Component
public class Student {

	public Student() {
		
	}
	
	private String name;
	
	private Integer readCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void sayName() {
		System.out.println("-------sayName------");
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Student(String name, Integer readCount) {
		super();
		this.name = name;
		this.readCount = readCount;
	}
}
