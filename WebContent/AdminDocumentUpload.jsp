
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


<s:form action="uploadFile" namespace="/" 
method="POST" enctype="multipart/form-data">

<s:file name="uploadFile" label="Select a File to upload" size="40" />
<s:textfield name="empCode" label="Select EmpCode"></s:textfield>
<s:textfield name="docType" label="Select Doctype"></s:textfield>
<s:submit value="submit" name="submit" />
 
</s:form>

</body>
</html>