package day53ForTair.three;

import java.util.Map;

import com.google.common.collect.Maps;

public enum MTairCodeEnum {

	PART_OK(1,"部分成功"),
    SUCCESS(0,"成功"),
    RESULT_ERROR(-1,"结果异常"),
    KEY_NOT_EXSIT(-2,"键值不存在");


    private final int value;
    private final String desc;

    private MTairCodeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDesc(int value) {
        return valueMap.containsKey(value) ? valueMap.get(value).getDesc() : "";
    }

    public static boolean isValid(int value) {
        return valueMap.containsKey(value);
    }

    private static Map<Integer, MTairCodeEnum> valueMap = Maps.newHashMap();

    static {
        for (MTairCodeEnum status : MTairCodeEnum.values()) {
            valueMap.put(status.getValue(), status);
        }
    }
    
    public static void main(String[] args) {
	}
}
