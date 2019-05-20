package day49ForMybatisDiscriminator;

public class AccDiscriminator {
    private Long id;

    private String name;

    private Integer personType;
    
    private EnabledEnum type;

    public AccDiscriminator() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
    }

	public EnabledEnum getType() {
		return type;
	}

	public void setType(EnabledEnum type) {
		this.type = type;
	}
    
    
}