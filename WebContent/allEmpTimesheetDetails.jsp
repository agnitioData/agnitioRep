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
#employeeprofileview
{
	width: 900px;
    margin: 70px auto;
    border-collapse: collapse;
    font-family: calibri;

    
}
#employeeprofileview tr
{
    border: 1px solid #4b4f52;
    height: 40px;
    text-align: center;
}
#employeeprofileview th
{
    border: 1px solid #4b4f52;
    height: 40px;
    text-align: center;
    background-color: #666666;
    color: #FFF;
    font-weight: 500;
}

#employeeprofileview tr td
{
	border: 1px solid #4b4f52;text-align: left;padding-left: 10px;
	
}

</style>
</head>
<body>
<table id="employeeprofileview">
<tr>

<th>Emp Code</th>
<th>Date</th>
<th>Project Name</th>
<th>Task Name</th>
<th>Task Description</th>
<th>Hour</th>
<th>Assigned By</th>
<th>Status</th>

</tr>

<s:iterator value="empTimesheetInfoList">
<tr><td>
<s:property value="empCode"></s:property>
</td>
<td>
<s:property value="date"></s:property>
</td>
<td>
<s:property value="projectName"></s:property>
</td>
<td>
<s:property value="taskName"></s:property>
</td>
<td>
<s:property value="taskDescription"></s:property>
</td>
<td>
<s:property value="hour"></s:property>
</td>
<td>
<s:property value="assignedBy"></s:property>
</td>
<td>
<s:property value="status"></s:property>
</td></tr>
</s:iterator>

</table>
</body>
</html>