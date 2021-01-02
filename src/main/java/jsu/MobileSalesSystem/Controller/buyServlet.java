package jsu.MobileSalesSystem.Controller;

import jsu.MobileSalesSystem.bean.Order;
import jsu.MobileSalesSystem.bean.Phone;
import jsu.MobileSalesSystem.daoImpl.OrderDaoImpl;
import jsu.MobileSalesSystem.daoImpl.PhoneDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(urlPatterns = "/buyServlet")
public class buyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int phone_id=Integer.parseInt(id);

//拿密码session
        HttpSession session = request.getSession();

        String user=(String)session.getAttribute("user");//密码
        System.out.println(user);
//拿地址session

        String address=(String)session.getAttribute("address");
        System.out.println(address);



        PhoneDaoImpl p=new PhoneDaoImpl();
        Phone phone= new Phone();
        try {
            phone= (Phone)p.findById(phone_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Order order=new Order();
        order.setOuser_name(user);
        order.setOphone_name(phone.getPhone_name());
        order.setOrder_adress(address);
        order.setOrder_price(phone.getPhone_price());
        order.setOrder_date(new Date());

        System.out.println(order);

        OrderDaoImpl orderDao=new OrderDaoImpl();
        boolean flag=false;
        try {
           flag=orderDao.addOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(flag==true){

            response.sendRedirect("/MobileSalesSystem/orderFinish.jsp");
        }
        else{

            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('服务器异常，请稍后再试！');");
            writer.write("window.location.href = 'buyNow.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
