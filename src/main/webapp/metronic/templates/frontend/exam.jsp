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
<head>
  <meta charset="utf-8">
  <title>Exam</title>

  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <meta content="Metronic Shop UI description" name="description">
  <meta content="Metronic Shop UI keywords" name="keywords">
  <meta content="keenthemes" name="author">

  <meta property="og:site_name" content="-CUSTOMER VALUE-">
  <meta property="og:title" content="-CUSTOMER VALUE-">
  <meta property="og:description" content="-CUSTOMER VALUE-">
  <meta property="og:type" content="website">
  <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
  <meta property="og:url" content="-CUSTOMER VALUE-">

  <link rel="shortcut icon" href="favicon.ico">

  <!-- Fonts START -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
  <!-- Fonts END -->

  <!-- Global styles START -->          
  <link href="../../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="../../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="../../assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="../../assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="../../assets/global/css/components.css" rel="stylesheet">
  <link href="../../assets/frontend/layout/css/style.css" rel="stylesheet">
  <link href="../../assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
  <link href="../../assets/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="../../assets/frontend/layout/css/custom.css" rel="stylesheet">
  <!-- Theme styles END -->
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
 
  
  
  <script>

  var question=[];
  
	 question.push('<s:property value="%{options[0].question}"/>');
	 question.push('<s:property value="%{options[0].option1}"/>');
	 question.push('<s:property value="%{options[0].option2}"/>');
	 question.push('<s:property value="%{options[0].option3}"/>');
	 question.push('<s:property value="%{options[0].option4}"/>');
	  

	 question.push('<s:property value="%{options[1].question}"/>');
	 question.push('<s:property value="%{options[1].option1}"/>');
	 question.push('<s:property value="%{options[1].option2}"/>');
	 question.push('<s:property value="%{options[1].option3}"/>');
	 question.push('<s:property value="%{options[1].option4}"/>');
	 

	 question.push('<s:property value="%{options[2].question}"/>');
	 question.push('<s:property value="%{options[2].option1}"/>');
	 question.push('<s:property value="%{options[2].option2}"/>');
	 question.push('<s:property value="%{options[2].option3}"/>');
	 question.push('<s:property value="%{options[2].option4}"/>');
	 
	 
	 question.push('<s:property value="%{options[3].question}"/>');
	 question.push('<s:property value="%{options[3].option1}"/>');
	 question.push('<s:property value="%{options[3].option2}"/>');
	 question.push('<s:property value="%{options[3].option3}"/>');
	 question.push('<s:property value="%{options[3].option4}"/>');
	  

	 question.push('<s:property value="%{options[4].question}"/>');
	 question.push('<s:property value="%{options[4].option1}"/>');
	 question.push('<s:property value="%{options[4].option2}"/>');
	 question.push('<s:property value="%{options[4].option3}"/>');
	 question.push('<s:property value="%{options[4].option4}"/>');
	 

	 question.push('<s:property value="%{options[5].question}"/>');
	 question.push('<s:property value="%{options[5].option1}"/>');
	 question.push('<s:property value="%{options[5].option2}"/>');
	 question.push('<s:property value="%{options[5].option3}"/>');
	 question.push('<s:property value="%{options[5].option4}"/>');
	 

	 question.push('<s:property value="%{options[6].question}"/>');
	 question.push('<s:property value="%{options[6].option1}"/>');
	 question.push('<s:property value="%{options[6].option2}"/>');
	 question.push('<s:property value="%{options[6].option3}"/>');
	 question.push('<s:property value="%{options[6].option4}"/>'); 

	 <%-- for(i=0;i<7;i++){{
		for(j=i;j<5;j++)
			 question.push('<s:property value="%{options['<%j%>'].question}"/>');
		 }
	 }
	  --%>
	
  
	var pos=0,test,test_status,question,choice,choices,chA,chB,chC,chD,correct=0;
	var timer=0;
	var timeTaken=0;
	var userInput=[];
	var k=0;
	 
	var questions=[
		[question[0],question[1],question[2],question[3],question[4]],
		[question[5],question[6],question[7],question[8],question[9]],
		[question[10],question[11],question[12],question[13],question[14]],
		[question[15],question[16],question[17],question[18],question[19]],
		[question[20],question[21],question[22],question[23],question[24]],
		[question[25],question[26],question[27],question[28],question[29]],
		[question[30],question[31],question[32],question[33],question[34]]
		           	];
  
	function _(x){
		return document.getElementById(x);
	}

	function dataSend(){
		$.ajax({
		       type: 'POST',
		       url:'examResult.action?userInput='+userInput+'&timeTaken='+timeTaken,
		       dataType: 'json',
		       success: function(data){
		             console.log(stringify(data));
		        }});
			}

	 

   	function renderQuestion(){
   		test = _("test");
   	 var bar = document.getElementById('progressBar');
  	  var status = document.getElementById('status');
  	  
   		if(pos >= questions.length){
   			clearTimeout(timer);	
			test.innerHTML = "";
   			_("test_status").innerHTML = "Test Completed";
   			document.getElementById("result").style.display='block'; 
   			pos = 0;
   			correct = 0;
  			 dataSend(); 
  			bar.style.display='none'; 
   			status.style.display='none';
 	 
   			return false;
   		}
   		_("test_status").innerHTML = "Question "+(pos+1)+" of "+'${numberOfQuestion}';
   		question = questions[pos][0];
   		chA = questions[pos][1];
   		chB = questions[pos][2];
   		chC = questions[pos][3];
   		chD = questions[pos][4];
   		test.innerHTML = "<h3>"+question+"</h3>";
   		test.innerHTML += "<input type='radio' name='choices' value='A'> "+chA+"<br>";
   		test.innerHTML += "<input type='radio' name='choices' value='B'> "+chB+"<br>";
   		test.innerHTML += "<input type='radio' name='choices' value='C'> "+chC+"<br>";
   		test.innerHTML += "<input type='radio' name='choices' value='D'> "+chD+"<br><br>";
   		test.innerHTML += "<button onclick='checkAnswer()'>Submit Answer</button>";
   	 
   		
   		
   	   	}
	   	
    
   	function checkAnswer(){
   		choices = document.getElementsByName("choices");
   		
   		
   		for(var i=0; i<choices.length; i++){
   			if(choices[i].checked){
   				choice = choices[i].value;
   				userInput[k]=choice;
   				k++;
   			}else{
   				userInput[k]='N';
   				k++;
   	   			}
   		}
   		
   		pos++;
   		renderQuestion();
   	}


	
   	function countDown(secs,elem) {
		var element = document.getElementById(elem);
		element.innerHTML = "Exam Ends By: "+secs+" seconds";
		if(secs < 1) {
			clearTimeout(timer);		
   			pos = 0;
   			correct = 0;
   			dataSend();
   			document.getElementById("test").innerHTML = "";
   			_("test_status").innerHTML = "Time Over";
   			document.getElementById("result").style.display='block'; 
   			return false;
		}
		timeTaken=secs--;
		timer = setTimeout('countDown('+secs+',"'+elem+'")',1000);
	}
   	function progressBarSim(al) {
   	  var bar = document.getElementById('progressBar');
   	  var status = document.getElementById('status');
   	  status.innerHTML = al+"seconds";
   	  bar.value = al;
   	  al--;
   		var sim = setTimeout("progressBarSim("+al+")",1000);
   		if(al == 0){
   			clearTimeout(timer);		
   			pos = 0;
   			correct = 0;
   			dataSend();
   			document.getElementById("test").innerHTML = "";
   			_("test_status").innerHTML = "Time Over";
   			document.getElementById("result").style.display='block'; 
   			bar.style.display='none'; 
   			status.style.display='none';
   			return false;
   		}
   	}
   	 window.addEventListener("load", renderQuestion, false); 


     var xmlHttp;
     function ajaxEditFunctionCall(){

         var URL = "welcomeAjax.action?";
         try{
             xmlHttp=new XMLHttpRequest();
         }catch (e){
             try{
                 xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
             }catch (e){
                 try{
                     xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                 }catch (e){
                     alert("Your browser does not support AJAX!");
                     return false;
                 }
             }
         }  
         xmlHttp.onreadystatechange = showMessage;
         xmlHttp.open("GET", URL, true);
         xmlHttp.send(null);
     }

     function showMessage() {      
         if(xmlHttp.readyState==4)
         {
             var r=xmlHttp.responseText;
             document.getElementById("test").innerHTML = "<h2>You got "+r+" of "+'${numberOfQuestion}'+" questions correct</h2>";
             document.getElementById("result").style.display='none';
         }
     } 
   	
   	
	</script>			
                
  
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="corporate">
	  
    <!-- BEGIN TOP BAR -->
    <div class="pre-header">
        <div class="container">
            <div class="row">
                <!-- BEGIN TOP BAR LEFT PART -->
                <div class="col-md-6 col-sm-6 additional-shop-info">
                    
                </div>
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
        <a class="site-logo" href="index-custom.jsp"><img src="../../assets/frontend/layout/img/logos/logo-proto.jpg" alt="Metronic FrontEnd"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation pull-right font-transform-inherit">
          <ul>
            <!-- BEGIN TOP SEARCH -->
            <li class="menu-search">
              <span class="sep"></span>
              <i class="fa fa-search search-btn"></i>
              <div class="search-box">
                
              </div> 
            </li>
            <!-- END TOP SEARCH -->
          </ul>
        </div>
        <!-- END NAVIGATION -->
      </div>
    </div>
    <!-- Header END -->

    <div class="main">
      <div class="container">
        
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-9">
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                
              
			             
			<div id="status" style="display:block"></div><br><br>		
			<h2 id="test_status" ></h2>
			<div id="test"></div><br><br>
			
			 <progress id="progressBar" value='${duration}' max='${duration}' style="width:300px; display:block"></progress>

 
			 
			      <div id=bank style="display:none">
              <s:iterator value="options">
               <s:property value="question"/><br><br>
     			 <s:property value="option1"/><br><br>
     			 <s:property value="option2"/><br><br>
     			 <s:property value="option3"/><br><br>
     			 <s:property value="option4"/><br><br>
			</s:iterator><br><br>
			<s:property value="numberOfQuestion"/><br><br>
			</div>
			
			<div id="result" style="display: none">
		 
		<s:form id="form">
			<input type="button" value="Get Score"onclick="ajaxEditFunctionCall()"/>
			</s:form>
			
			</div>
<%-- 			<script>countDown('${duration}',"status");</script> --%>
			<script>progressBarSim('${duration}');</script>
			
		
		 
			 
			</div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>


    <!-- BEGIN FOOTER -->
    <div class="footer">
      <div class="container">
        <div class="row">
          <!-- BEGIN COPYRIGHT -->
          <div class="col-md-6 col-sm-6 padding-top-10">
            2015 © Code Spark. ALL Rights Reserved. <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a>
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
    <script src="../../assets/global/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="../../assets/global/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="../../assets/frontend/layout/scripts/back-to-top.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="../../assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="../../assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

    <script src="../../assets/frontend/layout/scripts/layout.js" type="text/javascript"></script>
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