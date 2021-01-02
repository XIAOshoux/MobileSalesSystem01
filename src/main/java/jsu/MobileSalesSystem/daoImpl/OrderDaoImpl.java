package jsu.MobileSalesSystem.daoImpl;

import jsu.MobileSalesSystem.bean.Order;
import jsu.MobileSalesSystem.bean.Phone;
import jsu.MobileSalesSystem.bean.User;
import jsu.MobileSalesSystem.dao.OrderDao;
import jsu.MobileSalesSystem.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private PreparedStatement pstmt;
    public boolean addOrder(Order order) throws SQLException {

        String sql="insert into tb_order(user_name,phone_name,order_price,order_address,order_date)" +
                " values(?,?,?,?,?)";
        return DBUtils.save(sql,order.getOuser_name(),order.getOphone_name(),order.getOrder_price(),order.getOrder_adress(),order.getOrder_date());
    }

    public List<Order> findAll(String user_name) throws Exception {
        // TODO Auto-generated method stub
        Connection conn= DBUtils.getConnection();
        List<Order> all =new ArrayList<>();
        String sql="select user_name,phone_name,order_address,order_price,order_date from tb_order where user_name=?";
        this.pstmt =conn.prepareStatement(sql);
        pstmt.setString(1, user_name);

        ResultSet rs=this.pstmt.executeQuery();
        while(rs.next()){
            Order vo=new Order();
            vo.setOuser_name(rs.getString(1));
            vo.setOphone_name(rs.getString(2));
            vo.setOrder_adress(rs.getString(3));
            vo.setOrder_price(rs.getDouble(4));
            vo.setOrder_date(rs.getTimestamp(5));

            all.add(vo);
        }
        pstmt.close();
        conn.close();
        rs.close();
        return all;

    }


}
