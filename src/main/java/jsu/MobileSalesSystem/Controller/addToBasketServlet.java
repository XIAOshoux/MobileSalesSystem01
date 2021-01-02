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
import java.sql.SQLException;

@WebServlet(urlPatterns = "/addToBasketServlet")
public class addToBasketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
  Integer phone_id=Integer.parseInt(id);

         HttpSession session = request.getSession();
        String user=(String)session.getAttribute("user");
        System.out.println(user);

        if(user==null){
            response.sendRedirect("/MobileSalesSystem/login.html");
        }

        Cart cart1=new Cart();
        try {
            cart1= CartDaoImpl.getCartId(user,phone_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(cart1!=null)
        {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('亲亲，已经加购过啦，可以直接购买哦');");
            writer.write("window.location.href = 'HomePageServlet'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else {
            Cart cart = new Cart(null, user, phone_id);

            CartDaoImpl cartDao = new CartDaoImpl();
            try {

                System.out.println(cartDao.add(cart));
            } catch (Exception e) {
                e.printStackTrace();
            }

    PrintWriter writer = response.getWriter();
    writer.write("<script>");
    writer.write("alert('加购成功');");
    writer.write("window.location.href = 'HomePageServlet'");
    writer.write("</script>");
    writer.flush();
    writer.close();

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
