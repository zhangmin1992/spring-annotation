package day46ForMybatisLog4jPrintSql.entity;

import java.util.Date;

public class SaasServiceOrderInfo {
	/**
     * 自增id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 服务id
     */
    private Long serviceId;

    /**
     * 服务类
     */
    private String serviceType;

    /**
     * 服务名
     */
    private String serviceName;

    /**
     * 原价
     */
    private Long amount;

    /**
     * 实际总价
     */
    private Long actualFee;

    /**
     * 会员卡抵扣
     */
    private Integer useCard;

    /**
     * 用户实际总价
     */
    private Long userActualFee;

    /**
     * 会员卡抵扣
     */
    private Long couponFee;

    /**
     * 优惠券抵扣
     */
    private Long couponFee2;

    /**
     * 人为指定的优惠金额
     */
    private Long couponFee3;

    /**
     * 赠送
     */
    private Integer isGift;

    /**
     * 会员卡扣款
     */
    private Integer cardCouponFee;

    /**
     * 会员卡id
     */
    private Long useCardId;

    /**
     * 门店赠送项原价
     */
    private Long storeCouponFee;

    /**
     * 兑换码
     */
    private String redemptionCode;

    /**
     * 使用兑换码抵扣原价
     */
    private Integer redemptionFee;

    /**
     * 优惠券使用数据
     */
    private String couponPayData;

    /**
     * 会员卡使用数据
     */
    private String cardPayData;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getActualFee() {
        return actualFee;
    }

    public void setActualFee(Long actualFee) {
        this.actualFee = actualFee;
    }

    public Integer getUseCard() {
        return useCard;
    }

    public void setUseCard(Integer useCard) {
        this.useCard = useCard;
    }

    public Long getUserActualFee() {
        return userActualFee;
    }

    public void setUserActualFee(Long userActualFee) {
        this.userActualFee = userActualFee;
    }

