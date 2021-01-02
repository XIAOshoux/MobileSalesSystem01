<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="jsu.MobileSalesSystem.daoImpl.OrderDaoImpl" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Sail
  Date: 2020/12/30
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8" />
    <title>我的订单</title>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
    <style>
        body{
            text-align:center;
        }
    </style>
</head>
<body>
<%
HttpSession session1 = request.getSession();
String user=(String)session.getAttribute("user");

//CartDaoImpl cartDao=new CartDaoImpl();
//List list=new ArrayList();
//list= cartDao.findAll(user);

    OrderDaoImpl orderDao=new OrderDaoImpl();
    List list =new ArrayList();
    list=orderDao.findAll(user);

    Iterator it = list.iterator();
    while (it.hasNext()){
        System.out.println(it.next());
    }

    request.setAttribute("userorder", list);

%>
<h1>我的订单</h1>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>
                                用户名
                            </th>
                            <th>
                                产品
                            </th>
                            <th>
                                收货地址
                            </th>
                            <th>
                               价格
                            </th>
                            <th>
                               日期
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <c:forEach var="userorder" items="${userorder}">
                        <tr>

                            <td>${userorder.ouser_name}</td>
                            <td>${userorder.ophone_name}</td>
                            <td>${userorder.order_adress}</td>
                            <td>${userorder.order_price}</td>
                            <td>${userorder.order_date}</td>

                        </tr>
                        </c:forEach>

                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

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



</body>
</html>
