package jsu.MobileSalesSystem.daoImpl;

import jsu.MobileSalesSystem.bean.Admin;
import jsu.MobileSalesSystem.bean.User;
import jsu.MobileSalesSystem.dao.AdminDao;
import jsu.MobileSalesSystem.utils.DBUtils;

import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    public Admin getUserId(String admin_name, String admin_pwd) throws SQLException {

        String sql = "SELECT admin_name adminname,admin_pwd adminpwd \n" +
                "FROM tb_admin WHERE admin_name =? AND admin_pwd=?";


        return DBUtils.getSingleObj(Admin.class,sql,admin_name,admin_pwd);
    }
}
