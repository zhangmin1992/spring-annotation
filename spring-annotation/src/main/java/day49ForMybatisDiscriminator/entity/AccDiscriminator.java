package day49ForMybatisDiscriminator.entity;

import day49ForMybatisDiscriminator.enums.EnabledEnum;

public class AccDiscriminator extends BaseEntity  {
    private Long id;

    private String name;

    private EnabledEnum personType;
    
    private String prostate;
    
    private String womb;
    

    public String getProstate() {
		return prostate;
	}

	public void setProstate(String prostate) {
		this.prostate = prostate;
	}

	public String getWomb() {
		return womb;
	}

	public void setWomb(String womb) {
		this.womb = womb;
	}

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

	public EnabledEnum getPersonType() {
		return personType;
	}

	public void setPersonType(EnabledEnum personType) {
		this.personType = personType;
	}
    
}