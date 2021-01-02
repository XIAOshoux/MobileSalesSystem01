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

@WebServlet(urlPatterns = "/SeaPhoneServlet")
public class SeaPhoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=utf-8");

        String name=request.getParameter("seaname");

        PhoneDaoImpl phoneDao=new PhoneDaoImpl();

        Phone phone =new Phone();
        try {
            phone=phoneDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(phone);

        if(phone!=null){
            request.getSession().setAttribute("phone", phone);

            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('查询到！');");
            writer.write("window.location.href = 'SearchPhone.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();

        }else
        {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('没有查到！');");
            writer.write("window.location.href = 'ManagePhoneServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }


    }
}