    public Long getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Long couponFee) {
        this.couponFee = couponFee;
    }

    public Long getCouponFee2() {
        return couponFee2;
    }

    public void setCouponFee2(Long couponFee2) {
        this.couponFee2 = couponFee2;
    }

    public Long getCouponFee3() {
        return couponFee3;
    }

    public void setCouponFee3(Long couponFee3) {
        this.couponFee3 = couponFee3;
    }

    public Integer getIsGift() {
        return isGift;
    }

    public void setIsGift(Integer isGift) {
        this.isGift = isGift;
    }

    public Integer getCardCouponFee() {
        return cardCouponFee;
    }

    public void setCardCouponFee(Integer cardCouponFee) {
        this.cardCouponFee = cardCouponFee;
    }

    public Long getUseCardId() {
        return useCardId;
    }

    public void setUseCardId(Long useCardId) {
        this.useCardId = useCardId;
    }

    public Long getStoreCouponFee() {
        return storeCouponFee;
    }

    public void setStoreCouponFee(Long storeCouponFee) {
        this.storeCouponFee = storeCouponFee;
    }

    public String getRedemptionCode() {
        return redemptionCode;
    }

    public void setRedemptionCode(String redemptionCode) {
        this.redemptionCode = redemptionCode;
    }

    public Integer getRedemptionFee() {
        return redemptionFee;
    }

    public void setRedemptionFee(Integer redemptionFee) {
        this.redemptionFee = redemptionFee;
    }

    public String getCouponPayData() {
        return couponPayData;
    }

    public void setCouponPayData(String couponPayData) {
        this.couponPayData = couponPayData;
    }

    public String getCardPayData() {
        return cardPayData;
    }

    public void setCardPayData(String cardPayData) {
        this.cardPayData = cardPayData;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SaasServiceOrderInfo other = (SaasServiceOrderInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getServiceType() == null ? other.getServiceType() == null : this.getServiceType().equals(other.getServiceType()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getActualFee() == null ? other.getActualFee() == null : this.getActualFee().equals(other.getActualFee()))
            && (this.getUseCard() == null ? other.getUseCard() == null : this.getUseCard().equals(other.getUseCard()))
            && (this.getUserActualFee() == null ? other.getUserActualFee() == null : this.getUserActualFee().equals(other.getUserActualFee()))
            && (this.getCouponFee() == null ? other.getCouponFee() == null : this.getCouponFee().equals(other.getCouponFee()))
            && (this.getCouponFee2() == null ? other.getCouponFee2() == null : this.getCouponFee2().equals(other.getCouponFee2()))
            && (this.getCouponFee3() == null ? other.getCouponFee3() == null : this.getCouponFee3().equals(other.getCouponFee3()))
            && (this.getIsGift() == null ? other.getIsGift() == null : this.getIsGift().equals(other.getIsGift()))
            && (this.getCardCouponFee() == null ? other.getCardCouponFee() == null : this.getCardCouponFee().equals(other.getCardCouponFee()))
            && (this.getUseCardId() == null ? other.getUseCardId() == null : this.getUseCardId().equals(other.getUseCardId()))
            && (this.getStoreCouponFee() == null ? other.getStoreCouponFee() == null : this.getStoreCouponFee().equals(other.getStoreCouponFee()))
            && (this.getRedemptionCode() == null ? other.getRedemptionCode() == null : this.getRedemptionCode().equals(other.getRedemptionCode()))
            && (this.getRedemptionFee() == null ? other.getRedemptionFee() == null : this.getRedemptionFee().equals(other.getRedemptionFee()))
            && (this.getCouponPayData() == null ? other.getCouponPayData() == null : this.getCouponPayData().equals(other.getCouponPayData()))
            && (this.getCardPayData() == null ? other.getCardPayData() == null : this.getCardPayData().equals(other.getCardPayData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getServiceType() == null) ? 0 : getServiceType().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getActualFee() == null) ? 0 : getActualFee().hashCode());
        result = prime * result + ((getUseCard() == null) ? 0 : getUseCard().hashCode());
        result = prime * result + ((getUserActualFee() == null) ? 0 : getUserActualFee().hashCode());
        result = prime * result + ((getCouponFee() == null) ? 0 : getCouponFee().hashCode());
        result = prime * result + ((getCouponFee2() == null) ? 0 : getCouponFee2().hashCode());
        result = prime * result + ((getCouponFee3() == null) ? 0 : getCouponFee3().hashCode());
        result = prime * result + ((getIsGift() == null) ? 0 : getIsGift().hashCode());
        result = prime * result + ((getCardCouponFee() == null) ? 0 : getCardCouponFee().hashCode());
        result = prime * result + ((getUseCardId() == null) ? 0 : getUseCardId().hashCode());
        result = prime * result + ((getStoreCouponFee() == null) ? 0 : getStoreCouponFee().hashCode());
        result = prime * result + ((getRedemptionCode() == null) ? 0 : getRedemptionCode().hashCode());
        result = prime * result + ((getRedemptionFee() == null) ? 0 : getRedemptionFee().hashCode());
        result = prime * result + ((getCouponPayData() == null) ? 0 : getCouponPayData().hashCode());
        result = prime * result + ((getCardPayData() == null) ? 0 : getCardPayData().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", status=").append(status);
        sb.append(", orderId=").append(orderId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", serviceName=").append(serviceName);
        sb.append(", amount=").append(amount);
        sb.append(", actualFee=").append(actualFee);
        sb.append(", useCard=").append(useCard);
        sb.append(", userActualFee=").append(userActualFee);
        sb.append(", couponFee=").append(couponFee);
        sb.append(", couponFee2=").append(couponFee2);
        sb.append(", couponFee3=").append(couponFee3);
        sb.append(", isGift=").append(isGift);
        sb.append(", cardCouponFee=").append(cardCouponFee);
        sb.append(", useCardId=").append(useCardId);
        sb.append(", storeCouponFee=").append(storeCouponFee);
        sb.append(", redemptionCode=").append(redemptionCode);
        sb.append(", redemptionFee=").append(redemptionFee);
        sb.append(", couponPayData=").append(couponPayData);
        sb.append(", cardPayData=").append(cardPayData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}