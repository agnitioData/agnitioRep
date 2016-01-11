<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Error Page</title>
</head>

<body>
<%-- hasActionErrors() method is defined in ActionSupport --%>
<%-- <s:if test="hasActionErrors()">
	<div class="errorDiv">
		<s:actionerror/>
	</div>
</s:if> --%>
	<s:include value="login.jsp"></s:include>
<div style="width: 17%;position:absolute;z-index:100;height: 30px;text-align: center;margin: -150px 20% 0 63%">
	<div>User Name or Password is wrong</div>
</div>
</body>
</html>