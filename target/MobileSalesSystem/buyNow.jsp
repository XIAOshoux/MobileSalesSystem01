<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8" />
    <title>现在下单</title>


    <style>
        body{
            text-align:center;
        }
    </style>

    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
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
            <h1 class="text-center">${buy.phone_name}</h1>
            <h6 class="text-center">操作系统: ${buy.phone_classify}</h6>
            <h6 class="text-center">前置像素: 25</h6>
            <h6 class="text-center">后置像素: 25</h6>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8">
            <h2>支付订单: ￥${buy.phone_price}</h2>
        </div>
        <div class="col-sm-2">


            <form action="buyServlet?id=${buy.phone_id}" method="post">
                <input type="submit" class="btn btn-default" value="购买"/>
            </form>


        </div>
        <div class="col-sm-2">
            <form action="HomePageServlet" method="get">
                <input type="submit" class="btn btn-danger" value="取消"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>
