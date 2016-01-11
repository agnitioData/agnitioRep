<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Basic Info</title>
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
    
}
#employeepupdatebtntbl
{
	width: 900px;
    margin: 40px auto;
    border-collapse: collapse;
    
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
 <s:iterator value="empProfileViewBeanList">
<table id="employeeprofileview">


<tr>
<th colspan="4">Employee Basic Information</th>
</tr>
<tr>
<td>Name</td>
<td>
  <s:property  value="firstName" ></s:property>
  <s:property value="lastName" />
</td>
<td>Employee Code</td>
<td>  <s:property value="empCode" /></td>
</tr>
<tr>
<td>Email-ID</td>
<td><s:property value="emailId" /></td>
<td>Date of Birth</td>
<td><s:property value="dob" /></td>
</tr>
<tr>
<td>Date of Joining</td>
<td> <s:property value="doj" /></td>
<td>Passport No</td>
<td> <s:property value="passportNumber" /></td>
</tr>
<tr>
<td>Pan No</td>
<td><s:property value="panNumber" /></td>
<td>Marital Status</td>
<td> <s:property value="marritalStatus" /></td>
</tr>
<tr>
<td>Anniversary Date</td>
<td> <s:property value="anniversaryDate" /></td>
<td>Mobile No</td>
<td> <s:property value="mobileNumber" /></td>
</tr>
<tr>
<td>Present Address</td>
<td>   <s:property value="presentAddress" /></td>
<td>Permanent Address</td>
<td> <s:property value="permanenetAddress" /></td>
</tr>
</table>

<table id="employeepupdatebtntbl" class="updatebtn">
<tr><td colspan="4"><input type="button" value="update" name="submit" Class="submit_button" id="hide"/></td></tr>
</table>
<form action="empDetailsUpdate">
<table id="employeeprofileview" class="editdetails">


<tr>
<th colspan="4">Employee Basic Information</th>
</tr>

  <s:textfield name="empProfileViewBean.firstName" value='%{firstName}' label="First Name" cssClass="txtbox" readonly="true"/>
  <s:textfield name="empProfileViewBean.lastName"  value='%{lastName}' label="Last Name" cssClass="txtbox" readonly="true"/>

 <%-- <s:textfield name="empProfileViewBean.lastName" value="%{empCode}" label="Emp Code" cssClass="txtbox"/> --%>

<s:textfield name="empProfileViewBean.emailId" value="%{emailId}" label="Email Id" cssClass="txtbox" readonly="true"/>

<s:textfield name="empProfileViewBean.dob" value="%{dob}" label="Date OF Birth" cssClass="txtbox" readonly="true"/>

 <%-- <s:textfield name="empProfileViewBean.lastName" value="%{doj}" label="Date of Joining" cssClass="txtbox"/> --%>

 <s:textfield name="empProfileViewBean.passportNumber" value="%{passportNumber}" label="Passport Number" cssClass="txtbox"/>

<s:textfield name="empProfileViewBean.panNumber" value="%{panNumber}" label="Pan Number" cssClass="txtbox"/>

 <s:textfield name="empProfileViewBean.marritalStatus" value="%{marritalStatus}" label="Marrital Status" cssClass="txtbox"/>

 <s:textfield name="empProfileViewBean.anniversaryDate" value="%{anniversaryDate}" label="Anniversary Date" cssClass="txtbox"/>

<s:textfield name="empProfileViewBean.mobileNumber" value="%{mobileNumber}" label="Mobile Number" cssClass="txtbox"/>

   <s:textarea name="empProfileViewBean.presentAddress" value="%{presentAddress}" label="Present Address" cssClass="multitxtbox"/>

<s:textarea name="empProfileViewBean.permanenetAddress" value="%{permanenetAddress}" label="Permanent Address" cssClass="multitxtbox" />
<s:submit value="Save" name="submit" Class="submit_button"/>


</table>
</form>
       </s:iterator>
    
</body>
</html>