package jsu.MobileSalesSystem.daoImpl;

import jsu.MobileSalesSystem.bean.Phone;
import jsu.MobileSalesSystem.bean.User;
import jsu.MobileSalesSystem.dao.PhoneDao;
import jsu.MobileSalesSystem.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao {
    private PreparedStatement pstmt;

    public Object getAllphone() throws SQLException {

        String sql = "select phone_id,phone_name,phone_classify,phone_price from tb_phone";
        Object count = DBUtils.getList(Phone.class, sql,null );
        return count;
    }

    public Phone findById(Integer phone_id) throws Exception {
        // TODO Auto-generated method stub

        Connection conn=DBUtils.getConnection();
        Phone vo=null;
        String sql="select phone_id,phone_name,phone_classify,phone_price from tb_phone where phone_id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, phone_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                vo = new Phone();
                vo.setPhone_id(rs.getInt(1));
                vo.setPhone_name(rs.getString(2));
                vo.setPhone_classify(rs.getString(3));
                vo.setPhone_price(rs.getDouble(4));
            }
        }catch(SQLException e){
            e.printStackTrace();
            }
         finally{
            if(pstmt!= null)
                pstmt.close();
            if(conn!= null)
                conn.close();
        }
        return vo;
    }


    public Phone findByName(String phone_name) throws Exception {
        // TODO Auto-generated method stub

        Connection conn=DBUtils.getConnection();
        Phone vo=null;
        String sql="select phone_id,phone_name,phone_classify,phone_price from tb_phone where phone_name=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone_name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                vo = new Phone();
                vo.setPhone_id(rs.getInt(1));
                vo.setPhone_name(rs.getString(2));
                vo.setPhone_classify(rs.getString(3));
                vo.setPhone_price(rs.getDouble(4));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            if(pstmt!= null)
                pstmt.close();
            if(conn!= null)
                conn.close();
        }
        return vo;
    }



    public boolean doUpdate(Phone vo) throws Exception {
        Connection conn=DBUtils.getConnection();
        // TODO Auto-generated method stub
        String sql="update tb_phone set phone_name=?,phone_classify=?,phone_price=? where phone_id=?";
        this.pstmt=conn.prepareStatement(sql);

        this.pstmt.setString(1,vo.getPhone_name());
        this.pstmt.setString(2, vo.getPhone_classify());
        this.pstmt.setDouble(3,vo.getPhone_price());
        this.pstmt.setInt(4,vo.getPhone_id());

        boolean count=this.pstmt.executeUpdate()>0;
        conn.close();
        pstmt.close();
        return count;

    }

    public boolean doCreate(Phone vo) throws Exception {
        // TODO Auto-generated method stub
Connection conn=DBUtils.getConnection();

        String sql="insert into tb_phone(phone_name,phone_classify,phone_price)Values(?,?,?)";
        this.pstmt=conn.prepareStatement(sql);


        this.pstmt.setString(1,vo.getPhone_name());
        this.pstmt.setString(2, vo.getPhone_classify());
        this.pstmt.setDouble(3, vo.getPhone_price());
 boolean count=this.pstmt.executeUpdate()>0;
 conn.close();
 pstmt.close();
        return count;
    }




    public boolean Remove(Integer phone_id) throws Exception {
        // TODO Auto-generated method stub
        Connection conn= DBUtils.getConnection();

        String sql="DELETE from tb_phone where phone_id=?";
        this.pstmt =conn.prepareStatement(sql);

        this.pstmt.setInt(1,phone_id);


        int count=this.pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return count>0?true:false;
    }


//
//    public ArrayList<Phone> getByCutPage(Integer page, Integer cutnum) throws Exception {
//        Connection conn= DBUtils.getConnection();
//        Integer pagenum = getCount();
//        Integer allpagenum = pagenum/cutnum;
//        Integer startat = (page-1) * cutnum;
//        ArrayList<Phone> array = new ArrayList<Phone>() ;
//        String sql = "SELECT * from tb_phone ORDER BY id asc LIMIT ?,?";
//        PreparedStatement p ;
//
//        try {
//            p=conn.prepareStatement(sql);
//            p.setInt(1,startat);
//            p.setInt(2,cutnum);
//            ResultSet resultSet = p.executeQuery();
//            while(resultSet.next()){
////                Shop u= new Shop();
////                u.setId(resultSet.getInt(1));
////                u.setName(resultSet.getString(2));
////                u.setPrice(resultSet.getDouble(3));
////                u.setDiscount(resultSet.getDouble(4));
////                u.setDesc(resultSet.getString(5));
////                array.add(u);
//
//                Phone vo =new Phone();
//                vo.setPhone_id(resultSet.getInt(1));
//                vo.setPhone_name(resultSet.getString(2));
//                vo.setPhone_classify(resultSet.getString(3));
//                vo.setPhone_price(resultSet.getDouble(4));
//                 array.add(vo);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return array;
//    }
//
//    private Integer getCount() throws SQLException {
//        String sql="select count(*) from tb_phone";
//        return DBUtils.getCount(sql,null);
//    }


    public List<Phone> getCompanyListByPage(String sql) throws SQLException {

        List<Phone> companyList=DBUtils.getList(Phone.class,sql);
        return companyList;
    }

    //查询一共有多少行
    public Integer getPhoneCount(String sql,Object...param) throws SQLException {

        Integer count= DBUtils.getCount(sql,param);
        System.out.println("多少行"+count);
        return  count;
    }

}
