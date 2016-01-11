
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1>Struts 2 file upload example	</h1>

<s:form action="approved" namespace="/" 
method="POST" enctype="multipart/form-data">

<%-- <s:iterator value="empTimeSheetBeanList"> --%>
<s:textfield name="empTimeSheet.empCode"></s:textfield>
<s:textfield name="empTimeSheet.date"></s:textfield>
<s:textfield name="empTimeSheet.projectName"></s:textfield>
<s:textfield name="empTimeSheet.taskName"></s:textfield>
<s:textarea name="empTimeSheet.taskDescription"></s:textarea>
<s:combobox list="{'1','2','3','4','5','6','7','8'}" name="empTimeSheet.hour"></s:combobox>
<s:textfield name="empTimeSheet.assignedBy"></s:textfield>
<s:checkbox name="empTimeSheet.status"></s:checkbox>

<s:submit value="submit" name="submit" />
 <%-- </s:iterator> --%>

</s:form>

</body>
</html>