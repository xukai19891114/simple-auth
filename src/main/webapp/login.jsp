<%@ page import="java.net.URLEncoder" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html lang="zh-CN">
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	request.setAttribute("basePath", basePath);
%>
<%
    String ret = request.getParameter("ret");
    if(StringUtils.isNotBlank(ret)) {
        ret = URLEncoder.encode(ret);
    } else {
        ret = "";
    }
%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>登陆</title>
	
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/login.css" />

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
		<div id="body">
			<div class="login">
				<form class="form-signin" action="<%=basePath %>/sys/user/login" method="post">
					<div class="form-group">
						<label for="inputEmail" class="col-md-4 control-label">用户名:</label>
						<div class="col-md-8">
							<input type="text" id="inputEmail" name="username" class="form-control" placeholder="用户名" required/>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-md-4 control-label">密&nbsp;&nbsp;&nbsp;码:</label>
						<div class="col-md-8">
							<input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required/>
						</div>
					</div>
					<label class="col-md-4"></label>
					<div class="col-md-8" style="color: red;">${error}</div>
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-8">
							<button class="btn btn-warning btn-block" type="submit">登 陆</button>
						</div>
					</div>
				</form>
			</div>
	</body>
</html>
