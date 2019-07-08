package day49ForMybatisDiscriminator.enums;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import day49ForMybatisDiscriminator.DisplayedEnum;

public enum EnabledEnum implements DisplayedEnum {

	CASH(0, "现金支付"),
    WX(1, "微信扫码支付");
	
	public Integer type;
    public String desc;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    EnabledEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private static final Map<Integer, String> enumMap = new HashMap<Integer, String>();
	
    static{
        for(EnabledEnum value : EnabledEnum.values()){
        	enumMap.put(value.type, value.desc);
        }
    }
    
    public static String transferTypeToDesc(Integer type) {
        return enumMap.get(type);
    }
    
	public static void main(String[] args) {
		System.out.println(EnabledEnum.CASH);
		System.out.println(EnabledEnum.CASH.type); 
		System.out.println(EnabledEnum.CASH.desc); 
		System.out.println(EnabledEnum.CASH.name()); 
		
		System.out.println(JSONObject.toJSONString(EnabledEnum.values()));
		System.out.println(JSONObject.toJSONString(enumMap));
		
		System.out.println(transferTypeToDesc(1));
		System.out.println(transferTypeToDesc(3));
	}
}
