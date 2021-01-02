<%--
  Created by IntelliJ IDEA.
  User: Sail
  Date: 2020/12/27
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <meta charset="utf-8" />
    <title>手机商城</title>
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
                <input class="form-check-input" type="checkbox" name="marka" value="SAMSUNG"} >
                <label class="form-check-label">
                    三星
                </label>
            </div>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="marka" value="XIAOMI"} >
                <label class="form-check-label">
                    小米
                </label>
            </div>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="marka" value="APPLE"} >
                <label class="form-check-label">
                    苹果
                </label>
            </div>

            <button type="submit" class="btn btn-default">搜索</button>
        </form>
        <form action="/PhoneStore/" method="get">
            <button type="submit" class="btn btn-danger">清空</button>
        </form></div>
    <div class="col-sm-10">

        <div class="row">
            <div class="col-sm-2">
                <img src="/image/iphone.png" alt="S5 picture" width="134"
                     height="192"/>

            </div>
<%--            <%--%>
<%--                request.setAttribute("name", "lucy");--%>
<%--            %>--%>
<%--            asdfasname:${name}--%>



<%--            <c:if test="${empty name}">--%>
<%--                12345644--%>
<%--            </c:if>--%>
<%--            <c:if test="${not empty name}">--%>

<%--                <script>--%>
<%--                    $(function () {--%>
<%--                        var a=$("#h1").text();--%>

<%--                    })--%>
<%--                </script>--%>
<%--            </c:if>--%>




            <div class="col-sm-6">
                <a href="SeePhoneServlet?id=1">
                    <h1 id = 'h1' >SAMSUNG Galaxy A50 SM-A505</h1></a>
                <h6>操作系统: ANDROID</h6>
                <h6>前置像素: 25</h6>
                <h6>后置像素: 25</h6>
            </div>
            <div class="col-sm-2">

                <div class="col-12">￥1 599,9</div>
                <div class="col-12">
                    <form action="addToBasketServlet?id=1" method="post">
                        <input type="submit" class="btn btn-default" value="加购物车"/>
                    </form>
                </div>
                <div class="col-12">
                    <form action="buyNowServlet?id=1" method="post">
                        <input type="submit" class="btn btn-default" value="立即购买"/>
                    </form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-2">
                <img src="/image/iphone.png" alt="SAMSUNG Galaxy A40 SM-A405F picture" width="134"
                     height="192"/>
            </div>
            <div class="col-sm-6">
                <a href="SeePhoneServlet?id=2">
                    <h1>SAMSUNG Galaxy A40 SM-A405F</h1></a>
                <h6>操作系统: ANDROID</h6>
                <h6>前置像素: 25</h6>
                <h6>后置像素: 25</h6>
            </div>
            <div class="col-sm-2">

                <div class="col-12">￥1 149,9</div>
                <div class="col-12">
