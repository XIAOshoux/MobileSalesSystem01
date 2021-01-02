package jsu.MobileSalesSystem.Controller;

import jsu.MobileSalesSystem.bean.Cart;
import jsu.MobileSalesSystem.daoImpl.CartDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = "/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        Integer phone_id=Integer.parseInt(id);
        System.out.println(phone_id);

        HttpSession session = request.getSession();
        String user=(String)session.getAttribute("user");
        System.out.println(user);

        CartDaoImpl cartDao=new CartDaoImpl();

boolean flag=false;

        try {
            flag=cartDao.Remove(user,phone_id);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(flag==true)
        {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('删除成功！');");
            writer.write("window.location.href = 'cart.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
        response.sendRedirect("/MobileSalesSystem/cart.jsp");
    }
}
