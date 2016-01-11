<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <title>Home Page</title>
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/homepage_1.css" rel="stylesheet" type="text/css"/>
       <link rel="stylesheet" href="css/jquery.accordion.css" type="text/css">

    </head>
    <body>
        <div id="main">
            <div id="header">
                <div id="header_logo"> 
                   <img src="images/hrlogo.png" alt="Logo" /> 
                </div>
                  
                </div>
                <div id="notification">
                  <ul>
					<s:iterator value="notification">
    					<li><s:a action="taskApproval"><s:property /></s:a></li>
    				</s:iterator>
					</ul>
                </div>
                <div id="header_profile"> 
                	<img src="images/loginimage.png" alt="Logo" /> 
                	<a href="logout">logout</a>
                </div>
                  
               
            </div>
            <div id="menu">
               <a href="employeeList">
                <div class="menu_tab1 menu_tabColorodd">Employees List </div>
               </a>
               
                <a href="employeeDetails">
                <div class="menu_tab1 menu_tabColoreven">Profile Details</div> 
                </a>
                
                <a href="leaveViewAction">
                 <div class="menu_tab1 menu_tabColorodd">Leave </div>
                 </a>
                 
                 <a href="attendenceUpload.jsp">
                <div class="menu_tab1 menu_tabColoreven">Attendence</div> 
                </a>
                <a href="EmployeeDocuments.jsp">
               <!--  <a href="AdminDocumentUpload.jsp">  -->
                 <div class="menu_tab1 menu_tabColorodd">Employee Doc </div>
                 </a>

               

                  <!-- <a href="HRPolicies.jsp"> -->
                <a href="EmployeeHRPolicies.jsp"> 

                 <div class="menu_tab1 menu_tabColorodd">HR Policies </div>
                 </a>
                 <a href="EmployeeTimeSheet.jsp"> 
                <div class="menu_tab1 menu_tabColoreven">Timesheet</div>
                 </a>
                 <a href="Projects.jsp"> 
                <div class="menu_tab1 menu_tabColoreven">Projects</div>
                 </a>
                 
        
            </div>
            <div id="mid">
                <div class="mid_left">
                    <div class="mid_left_inner">Events & Blogs</div>
                        <div class="mid_left_heading">Birthday Wishes</div>
                        <div class="mid_left_innermenu">
                            
                            <div id="accordion1">
                                <ul >
         <li>
            <h1>Vikash Chauhan</h1>
              <div>
               <span>Phasellus eget libero elit, a sodales felis. Morbi ligula tellus, posuere nec interdum ac,
                blandit et ante. Morbi nibh orci, eleifend vitae venenatis non, molestie in magna.
                Cras scelerisque risus eget odio interdum consequat.
              </span>
         </div>
        </li>
        <li>
            <h1>Ankit Gupta</h1>
            <div>
                <span>Phasellus eget libero elit, a sodales felis. Morbi ligula tellus, posuere nec interdum ac,
                    blandit et ante. Morbi nibh orci, eleifend vitae venenatis non, molestie in magna. 
                    Cras scelerisque risus eget odio interdum consequat
                 </span>
            </div>
        </li>
        <li>
            <h1>Rishabh Porwal</h1>
            <div>
                <span>
                    Cras sollicitudin justo sit amet nibh vulputate laoreet. Etiam vitae ligula diam.
                    Cras condimentum, nisl eu mollis convallis, purus risus pulvinar lectus, et commodo
                    diam purus non purus.
           </span></div>
         </li>
         <%--< li>
            <h1>Prem Chopra</h1>
            <div>
                <span>
                    Cras sollicitudin justo sit amet nibh vulputate laoreet. Etiam vitae ligula diam.
                    Cras condimentum, nisl eu mollis convallis, purus risus pulvinar lectus, et commodo
                    diam purus non purus.
           </span></div>
         </li> --%>
         <li>
            <h1>Ankita Soni</h1>
            <div>
                <span>
                    Cras sollicitudin justo sit amet nibh vulputate laoreet. Etiam vitae ligula diam.
                    Cras condimentum, nisl eu mollis convallis, purus risus pulvinar lectus, et commodo
                    diam purus non purus.
           </span></div>
         </li>
         <li>
            <h1>Aniket Rajput</h1>
            <div>
                <span>
                    Cras sollicitudin justo sit amet nibh vulputate laoreet. Etiam vitae ligula diam.
                    Cras condimentum, nisl eu mollis convallis, purus risus pulvinar lectus, et commodo
                    diam purus non purus.
           </span></div>
         </li>
     </ul>
    </div>
                        </div>
                    
                </div>
                <div class="mid_left">
                        <div class="mid_left_inner">Knowledge Center</div>
                        <div class="mid_left_knowledgecenter">
                            <div class="mid_left_knowledgecenter_inner">Java Innovation:-</div>
                            <div class="knowledgecenter_inner_text">
                                Phasellus eget libero elit, a sodales felis. Morbi ligula tellus, posuere nec interdum ac,
                    blandit et ante. Morbi nibh orci, eleifend vitae venenatis non, molestie in magna. 
                    Cras scelerisque risus eget odio interdum consequat
             
                            </div>
                        </div>
                        <div class="mid_left_knowledgecenter">
                            <div class="mid_left_knowledgecenter_inner">Java Innovation:-</div>
                            <div class="knowledgecenter_inner_text">
                                 Phasellus eget libero elit, a sodales felis. Morbi ligula tellus, posuere nec interdum ac,
                    blandit et ante. Morbi nibh orci, eleifend vitae venenatis non, molestie in magna. 
                    Cras scelerisque risus eget odio interdum consequat
                            </div>
                        </div>
                </div>
            
            </div>
            
        </div>
        <div class="footer">Â©2012 Agnitio Technologies Pvt. Ltd. All Rights Reserved</div> 
        
        
        
        
        
        
        
           <script src="css/jquery-1.8.2.min.js"></script>
    <script src="css/jquery.accordion.js"></script>
    <script>    
    $("#accordion1").awsAccordion({
    type:"vertical",
    cssAttrsVer:{
        ulWidth:800,
        liHeight:50
    },
    startSlide:1,
    openCloseHelper:{
        openIcon:"ok-circle",
        closeIcon:"ok-sign"
    },
    openOnebyOne:true,
    classTab:"active",
    slideOn:"click",
    autoPlay:false,
    autoPlaySpeed:2000
})
    </script>
    </body>
