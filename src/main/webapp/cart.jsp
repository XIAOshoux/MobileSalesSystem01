<%@ page import="jsu.MobileSalesSystem.utils.DBUtils" %>
<%@ page import="jsu.MobileSalesSystem.daoImpl.PhoneDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jsu.MobileSalesSystem.bean.Phone" %>
<%@ page import="jsu.MobileSalesSystem.daoImpl.CartDaoImpl" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8" />
    <title>购物车</title>
</head>
<body>



<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">

            用户名：${user}
            <c:choose>
                <c:when test="${empty user}">    <!--如果 -->
                    <p class="navbar-brand"><a href="HomePageServlet" class="navbar-link">返回</a></p>
                </c:when>

                <c:otherwise>  <!--否则 -->
                  <p class="navbar-brand"><a href="HomePageServlet" class="navbar-link">返回</a></p>
                </c:otherwise>

            </c:choose>


        </div>
        <div class="navbar-right">
            <p class="navbar-text"><a href="cart.jsp" class="navbar-link">购物车</a></p>



            <c:choose>
                <c:when test="${empty user}">    <!--如果 -->
                    <p class="navbar-text"><a href="LogOutServlet" class="navbar-link">退出</a></p>
                </c:when>

                <c:otherwise>  <!--否则 -->
                    <p class="navbar-text"><a href="LogOutServlet" class="navbar-link">退出</a></p>
                </c:otherwise>

            </c:choose>






        </div>
    </div>
</nav>



<div class="container">


    <%

//        PhoneDaoImpl p=new PhoneDaoImpl();
//        List list= new ArrayList();
//        list= (List) p.getAllphone();
//        request.setAttribute("list", list);

        HttpSession session1 = request.getSession();
        String user=(String)session.getAttribute("user");

        CartDaoImpl cartDao=new CartDaoImpl();
        List list=new ArrayList();
        list= cartDao.findAll(user);

        request.setAttribute("usercart", list);

    %>


    <c:if test="${empty usercart}">

    <div class="alert alert-info" role="alert">
        <h1>空空如也，快去加购吧！！！</h1>
    </div>
    </c:if>


<c:forEach var="usercart" items="${usercart}">
    <div class="row">

        <div class="col-sm-3">
            <img src="/image/iphone.png" alt="SAMSUNG Galaxy A50 SM-A505 picture" width="134"
                 height="192"/>
        </div>
        <div class="col-sm-7">


            <td>ID:${usercart.phone_id}</td>
            <h1 class="text-center">${usercart.phone_name}</h1>
            <h6 class="text-center">${usercart.phone_classify}</h6>
            <h6 class="text-center">前置像素: 25</h6>
            <h6 class="text-center">后置像素: 25</h6>
        </div>
        <div class="col-sm-2">
            <div class="col-12">价格:${usercart.phone_price} 元</div>
            <div class="col-12">
                <form action="CartbuyServlet?id=${usercart.phone_id}" method="post">
                    <input type="submit" class="btn btn-default" value="下单"/>
                </form>
            </div>
            <div class="col-12">
                <form action="CartDeleteServlet?id=${usercart.phone_id}" method="post">
                    <input type="submit" class="btn btn-danger" value="删除"/>
                </form>
            </div>
        </div>
    </div>
</c:forEach>




<%--        <div class="container-fluid">--%>
<%--            <div class="row-fluid">--%>
<%--                <div class="span12">--%>
<%--                    <table class="table">--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th>--%>
<%--                                ID--%>
<%--                            </th>--%>
<%--                            <th>--%>
<%--                                产品--%>
<%--                            </th>--%>
<%--                            <th>--%>
<%--                                系统--%>
<%--                            </th>--%>
<%--                            <th>--%>
<%--                               价格--%>
<%--                            </th>--%>
<%--                            <th>--%>
<%--                                操作--%>
<%--                            </th>--%>
<%--                        </tr>--%>
<%--                        </thead>--%>
<%--                        <tbody>--%>
<%--                        <tr>--%>
<%--                            <td>--%>
<%--                                <c:forEach var="usercart" items="${usercart}">--%>
<%--                        <tr>--%>

<%--                            <td>${usercart.phone_id}</td>--%>
<%--                            <td>${usercart.phone_name}</td>--%>
<%--                            <td>${usercart.phone_classify}</td>--%>
<%--                            <td>${usercart.phone_price}</td>--%>
<%--                            <td>--%>
<%--                            <td><a href="CartDeleteServlet?id=${usercart.phone_id}"><button  class="btn">删除</button></a>--%>

<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        </c:forEach>--%>

<%--                        </tr>--%>
<%--                        </tbody>--%>
<%--                    </table>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--    <table>--%>
<%--        <tr>--%>
<%--            <c:forEach var="list" items="${list}">--%>
<%--        <tr>--%>

<%--            <td>${list.phone_name}</td>--%>
<%--            <td>${list.phone_classify}</td>--%>
<%--            <td>${list.phone_price}</td>--%>

<%--        </tr>--%>
<%--        </c:forEach>--%>
<%--        </tr>--%>
<%--    </table>--%>




</div>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
