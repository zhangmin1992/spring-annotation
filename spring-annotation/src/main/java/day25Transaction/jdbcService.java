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
	
	/**
	 * 测试事务的传播属性
	 * 外部事务是REQUIRED，内部事务也是REQUIRED，无论是否trycatch 住异常，都会被外部事务发现而回滚，外部事务和内部REQUIRED事务都插不进去
	 * 外部事务是REQUIRED，内部事务是NESTED，内部事务three异常，trycatch 住异常，事务不会回滚，外部事务和内部REQUIRED都会插入、
	 * 外部事务是REQUIRED，内部事务是NESTED，内部事务three异常，没有trycatch 住异常，事务不会回滚，外部事务和内部REQUIRED都不会插入
	 * 外部事务是REQUIRED，内部事务是REQUIRES_NEW，无论是否trycanche，事务都不会回滚，外部事务和内部REQUIRED事务都能插进去
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param 
		* @return void    返回类型 
		* @throws
	 */
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
	
	/**
	 * 同样的代码不同的结果，这两段代码全部插入了
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param 
		* @return void    返回类型 
		* @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED )
	public void testTransactional() {
		jdbcOperator.one();
		this.three();
		jdbcOperator.three();
	}
	
	@Transactional(propagation = Propagation.REQUIRED )
	public void three() {
		jdbcOperator.two();
	}
	
	/**
	 *  虽然再事务中还没有提交，但是在本回话中是能够找到刚刚插入的数据11的
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param 
		* @return void    返回类型 
		* @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED )
	public void testInsertAndGet() {
		jdbcOperator.one();
		String code = jdbcOperator.searchUserName(11);
		System.out.println(code);
	}
}
