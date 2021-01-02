

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8" />
    <title>订单成功</title>

    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>



<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <p class="navbar-brand"><a href="HomePageServlet" class="navbar-link"> 返回</a></p>
        </div>
        <div class="navbar-right">
            <p class="navbar-text"><a href="cart.jsp" class="navbar-link">购物车</a></p>



            <p class="navbar-text"><a href="LogOutServlet" class="navbar-link">退出</a></p>

        </div>
    </div>
</nav>


<div class="alert alert-success" role="alert">
    <h1>订单已成功付款</h1>
    <form action="HomePageServlet" method="get">
        <input type="submit" class="btn btn-info" value="返回首页">
    </form>
</div>

</body>
</html>
