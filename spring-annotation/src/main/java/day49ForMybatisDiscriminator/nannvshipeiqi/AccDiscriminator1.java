package day49ForMybatisDiscriminator.nannvshipeiqi;

/**
 * 
	* AccDiscriminator1 适配器的实体
	* @author zhangmin 
	* @date Jul 5, 2019 2:18:16 PM
 */
public class AccDiscriminator1 {
    private Long id;

    private String name;

    private Integer personType;

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
    
}