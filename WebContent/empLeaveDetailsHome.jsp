<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
    text-align: left;
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
	width: 440px;
	    padding-left: 130px;
	
}



</style>
</head>
<body>
<form action="">
				<table id="leavedetails">
				 <tr>
				<th colspan="4">Leave Summary</th>
			   </tr>
				<s:iterator value="leaveViewData">
				<tr><td>Balance Leaves Forwarded (2015-2016)</td>	<td><s:property value="carryFwdLeaves" /></td></tr>
				<tr><td>Total Leaves</td>	<td><s:property value="totalLeaves" /></td></tr>
				<tr><td>Remaining Leaves	</td>	<td><s:property value="remainingLeaves" /></td></tr>
				<tr><td>Used Leaves	</td>	<td><s:property value="usedLeaves" /></td></tr>
				
				
				</s:iterator>
				</table>
</form>			
 				

</body>
</html>