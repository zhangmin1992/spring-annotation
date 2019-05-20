package day49ForMybatisDiscriminator;

public enum EnabledEnum {

	CASH(0, "现金支付"),
    WX(1, "微信扫码支付"),
    MEMBERCARD(2, "会员卡抵扣"),
    ALIPAYTRANSFER(3, "支付宝转账"),
    WXTRANSFER(4, "微信转账"),
    CREDITCARD(5, "刷卡支付"),
    GROUPPAY(6, "组合支付"),
    RedemptionCode(7, "兑换码兑换");
	
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
}
