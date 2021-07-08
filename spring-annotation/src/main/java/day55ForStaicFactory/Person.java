package day55ForStaicFactory;

public class Person {

	public Person() {
		
	}
	
	private String name;

	private float value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Person(String name) {
		super();
		this.name = name;
	}

    public Person(String name, float value) {
        this.name = name;
        this.value = value;
    }
}
