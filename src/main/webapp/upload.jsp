<%--
  Created by IntelliJ IDEA.
  User: ZENG
  Date: 2019/11/21
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图片上传页面</title>
    <style type="text/css">
        .box{
            width: 100px;
            height: 100px;
            border: 1px dashed #aaa;
            position: relative;
            top: 10px;
            left:10px;
        }
        .box img {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
        }
        .select-file {
            position: absolute;
            top: 0;
            left: 0;
            height: 100%;
            width: 100%;
            opacity: 0;
            z-index: 9999;
            cursor: pointer;
        }
        .btn {
            margin-top: 20px;
            margin-left: 30px;
            width: 60px;
            height: 40px;
            border-radius: 10px;
            color: aliceblue;
            background-color: rgb(229, 115, 115);
            border: 1px solid rgb(229, 115, 115);
        }

    </style>
</head>
<body>

<form action="${pageContext.request.contextPath}/api/upload" method="post" enctype="multipart/form-data">
<div class="box">
    <input type="file" name="filename" class="select-file" multiple>
    <img src="https://niit-soft.oss-cn-hangzhou.aliyuncs.com/icon/_plus%20.png" class="img">

</div>
    <input type="submit" value="上传" class="btn">
</form>
<p>${ msg}</p>
<p>${ url}</p>


</body>
</html>
