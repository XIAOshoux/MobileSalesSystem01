package jsu.MobileSalesSystem.Controller;

import jsu.MobileSalesSystem.bean.Admin;
import jsu.MobileSalesSystem.daoImpl.AdminDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String adminname = request.getParameter("adminname");
        String password = request.getParameter("adminpwd");

        Admin admin=new Admin(adminname,password);
        System.out.println(admin.toString());

        AdminDaoImpl adminDao=new AdminDaoImpl();
Admin a=new Admin();
        try {
           a =adminDao.getUserId(adminname,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
if(a!=null){

    request.getSession().setAttribute("admin", a.getAdminname());

    response.sendRedirect("/MobileSalesSystem/ManagePhoneServlet");
}
else {

    PrintWriter writer = response.getWriter();
    writer.write("<script>");
    writer.write("alert('用户名或密码错误！');");
    writer.write("window.location.href = 'login.html'");
    writer.write("</script>");
    writer.flush();
    writer.close();
}
    }
}
