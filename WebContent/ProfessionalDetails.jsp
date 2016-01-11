<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Profile Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="js/jquery.min.js"></script>
        <link href="css/homepage_1.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
body
{
background-color: #fff;
}
#employeeprofileview
{
	width: 900px;
    margin: 40px auto;
    border-collapse: collapse;
    font-family: calibri;
    
}
#employeepupdatebtntbl
{
	width: 900px;
    margin: 40px auto;
    border-collapse: collapse;
    font-family: calibri;
    
}
#employeepupdatebtntbl tr td
{
	width: 900px;
    margin: 40px auto;
    border-collapse: collapse;
    text-align: right;
    
}

#employeeprofileview tr
{
    border: 1px solid #4b4f52;
    height: 40px;
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
    font-size: 19px;
  font-family: calibri;
}

#employeeprofileview tr td
{
	border: 1px solid #4b4f52;   padding-left: 50px;
	
}
#employeeprofileview tr td:nth-child(odd)
{
    background-color: #B0ADAD;   padding-left: 20px;
	
}
.txtbox {
    width: 213px;
    height: 25px;
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
.multitxtbox {
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
 <script type="text/javascript">

$(document).ready(function(){
	$(".editdetails").hide();
	 $("#hide").click(function(){
		 $("#employeeprofileview").hide();
	        $(".editdetails").show();
	        $("#hide").hide();
	        $(".updatebtn").hide();
	        
	    });
	  });
</script>
</head>

<body>
  <s:iterator value="empProfessionalInfoList">
<table id="employeeprofileview">
<tr>
<th colspan="4">Employee Professional Details</th>
</tr>
<tr>
<td>Manager Code</td>
<td><s:property value="empManager" /></td>
<td>Department</td>
<td>	<s:property  value="department" ></s:property></td>
</tr>
<tr>
<td>Designation</td>
<td><s:property value="designation" /></td>
<td>Total Experience</td>
<td><s:property value="totalExp" /></td>
</tr>
<tr>
<td>Working Status</td>
<td><s:property value="empStatus" /></td>
<td>CTC(per Annum)</td>
<td><s:property value="ctc" /></td>
</tr>
</table>
<table id="employeepupdatebtntbl" class="updatebtn">
<tr><td colspan="4"><input type="button" value="update" name="submit" Class="submit_button" id="hide"/></td></tr>
</table>

<form action="empProfDetailsUpdate">
<table id="employeeprofileview" class="editdetails">


<tr>
<th colspan="4">Employee Professional Details</th>
</tr>




    <s:textfield name="empProfessionalInfoBean.empManager" value="%{empManager}" label="Emp Manager" cssClass="txtbox" readonly="true"/>

	<s:textfield name="empProfessionalInfoBean.department"  value="%{department}" label="Department" cssClass="txtbox" readonly="true"/>

    <s:textfield name="empProfessionalInfoBean.designation" value="%{designation}" label="Designation" cssClass="txtbox" readonly="true"/>

     <s:textfield name="empProfessionalInfoBean.totalExp" value="%{totalExp}" label="Total Experience" cssClass="txtbox" readonly="true"/>

     <s:textfield name="empProfessionalInfoBean.empStatus" value="%{empStatus}" label="Working Status" cssClass="txtbox" readonly="true"/>

     <s:textfield name="empProfessionalInfoBean.ctc" value="%{ctc}" label="CTC(per Annum)" cssClass="txtbox"/>


<s:submit value="Save" name="submit" Class="submit_button"/>


</table>

</form>


 </s:iterator>

    </body>
</html>












