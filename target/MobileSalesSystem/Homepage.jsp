<%--
  Created by IntelliJ IDEA.
  User: Sail
  Date: 2020/12/31
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored="false" %>




<%--
  Created by IntelliJ IDEA.
  User: dsl
  Date: 2020/12/4
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>分页查询</title>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
    <style>
        body{
            text-align:center;
        }
    </style>
</head>
<body>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">

        </div>
        <div class="navbar-right">
            <p class="navbar-text"><a href="order.jsp" class="navbar-link">我的订单</a></p>
            <p class="navbar-text"><a href="cart.jsp" class="navbar-link">购物车</a></p>



            <%--            <p class="navbar-text"><a href="/MobileSalesSystem/login.html" class="navbar-link">登录</a></p>--%>


            用户名：${user}
            <c:choose>
                <c:when test="${empty user}">    <!--如果 -->
                    <p class="navbar-text"><a href="/MobileSalesSystem/login.html" class="navbar-link">登录</a></p>
                </c:when>

                <c:otherwise>  <!--否则 -->
                    <p class="navbar-text"><a href="LogOutServlet" class="navbar-link">退出</a></p>
                </c:otherwise>

            </c:choose>



        </div>
    </div>
</nav>


<c:choose>
    <c:when test="${empty user}">    <!--如果 -->
        <h2>请登录</h2>
    </c:when>

    <c:otherwise>  <!--否则 -->
        <h2>您好 ${user}，欢迎您的到来，请加购吧！！！！</h2>
    </c:otherwise>

</c:choose>

<div class="container-fluid">

    <div class="col-sm-2">




        <form action="/produkty" method="get">

            <div class="form-check">
<%--                <input class="form-check-input" type="checkbox" name="marka" value="SAMSUNG"} >--%>
                <label class="form-check-label">
<%--                    三星--%>
                </label>
            </div>

            <div class="form-check">
<%--                <input class="form-check-input" type="checkbox" name="marka" value="XIAOMI"} >--%>
                <label class="form-check-label">
<%--                    小米--%>
                </label>
            </div>

            <div class="form-check">
<%--                <input class="form-check-input" type="checkbox" name="marka" value="APPLE"} >--%>
                <label class="form-check-label">
<%--                    苹果--%>
                </label>
            </div>

<%--            <button type="submit" class="btn btn-default">搜索</button>--%>
        </form>
        <form action="/PhoneStore/" method="get">
<%--            <button type="submit" class="btn btn-danger">清空</button>--%>
        </form></div>


<div class="col-sm-10">
<c:if test="${not empty requestScope.pageBean.list}">

    <c:forEach items="${requestScope.pageBean.list}" var="phone">



        <div class="row">
            <div class="col-sm-2">
                <img src="/image/iphone.png" alt="APPLE iPhone X 64GB picture" width="134"
                     height="192"/>
            </div>
            <div class="col-sm-6">
                <a href="SeePhoneServlet?id=${phone.phone_id}">
                    <h1>${phone.phone_name}</h1></a>
                <h6>操作系统: ${phone.phone_classify}</h6>
                <h6>前置像素: 25</h6>
                <h6>后置像素: 25</h6>
            </div>
            <div class="col-sm-2">

                <div class="col-12">￥${phone.phone_price}</div>
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

    </c:forEach>
</c:if>
</div>
</div>
<div align="center">
    <a href="javascript:beforePage('${pageBean.beforePage}')">上一页</a>
    共${pageBean.totalPages}页 共${pageBean.totalRows}行
    第${pageBean.currentPage}页
    每页${pageBean.pageSize}行
    <a href="javascript:afterPage('${pageBean.afterPage}')">下一页</a>
</div>

<script>
    function beforePage(page) {

        window.location="${appPath}/MobileSalesSystem/HomePageServlet?currentPage="+page+"&pageSize=${pageBean.pageSize}";
    }
    function afterPage(page) {

        window.location="${appPath}/MobileSalesSystem/HomePageServlet?currentPage="+page+"&pageSize=${pageBean.pageSize}";
    }
</script>

</body>
</html>









<%--<c:forEach var="usercart" items="${usercart}">--%>

<%--<div class="col-sm-6">--%>
<%--    <a href="SeePhoneServlet?id=1">--%>
<%--        <h1 id = 'h1' >SAMSUNG Galaxy A50 SM-A505</h1></a>--%>
<%--    <h6>操作系统: ANDROID</h6>--%>
<%--    <h6>前置像素: 25</h6>--%>
<%--    <h6>后置像素: 25</h6>--%>
<%--</div>--%>
<%--<div class="col-sm-2">--%>

<%--    <div class="col-12">￥1 599,9</div>--%>
<%--    <div class="col-12">--%>
<%--        <form action="addToBasketServlet?id=1" method="post">--%>
<%--            <input type="submit" class="btn btn-default" value="加购物车"/>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--    <div class="col-12">--%>
<%--        <form action="buyNowServlet?id=1" method="post">--%>
<%--            <input type="submit" class="btn btn-default" value="立即购买"/>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="row">--%>
<%--    <div class="col-sm-2">--%>
<%--        <img src="/image/iphone.png" alt="SAMSUNG Galaxy A40 SM-A405F picture" width="134"--%>
<%--             height="192"/>--%>
<%--    </div>--%>

<%--    </c:forEach>--%>




</body>
</html>
