package day50ForMybatisCache;

import java.util.List;

public interface AccEncacheMapper {
	
    AccEncache selectByPrimaryKey(Integer id);
   
    List<AccEncache> selectAll();

}