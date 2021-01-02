package jsu.MobileSalesSystem.Controller;

import jsu.MobileSalesSystem.bean.Phone;
import jsu.MobileSalesSystem.daoImpl.PhoneDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddPhoneServlet")
public class AddPhoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=utf-8");

        String name=request.getParameter("addname");
        String classify=request.getParameter("addclassify");
        String price=request.getParameter("addprice");
        Double phone_price=Double.parseDouble(price);

        Phone phone=new Phone(null,name,classify,phone_price);

        PhoneDaoImpl phoneDao=new PhoneDaoImpl();
        boolean flag=false;
        try {
           flag= phoneDao.doCreate(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(flag){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('添加成功！');");
            writer.write("window.location.href = 'ManagePhoneServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }
}
