package jsu.MobileSalesSystem.daoImpl;

import jsu.MobileSalesSystem.bean.User;
import jsu.MobileSalesSystem.dao.UserDao;
import jsu.MobileSalesSystem.utils.DBUtils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    public boolean saveUser(User user) throws SQLException {

        String sql="insert into tb_user(user_name,user_pwd,user_address,user_date)" +
                " values(?,?,?,?)";
        return DBUtils.save(sql,user.getVuser_name(),user.getVuser_pwd(),user.getVaddress(),user.getVuser_date());
    }

    public User getUserId(String vuser_name, String vuser_pwd) throws SQLException {

        String sql = "SELECT user_id vuser_id,user_name vuser_name,user_pwd vuser_pwd,user_address vaddress,user_date vuser_date \n" +
                "FROM tb_user WHERE user_name =? AND user_pwd=?";


        return DBUtils.getSingleObj(User.class,sql,vuser_name,vuser_pwd);
    }

    public Integer selectUserCount(String vuser_name) throws SQLException {

        String sql = "SELECT COUNT(*) FROM tb_user a WHERE a.user_name =?";
        Integer count = DBUtils.getCount(sql,vuser_name);
        return count;
    }




}
