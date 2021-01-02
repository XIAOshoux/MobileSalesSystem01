package jsu.MobileSalesSystem.dao;

import jsu.MobileSalesSystem.bean.Phone;

import java.sql.SQLException;
import java.util.List;

public interface PhoneDao {
    //查询所有
    public Object getAllphone() throws SQLException;
    //查询ID
    public Phone findById(Integer phone_id) throws Exception;
    //查询名字
    public Phone findByName(String phone_name) throws Exception;
    //修改
    public boolean doUpdate(Phone vo) throws Exception;
    //添加
    public boolean doCreate(Phone vo) throws Exception;
    //删除
    public boolean Remove(Integer phone_id) throws Exception;
    //集合
    public List<Phone> getCompanyListByPage(String sql) throws SQLException;
    //查询多少行
    public Integer getPhoneCount(String sql,Object...param) throws SQLException;
}
