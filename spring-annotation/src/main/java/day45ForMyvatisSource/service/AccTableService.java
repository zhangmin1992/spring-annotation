package day45ForMyvatisSource.service;

import java.util.Map;

import day45ForMyvatisSource.entity.AccTable2;

public interface AccTableService {

	AccTable2 getById(Integer id);
	
	int insert(AccTable2 record);
	
	AccTable2 selectByActivityName(String activityName,Integer id);
	
	void testTransation();
}
