package day25Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JdbcOperator {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void insertInfo() {
		String sql = "insert into acc_legal_holidays values (?,?)";
		jdbcTemplate.update(sql,"88","2018-09-09");
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
	
//	@Transactional(propagation=Propagation.REQUIRED)
	public void one() {
		String sql = "insert into acc_legal_holidays values (?,?)";
		jdbcTemplate.update(sql,"11","2018-09-09");
	}
	
//	@Transactional(propagation=Propagation.NESTED)
	public void two() {
		String sql = "insert into acc_legal_holidays values (?,?)";
		jdbcTemplate.update(sql,"22","2018-09-09");
	}
	
//	@Transactional(propagation=Propagation.REQUIRED)
//	@Transactional(propagation=Propagation.NESTED)
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void three() {
		String sql = "insert into acc_legal_holidays values (?,?)";
		jdbcTemplate.update(sql,"33","2018-09-09");
		throw new RuntimeException();
	}
}
