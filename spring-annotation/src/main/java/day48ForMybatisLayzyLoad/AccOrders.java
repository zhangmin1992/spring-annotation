package day48ForMybatisLayzyLoad;

public class AccOrders {
    private Integer id;

    private String orderName;

    private AccUser accUser;

    public AccOrders() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

	public AccUser getAccUser() {
		return accUser;
	}

	public void setAccUser(AccUser accUser) {
		this.accUser = accUser;
	}

}