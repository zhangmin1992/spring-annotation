package day26aop;


public class MethodBean {

	public int getNum(int num) {
		return 10/num;
	}
	
	public void getMyNum() {
		MethodBean MethodBean = new MethodBean();
		MethodBean.getNum(2);
	}
	
}
