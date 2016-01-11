<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
.dropdown
{
      width: 224px;
    height: 32px;
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
</style>
</head>
<body>
<form action="resetPwd" method="post">

<table id="employeeprofileview">
<tr>
<th colspan="2">Change Employee Confirmation</th>
</tr>

<tr>
<td>Employee Name </td>
<td><input id="prevpassword" name="empProfileViewBean.password"  type="password"  class="txtbox" required autofocus/> </td>
</tr>

<tr>
<td>Employee Confirmation </td>
<td>
        <select id="someDropDown" placeholder="Please Select Status" class="dropdown" name="employeeGenDetails.empGender">
							           <option value="">Select Status</option>
							  <option value="volvo">Confirm</option>
							  <option value="saab">Probation</option>
							
							</select>
 </td>
</tr>


</table>
				

<table id="employeeprofileviewbtn">
  <tr>
	<td><input value="submit" type="submit" class="submit_button"></input> </td>
 </tr>
</table>           
</form>               
</body>
</html>