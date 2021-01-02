package jsu.MobileSalesSystem.Controller;

import jsu.MobileSalesSystem.bean.Phone;
import jsu.MobileSalesSystem.daoImpl.PhoneDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/SeePhoneServlet")
public class SeePhoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int phone_id=Integer.parseInt(id);

        PhoneDaoImpl p=new PhoneDaoImpl();
        Phone phone= new Phone();
        try {
            phone= (Phone)p.findById(phone_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(phone);

       // request.setAttribute("phone",phone);
        request.getSession().setAttribute("phone", phone);

        response.sendRedirect("/MobileSalesSystem/see.jsp");

       // request.getRequestDispatcher("/see.jsp").forward(request,response);
      //  response.sendRedirect("/MobileSalesSystem/see.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
