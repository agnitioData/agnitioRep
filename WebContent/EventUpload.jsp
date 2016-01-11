<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event Upload</title>

<style type="text/css">
#employeeprofileview
{
	width: 900px;
    margin: 70px auto;
    border-collapse: collapse;
    
}
#employeeprofileview tr
{
     border: 1px solid #4b4f52;
    height: 0px;
    line-height: 35px;
    text-align: left;
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
#employeeprofileview tr td:nth-child(odd)
{
    background-color: #B0ADAD;	    padding-left: 124px;
}
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

<s:form action="userImage" namespace="/" 
method="POST" enctype="multipart/form-data">

<s:file name="image" label="Select a File to upload" size="40" />
<s:textfield name="title"></s:textfield>
<s:textarea name="description"></s:textarea>
<s:submit value="submit" name="submit" />
 
</s:form>
<!-- <form action="userImage"> -->
<!-- <table id="employeeprofileview">
<tr><th colspan="2">Event Upload</th></tr>
<tr>
<td>File Upload</td>
<td>  <input type="file" name="image" accept="image/*" Class="txtbox"></input></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="newsAndBlogsModel.titleName" Class="txtbox" required></input></td>
</tr>

<tr>
<td>Description</td>
<td><textarea type="text" Class="txtbox" required style="height: 50px"></textarea></td>
</tr>
<tr>
<td colspan="2">
 <input value="Upload" type="submit" class="submit_button"></input> 
<input type="button"  value="Upload" Class="submit_button"/>
</td>
</tr>

</table> -->
<!-- </form> -->

</body>
</html>