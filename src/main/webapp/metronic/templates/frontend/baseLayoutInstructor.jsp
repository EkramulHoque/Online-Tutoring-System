<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<style>
div#video_player_box{ width:550px; background:#000; margin:0px auto;}
div#video_controls_bar{ background: #333; padding:10px; color:#000; font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;}
button#playpausebtn{
	border:none;
	width:40px;
	height:18px;
	cursor:pointer;
	display: block;
}

input#seekslider{ width:520px; }
input#volumeslider{ 
width: 50px; 
 }
input[type='range'] {
    -webkit-appearance: none !important;
    background: #000;
	border:#666 1px solid;
    height:4px;
}
input[type='range']::-webkit-slider-thumb {
    -webkit-appearance: none !important;
    background: #FFF;
    height:15px;
    width:15px;
	border-radius:100%;
	cursor:pointer;
}

 

 
</style>
<script>
   

  

  var vid, playbtn, seekslider, curtimetext, durtimetext, mutebtn, volumeslider, fullscreenbtn;
  function intializePlayer(){
  	// Set object references
  	vid = document.getElementById("my_video");
  	//vid.src='${videoPath}';
  	playbtn = document.getElementById("playpausebtn");
  	seekslider = document.getElementById("seekslider");
  	curtimetext = document.getElementById("curtimetext");
  	durtimetext = document.getElementById("durtimetext");
  	mutebtn = document.getElementById("mutebtn");
  	volumeslider = document.getElementById("volumeslider");
  	fullscreenbtn = document.getElementById("fullscreenbtn");
  	// Add event listeners
  	playbtn.addEventListener("click",playPause,false);
  	seekslider.addEventListener("change",vidSeek,false);
  	vid.addEventListener("timeupdate",seektimeupdate,false);
  	mutebtn.addEventListener("click",vidmute,false);
  	volumeslider.addEventListener("change",setvolume,false);
  	fullscreenbtn.addEventListener("click",toggleFullScreen,false);

  	var s='${role}';
  	if(s=='instructor'){
  		document.getElementById("uploadBtn").style.display='block';
  	  	}
  }
  window.onload = intializePlayer;
  function playPause(){
	
	  
  	if(vid.paused){
  		vid.play();
  		playbtn.innerHTML="Pause";
  		 
  	} else {
  		vid.pause();
  		playbtn.innerHTML="Play";
  		 
  	}
  }
  function vidSeek(){
  	var seekto = vid.duration * (seekslider.value / 100);
  	vid.currentTime = seekto;
  	 
  	if(vid.currentTime==vid.duration){$
  		document.getElementById("Exam").style.display='block';

  	  	}
  }
  function seektimeupdate(){
  	var nt = vid.currentTime * (100 / vid.duration);
  	seekslider.value = nt;
  	 
  	var curmins = Math.floor(vid.currentTime / 60);
  	var cursecs = Math.floor(vid.currentTime - curmins * 60);
  	var durmins = Math.floor(vid.duration / 60);
  	var dursecs = Math.floor(vid.duration - durmins * 60);
  	if(cursecs < 10){ cursecs = "0"+cursecs; }
  	if(dursecs < 10){ dursecs = "0"+dursecs; }
  	if(curmins < 10){ curmins = "0"+curmins; }
  	if(durmins < 10){ durmins = "0"+durmins; }

  	if(curmins==durmins && dursecs==cursecs){	
 document.getElementById("Exam").style.display='block';
   	  	}
  	curtimetext.innerHTML = curmins+":"+cursecs;
  	durtimetext.innerHTML = durmins+":"+dursecs;
  }
  function vidmute(){
  	if(vid.muted){
  		vid.muted = false;
  		mutebtn.innerHTML = "Mute";
  	} else {
  		vid.muted = true;
  		mutebtn.innerHTML = "Unmute";
  	}
  }
  function setvolume(){
  	vid.volume = volumeslider.value / 100;
  }
  function toggleFullScreen(){
  	if(vid.requestFullScreen){
  		vid.requestFullScreen();
  	} else if(vid.webkitRequestFullScreen){
  		vid.webkitRequestFullScreen();
  	} else if(vid.mozRequestFullScreen){
  		vid.mozRequestFullScreen();
  	}
  }

  </script>
<meta charset="utf-8"/>
<title>Online Tutor</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="../../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="../../assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="../../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="../../assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="../../assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
 <link href="../../assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
