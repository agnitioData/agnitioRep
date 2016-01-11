<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script src="js/jquery.min.js"></script>
<style type="text/css">
body
{
background-color: #fff;
}
#employeeprofileviewbtn
{
	width: auto;
    margin: 70px auto;    
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
     font-family: calibri;
    
}
#employeeprofileview tr td
{
	border: 1px solid #4b4f52;    padding-left: 124px;v
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
<script language="javascript" type="text/javascript">

  
    $(document).ready(function(){
    	  $(".submit_button").click(function(){
    	        var firstDate = $('#fromdate').val();
    	        var lastDate = $('#todate').val();
    	        if (Date.parse(firstDate) > Date.parse(lastDate)) {
    	            alert("First date can not be greater than Last date!!");
    	        } 
    	    });
    });

</script>
</head>
<body>
<%-- <s:if test="hasActionErrors()">
   <!-- <div class="errors"> -->
      
  <!--  </div> -->
</s:if> --%>
<s:if test="hasActionErrors()">
	<div class="errorDiv">
		<s:actionerror/>
	</div>
</s:if>
<s:form action="leaveSubmit" namespace="/" method="GET" enctype="multipart/form-data">
<table id="employeeprofileview">
<tr><th colspan="2">Apply Leave</th></tr>
<%-- <tr><s:textfield name="leaveMailBean.userName" label="Official MailId" cssClass="txtbox"></s:textfield> </tr>
<tr><s:password name="leaveMailBean.password" label="Password"  cssClass="txtbox"></s:password></tr> --%>
<%-- <tr><s:textfield name="empLeaveApplyBean.applyDate" label="Date" cssClass="txtbox"></input></tr> --%>

<tr><td>No of Days</td>   <td><input type="number" min="1" max="30" maxlength="6" name="empLeaveApplyBean.noOfDays" Class="txtbox" required pattern="d{29}"></input></td></tr>

<tr><td>From Date</td><td><input type="date" name="empLeaveApplyBean.fromDate" Class="txtbox" required id="fromdate"></input></td></tr>
<tr><td>To Date</td><td><input type="date" name="empLeaveApplyBean.toDate" Class="txtbox" required id="todate"></input></td></tr>
<tr><td>Reason for Leave</td><td><input type="text" name="empLeaveApplyBean.leaveReason"  Class="txtbox" required></input></td></tr>

</table>
<table id="employeeprofileviewbtn">
<tr>
<td>
<s:submit value="Apply" name="submit" Class="submit_button"/>
</td>
</tr>
</table>

</s:form>
</body>
</html>