<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave History</title>

<style type="text/css">
body
{
background-color: #fff;
}

#leavedetails
{
	width: 900px;
    margin: 70px auto;
    border-collapse: collapse;
    font-family: calibri;
    
}
#leavedetails tr
{
    border: 1px solid #4b4f52;
    height: 40px;
    text-align: center;
}
#leavedetails th
{
    border: 1px solid #4b4f52;
    height: 40px;
    text-align: center;
    background-color: #666666;
     color: #fff;
 
     font-family: calibri;
}

#leavedetails tr td
{
	border: 1px solid #4b4f52;
	
}




</style>
</head>
<body>
<form action="">
				<table id="leavedetails">
				<tr>
				<th>Apply Date</th>
				<th>No Of Days</th>
				<th>From Date</th>
				<th>To Date</th>
				<th>Leave Reason</th>
				</tr>
				<s:iterator value="empLeaveApplyDetailList">
 					<tr>
						<td><s:property value="applyDate" /></td>
						
						<td><s:property value="noOfDays" /></td>
						
						<td><s:property value="fromDate" /></td>
						
						<td><s:property value="toDate" /></td>
					
						<td><s:property value="leaveReason" /></td>
					</tr>
				</s:iterator>
				</table>
</form>	
</body>
</html>