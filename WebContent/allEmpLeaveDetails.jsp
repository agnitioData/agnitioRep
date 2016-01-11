<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
     <link href="css/datatables.min.css" rel="stylesheet" type="text/css"></link>
<script src="js/datatables.min.js"></script>

	<script type="text/javascript" >
$(document).ready(function() {
	$('#example').DataTable();
} );
</script>
</head>
<body>
<div style="height: auto;margin:20px auto 50px auto;">
<div class="container">
<table id="example" class="display" cellspacing="0" width="100%">
<thead>
<tr>
<th>Emp Code</th>
<th>Emp Name</th>
<th>Total Leaves</th> 
<th>Remaining Leaves</th> 
<th>Used Leaves</th>
</tr>
</thead>
<tbody>
<s:iterator value="allEmpLeaveDetailsList">
<tr>
<td><s:property value="empCode"/></td>
<td><s:property value="empName"/></td>
<td><s:property value="totalLeaves"/></td>
<td><s:property value="remainLeaves"/></td> 
<td><s:property value="usedLeaves"/></td> 
</tr>
</s:iterator>
</tbody>
</table>
</div>
</div>

<script type="text/javascript">
	// For demo to fit into DataTables site builder...
	$('#example')
		.removeClass( 'display' )
		.addClass('table table-striped table-bordered');
</script>
</body>

</html>