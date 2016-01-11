<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Login Page</title>
	
<!-- Latest compiled and minified CSS -->
<!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style.css">
<%-- <script src="https://www.google.com/recaptcha/api.js"></script> --%>
</head>

<body>
<%-- hasActionErrors() method is defined in ActionSupport --%>
<s:if test="hasActionErrors()">
	<div class="errorDiv">
		<s:actionerror/>
	</div>
</s:if>
	<form action="login" method="post">
		<section id="header" >

			<div class="logo"> <img src="images/logo.png" alt=""/></div>
		</section> 
			<div class="clearfix" style="  width:100%; clear:both;"></div>
			<div class="container"><div class="row"><div class="col-lg-8 col-md-6 col-sm-12 col-xs-12">  <div class="welcome-text"><h1>  
			<span></span> </h1>  </div></div> <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12">


	<div class="loginbox-outer">    

		<div class="loginbox">
  

        <div class="row">

            <div class="col-xs-12 margin-bottom">

              <div class="input-group">

                <span class="input-group-addon bgcolor">

                 <span class="glyphicon glyphicon-user"></span>

                </span>
                    <!--  <input type="text" class="form-control" placeholder="Employee Code" id="name" name="username" required autofocus/> --> 
                    <!--  <input type="text" class="form-control" placeholder="Employee Code" id="name" name="username"/> -->
                     <s:textfield name="username" cssClass="form-control" placeholder="Employee Code" ></s:textfield>  
  
              <!--   <input type="text" id="uid" placeholder="Username" class="form-control"  required autofocus> -->
                
              

              </div>
            <div class="message-error" id="uid-err1"> Username is required.</div>
            <div class="message-error" id="uid-err2"> Invalid Username.</div>
            </div>

            <div class="col-xs-12 margin-bottom ">

              <div class="input-group ">

                <span class="input-group-addon bgcolor">

                    <span class="glyphicon glyphicon-lock"></span>

                </span>
                <!-- <input type="text" class="form-control" placeholder="*********" id="pwd" name="userpass" type="password" required autofocus/> -->
                <s:password name="userpass" placeholder="Password" cssClass="form-control"></s:password> 
                
               <!--  <input type="password" name="password" placeholder="Password" id="pass"  class="form-control" required autofocus> -->

              </div>
             <div class="message-error" id="pass-err1">Pasword is required.</div>
             <div class="message-error" id="pass-err2">Invalid Pasword.</div>
            </div>

          </div>
          
		              <div class="form-group ">
		
		                   <div class=" col-xs-12  margin-bottom">
		 
		                         <div class="checkbox">
		
		                         <label><input id="chkBtn" style="background-color: transparent;" type="checkbox"> Remember me</label>
		
		                     </div>
		  
		                  </div>
		
		              </div>
		              
				<div>
				<%
					ReCaptcha c = ReCaptchaFactory.newReCaptcha(
       		  		"6LdlHOsSAAAAAM8ypy8W2KXvgMtY2dFsiQT3HVq-", 
        			"6LdlHOsSAAAAACe2WYaGCjU2sc95EZqCI9wLcLXY", false);
					out.print(c.createRecaptchaHtml(null, null));
		  		%>
				</div>
				
				    <div class="form-group">
				    
				      <!-- <div class=" col-xs-6">
				                     <a href="forgetPassword.jsp" class="Login_button">
				               <button type="button" Class="loginbtn">Forgot Password</button> 
				                </a> </div> -->
				                  <div class=" col-xs-6">
				           <s:submit value="Login" cssClass="loginbtn" ></s:submit>
				    </div>
				
				    </div>

  
</div>

     <!--  <div class="g-recaptcha"
            data-sitekey="6LdMAgMTAAAAAGYY5PEQeW7b3L3tqACmUcU6alQf"></div> -->
      
      </div></div></div></div>
      
    <footer>
          <div>
      <span class="text">Designed &amp; Developed by:</span>
      <span><img src="images/agnito-logo.png" alt="Agnito"/></span>  </div>
      <p>Copyright @ 2015 Agnitio Technologies. All Rights Reserved.</p></footer>
	</form>
	
</body>
</html>














