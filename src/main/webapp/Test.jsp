<%@ page import="jsu.MobileSalesSystem.utils.DBUtils" %>
<%@ page import="jsu.MobileSalesSystem.daoImpl.PhoneDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jsu.MobileSalesSystem.bean.Phone" %>
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

            ${user}
            <c:choose>
                <c:when test="${empty user}">    <!--如果 -->
                    22 <p class="navbar-brand"><a href="home.jsp" class="navbar-link">返回</a></p>
                </c:when>

                <c:otherwise>  <!--否则 -->
                    11   <p class="navbar-brand"><a href="userHome.jsp" class="navbar-link">返回</a></p>
                </c:otherwise>

            </c:choose>


        </div>
        <div class="navbar-right">
            <p class="navbar-text"><a href="/PhoneStore/basket" class="navbar-link">购物车</a></p>



            <c:choose>
                <c:when test="${empty user}">    <!--如果 -->
                    <p class="navbar-text"><a href="/PhoneStore/login" class="navbar-link">登录</a></p>
                </c:when>

                <c:otherwise>  <!--否则 -->
                    <p class="navbar-text"><a href="/PhoneStore/login" class="navbar-link">退出</a></p>
                </c:otherwise>

            </c:choose>

        </div>
    </div>
</nav>



<div class="container">


    <%

        PhoneDaoImpl p=new PhoneDaoImpl();
        List list= new ArrayList();
        list= (List) p.getAllphone();
        request.setAttribute("list", list);

    %>




    <c:if test="${empty list}">

        <div class="alert alert-info" role="alert">
            <h1>空空如也，快去加购吧！！！</h1>
        </div>
    </c:if>


    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <table class="table">
                    <thead>
                    <tr>

                        <th>
                            产品
                        </th>
                        <th>
                            系统
                        </th>
                        <th>
                            价格
                        </th>
                        <th>
                            操作
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <c:forEach var="list" items="${list}">
                    <tr>

                        <td>${list.phone_name}</td>
                        <td>${list.phone_classify}</td>
                        <td>${list.phone_price}</td>
                        <td>
                            <button  class="btn" type="submit">删除</button>
                        </td>
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




</div>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
