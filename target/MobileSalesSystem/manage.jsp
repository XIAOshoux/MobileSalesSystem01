<%--
  Created by IntelliJ IDEA.
  User: Sail
  Date: 2020/12/30
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>


</head>
<body>

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>
                                ID
                            </th>
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
                                <c:forEach var="usercart" items="${usercart}">
                        <tr>

                            <td>${usercart.phone_id}</td>
                            <td>${usercart.phone_name}</td>
                            <td>${usercart.phone_classify}</td>
                            <td>${usercart.phone_price}</td>
                            <td>
                            <td><a href="CartDeleteServlet?id=${usercart.phone_id}"><button  class="btn">删除</button></a>

                            </td>
                        </tr>
                        </c:forEach>

                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>



</body>
</html>
