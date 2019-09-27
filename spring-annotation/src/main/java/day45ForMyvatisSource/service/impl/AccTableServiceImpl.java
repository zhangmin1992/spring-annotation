package day45ForMyvatisSource.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import day45ForMyvatisSource.dao.AccTable2Mapper;
import day45ForMyvatisSource.entity.AccTable2;
import day45ForMyvatisSource.service.AccTableService;

@Service
public class AccTableServiceImpl implements AccTableService {

	@Autowired
	private AccTable2Mapper accTableMapper;
	
	public AccTable2 getById(Integer id) {
		System.out.println("AccTableServiceImpl accTableMapper id="+id);
		return accTableMapper.selectByPrimaryKey(id);
	}

	public int insert(AccTable2 record) {
		return accTableMapper.insertSelective(record);
	}

	public AccTable2 selectByActivityName(String activityName, Integer id) {
		return accTableMapper.selectByActivityName(activityName, id);
	}

	@Override
	public void testTransation() {
		testTransation2();
		System.out.println("我执行结束");
		AccTable2 accTable2 = new AccTable2(new Date(), "哈哈哈哈哈哈");
		insert(accTable2);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void testTransation2() {
		getById(19);
		getById(20);
		AccTable2 accTable2 = new AccTable2(new Date(), "6666");
		insert(accTable2);
		int i = 3/0;
	}
	

}
