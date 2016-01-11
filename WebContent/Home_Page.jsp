<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="com.hrms.dao.EmployeeLoginDao"%>
    <%@page import="com.hrms.action.EmployeeLoginAction"%>
<%@page import="com.hrms.action.NotificationAction"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Page</title>
<link href="css/MasterCss.css" rel="stylesheet" type="text/css"></link>
<script src="js/jscolor.js"></script>
<script src="js/jquery-1.11.1.js"></script>
<script src="js/MasterJs.js"></script>
<script src="js/empProfile.js"></script>
<style type="text/css">
 
</style>
</head>
<body class="body_background">
<header id="headertext">
</header>
<section>    
<article id="menu"></article>
<aside id="menuleft">
 <section id="mainmenu"></section>
<section id="maininner"><iframe id="independentPage" class="frame"></iframe>
</section> 
</aside>
</section>

<footer id="footertext">

</footer>

 <!-- Body Background	Color: <input id = "backColor" class="jscolor" value="ab2567">
<button onclick="changeBackgroundColor()">Try it</button>  -->
 <%
			String name = EmployeeLoginDao.USER_NAME;
			String empCode = EmployeeLoginDao.EMP_CODE;
			String notif_cnt = EmployeeLoginAction.NOTIFICATION_COUNT;
			List notification = new NotificationAction().getNotification(empCode);
			
		%>
<script>
 var userName = '<%=name%>';
$(document).ready(function(){
	
MasterJs.addHeader('headertext', userName);
MasterJs.addFooter('footertext');
var menuItems=['Daily TimeSheet','Attendance Record','Leave Management','HR Policies','Project Details']
var menuLinkPages=['EmployeeTimeSheet','empAttendenceUpdate','leaveViewAction','EmployeeHRPolicies','DLMS']
var taskbarItems=['Home','Basic Profile','Professional','Family','Education','Documents','Reset Password']
var taskbarLinkPages=['HomeWidgets',"employeeDetails", "professionalInfo","familyInfo","employeeEducationDetails","download","ResetPassword"]

MasterJs.addTaskbar(7, taskbarItems, 'menu',taskbarLinkPages);
MasterJs.addMenu(5, menuItems, 'mainmenu', menuLinkPages);
document.getElementById('independentPage').src = 'HomeWidgets.html';
	//MasterJs.changeBackgroundCss();
$(".menubar-div tr td").click(function(){
	
	$('.menubar-cell').css('background','');
	$(this).css('background','#E3EDFD');
	   

});
});



	
	
</script>
 
</body>
</html>