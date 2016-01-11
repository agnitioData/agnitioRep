<%@page import="net.sf.json.JSON"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.hrms.dao.EmployeeLoginDao"%>
<%@page import="com.hrms.action.EmployeeLoginAction"%>
<%@page import="com.hrms.action.NotificationAction"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin Page</title>
		<link href="css/MasterCss.css" rel="stylesheet" type="text/css"></link>
		<script src="js/jscolor.js"></script>
		<script src="js/jquery-1.11.1.js"></script>
		<script src="js/MasterJs.js"></script>
		<script src="js/adminempProfile.js"></script>
		<style type="text/css">
		.notificationClass{
		float: left;
    background: rgb(209,209,209);
    background: -moz-linear-gradient(top, rgba(209,209,209,1) 0%, rgba(147,147,147,1) 100%);
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(209,209,209,1)), color-stop(100%,rgba(147,147,147,1)));
    background: -webkit-linear-gradient(top, rgba(209,209,209,1) 0%,rgba(147,147,147,1) 100%);
    background: -o-linear-gradient(top, rgba(209,209,209,1) 0%,rgba(147,147,147,1) 100%);
    background: -ms-linear-gradient(top, rgba(209,209,209,1) 0%,rgba(147,147,147,1) 100%);
    background: linear-gradient(to bottom, rgba(0,131,255,1) 0%,rgba(147,147,147,1) 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#d1d1d1', endColorstr='#939393',GradientType=0 );
    height: 35px;
    width: 35px;
    border-radius: 40px;
    text-align: center;
    width: 35px;
    margin-right: 10px;
    position: absolute;
    color:#000;
    cursor:pointer;
}
		
		#popup_box { 
	display:none; /* Hide the DIV */
	position:fixed;  
	_position:absolute; /* hack for internet explorer 6 */  
	height:300px;  
	width:600px;  
	background:#FAFAFA;
	left: 300px;
	top: 150px;
	z-index:100; /* Layering ( on-top of others), if you have lots of layers: I just maximized, you can change it yourself */
	margin-left: 15px;  
	
	/* additional features, can be omitted */
	border:2px solid #7f7f7f;  	
	padding:15px;  
	font-size:15px;  
	-moz-box-shadow: 0 0 5px #ff0000;
	-webkit-box-shadow: 0 0 5px #ff0000;
	box-shadow: 0 0 5px #afafaf;
	
}


