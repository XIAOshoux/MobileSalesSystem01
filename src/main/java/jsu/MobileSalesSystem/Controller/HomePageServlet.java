package jsu.MobileSalesSystem.Controller;

import jsu.MobileSalesSystem.bean.PageBean;
import jsu.MobileSalesSystem.bean.Phone;
import jsu.MobileSalesSystem.daoImpl.PhoneDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/HomePageServlet")
public class HomePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //1、每页多少行 pageSize
        String pageSizeStr=request.getParameter("pageSize");
        Integer pageSize=null;//每页多少行
        if(pageSizeStr!=null&&pageSizeStr.length()>0){
            pageSize=Integer.valueOf(pageSizeStr);
        }else{
            pageSize=3;
        }
        //2、当前是第几页 currentPage
        String currentPageStr=request.getParameter("currentPage");
        Integer currentPage=null;//当前查询第几页
        if(currentPageStr!=null&&currentPageStr.length()>0){
            currentPage=Integer.valueOf(currentPageStr);
        }else{
            currentPage=1;
        }
        //3、一共有多少行数据 totalRows
        Integer totalRows=0;

      //  CompanyDao companyDao=new CompanyDao();
        PhoneDaoImpl phoneDao =new PhoneDaoImpl();

        String sqlCount="select count(*) from tb_phone";
        System.out.println(sqlCount);
        //totalRows=companyDao.getCompanyCount(sqlCount);
        try {
            totalRows=phoneDao.getPhoneCount(sqlCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 4、一共多少页 totalPages
        // 10,3,4页  , 10,5,2页 limit startRow,pageSize
        // Integer totalPages=totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
        // 5、起始行 startRow
        Integer startRow=(currentPage-1)*pageSize;

        StringBuffer sqlRow=new StringBuffer("SELECT " +
                "tb_phone.phone_id phone_id," +
                "tb_phone.phone_name phone_name," +
                "tb_phone.phone_classify phone_classify," +
                "tb_phone.phone_price phone_price " +
                "FROM " +
                "tb_phone");

        sqlRow.append(" limit ").append(startRow).append(",").append(pageSize);
         System.out.println(sqlRow);

        //把所有公司信息查询出来
        List<Phone> companyList= null;
        try {
            companyList = phoneDao.getCompanyListByPage(sqlRow.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PageBean pageBean = new PageBean(currentPage,pageSize,totalRows,companyList);

        request.setAttribute("pageBean",pageBean);
        System.out.println(pageBean.toString());

        request.getRequestDispatcher("Homepage.jsp").forward(request,response);


    }
}
