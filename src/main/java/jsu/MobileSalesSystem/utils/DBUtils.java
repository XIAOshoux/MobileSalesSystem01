package jsu.MobileSalesSystem.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.support.ibatis.SqlMapClientImplWrapper;
import jsu.MobileSalesSystem.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DBUtils {

    public static Connection getConnection() throws Exception {
        //读取配置文件进流
       // LoadCacheFile.class.getClassLoader().getResourceAsStream("config/db.properties");
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/db.properties");
        //定义类
        Properties properties = new Properties();
        //写入
        properties.load(in);
        //DataSource读取配置文件信息
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //返回数据库连接
        return dataSource.getConnection();
    }

    //保存对象的方法
    public static boolean save(String sql, Object ...args) throws SQLException {
        Connection conn = null;//连接
        PreparedStatement ps = null;//操作
        Integer count = null;//结果

        try {
            conn = DBUtils.getConnection();//数据库获取连接
            ps = conn.prepareStatement(sql);//操作

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);//values(?,?,?)从1,2,3开始，所以i+1
                }
            }
            //返回更新的记录数
            count = ps.executeUpdate();

        } catch (Exception e) {//异常
            e.printStackTrace();
        } finally {
            close(conn,ps,null);
        }


        return count!=null&&count>0?true:false;
    }


    //关闭连接
    public static void close(Connection conn, Statement ps, ResultSet rs) throws SQLException {

        if(conn!=null)conn.close();
        if(ps!=null) ps.close();
        if(rs!=null)rs.close();
    }

    //类型参数，类型变量，类型是可以变化  Teacher Student
    public static <T> List<T> getList(Class<T> clazz, String sql, Object ...args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        List<T> userList = null;

        try {
            conn = DBUtils.getConnection();
            //string sql = "sect id, username, birthday from users where id = ? and username = ?";
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs=ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colnum = rsmd.getColumnCount();


            userList = new ArrayList<>();

            while (rs.next()) {
                // key存放列名 , value 存放列值，for解环完成之后，rowmap存放了一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for (int i = 1; i <= colnum; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    //判断查润出来的类的类型，如果是java. sql . Date转成java. util.Date
                    if (columnValue instanceof java.sql.Date) {
                        java.sql.Date date = (java.sql.Date) columnValue;
                        columnValue = new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName, columnValue);
                }
                //创建一个User对象，给这个User对象属性赋值；
                T bean = clazz.newInstance();
                //根据列名，id == 给user对象id属性赋值的方法名，setId, “set"+Id = setId, 调用setId 方法给user对象赋，
                //循环rowap给User所有属性赋值entry {key, value} [{"id":1}, {username: "king"},{"birthday":“2020-06-”6}]
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    BeanUtils. setProperty(bean,propertyName ,propertyValue);

                }
                userList . add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return userList;
    }

    //查询记录数量
    public static Integer getCount(String sql, Object...args) throws SQLException {
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        Integer count = null;

        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);


            if(args!=null && args.length>0){

                for (int i = 0;i< args.length;i++){

                    ps.setObject(i+1,args[i]);
                }
            }
            rs = ps.executeQuery();

            while (rs.next()){

                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close(conn, ps, rs);
        }

        return  count;
    }




    
    public  static <T> T  getSingleObj(Class<T> clazz, String sql, Object...args) throws SQLException {
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        T bean = null;

        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);

            if(args!=null && args.length>0){
                for (int i = 0;i< args.length;i++){

                    ps.setObject(i+1,args[i]);
                }
            }
            rs = ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData rsmd =rs.getMetaData();

            //获取当前结果集的列数
            int colnum =rsmd.getColumnCount();

            while (rs.next()){

                //key存放列名，value存放列值，for循环完成之前，rowMap存放一条记录
                Map<String,Object> rowMap = new HashMap<String,Object>();
                for (int i = 1;i<=colnum;i++){
                    String columnName = rsmd.getColumnLabel(i);
                    Object columValue = rs.getObject(columnName);
                    System.out.println(columnName);
                    System.out.println(columValue);
                    //判断查询出来的类的类型，如果是java.sql.Date就转成java.util.Date
                    if (columValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columValue;
                        columValue = new java.util.Date(date.getTime());
                    }

                    rowMap.put(columnName,columValue);
                }
                //创建一个对象 给它赋值
              bean = clazz.newInstance();

                for(Map.Entry<String,Object> entry : rowMap.entrySet()) {

                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    BeanUtils.setProperty(bean, propertyName, propertyValue);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close(conn, ps, rs);
        }

       return bean;
    }

    //更新操作
    public  static boolean update(String sql, Object...args) throws SQLException {
        Connection conn =null;
        PreparedStatement ps =null;
        Integer count=0;

        try{
            // 获取数据库连接对象
            conn = DBUtils.getConnection();

            // 预编译SQL语句
            ps = conn.prepareStatement(sql);

            // 如果有条件参数
            if(args!=null && args.length>0){
                for (int i = 0;i< args.length;i++){
                    //判断当前类型，是不是java.util.Date,转换成java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date=(java.util.Date)args[i];
                        //转换成java.sql.Date
                        args[i]=new java.sql.Date(date.getTime());
                    }
                    ps.setObject(i+1,args[i]);
                }
            }
            count = ps.executeUpdate();

            //

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close(conn, ps, null);
        }
        return  count>0?true:false;
    }



    // 更新操作
    public static Integer updateForPrimary(String sql, Object... args) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        Integer primaryKey = null;
        ResultSet rs = null;

        try {
            // 获取数据库连接对象
            conn = DBUtils.getConnection();

            // 预编译SQL语句
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {

                    // 判断当前类型，是不是java.util.Date，转换成java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        // 转换成java.sql.Date
                        args[i] = new java.sql.Date(date.getTime());
                    }

                    ps.setObject(i + 1, args[i]);
                }
            }

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if(rs.next()){
                primaryKey = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, ps, rs);
        }
        return primaryKey;
    }




    //类型参数，类型变量，类型是可以变化  Teacher Student
    public static <T> List<T> getId(Class<T> clazz, String sql, Object ...args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        List<T> userList = null;

        try {
            conn = DBUtils.getConnection();
            //string sql = "sect id, username, birthday from users where id = ? and username = ?";
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs=ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colnum = rsmd.getColumnCount();


            userList = new ArrayList<>();

            while (rs.next()) {
                // key存放列名 , value 存放列值，for解环完成之后，rowmap存放了一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for (int i = 1; i <= colnum; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    //判断查润出来的类的类型，如果是java. sql . Date转成java. util.Date
                    if (columnValue instanceof java.sql.Date) {
                        java.sql.Date date = (java.sql.Date) columnValue;
                        columnValue = new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName, columnValue);
                }
                //创建一个User对象，给这个User对象属性赋值；
                T bean = clazz.newInstance();
                //根据列名，id == 给user对象id属性赋值的方法名，setId, “set"+Id = setId, 调用setId 方法给user对象赋，
                //循环rowap给User所有属性赋值entry {key, value} [{"id":1}, {username: "king"},{"birthday":“2020-06-”6}]
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    BeanUtils. setProperty(bean,propertyName ,propertyValue);

                }
                userList . add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return userList;
    }

}
