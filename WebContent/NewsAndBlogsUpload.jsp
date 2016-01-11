
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News & Blogs</title>

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

    font-weight: 500;
}
#employeeprofileview tr td
{
	border: 1px solid #4b4f52;    padding-left: 124px;
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
.dropdown {
       width: 225px;
    height: 31px;
    padding-left: 10px;
    font-family: calibri;
    color: #5c5a5a;
    font-size: 12px;
    background: -moz-linear-gradient(top, #ffffff 0%, #ffffff);
    background: -webkit-gradient(linear, left top, left bottom, from(#ffffff), to(#fffffff));
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #999999;
    -moz-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px rgba(255, 255, 255, 1);
    -webkit-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px rgba(255, 255, 255, 1);
    box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px rgba(255, 255, 255, 1);
}
.txtarea {
    width: 213px;
    height: 50px;
    padding-left: 10px;
    font-family: 'Open Sans', sans-serif;
    color: #5c5a5a;
    font-size: 12px;
    background: -moz-linear-gradient(top, #ffffff 0%, #ffffff);
    background: -webkit-gradient(linear, left top, left bottom, from(#ffffff), to(#fffffff));
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #999999;
    -moz-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px rgba(255, 255, 255, 1);
    -webkit-box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px rgba(255, 255, 255, 1);
    box-shadow: 0px 1px 2px rgba(000, 000, 000, 0.5), inset 0px 1px 0px rgba(255, 255, 255, 1);
}
</style>


</head>
<body>
<s:form action="newsUpload" namespace="/" method="POST" enctype="multipart/form-data">

<table id="employeeprofileview">
<tr><th colspan="2">News & Blogs</th></tr>
<tr>
<td>Date</td>
<td><input type="date" name="newsAndBlogsModel.date" Class="txtbox" required></input></td>
</tr>
<tr>
<td>Select Event Name </td>
<td>
<select id="someDropDown" placeholder="Select Event Name" class="dropdown" name="newsAndBlogsModel.newsCategory" required>
          	<option value="">Select Event Name</option>
	  		<option value="Energy_Meter">Energy Meter</option>
	  		<option value="Company Events">Company Events</option>
	 		<option value="International News">International News</option>
	  		<option value="Domestic News">Domestic News</option>
	   		<option value="Technologies">Technologies</option>
	      	<option value="Upcoming Events">Upcoming Events</option>
	      	<option value="Competitive News">Competitive News</option>
</select>
</td>
</tr>
<tr>
<td>Title</td>
<td><input type="text" name="newsAndBlogsModel.titleName" Class="txtbox" required></input></td>
</tr>
<tr>
<td>News Description</td>
<td>


<textarea name="newsAndBlogsModel.newsDescription" Class="txtarea" ></textarea>

							 
</td></tr>
				
</table>
<table id="employeeprofileviewbtn">
<tr>
<td>
<s:submit value="submit" name="submit" cssClass="submit_button"/>
</td>
</tr>
</table>
</s:form>

</body>
</html>