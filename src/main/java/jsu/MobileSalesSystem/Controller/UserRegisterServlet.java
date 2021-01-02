package jsu.MobileSalesSystem.Controller;

import jsu.MobileSalesSystem.bean.User;
import jsu.MobileSalesSystem.daoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(urlPatterns = "/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //编码格式
        response.setContentType("text/html;charset=UTF-8");
        //从页面提交的input标签数据
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address=request.getParameter("address");

        //新建User对象，封装
        User user=new User(null,username,password,address,new Date());
        System.out.println(user.toString());
        UserDaoImpl userimpl=new UserDaoImpl();
        Integer count = null;
        try {
             count = userimpl.selectUserCount(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(count>0&&count!=null){
            // 数据库中已经有相同的email的用户
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('申请注册的email已经被占用！');");
            writer.write("window.location.href = 'register.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else {

            boolean flag = false;
            try {
                flag = userimpl.saveUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (flag == true)
                response.sendRedirect("/MobileSalesSystem/login.html");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost( request,  response);
    }
}