</html>




<%-- <%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Welcome Page</title>
	
<style type="text/css">
*
{
    padding: 0;
    margin: 0;
    border: 0;
}
body
{
    background-color: #439efb;
}
#main
{
    width: auto;
    height: auto;
}
#header
{
    width: 100%;
    height: 100px;
}
.login_pic
{
    width: 50px;height: 50px;float: right;
}
.login_name
{
       width: 128px;
    height: 50px;
    float: right;
    color: #fff;
    line-height: 50px;
}
#mid
{
    width: 990px;;
    height: 600px;
    margin: auto;
}
#footer
{
 width: 100%;
    height: 50px;
    text-align: center;
    color: #fff;
    font-size: 15px;
    font-family: calibri;
}
.product1
{
  width: 300px;
    height: 150px;
    float: left;
    margin: 13px;
}
.product1_left
{
  width:120px;
   height: 124px;
    float: left;

}
.product1_right
{
        width: 120px;
    height: 124px;
    float: left;
    margin-top: 56px;
    color: #fff;
    font-family: calibri;
    font-size: 20px;
}
.colour1
{
    background-color: #00c0e2;border: 1px solid #04a5c1;
}
.colour2
{
       background-color: #5bd998; border: 1px solid #1ebf6c;
}
.colour3
{
       background-color: #7558f8; border: 1px solid #5733fa;
}
.colour4
{
       background-color: #e9c14d; border: 1px solid #dcad26;
}
.colour5
{
       background-color: #e55679; border: 1px solid #dd2754;
}
.colour6
{
       background-color: #cb70d6; border: 1px solid #c03cd0;
}
.colour7
{
       background-color: #fb6744; border: 1px solid #ea4b26;
}
.colour8
{
       background-color: #926063; border: 1px solid #75484a;
}
.colour9
{
       background-color: #39c838; border: 1px solid #21b820;
}
#mainloginpage
{
    
    background-color: #f3f3f3;top:50%;left: 50%;
    width: 350px;height: 400px;margin-left: -175px;
    margin-top: -200px;position: absolute;
    border-radius: 10px
}
.login_header
{
      font-family: calibri;
    font-size: 25px;
    height: 50px;
    text-align: center;
    line-height: 47px;  
}
.login_header_text
{
     font-family: calibri;
    font-size: 16px;
    height: 50px;
    text-align: center;
    width: 300px;
    margin: 0 22px;
}
.login_mid
{
    height: 180px;
    width: 350px;
}
.login_footer
{
    background-color: #d4dedf;
    height: 108px;
    width: 350px;
        border-top: 1px solid #BFBCBC;
}
.textbox
{
   

    width: 250px;
    height: 35px;
    padding-left: 10px;
    font-family: 'Open Sans', sans-serif;
    color: #5c5a5a;
    font-size: 13px;
    background: -moz-linear-gradient(top, #ffffff 0%, #ffffff);
    background: -webkit-gradient(linear, left top, left bottom, from(#ffffff),to(#fffffff));
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #999999;
    -moz-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0pxrgba(255, 255, 255, 1);
    -webkit-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px rgba(255, 255, 255, 1);
    box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px rgba(255, 255, 255, 1);
 
}
.inputtext
{
       text-align: center;
    height: 9px;
    padding-top: 47px;
}
.register
{

    height: 65px;
    width: 175px;
    float: left;
        text-align: center;
}
.signin
{

    height: 65px;
    width: 175px;
     float: left;
         text-align: center;
}
.Login_button {
    background: #676767;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    font-family: calibri;
    color: #ffffff;
    font-size: 17px;
    text-decoration: none;
    width: 140px;
    height: 45px;
    margin-top: 20px;
    border: 1px solid #ffffff;
}


</style>
	
</head>

<body>
	<h3>Welcome <s:property value="name"></s:property></h3>
 
	<h3>Your id is <s:property value="id"></s:property></h3>
 
	<h3>Your password is <s:property value="pwd"></s:property></h3>
 
	<h3>Your email id is <s:property value="email"></s:property></h3>
 <div id="main">
            <div id="header">
                
                <div class="login_pic"><img src="images/loginimage.png" /></div>
                <div class="login_name"><s:property value="empName"></s:property></div>
            </div>
            <div id="mid">
                <div class="product1 colour1">
                      <div class="product1_left"><img src="images/project.png" /> </div>
                    <div class="product1_right">Project</div>
                </div>
                
                
                
                <a href="employeeDetails">
                <div class="product1 colour2" >
                     <div class="product1_left"><img src="images/profile.png" /> </div>
                    <div class="product1_right">Profile Details</div>
                </div></a>
                
                <div class="product1 colour3">
                       <div class="product1_left"><img src="images/timesheet.png" /> </div>
                    <div class="product1_right">Timesheet</div>
                </div>
                <div class="product1 colour4">
                      <div class="product1_left"><img src="images/leave.png" /> </div>
                    <div class="product1_right">Leave</div>
                </div>
                
                <a href="empAttendenceHome.jsp">
                <div class="product1 colour5">
                      <div class="product1_left"><img src="images/attendence.png" /> </div>
                    <div class="product1_right">Attendence</div>
                </div></a>
                
                <div class="product1 colour6">
                        <div class="product1_left"><img src="images/knowlegecenter.png" /> </div>
                    <div class="product1_right">Knowlege Center</div>
                </div>
                <div class="product1 colour7">
                     <div class="product1_left"><img src="images/hrPolice.png" /> </div>
                    <div class="product1_right">HR & Policies</div>
                </div>
                <div class="product1 colour8">
                    <div class="product1_left"><img src="images/empdoc.png" /> </div>
                    <div class="product1_right">Employee Document</div>
                </div>
                <div class="product1 colour1 colour9">
                      <div class="product1_left"><img src="images/event.png" /> </div>
                    <div class="product1_right">Events & Blogs</div>
                </div>
                            
                                  
            </div>
            <div id="footer">©2012 Agnitio Technologies Pvt. Ltd. All Rights Reserved</div>      
        </div>
</body>
</html> --%>