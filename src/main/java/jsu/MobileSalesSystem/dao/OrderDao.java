package jsu.MobileSalesSystem.dao;

import jsu.MobileSalesSystem.bean.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    //添加
    public boolean addOrder(Order order) throws SQLException;
//查询
    public List<Order> findAll(String user_name) throws Exception;
}
