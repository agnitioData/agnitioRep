
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
#employeeprofileviewbtn
{
	width: auto;
    margin: 70px auto;    
}
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
    height: 0px;
    line-height: 35px;
    text-align: left;
    font-family: calibri;
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
	border: 1px solid #4b4f52;    padding-left: 124px;
}
/* #employeeprofileview tr td:nth-child(odd)
{
    background-color: #B0ADAD;	    padding-left: 124px;
} */
.txtbox {
    width: 213px;
    height: 25px;
    padding-left: 10px;
    font-family: 'Open Sans', sans-serif;
    color: #5c5a5a;
    font-size: 12px;
    background: -moz-linear-gradient(top, #ffffff 0%, #ffffff);
    background: -webkit-gradient(linear, left top, left bottom, from(#ffffff),
 to(#fffffff));
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #999999;
    -moz-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px
 rgba(255, 255, 255, 1);
    -webkit-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px
 0px rgba(255, 255, 255, 1);
    box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px
 rgba(255, 255, 255, 1);
}
.txtarea {
    width: 213px;
    height: 50px;
    padding-left: 10px;
    font-family: 'Open Sans', sans-serif;
    color: #5c5a5a;
    font-size: 12px;
    background: -moz-linear-gradient(top, #ffffff 0%, #ffffff);
    background: -webkit-gradient(linear, left top, left bottom, from(#ffffff),
 to(#fffffff));
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #999999;
    -moz-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px
 rgba(255, 255, 255, 1);
    -webkit-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px
 0px rgba(255, 255, 255, 1);
    box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px
 rgba(255, 255, 255, 1);
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
<s:form action="timeSheetSubmit" namespace="/" method="POST" enctype="multipart/form-data">

<table id="employeeprofileview">
<tr><th colspan="2">Time Sheet</th></tr>
<tr>
<td>Date</td>
<td><input type="date" name="empTimeSheetDetailBean.date" Class="txtbox" required></input></td>
</tr>
<tr>
<td>Project Name</td>
<td><input type="text" name="empTimeSheetDetailBean.projectName" Class="txtbox" required></input></td>
</tr>
<tr>
<td>Task Name</td>
<td><input type="text" name="empTimeSheetDetailBean.taskName" Class="txtbox" required></input></td></tr>
<tr>

<td>Spent Time (In hour)</td>
<td><input type="number" list="{'1','2','3','4','5','6','7','8','9'}" name="empTimeSheetDetailBean.hour" Class="txtbox" min="1" max="24" maxlength="2"  required></input></td>
</tr>
<tr>
<td>Assigned By</td>
<td><input type="number" name="empTimeSheetDetailBean.assignedBy" Class="txtbox" required type="number" min="1" max="99999" maxlength="6"></input></td></tr>
<td>Task Description</td>
<td><textarea  name="empTimeSheetDetailBean.taskDescription" Class="txtarea" required pattern=".{25,100}" title="25 to 100 characters"> </textarea ></td></tr>
<tr>
<!-- <tr>
<td>Status</td>
<td><input type="checkbox" name="empTimeSheetDetailBean.status" disabled="true"  Class="txtbox"></input></td></tr>
 -->


<%-- <tr><s:a action="empViewTimeSheet">Time Sheet</s:a></tr> --%>
</table>
<table id="employeeprofileviewbtn">
<tr>
<td><s:submit value="submit" name="submit" cssClass="submit_button"/></td>
</tr>
</table>
</s:form>

</body>
</html>