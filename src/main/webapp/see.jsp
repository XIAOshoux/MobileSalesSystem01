<%--
  Created by IntelliJ IDEA.
  User: Sail
  Date: 2020/12/27
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="jsu.MobileSalesSystem.utils.DBUtils" %>
<%@ page import="jsu.MobileSalesSystem.daoImpl.PhoneDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jsu.MobileSalesSystem.bean.Phone" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>${phone.phone_name}</title>
</head>
<body>



<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <p class="navbar-brand"><a href="HomePageServlet" class="navbar-link">返回</a></p>
        </div>
        <div class="navbar-right">
            <p class="navbar-text"><a href="cart.jsp" class="navbar-link">购物车</a></p>



            <p class="navbar-text"><a href="LogOutServlet" class="navbar-link">退出</a></p>



        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <img src="/image/iphone.png" alt="SAMSUNG Galaxy A50 SM-A505 picture" width="134"
                 height="192"/>
        </div>
        <div class="col-sm-7">
            <h1 class="text-center">${phone.phone_name}</h1>
            <h6 class="text-center">系统：${phone.phone_classify}</h6>
            <h6 class="text-center">前置像素: 25</h6>
            <h6 class="text-center">后置像素: 25</h6>

<%--            <div class="col-sm-8">--%>

<%--                <h2>价格:${phone.phone_price} 元</h2>--%>
<%--            </div>--%>
<%--            <td>${list.phone_name}</td>--%>
<%--            <td>${list.phone_classify}</td>--%>
<%--            <td>${list.phone_price}</td>--%>
        </div>
        <div class="col-sm-2">
            <div class="col-12">价格:${phone.phone_price} 元</div>
            <div class="col-12">
                <form action="addToBasketServlet?id=${phone.phone_id}" method="post">
                    <input type="submit" class="btn btn-default" value="加购物车"/>
                </form>
            </div>
            <div class="col-12">
                <form action="buyNowServlet?id=${phone.phone_id}" method="post">
                    <input type="submit" class="btn btn-default" value="立即购买"/>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
