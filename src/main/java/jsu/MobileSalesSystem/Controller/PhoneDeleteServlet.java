package jsu.MobileSalesSystem.Controller;

import jsu.MobileSalesSystem.daoImpl.PhoneDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/PhoneDeleteServlet")
public class PhoneDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        Integer phone_id=Integer.parseInt(id);

        System.out.println(phone_id);

        PhoneDaoImpl phoneDao  =new PhoneDaoImpl();

        boolean flag=false;
        try {
            flag=   phoneDao.Remove(phone_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (flag){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('删除成功！');");
            writer.write("window.location.href = '/MobileSalesSystem/ManagePhoneServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}
