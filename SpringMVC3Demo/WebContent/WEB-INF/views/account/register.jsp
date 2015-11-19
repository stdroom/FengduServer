<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

<html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>Conquer | 注册</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<meta name="MobileOptimized" content="320">
	
	<%@ include file="../shared/importCss.jsp"%>
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="<c:url value='/css/pages/login.css'/>" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->
	
	<%@ include file="../shared/importJs.jsp"%>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="<c:url value='/plugins/jquery-validation/dist/jquery.validate.min.js'/>" type="text/javascript"></script>   
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/js/account.validate.js'/>" type="text/javascript"></script>  
	<!-- END PAGE LEVEL SCRIPTS -->
	
	<link rel="shortcut icon" href="favicon.ico" />
</head>

<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN LOGO -->
	<div class="logo">
		<img src="assets/img/logo.png" alt="" /> 
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN REGISTRATION FORM -->
		<form:form modelAttribute="contentModel" class="register-form" method="POST">
			<h3 >注册新账户</h3>
			<p>请输入个人信息：</p>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">姓名</label>
				<div class="input-icon">
					<i class="icon-font"></i>
					<form:input path="name" class="form-control placeholder-no-fix" autocomplete="off" placeholder="姓名"/><br/>
					<form:errors path="name" class="field-has-error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">邮箱</label>
				<div class="input-icon">
					<i class="icon-envelope"></i>
					<form:input path="email" class="form-control placeholder-no-fix" autocomplete="off" placeholder="邮箱"/><br/>
					<form:errors path="email" class="field-has-error"></form:errors>
				</div>
			</div>		
			<p>请输入账户信息：</p>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<div class="input-icon">
					<i class="icon-user"></i>
					<form:input path="username" class="form-control placeholder-no-fix" autocomplete="off" placeholder="用户名"/><br/>
					<form:errors path="username" class="field-has-error"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="input-icon">
					<i class="icon-lock"></i>
					<form:password path="password" class="form-control placeholder-no-fix" autocomplete="off" placeholder="密码"/><br/>
					<form:errors path="password" class="field-has-error"></form:errors> 
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">确认密码</label>
				<div class="controls">
					<div class="input-icon">
						<i class="icon-ok"></i>
						<form:password path="confirmPassword" class="form-control placeholder-no-fix" autocomplete="off" placeholder="确认密码"/><br/>
						<form:errors path="confirmPassword" class="field-has-error"></form:errors> 
					</div>
				</div>
			</div>
			<div class="form-group">
				<label>
					<form:checkbox path="agreement"/> 我同意 <a href="#">服务条款</a> 和 <a href="#">隐私政策</a>
				</label>  
				<div id="register_agreement_error"></div>
				<form:errors path="agreement" class="field-has-error"></form:errors>
			</div>
			<div class="form-actions">
				<button id="register-back-btn" type="button" class="btn btn-default">
				<i class="m-icon-swapleft"></i>  返回
				</button>
				<button type="submit" id="register-submit-btn" class="btn btn-info pull-right">
				注册 <i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
		</form:form>
		<!-- END REGISTRATION FORM -->     
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">
		2013 &copy; Conquer. Admin Dashboard Template.
	</div>
	<!-- END COPYRIGHT -->
	
	<script type="text/javascript">
		$(function() {
			App.init();
		  	AccountValidate.handleRegister();
	    });
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>