/* This is for the positioning of the Close Link */
#popupBoxClose {
	font-size:20px;  
	line-height:15px;  
	right:5px;  
	top:5px;  
	position:absolute;  
	color:#6fa5e2;  
	font-weight:500;  	
}
		
		
		
		</style>
	</head>
	<body class="body_background" id="body">
	<div id="outer">	
		<header id="headertext"></header>
		<section>    
			<article id="menu"></article>
			<aside id="menuleft">
				 <section id="mainmenu"></section>
				<section id="maininner">
					<iframe id="independentPage" class="frame"></iframe>
				</section> 
			</aside>
		</section>
		<footer id="footertext"></footer>
		<!--  Body Background	Color: <input id = "backColor" class="jscolor" value="ab2567">
		<button onclick="changeBackgroundColor()">Try it</button>  -->
		</div>
		
		<div id="popup_box">	<!-- OUR PopupBox DIV-->
		<div id="notif_id">
		 <div id="notification">
                  <ul>
					<s:iterator value="notification">
    					<li><s:a action="taskApproval" ><s:property /></s:a></li>
    				</s:iterator>
					</ul>
                </div>
		</div>
		<a id="popupBoxClose">Close</a>	
	</div>
	<%-- <div id="approvalid">
		<s:form action="approved" namespace="/" method="POST" enctype="multipart/form-data">
			<s:textfield name="empTimeSheet.empCode"></s:textfield>
			<s:textfield name="empTimeSheet.date"></s:textfield>
			<s:textfield name="empTimeSheet.projectName"></s:textfield>
			<s:textfield name="empTimeSheet.taskName"></s:textfield>
			<s:textarea name="empTimeSheet.taskDescription"></s:textarea>
			<s:combobox list="{'1','2','3','4','5','6','7','8'}" name="empTimeSheet.hour"></s:combobox>
			<s:textfield name="empTimeSheet.assignedBy"></s:textfield>
			<s:checkbox name="empTimeSheet.status"></s:checkbox>
			<s:submit value="submit" name="submit" />
		</s:form>
	</div> --%>
		
		<%
			String name = EmployeeLoginDao.USER_NAME;
			String empCode = EmployeeLoginDao.EMP_CODE;
			String notif_cnt = EmployeeLoginAction.NOTIFICATION_COUNT;
			List notification = new NotificationAction().getNotification(empCode);
			
		%>
	<script>
		var userName = '<%=name%>';
		var notif_Count = '<%=notif_cnt%>';
		<%-- var notificationList = '<%=notification%>';
		var i;
		var len=0;
		var local;
		var popid = document.getElementById("notif_id");
		var table = document.createElement("table");
		for(var j=0; j<notif_Count; j++)
		{
				var local="";
				var row = document.createElement("tr");
				var cell = document.createElement("td");
				
			for (var i = len+1; i < notificationList.length; i++) 
			{
				len++;
				if(notificationList[i]==',' || notificationList[i]==']')
				{
					break;
				}
				else
				{
					local+=notificationList[i];
				}
			} --%>
			/* var cellText = document.createTextNode(local);
			var anchor = document.createElement("a");
			cell.appendChild(anchor);
			anchor.appendChild(cellText);
			
			row.appendChild(cell);
			table.appendChild(row); */
		 
		/* popid.appendChild(table); */
				
		
	
		
		
		
		$(document).ready(function(){
		MasterJs.addHeader('headertext',userName);
		MasterJs.addFooter('footertext');
		var menuItems=['Daily TimeSheet','Running Projects','Attendance Record','Leave Management','Employee list','HR Policies','Knowledge Center']
		var menuLinkPages=['allEmpTimesheetInfo','DLMS','employeePresentList','allEmployeeLeaveDetails','employeeList','EmployeeHRPolicies','NewsAndBlogsUpload']
		var taskbarItems=['Home','Basic Profile','Professional','Family','Education','Documents']
		var taskbarLinkPages=['HomeWidgets',"employeeDetails", "professionalInfo","familyInfo","employeeEducationDetails","viewEventImage"]
		MasterJs.addTaskbar(6, taskbarItems, 'menu',taskbarLinkPages);
		MasterJs.addMenu(7, menuItems, 'mainmenu', menuLinkPages);
		document.getElementById('independentPage').src = 'HomeWidgets.html';
		//MasterJs.changeBackgroundCss();
			if(notif_Count!=0)
			{
				$( "#iconUser" ).append( "<div id='notificationId' class='notificationClass'>"+notif_Count+"</div>" );	
				
			
			}
			
			$('#notificationId').click( function() {
				loadPopupBox();
			});
			
			$('#popupBoxClose').click( function() {			
				unloadPopupBox();
			});
			
			function unloadPopupBox() {	// TO Unload the Popupbox
				$('#popup_box').fadeOut("slow");
				$("#outer").css({ // this is just for style		
					"opacity": "1"  
				}); 
			}	
			
			function loadPopupBox() {	// To Load the Popupbox
				$('#popup_box').fadeIn("fast");
			
				$("#outer").css({ // this is just for style		
					"opacity": "1"  
				});		
			}
			$(".menubar-div tr td").click(function(){
						
				$('.menubar-cell').css('background','');
				$(this).css('background','#E3EDFD');
				   
			
			});
			/* $("icon").css("background-color", "rgb(235,18,18)"); */
		});
		
		
		</script>
	
	
 </body>
</html>