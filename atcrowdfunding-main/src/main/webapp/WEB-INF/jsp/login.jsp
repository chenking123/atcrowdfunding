<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">

		<form id="loginform" action="${APP_PATH }/main.htm" method="post"
			class="form-signin" role="form">
			<h2 class="form-signin-heading">
				<i class="glyphicon glyphicon-log-in"></i> 用户登录
			</h2>
			<br />
			<h4>${exception.message }</h4>


			<div class="form-group has-success has-feedback">
				<input type="text" class="form-control" id="floginacct"
					name="loginacct" placeholder="请输入登录账号" value="lisi" autofocus> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="password" class="form-control" value="123456" id="fuserpswd"
					name="userpswd" placeholder="请输入登录密码" style="margin-top: 10px;">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<select class="form-control" id="ftype" name="type">
					<option value="member">会员</option>
					<option value="user">管理</option>
				</select>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					记住我
				</label> <br> <label> 忘记密码 </label> <label style="float: right">
					<a href="${APP_PATH }/reg.htm">我要注册</a>
				</label>
			</div>
			<a class="btn btn-lg btn-success btn-block" onclick="dologin()">
				登录</a>
		</form>
	</div>
	<script src="${APP_PATH }/jquery/jquery-2.1.1.min.js"></script>
	<script src="${APP_PATH }/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/jquery/layer/layer.js"></script>
	<script>
		function dologin() {

			var floginacct = $("#floginacct");
			var fuserpswd = $("#fuserpswd");
			var ftype = $("#ftype");

			//对于表单数据而言不能用null进行判断
			if ($.trim(floginacct.val()) == "") {
				//alert("用户账号不能为空");
				layer.msg("用户账号不能为空",{time:1000,icon:5,shift:6},function(){
					floginacct.val("");
					floginacct.focus();
				});
				return false;
			}
			if (fuserpswd.val() == "") {
				//alert("密码不能为空");
				layer.msg("密码不能为空",{time:1000,icon:5,shift:6},function(){
					fuserpswd.val("");
					fuserpswd.focus();
				});
				return false;
			}
			
			//var loadingIndex=-1;

			$.ajax({
				type : "POST",
				data : {
					"loginacct" : floginacct.val(),
					"userpswd" : fuserpswd.val(),
					"type" : ftype.val()
				},
				url : "${APP_PATH}/dologin.do",
				beforeSend : function() {
					//一般做表单数据验证
					//loadingIndex=layer.msg("正在登陆...",{icon:16});
					return true;
				},
				success : function(result) {
					//layer.close(loadingIndex);
					if (result.success) {
						//alert("登陆成功！");
						layer.msg("登陆成功！",{time:1000,icon:6,shift:6},function(){
							$("#loginform").submit();
						});
						//跳转主页面
						//$("#loginform").submit();
						//windows.location.href="${APP_PATH }/main.htm"
					} else {
						//alert("登陆失败，请重新登陆！");
						layer.msg("登陆失败，请重新登陆！",{time:1000,icon:5,shift:6});
					}

				}
			});

			/* $("#loginform").submit();
			var type = $(":selected").val();
			if ( type == "user" ) {
			    window.location.href = "main.html";
			} else {
			    window.location.href = "index.html";
			} */
		}
	</script>
</body>
</html>