<%--                    <script>--%>
<%--                        $(function () {--%>
<%--                            $("#submit").click(function () {--%>

<%--                            })--%>
<%--                        })--%>
<%--                    </script>--%>
                    <form action="addToBasketServlet?id=2" method="post">
                        <input type="submit" class="btn btn-default" value="加购物车"/>
                    </form>
                </div>
                <div class="col-12">
                    <form action="buyNowServlet?id=2" method="post">
                        <input type="submit" class="btn btn-default" value="立即购买"/>
                    </form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-2">
                <img src="/image/iphone.png" alt="SAMSUNG Galaxy S10 SM-G973 picture" width="134"
                     height="192"/>
            </div>
            <div class="col-sm-6">
                <a href="SeePhoneServlet?id=3">
                    <h1>SAMSUNG Galaxy S10 SM-G973</h1></a>
                <h6>操作系统: ANDROID</h6>
                <h6>前置像素: 25</h6>
                <h6>后置像素: 25</h6>
            </div>
            <div class="col-sm-2">

                <div class="col-12">￥3 949,9</div>
                <div class="col-12">
                    <form action="addToBasketServlet?id=3" method="post">
                        <input type="submit" class="btn btn-default" value="加购物车"/>
                    </form>
                </div>
                <div class="col-12">
                    <form action="buyNowServlet?id=3" method="post">
                        <input type="submit" class="btn btn-default" value="立即购买"/>
                    </form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-2">
                <img src="/image/iphone.png" alt="XIAOMI Galaxy A10 SM-A105F picture" width="134"
                     height="192"/>
            </div>
            <div class="col-sm-6">
                <a href="SeePhoneServlet?id=4">
                    <h1>SAMSUNG Galaxy A10 SM-A105F</h1></a>
                <h6>操作系统: ANDROID</h6>
                <h6>前置像素: 25</h6>
                <h6>后置像素: 25</h6>
            </div>
            <div class="col-sm-2">

                <div class="col-12">￥649,9</div>
                <div class="col-12">
                    <form action="addToBasketServlet?id=4" method="post">
                        <input type="submit" class="btn btn-default" value="加购物车"/>
                    </form>
                </div>
                <div class="col-12">
                    <form action="buyNowServlet?id=4" method="post">
                        <input type="submit" class="btn btn-default" value="立即购买"/>
                    </form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-2">
                <img src="/image/iphone.png" alt="APPLE iPhone X 64GB picture" width="134"
                     height="192"/>
            </div>
            <div class="col-sm-6">
                <a href="SeePhoneServlet?id=5">
                    <h1>APPLE iPhone X 64GB</h1></a>
                <h6>操作系统: ANDROID</h6>
                <h6>前置像素: 25</h6>
                <h6>后置像素: 25</h6>
            </div>
            <div class="col-sm-2">

                <div class="col-12">￥4 049,9</div>
                <div class="col-12">
                    <form action="addToBasketServlet?id=5" method="post">
                        <input type="submit" class="btn btn-default" value="加购物车"/>
                    </form>
                </div>
                <div class="col-12">
                    <form action="buyNowServlet?id=5" method="post">
                        <input type="submit" class="btn btn-default" value="立即购买"/>
                    </form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-2">
                <img src="/image/iphone.png" alt="XIAOMI Redmi Note 7 4/64 GB picture" width="134"
                     height="192"/>
            </div>
            <div class="col-sm-6">
                <a href="SeePhoneServlet?id=6">
                    <h1>XIAOMI Redmi Note 7 4/64 GB</h1></a>
                <h6>操作系统: ANDROID</h6>
                <h6>前置像素: 25</h6>
                <h6>后置像素: 25</h6>
            </div>
            <div class="col-sm-2">

                <div class="col-12">￥649,9 </div>
                <div class="col-12">
                    <form action="addToBasketServlet?id=6" method="post">
                        <input type="submit" class="btn btn-default" value="加购物车"/>
                    </form>
                </div>
                <div class="col-12">
                    <form action="buyNowServlet?id=6" method="post">
                        <input type="submit" class="btn btn-default" value="立即购买"/>
                    </form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-2">
                <img src="/image/iphone.png" alt="XIAOMI Mi 9 SE 6/128GB picture" width="134"
                     height="192"/>
            </div>
            <div class="col-sm-6">
                <a href="SeePhoneServlet?id=7">
                    <h1>XIAOMI Mi 9 SE 6/128GB</h1></a>
                <h6>操作系统: ANDROID</h6>
                <h6>前置像素: 25</h6>
                <h6>后置像素: 25</h6>
            </div>
            <div class="col-sm-2">

                <div class="col-12">￥1 559,9 </div>
                <div class="col-12">
                    <form action="addToBasketServlet?id=7" method="post">
                        <input type="submit" class="btn btn-default" value="加购物车"/>
                    </form>
                </div>
                <div class="col-12">
                    <form action="buyNowServlet?id=7" method="post">
                        <input type="submit" class="btn btn-default" value="立即购买"/>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<%--<script src="webjars/jquery/3.4.1/jquery.min.js"/>--%>
<%--<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>--%>


<

</body>
</html>
