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

@WebServlet(urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的email和密码
        String phone_id = request.getParameter("phone_id");
        Integer id=Integer.parseInt(phone_id);
        String name = request.getParameter("phone_name");
        String classify = request.getParameter("phone_classify");
        String phone_price= request.getParameter("phone_price");
        Double price=Double.parseDouble(phone_price);

        Phone phone=new Phone(id,name,classify,price);

        System.out.println(phone);

        PhoneDaoImpl phoneDao=new PhoneDaoImpl();
        boolean flag=false;

        try {
            flag=phoneDao.doUpdate(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(flag){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('修改成功');");
            writer.write("window.location.href = '/MobileSalesSystem/ManagePhoneServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }
}
