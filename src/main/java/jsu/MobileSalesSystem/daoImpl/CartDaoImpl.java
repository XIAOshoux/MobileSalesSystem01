package jsu.MobileSalesSystem.daoImpl;

import jsu.MobileSalesSystem.bean.Cart;
import jsu.MobileSalesSystem.bean.Phone;
import jsu.MobileSalesSystem.bean.User;
import jsu.MobileSalesSystem.dao.CartDao;
import jsu.MobileSalesSystem.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CartDaoImpl implements CartDao {

    private PreparedStatement pstmt;
//添加
    public boolean add(Cart vo) throws Exception{
        // TODO Auto-generated method stub
        Connection conn= DBUtils.getConnection();

        String sql="insert into tb_cart(user_name,phone_id)Values(?,?)";
        this.pstmt=conn.prepareStatement(sql);

        this.pstmt.setString(1,vo.getUser_name());
        this.pstmt.setInt(2,vo.getPhone_id());

        int count=this.pstmt.executeUpdate();

        pstmt.close();
        conn.close();

        return count>0;
    }

//查找
    public List<Phone> findAll(String user_name) throws Exception {
        // TODO Auto-generated method stub
        Connection conn= DBUtils.getConnection();
        List<Phone> all =new ArrayList<Phone>();
        String sql="select tb_phone.phone_id,tb_phone.phone_name,tb_phone.phone_classify,tb_phone.phone_price from tb_phone INNER JOIN tb_cart where tb_cart.user_name=? and tb_cart.phone_id  and tb_phone.phone_id=tb_cart.phone_id";

        this.pstmt =conn.prepareStatement(sql);
        pstmt.setString(1, user_name);

        ResultSet rs=this.pstmt.executeQuery();
        while(rs.next()){
            Phone vo=new Phone();
            vo.setPhone_id(rs.getInt(1));
            vo.setPhone_name(rs.getString(2));
            vo.setPhone_classify(rs.getString(3));
           vo.setPhone_price(rs.getDouble(4));
            all.add(vo);
        }
        pstmt.close();
        conn.close();
rs.close();
        return all;

    }
//查找
    public static Cart getCartId(String user_name, Integer phone_id) throws SQLException {

        String sql = "SELECT tb_cart.cart_id cart_id,tb_cart.user_name user_name,tb_cart.phone_id phone_id \n" +
                "FROM tb_cart WHERE user_name =? AND phone_id=?";


        return DBUtils.getSingleObj(Cart.class,sql,user_name,phone_id);
    }

//删除
    public boolean Remove(String username,Integer phone_id) throws Exception {
        // TODO Auto-generated method stub
        Connection conn= DBUtils.getConnection();

        String sql="DELETE from tb_cart where user_name=? and phone_id=?";
        this.pstmt =conn.prepareStatement(sql);
        this.pstmt.setString(1,username);
        this.pstmt.setInt(2,phone_id);


        int count=this.pstmt.executeUpdate();
pstmt.close();
conn.close();
        return count>0?true:false;
    }



}
