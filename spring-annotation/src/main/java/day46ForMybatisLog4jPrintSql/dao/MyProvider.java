package day46ForMybatisLog4jPrintSql.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class MyProvider {
	public String selectServiceOrderInfoV3(Map<String, Object> map) {
        List<Integer> orderIds = (List) map.get("orderIds");
        return new SQL() {
            {
                SELECT("    id AS orderId,\n" + 
                		"    saas_service_order_info.id AS id,\n" + 
                		"    saas_service_order_info.created_at AS createdAt,\n" + 
                		"    saas_service_order_info.updated_at AS updatedAt,\n" + 
                		"    saas_service_order_info.status AS status,\n" + 
                		"    saas_service_order_info.order_id as order_id,\n" + 
                		"    saas_service_order_info.service_id as serviceId,\n" + 
                		"    saas_service_order_info.service_type as serviceType,\n" + 
                		"    saas_service_order_info.service_name as service_Name,\n" + 
                		"    saas_service_order_info.amount as amount,\n" + 
                		"    saas_service_order_info.actual_fee as actualFee,\n" + 
                		"    saas_service_order_info.use_card as useCard,\n" + 
                		"    saas_service_order_info.user_actual_fee as userActualFee,\n" + 
                		"    saas_service_order_info.coupon_fee as couponFee,\n" + 
                		"    saas_service_order_info.coupon_fee2 as couponFee2,\n" + 
                		"    saas_service_order_info.coupon_fee3 as couponFee3,\n" + 
                		"    saas_service_order_info.is_gift as isGift,\n" + 
                		"    saas_service_order_info.card_coupon_fee as cardCouponFee,\n" + 
                		"    saas_service_order_info.use_card_id as useCardId,\n" + 
                		"    saas_service_order_info.store_coupon_fee as storeCouponFee,\n" + 
                		"    saas_service_order_info.redemption_code as redemptionCode,\n" + 
                		"    saas_service_order_info.redemption_fee as redemptionFee, \n" + 
                		"    saas_service_order_info.coupon_pay_data as couponPayData,\n" + 
                		"    saas_service_order_info.card_pay_data as cardPayData\n");
                FROM("saas_service_order_info");
                WHERE("order_id in ((202970,202969,202968,202967,202965)) ");
            }
        }.toString();
    }
}