<!-- BEGIN THEME STYLES -->
<link href="../../assets/global/css/components.css" rel="stylesheet" type="text/css"/>
<link href="../../assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="../../assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link id="style_color" href="../../assets/admin/layout/css/themes/default.css" rel="stylesheet" type="text/css"/>
<link href="../../assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-header-fixed page-quick-sidebar-over-content page-header-fixed-mobile page-footer-fixed1">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="index.html">
			<img src="../../assets/frontend/layout/img/logos/logo-proto.jpg" alt="logo" class="logo-default"/>
			</a>
			<div class="menu-toggler sidebar-toggler hide">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
			
				<!-- BEGIN USER LOGIN DROPDOWN -->
				<li class="dropdown dropdown-user">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<span class="username username-hide-on-mobile">
					<s:property value="%{instructor.firstname}"/> <s:property value="%{instructor.lastname}"/> </span>
					<i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="<s:url action="userProfileInstructor"/>">
							<i class="icon-user"></i> My Profile </a>
						</li>
						
						<li>
							<a href="<s:url action="logout"/>">
							<i class="icon-key"></i> Sign Out </a>
						</li>
					</ul>
				</li>
				<!-- END USER LOGIN DROPDOWN -->
			</ul>
		</div>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END HEADER INNER -->
</div>

<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="page-sidebar-menu " data-auto-scroll="true" data-slide-speed="200">
				<!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
				<li class="sidebar-toggler-wrapper">
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler">
					</div>
					<!-- END SIDEBAR TOGGLER BUTTON -->
				</li>
				<!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
				 
				<li class="start ">
					<a href="home-instructor.jsp">
					<i class="icon-home"></i>
					<span class="title">Home</span>
					</a>
				</li>
				<li class="start ">
					<a href="<s:url action="userProfileInstructor"/>">
					<i class="fa fa-user color-grey"></i>
					<span class="title">My Profile</span>
					</a>
				</li>
				<li>
					<a href="<s:url action="newCourse"/>">
					<i class="fa fa-plus-square color-grey"></i>
					<span class="title">Open A New Course</span>
					</a>
				</li>
				<li>
					<a href="javascript:;">
					<i class="fa fa-graduation-cap color-grey"></i>
					<span class="title">My Courses</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<s:iterator value="courses">
						<li>
							<a href="http://localhost:8080/hello/metronic/templates/frontend/course?courseID=<s:property value="courseID"/>">
							<s:property value="courseID"/>
							<s:property value="courseTitle"/>
							</a>
						</li>
						</s:iterator>
					</ul>
				</li>
				 
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN STYLE CUSTOMIZER -->
			<div class="theme-panel hidden-xs hidden-sm">
				<div class="toggler">
				</div>
				<div class="toggler-close">
				</div>
				<div class="theme-options">
					<div class="theme-option theme-colors clearfix">
						<span>
						THEME COLOR </span>
						<ul>
							<li class="color-default current tooltips" data-style="default" data-container="body" data-original-title="Default">
							</li>
							<li class="color-darkblue tooltips" data-style="darkblue" data-container="body" data-original-title="Dark Blue">
							</li>
							<li class="color-blue tooltips" data-style="blue" data-container="body" data-original-title="Blue">
							</li>
							<li class="color-grey tooltips" data-style="grey" data-container="body" data-original-title="Grey">
							</li>
							<li class="color-light tooltips" data-style="light" data-container="body" data-original-title="Light">
							</li>
							<li class="color-light2 tooltips" data-style="light2" data-container="body" data-html="true" data-original-title="Light 2">
							</li>
						</ul>
					</div>
					<div class="theme-option">
						<span>
						Layout </span>
						<select class="layout-option form-control input-small">
							<option value="fluid" selected="selected">Fluid</option>
							<option value="boxed">Boxed</option>
						</select>
					</div>
					<div class="theme-option">
						<span>
						Header </span>
						<select class="page-header-option form-control input-small">
							<option value="fixed" selected="selected">Fixed</option>
							<option value="default">Default</option>
						</select>
					</div>
					<div class="theme-option">
						<span>
						Sidebar Mode</span>
						<select class="sidebar-option form-control input-small">
							<option value="fixed">Fixed</option>
							<option value="default" selected="selected">Default</option>
						</select>
					</div>
					<div class="theme-option">
						<span>
						Sidebar Menu </span>
						<select class="sidebar-menu-option form-control input-small">
							<option value="accordion" selected="selected">Accordion</option>
							<option value="hover">Hover</option>
						</select>
					</div>
					<div class="theme-option">
						<span>
						Sidebar Style </span>
						<select class="sidebar-style-option form-control input-small">
							<option value="default" selected="selected">Default</option>
							<option value="light">Light</option>
						</select>
					</div>
					<div class="theme-option">
						<span>
						Sidebar Position </span>
						<select class="sidebar-pos-option form-control input-small">
							<option value="left" selected="selected">Left</option>
							<option value="right">Right</option>
						</select>
					</div>
					<div class="theme-option">
						<span>
						Footer </span>
						<select class="page-footer-option form-control input-small">
							<option value="fixed">Fixed</option>
							<option value="default" selected="selected">Default</option>
						</select>
					</div>
				</div>
			</div>
			<!-- END STYLE CUSTOMIZER -->
			<!-- BEGIN PAGE HEADER-->
			<h3 class="page-title">
			Lecture
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="index.html">Home</a>
						<i class="fa fa-angle-right"></i>
					</li>
				</ul>
				
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
			 <div class="container">
        
     
