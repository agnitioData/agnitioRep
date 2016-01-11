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
 #employeeprofileviewbtn
{
	width: auto;
    margin: 70px auto;
    border-collapse: collapse;
    font-family: calibri;
    
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
    font-size: 19PX;
    font-weight: 500;
}

#employeeprofileview tr td
{
	border: 1px solid #4b4f52;
	 background-color: #fff;
	
}

.submit_button {
    background: #676767;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    font-family: 'Open Sans', sans-serif;
    color: #ffffff;
    font-size: 14px;
    text-decoration: none;
    width: 215px;
    height: 30px;
    margin-top: 10px;
    border: 1px solid #ffffff;
}
</style>
</head>

<body>



<%--    <s:file name="uploadFile" label="Choose File" size="40" />
   <s:submit value="Upload" name="submit" /> --%>





<s:form action="uploadAction" method="POST" enctype="multipart/form-data">
<table id="employeeprofileview">
<tr>
<th colspan="2">Attendence Upload</th>
</tr>
<tr>
<td>Select a Attendence to upload</td>
<td>
 <input type="file" name="uploadFile" label="Choose File" size="40" required/>
</td></tr>
<%-- 
<s:file name="uploadFile" label="Select a File to upload" size="40" /> --%>

 </table>
 <table id="employeeprofileviewbtn">
 
 <tr>
 <td>

 <s:submit value="Upload" name="submit" cssClass="submit_button"/>
 </td>
 </tr>
 </table>
</s:form>
</body>
</html>