package day25Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class jdbcService {

	@Autowired
	public JdbcOperator jdbcOperator;
	
	public void processDeamonWriteBackOutFee() {
		try {
			//回写手续费等信息逻辑处理
			writeBackOutFee();
			System.out.println("我在继续处理！！");
		}catch (Exception e) {
			System.out.println("定时回写通道费数据异常！");
		}
	}
	
	public void writeBackOutFee() {
		try {
			jdbcOperator.testTransactional();
		} catch (Exception e) {
			System.out.println("通道费回写异常");
		}
	}
}
