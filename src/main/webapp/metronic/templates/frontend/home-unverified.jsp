<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
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
<head>
<meta charset="utf-8">
<title>Home</title>

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
						<li><a href="<s:url action="logout"/>">Sign Out</a></li>
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
				<li><a href="#">Student</a></li>
			</ul>

			<!-- BEGIN SIDEBAR & CONTENT -->
			<div class="row margin-bottom-40">
				<!-- BEGIN CONTENT -->
				<div class="col-md-12 col-sm-12">
					<h1>Home</h1>
					<div class="content-page">
						<div class="row">
							<!-- BEGIN SERVICE BLOCKS -->
							<div class="col-md-7">
								<h2>Unverified Account</h2>
								<p>Your account is not verified yet. Please check your email
									for verification. </p>
								<div class="col-md-6 col-sm-6 additional-nav">
                    				<ul class="list-unstyled list-inline pull-right">
                        				<li><a href="<s:url action="resendVerificationMail"/>">Resend Verification mail.</a></li>
                   					 </ul>
                				</div>
								<div class="row margin-bottom-20">
									
								</div>
							</div>
							<!-- END SERVICE BLOCKS -->

							<!-- BEGIN VIDEO AND TESTIMONIALS -->
							<div class="col-md-5">
								<!-- BEGIN VIDEO -->
								<iframe height="270" allowfullscreen=""
									style="width: 100%; border: 0"
									src="../../assets/frontend/pages/img/people/no-photo-male.png"
									class="margin-bottom-10"></iframe>
								<!-- END VIDEO -->

							</div>
							<!-- END BEGIN VIDEO AND TESTIMONIALS -->
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
						<script
							src="../../assets/global/plugins/jquery-migrate-1.2.1.min.js"
							type="text/javascript"></script>
						<script
							src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js"
							type="text/javascript"></script>
						<script src="../../assets/frontend/layout/scripts/back-to-top.js"
							type="text/javascript"></script>
						<!-- END CORE PLUGINS -->

						<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
						<script
							src="../../assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"
							type="text/javascript"></script>
						<!-- pop up -->

						<script src="../../assets/frontend/layout/scripts/layout.js"
							type="text/javascript"></script>
						<script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initTwitter();
        });
    </script>
						<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>