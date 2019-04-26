package day45ForMyvatisSource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