<!--          <div id="lectureTitle" name="title"></div> -->
<!--          <div id="lectureDescription" name ></div><br><br> -->

				<h1><s:property value="title"/></h1>
                <h4><s:property value="description"/></h4>
                
      <div class="row">
    <div class="col-md-6 col-sm-6 padding-top-10">
               
               
   <div id="video_player_box" >
  
  <video id="my_video" width="550" height="310">
    <source src="<s:property value="videoPath"/>">
  </video>
  <div id="video_controls_bar">
  
    <button id="playpausebtn"></button>
    <input id="seekslider" type="range" min="0" max="100" value="0" step="1">
    <span id="curtimetext">00:00</span> / <span id="durtimetext">00:00</span>
    <input id="volumeslider" type="range" min="0" max="100" value="100" step="1">
     <button id="mutebtn"  style="margin-left: 460px;">Mute</button>
    <button id="fullscreenbtn" style="margin-top:auto;">[ &nbsp; ]</button>
  	
  	
  	</div>
  	</div>
	</div>
	
	<div class="col-md-6 col-sm-6 padding-top-10">
		      <h2>Lecture Materials</h2>
		       
		       <div style="display:none">
		     <s:property value="videoPath"/>
		      	</div>
		      	
		
		 
		       <s:form action="download">
		 <s:select label="Select Files"  
		list="downLoadFiles" 
		name="userDownload"/>
		     <s:submit value="submit" name="submit" />
				</s:form>
				
				<div style="display:none">
				<s:property value="role"/>
				</div>
				
				<s:fielderror fieldName="invalid"/>
				<div class="col-md-4 col-sm-4 padding-top-10" id="Exam">
                      <div class="service-box-v1">
                        <div><i class="fa fa-cloud-download color-grey"></i></div>
                        <h2><a  href="http://localhost:8080/hello/metronic/templates/frontend/openUploadPage?lectureID=<s:property value="lectureID"/>" >Create Exam</a></h2>
                      </div>
                    </div>
                    
                   
                    <div class="col-md-4 col-sm-4 padding-top-10" id="uploadBtn" style="display: none">
                      <div class="service-box-v1">
                        <div><i class="fa fa-cloud-download color-grey"></i></div>
                        <h2><a href="http://localhost:8080/hello/metronic/templates/frontend/openVideoPage?lectureID=<s:property value="lectureID"/>" >Upload Lecture Materials</a></h2>                   
                      </div>
                    </div>  
	</div>
		      	
		      	
		      	
		    </div>	
		    	<br><br>
		     <h2>Comments:</h2><br>
		     
		     
		     
		    <div class="col-md-6 col-sm-6 padding-top-10">
		      	<s:iterator value="comment" var="user">
		      	 <h4><li><s:property value="%{user.firstname}"/></li><br></h4>
		      	  <s:property value="date_time"/><br>
		      	  <s:property value="comment"/><br><br>
		      	</s:iterator>
		      	</div>
		      	
		      		<div style="width:200px;">
			<s:form action="submitComment">  
		<s:textarea name="userComment" cols="35" rows="8"/><br/><br/>		 
				<s:submit value="Submit"/>   	
						</s:form>
				</div>	      	
               </div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
	<!-- BEGIN QUICK SIDEBAR -->
	
		
	<!-- END QUICK SIDEBAR -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
	<div class="page-footer-inner">
		            2015 © Code Spark. ALL Rights Reserved. <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a>
	</div>
	<div class="page-footer-tools">
		<span class="go-top">
		<i class="fa fa-angle-up"></i>
		</span>
	</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="../../assets/global/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="../../assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="../../assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="../../assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="../../assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="../../assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script>
      jQuery(document).ready(function() {    
         Metronic.init(); // init metronic core components
Layout.init(); // init current layout
QuickSidebar.init(); // init quick sidebar
Demo.init(); // init demo features
      });
   </script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>