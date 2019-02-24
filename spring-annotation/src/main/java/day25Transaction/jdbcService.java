package day25Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
		} catch (Exception e) {
			System.out.println("通道费回写异常");
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED )
	public void testRequiredTransactional() {
		jdbcOperator.one();
		jdbcOperator.two();
		try {
			jdbcOperator.three();
		} catch (Exception e) {
			System.out.println("异常被捕获");
		}
	}
}
