package day53ForTair.two;

import java.io.Serializable;

import lombok.Data;

@Data
public class BizAccount implements Serializable {

    private Long dealId;

    private String name;

	public BizAccount(Long dealId, String name) {
		super();
		this.dealId = dealId;
		this.name = name;
	}
    
}