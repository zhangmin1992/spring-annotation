package day48ForMybatisLayzyLoad;

import day48ForMybatisLayzyLoad.AccOrders;

public interface AccOrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccOrders record);

    int insertSelective(AccOrders record);

    AccOrders selectByPrimaryKey(Integer id);
    
    AccOrders getOrderByPrimaryKey(Integer id);
    
    AccOrders getOrderByPrimaryKey2(Integer id);
    
    AccOrders getOrderByPrimaryKey3(Integer id);
    
    AccOrders getOrderByPrimaryKey4(Integer id);

    int updateByPrimaryKeySelective(AccOrders record);

    int updateByPrimaryKey(AccOrders record);
}