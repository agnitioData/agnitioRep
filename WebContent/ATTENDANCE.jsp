<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Attendance</title>
	
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/homepage_1.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="main">
            <div id="header">
                <div id="header_logo"> 
                   <img src="images/hrlogo.png" alt="Logo" /> 
                </div>
                 <div id="header_profilename"> 
                 priya rani
                </div>
                <div id="header_profile"> 
                   <img src="images/loginimage.png" alt="Logo" /> 
                </div>
                  
               
            </div>
            
            <div id="mid_form">
                
                <div class="main_form">
                  <div class="form_heading">
                   <h3 >Add Attendance </h3>
                   </div>
                    <div class="form_details">
                    <div class="form_details_inner">
                     <input id="empCode" name="empMasterDetails.empCode" placeholder="Morning" type="text" class="textbox" required autofocus/> 
                   </div>
                     <div class="form_details_inner">
                     <input id="firstName" name="empMasterDetails.firstName" placeholder="Evening" type="text" class="textbox" required autofocus/> 
                   </div>
          
                      
                   
		                      <div class="form_details_inner">
                      <input value="submit" type="submit" class="loginbtn"></input>   </div>
                    </div>
                </div>
               

    	
 
            
            </div>
            
        </div>
        <div class="footer">&#64;2012 Agnitio Technologies Pvt. Ltd. All Rights Reserved</div> 

    </body>
</html>












