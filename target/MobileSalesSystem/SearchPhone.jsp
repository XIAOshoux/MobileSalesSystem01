<%--
  Created by IntelliJ IDEA.
  User: Sail
  Date: 2021/1/1
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored="false" %>

<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        编号
                    </th>
                    <th>
                        产品
                    </th>
                    <th>
                        型号
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
                        ${phone.phone_id}
                    </td>
                    <td>
                        ${phone.phone_name}
                    </td>
                    <td>
                       ${phone.phone_classify}
                    </td>
                    <td>
                       ${phone.phone_price}
                    </td>
                    <td>
                        <a  href="#" id="update" class="tbox">修改</a>
                        <a href="PhoneDeleteServlet?id=${phone.phone_id}">删除</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){

        $(".tbox").click(function(){
            $('#myModal').modal('show') //显示模态框
        })

    });
</script>

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



</body>
</html>
