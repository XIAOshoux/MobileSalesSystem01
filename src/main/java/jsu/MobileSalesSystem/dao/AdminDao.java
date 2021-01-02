package jsu.MobileSalesSystem.dao;

import jsu.MobileSalesSystem.bean.Admin;

import java.sql.SQLException;

public interface AdminDao {
    //查询管理员
    public Admin getUserId(String admin_name, String admin_pwd) throws SQLException;
}
