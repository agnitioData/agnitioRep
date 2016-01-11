<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>    
    
     <link href="css/datatables.min.css" rel="stylesheet" type="text/css"></link>
<script src="js/datatables.min.js"></script> 
      <script type="text/javascript" src="js/dataTables.fixedHeader.min.js"></script>
<style type="text/css">

div.FixedHeader_Cloned th,
div.FixedHeader_Cloned td {
	background-color: white !important;
}
    body { font-size: 140%; padding: 1em; }
div.FixedHeader_Cloned table { margin: 0 !important }
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
</style>
</head>
<body>

<div style="height: auto;margin:20px auto 50px auto;">
<table id="employeeprofileview">
<tr>
<td>P</td>
<td>Present</td>
<td>A</td>
<td>Absent</td>
<td>WO</td>
<td>Weekend Off</td>
<td>HO</td>
<td>Holiday Off</td>
</tr>
</table>
<div class="container">
<table id="example" class="table table-striped table-bordered dataTable" cellspacing="0" width="100%" role="grid" aria-describedby="example_info" style="width: 100%;">

<thead>
<tr>
<th>Date</th> 
<th>Emp Code</th>
<th>Emp Name</th>
<th>In Time</th>
<th>Out Time</th>
<th>Duration</th>
<th>Status</th> 

</tr>
</thead>
<tbody>
<s:iterator value="absentList">
<tr id="absentList">
<td><s:property value="dateTime"/></td>
<td><s:property value="empCode"/></td>
<td><s:property value="empName"/></td>
<td><s:property value="inTime"/></td>
<td><s:property value="outTime"/></td>
<td id="workingHours"><s:property value="workingHours"/></td>
<td id="status"><s:property value="status"/></td>

</tr>
</s:iterator>
</tbody>
</table>
</div>
</div>

<script type="text/javascript">
$( "#example tbody #absentList #status" ).each( function( index ) {
	if ($(this).text()  == "A" ) {
	$( this ).css('color','red');
	}
	}); 
$( "#example tbody #absentList" ).each( function( index ) {
	
	if (($(this).find('#workingHours').text() < "08:59 Hr")&&($(this).find('#status').text() == "P")) {
	$( this ).find('#workingHours').css('color','red');
	}
	});
</script>

<script type="text/javascript">//<![CDATA[
window.onload=function(){
$(document).ready(function() {
    var table = $('#example').DataTable();
    
    
    
    new $.fn.dataTable.FixedHeader( table, {
        alwaysCloneTop: true
    });
    
   
    
});
 
}


</script>
</body>
</html>