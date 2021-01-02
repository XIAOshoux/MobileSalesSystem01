package jsu.MobileSalesSystem.Controller;

import jsu.MobileSalesSystem.bean.User;
import jsu.MobileSalesSystem.dao.UserDao;
import jsu.MobileSalesSystem.daoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet( request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的email和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");




        // 根据email和密码查询申请人

UserDaoImpl userDaoimpl =new UserDaoImpl();


            User user = null;
        try {
            user = userDaoimpl.getUserId(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

      //  System.out.println("登录"+user.toString());

        // 判断applicant == null,返回登录界面，不为空，就进入主页面
        if(user!=null){
            request.getSession().setAttribute("user", username);

            request.getSession().setAttribute("address", user.getVaddress());



            response.sendRedirect("/MobileSalesSystem/HomePageServlet");
        }else {

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
