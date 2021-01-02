package jsu.MobileSalesSystem.dao;

import jsu.MobileSalesSystem.bean.Cart;
import jsu.MobileSalesSystem.bean.Phone;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    //添加
    public boolean add(Cart vo) throws Exception;
    //查询集合
    public List<Phone> findAll(String user_name) throws Exception;
    //删除
    public boolean Remove(String username,Integer phone_id) throws Exception;
}
