package day25Transaction;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JdbcOperator {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertInfo() {
		String sql = "insert into acc_legal_holidays values (?,?)";
		jdbcTemplate.update(sql,"88","2018-09-09");
	}
	
	@Transactional
	public void testTransactional() throws Exception {
		//事务无效方式1
		/*String id = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(id);
		String sql2 = "insert into acc_legal_holidays values (?,?)";
		jdbcTemplate.update(sql2,id,"2018-09-09");
		throw new Exception();*/
		
		//事务无效方式2
		/*try {
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println(id);
			String sql2 = "insert into acc_legal_holidays values (?,?)";
			jdbcTemplate.update(sql2,id,"2018-09-09");
			throw new Exception();
		} catch (Throwable e) {
			System.out.println("我在@Transactional标记中捕获到异常了！！！");
		}*/
		
		//事务不生效的写法三
		/*String id = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(id);
		String sql2 = "insert into acc_legal_holidays values (?,?)";
		jdbcTemplate.update(sql2,id,"2018-09-09");
		testB();*/
		testC();
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(id);
		String sql2 = "insert into acc_legal_holidays values (?,?)";
		jdbcTemplate.update(sql2,id,"2018-09-09");
	}
	
	@Transactional
	public void testB() {
		String sql2 = "insert into acc_legal_holidays values (?,?)";
		jdbcTemplate.update(sql2,"88","2018-09-09");
	}
	
	@Transactional
	public void testC() {
//		try {
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println(id);
			String sql2 = "insert into acc_legal_holidays values (?,?)";
			jdbcTemplate.update(sql2,"100fen","2018-01-01");
			int i = 10 / 0;
//		} catch (Throwable e) {
//			System.out.println("我在@Transactional标记中捕获到异常了！！！");
//		}
	}
	
	public void delete(int id) {
		String sql = "delete from acc_legal_holidays where id = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public void update(String date,int id) {
		String sql = "update acc_legal_holidays set holiday_date = ? where id = ?";
		this.jdbcTemplate.update(sql, date,id);
	}
	
	public String searchUserName(int id) {
		String sql = "select holiday_date from acc_legal_holidays where id = ?";
		return  this.jdbcTemplate.queryForObject(sql, String.class, id);
	}

}
