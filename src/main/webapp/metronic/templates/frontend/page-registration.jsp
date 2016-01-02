<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.2.0
Version: 3.1.3
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest (the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- Head BEGIN -->
<s:head/>
<head>
<meta charset="utf-8">
<title>Create new account</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<meta content="Metronic Shop UI description" name="description">
<meta content="Metronic Shop UI keywords" name="keywords">
<meta content="keenthemes" name="author">

<meta property="og:site_name" content="-CUSTOMER VALUE-">
<meta property="og:title" content="-CUSTOMER VALUE-">
<meta property="og:description" content="-CUSTOMER VALUE-">
<meta property="og:type" content="website">
<meta property="og:image" content="-CUSTOMER VALUE-">
<!-- link to image for socio -->
<meta property="og:url" content="-CUSTOMER VALUE-">

<link rel="shortcut icon" href="favicon.ico">

<!-- Fonts START -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
	rel="stylesheet" type="text/css">
<!-- Fonts END -->

<!-- Global styles START -->
<link
	href="../../assets/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../../assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Global styles END -->

<!-- Page level plugin styles START -->
<link
	href="../../assets/global/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link href="../../assets/global/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin styles END -->

<!-- Theme styles START -->
<link href="../../assets/global/css/components.css" rel="stylesheet">
<link href="../../assets/frontend/layout/css/style.css" rel="stylesheet">
<link href="../../assets/frontend/layout/css/style-responsive.css"
	rel="stylesheet">
<link href="../../assets/frontend/layout/css/themes/red.css"
	rel="stylesheet" id="style-color">
<link href="../../assets/frontend/layout/css/custom.css"
	rel="stylesheet">
<!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="corporate">

	<!-- BEGIN TOP BAR -->
	<div class="pre-header">
		<div class="container">
			<div class="row">
				<!-- BEGIN TOP BAR LEFT PART -->
				<div class="col-md-6 col-sm-6 additional-shop-info"></div>
				<!-- END TOP BAR LEFT PART -->
				<!-- BEGIN TOP BAR MENU -->
				<div class="col-md-6 col-sm-6 additional-nav">
					<ul class="list-unstyled list-inline pull-right">
						<li><a href="page-login.jsp">Log In</a></li>
						<li><a href="page-registration.jsp">Registration</a></li>
					</ul>
				</div>
				<!-- END TOP BAR MENU -->
			</div>
		</div>
	</div>
	<!-- END TOP BAR -->
	<!-- BEGIN HEADER -->
	<div class="header">
		<div class="container">
			<a class="site-logo" href="index.html"><img
				src="../../assets/frontend/layout/img/logos/logo-proto.jpg"
				alt="Metronic FrontEnd"></a> <a href="javascript:void(0);"
				class="mobi-toggler"><i class="fa fa-bars"></i></a>

			<!-- BEGIN NAVIGATION -->
			<div class="header-navigation pull-right font-transform-inherit">
				<ul>
					<!-- BEGIN TOP SEARCH -->
					<li class="menu-search"><span class="sep"></span> <i
						class="fa fa-search search-btn"></i>
						<div class="search-box">
							<form action="#">
								<div class="input-group">
									<input type="text" placeholder="Search" class="form-control">
									<span class="input-group-btn">
										<button class="btn btn-primary" type="submit">Search</button>
									</span>
								</div>
							</form>
						</div></li>
					<!-- END TOP SEARCH -->
				</ul>
			</div>
			<!-- END NAVIGATION -->
		</div>
	</div>
	<!-- Header END -->

	<div class="main">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="#">Pages</a></li>
				<li class="active">Create new account</li>
			</ul>
			<!-- BEGIN SIDEBAR & CONTENT -->
			<div class="row margin-bottom-40">

				<!-- BEGIN CONTENT -->
				 
					<div class="col-md-9 col-sm-9">
					<h1>Create an account</h1>
					<div class="content-form-page">
						<div class="row">
							<div class="col-md-7 col-sm-7">
								<s:form action="performSignup" method="post"
									class="form-horizontal" role="form">
									<fieldset>
										<legend>Your personal details</legend>
										<s:fielderror fieldName="password"/>
										<s:fielderror fieldName="email"/>
										<s:fielderror fieldName="others"/>
										<s:fielderror fieldName="acType"/>
										
										<div class="form-group">
											<label for="firstname" class="col-lg-4 control-label">First
												Name <span class="require">*</span>
											</label>
											<div class="col-lg-8">
											
												<input type="text" name="firstname" class="form-control"
													id="firstname">
											</div>
										</div>
										<div class="form-group">
											<label for="lastname" class="col-lg-4 control-label">Last
												Name <span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<input type="text" name="lastname" class="form-control"
													id="lastname">
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-lg-4 control-label">Email
												<span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<input type="text" name="email" class="form-control"
													id="email">
											</div>
										</div>
									</fieldset>
									<fieldset>
										<legend>Your password</legend>
										<div class="form-group">
											<label for="password" class="col-lg-4 control-label">Password
												<span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Password" name="password" id="password"/>
											</div>
										</div>
										<div class="form-group">
											<label for="confirm-password" class="col-lg-4 control-label">Confirm
												password <span class="require">*</span>
											</label>
											<div class="col-lg-8">
												<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Password" name="confirmPass" id="confirm-password"/>
											</div>
										</div>
									</fieldset>
									<fieldset>
										<legend>Sign up as :</legend>
										
										<div class="clearfix">
													<div class="btn-group btn-group-circle" data-toggle="buttons">
														<label class="btn btn-default active">
														<input type="radio" class="toggle" name="roll" value="student" > Student </label>
														<label class="btn btn-default">
														<input type="radio" class="toggle" name="roll" value="instructor"> Instructor </label>
													</div>
												</div>
									</fieldset>
									<div class="row">
										<div
											class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
											<button type="submit" class="btn btn-primary">Create
												an account</button>
											<button type="button" class="btn btn-default">Cancel</button>
										</div>
									</div>
								</s:form>
							</div>

						</div>
					</div>
				</div>
				</div>
				<!-- END CONTENT -->
			</div>
			<!-- END SIDEBAR & CONTENT -->
		</div>
	 


	<!-- BEGIN FOOTER -->
	<div class="footer">
		<div class="container">
			<div class="row">
				<!-- BEGIN COPYRIGHT -->
				<div class="col-md-6 col-sm-6 padding-top-10">
					2015 © Code Spark. ALL Rights Reserved. <a href="#">Privacy
						Policy</a> | <a href="#">Terms of Service</a>
				</div>
				<!-- END COPYRIGHT -->
			</div>
		</div>
	</div>
	<!-- END FOOTER -->

	<!-- Load javascripts at bottom, this will reduce page load time -->
	<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
	<!--[if lt IE 9]>
    <script src="../../assets/global/plugins/respond.min.js"></script>
    <![endif]-->
	<script src="../../assets/global/plugins/jquery-1.11.0.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/jquery-migrate-1.2.1.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="../../assets/frontend/layout/scripts/back-to-top.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<script
		src="../../assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script src="../../assets/global/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>

	<script src="../../assets/frontend/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();
            Layout.initUniform();
            Layout.initTwitter();
        });
    </script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
ml>
