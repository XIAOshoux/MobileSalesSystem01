<%--
  Created by IntelliJ IDEA.
  User: Sail
  Date: 2020/12/31
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<h1>所有手机</h1>
<div class="table_div">
    <div class="div_clear">

        <div class="center_top">
            <span style="font-weight:bold">你当前的位置</span>：所有手机
        </div>
    </div>
    <div class="center_center">
        <div class="table_content">
            <table cellspacing="0px" cellpadding="0px">
                <thead>
                <tr>
                    <th width="15%">手机编号</th>
                    <th width="15%">手机名称</th>
                    <th width="10%">手机系统</th>
                    <th width="15%">手机价格</th>
                    <th wdith="15%" style="border-right:none">操作</th>
                </tr>
                </thead>



                <tbody id="context">

<c:if test="${not empty requestScope.m_phone.list}">

    <c:forEach items="${requestScope.m_phone.list}" var="phone">
        <tr>
                    <td width="15%" id="${phone.phone_id}">${phone.phone_id}</td>
                    <td width="15%"><span>${phone.phone_name}</span></td>
                    <td width="10%">${phone.phone_classify}</td>
                    <td width="15%">${phone.phone_price}</td>
                    <td width="15%" style="border-right:none">
                        <a  href="#" id="update" class="tbox">修改</a>
                        <a href="PhoneDeleteServlet?id=${phone.phone_id}">删除</a>
                    </td>
                </tr>
    </c:forEach>
</c:if>

 </tbody>
            </table>
        </div>
    </div>
</div>


<%--<a style="display:block;width:200px;height:42px;line-height:42px;font-size:18px;text-align:center;margin:40px auto;font-weight:800;" href="#" class="tbox">后台管理</a>--%>

<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <h4 class="modal-title" align="center">修改信息</h4>
                <br/>
                <form class="form-horizontal" role="form" action="UpdateServlet" method="get">
                    <input type="hidden" class="form-control" id="num" name="phone_id" placeholder="id">

                    <div class="form-group">
                        <label for="phonename" class="col-sm-offset-2 col-sm-2 control-label">手机名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="phonename" name="phone_name" placeholder="asdfasd">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="classify" class="col-sm-offset-2 col-sm-2 control-label">系统型号</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="classify" name="phone_classify" placeholder="123">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="col-sm-offset-2 col-sm-2 control-label">手机价格</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="price" name="phone_price" placeholder="456">
                        </div>
                    </div>

                <script type="text/javascript">

                    $(function(){

                        $(".tbox").click(function(){
                            $('#myModal').modal('show') //显示模态框
                        })

                    });



                        $(function(){
                            $("tbody").on("click","tr",function(){
                                var _this = $(this).children();

                                var num=_this[0].innerText;
                                console.log(num)

                                var name=_this[1].innerText;
                                console.log(name)

                                var classify=_this[2].innerText;
                                console.log(classify)

                                var price=_this[3].innerText;
                                console.log(price)

                                $("#num").val(num)
                                $("#phonename").val(name)
                                $("#classify").val(classify)
                                $("#price").val(price)

                            })
                        })

                    </script>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-5">
                            <button id="submitBtn" type="submit" class="btn btn-default btn-block btn-primary">修改</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
        <!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script>
$(function(){

$(".addbox").click(function(){
$('#addModal').modal('show') //显示模态框
})
});
</script>

<script>
$(function(){
$(".seabox").click(function(){
$('#seaModal').modal('show') //显示模态框
})
});
</script>




<div class="modal fade" id="addModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <h4 class="modal-title" align="center">添加手机</h4>
                <br/>
                <form class="form-horizontal" role="form" action="AddPhoneServlet" method="get">
                    <div class="form-group">
                        <label for="addphonename" class="col-sm-offset-2 col-sm-2 control-label">手机名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="addphonename" name="addname" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addclassify" class="col-sm-offset-2 col-sm-2 control-label">系统型号</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="addclassify" name="addclassify" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addprice" class="col-sm-offset-2 col-sm-2 control-label">手机价格</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="addprice" name="addprice" placeholder="">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-5">
                            <button id="add" type="submit" class="btn btn-default btn-block btn-primary">添加</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
        <!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="modal fade" id="seaModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <h4 class="modal-title" align="center">查询</h4>
                <br/>
                <form class="form-horizontal" role="form" action="SeaPhoneServlet" method="get">
                    <div class="form-group">
                        <label for="seaname" class="col-sm-offset-2 col-sm-2 control-label">手机名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="seaname" name="seaname" placeholder="请输入手机名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-5">
                            <button id="sea" type="submit" class="btn btn-default btn-block btn-primary">查询</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
        <!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<script type="text/javascript">
    (function() {
        var s = "_" + Math.random().toString(36).slice(2);
        document.write('<div style="" id="' + s + '"></div>');
        (window.slotbydup = window.slotbydup || []).push({
            id: "u4923786",
            container:  s }); })();
</script>
<script type="text/javascript" src="//cpro.baidustatic.com/cpro/ui/c.js" async="async" defer="defer" ></script>

<%--<div align="center">--%>
<%--    <a href="javascript:beforePage('${pageBean.beforePage}')">上一页</a>--%>
<%--    共${pageBean.totalPages}页 共${pageBean.totalRows}行--%>
<%--    第${pageBean.currentPage}页--%>
<%--    每页${pageBean.pageSize}行--%>
<%--    <a href="javascript:afterPage('${pageBean.afterPage}')">下一页</a>--%>
<%--</div>--%>




<div class="div_clear">
    <div class="table_foot">
        <span>&nbsp;&nbsp;共有 ${m_phone.totalRows}条记录，当前第 ${m_phone.currentPage}/${m_phone.totalPages}页</span>

        <div style="float:right;padding-right:30px">
            <div>
                <button class="seabox">查询</button>
            </div>
            <div>
                <button class="addbox">添加手机</button>
            </div>
            <a href="javascript:beforePage('${m_phone.beforePage}')"><input type="button" value="上页" /></a>


            <a href="javascript:afterPage('${m_phone.afterPage}')"> <input type="button" value="下页" /></a>
        </div>
    </div>
</div>

<script>
    function beforePage(page) {

        window.location="${appPath}/MobileSalesSystem/ManagePhoneServlet?currentPage="+page+"&pageSize=${m_phone.pageSize}";
    }
    function afterPage(page) {

        window.location="${appPath}/MobileSalesSystem/ManagePhoneServlet?currentPage="+page+"&pageSize=${m_phone.pageSize}";
    }
</script>
</body>
</html>
