<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Education Details</title>
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
    font-family: calibri;
 
}

#employeeprofileview tr td
{
	border: 1px solid #4b4f52;   padding-left: 50px;
	
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
		<s:iterator value="empEducationDetailsList">
	<table id="employeeprofileview">
<tr>
<th colspan="4">Employee Education Details</th>
</tr>

	<tr>
	<th>Degree</th>
	<th>University</th>
	<th>Year Of Pass</th>
	<th>Grade</th>
	</tr>
	<tr>
	<td><s:property value="tenthDegree" /></td>
	<td><s:property  value="tenthUniversity" ></s:property></td>
	<td><s:property value="tenthYearOfPass" /></td>
	<td><s:property value="tenthGrade" /></td>
	</tr>
	<tr>
	<td><s:property value="twelveDegree" /></td>
	<td><s:property  value="twelveUniversity" ></s:property></td>
	<td><s:property value="twelveYearOfPass" /></td>
	<td><s:property value="twelveGrade" /></td>
	</tr>
	<tr>
	<td><s:property value="graduationDegree" /></td>
	<td><s:property  value="graduationUniversity" ></s:property></td>
	<td><s:property value="graduationYearOfPass" /></td>
	<td><s:property value="graduationGrade" /></td>
	</tr>
	<tr>
	<td><s:property value="pgDegree" /></td>
	<td><s:property  value="pgUniversity" ></s:property></td>
	<td><s:property value="pgYearOfPass" /></td>
	<td><s:property value="pgGrade" /></td>
	</tr>
	  
	</table>
	<table id="employeepupdatebtntbl" class="updatebtn">
<tr><td colspan="4"><input type="button" value="update" name="submit" Class="submit_button" id="hide"/></td></tr>
</table>

<form action="empEduUpdate">
<table id="employeeprofileview" class="editdetails">


<tr>
<th colspan="4">Employee Education Information</th>
</tr>

  <s:textfield name="empEducationDetails.tenthDegree" value="%{tenthDegree}" cssClass="txtbox" Class="txtbox" label="Tenth Degree" />
	<s:textfield name="empEducationDetails.tenthUniversity"  value="%{tenthUniversity}" cssClass="txtbox" label="Tenth University" />
	<s:textfield name="empEducationDetails.tenthYearOfPass" value="%{tenthYearOfPass}" cssClass="txtbox" label="Tenth Year of Pass" />
	<s:textfield name="empEducationDetails.tenthGrade" value="%{tenthGrade}" cssClass="txtbox" label="Tenth Grade" />
	
	
	<s:textfield name="empEducationDetails.twelveDegree" value="%{twelveDegree}" cssClass="txtbox" label="Twelve Degree" />
	<s:textfield name="empEducationDetails.twelveUniversity"  value="%{twelveUniversity}" cssClass="txtbox" label="Twelve University" />
	<s:textfield name="empEducationDetails.twelveYearOfPass" value="%{twelveYearOfPass}" cssClass="txtbox" label="Twelve Year of Pass" />
	<s:textfield name="empEducationDetails.twelveGrade" value="%{twelveGrade}" cssClass="txtbox" label="Twelve Grade" />
	
	<s:textfield name="empEducationDetails.graduationDegree" value="%{graduationDegree}" cssClass="txtbox" label="Graduation Degree" />
	<s:textfield name="empEducationDetails.graduationUniversity"  value="%{graduationUniversity}" cssClass="txtbox" label="Graduation University" />
	<s:textfield name="empEducationDetails.graduationYearOfPass" value="%{graduationYearOfPass}" cssClass="txtbox" label="Graduation Year of Pass" />
	<s:textfield name="empEducationDetails.graduationGrade" value="%{graduationGrade}" cssClass="txtbox" label="Graduation Grade" />
	
	<s:textfield name="empEducationDetails.pgDegree" value="%{pgDegree}" cssClass="txtbox" label="Post Graduation Degree" />
	<s:textfield name="empEducationDetails.pgUniversity"  value="%{pgUniversity}" cssClass="txtbox" label="Post Graduation University" />
	<s:textfield name="empEducationDetails.pgYearOfPass" value="%{pgYearOfPass}" cssClass="txtbox" label="Post Graduation Year of Pass" />
	<s:textfield name="empEducationDetails.pgGrade" value="%{pgGrade}" cssClass="txtbox" label="Post Graduation Grade" />
	

<s:submit value="Save" name="submit" Class="submit_button"/>


</table>
</form>
	 </s:iterator>
	
	
     
	</body>
</html>












