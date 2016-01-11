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
<form action="">
<s:iterator value="empEventsBeanList">
<table>
<tr>
<td>Title: <s:property value="titleName" /></td>  

<td>Description: <s:property value="description" /></td> 

<td>data: <s:property value="imageName" /></td>
<td><img src="<s:property value="image"/>" alt="Smiley face" width="100" height="100"> 
<%-- <img src="<s:url value="image"/>"> --%></td>
<%-- <img src="userimages/<s:property value="userImageFileName"/>"   
                                                     width="100" height="100" /></td> --%>
</tr>
</table>
</s:iterator>
<img src="<s:property value="image"/>"  />  
</form>
</body>
</html>