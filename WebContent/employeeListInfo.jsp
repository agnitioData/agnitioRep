<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-1.11.1.js"></script>
<style type="text/css">
body
{
background-color: #fff;
}
#emplistinfo
{
	width: 1050px;
    margin: 70px auto;
    border-collapse: collapse;
    font-family: calibri;
    
}
#emplistinfo tr
{
    border: 1px solid #4b4f52;
    height: 40px;

}
#emplistinfo th
{
    border: 1px solid #4b4f52;
    height: 40px;
    text-align: center;
    background-color: #666666;;
    color: #fff;
}

#emplistinfo tr td
{
	border: 1px solid #4b4f52;
	padding: 0px 50px;
	    text-align: left;
	
}
.checkbox
{
   width: 30px;height: 30px;
}


</style>
<script type="text/javascript">
$(document).ready(function() {

$('#emplistinfo tr td #clickstatus').click(function() {
    var empcode = $(this).parent().parent().find("#empcode").html();
	
/*     
    var gateSerialNumber = $(this).find("#main #rowdatalist #gatewaySerialNumber").val();
    $('#gateSerialNumber').val(gateSerialNumber); */
}); 

});
var div1 = document.getElementById('#expstatus');
</script>
</head>
<body>
<form action="">
			<table id="emplistinfo">
					<tr>
		        	<th>Emp Code </th>
                    <th>Emp Name</th>
                    <th>Emp Status</th>
                    <th>Confirmation</th>
                    </tr>
				
				<s:iterator var="parent" value="employeesListBeanList">
			
					<tr id="rowdatalist">
			
						<td id="a">
						<s:label label=" "
												value='%{empCode}' theme="simple"
												readonly="true" id="empcode"
												cssClass="textbox_sr_no" />
						
						</td>
						<td>
							<s:label label=""
												value='%{firstName}' theme="simple"
												readonly="true" id="empfirstname"
												cssClass="textbox_sr_no" />
												<s:label label="Gateway Serial Number "
												value='%{lastName}' theme="simple"
												readonly="true" 
												cssClass="textbox_sr_no" />
							
						</td>
						<%-- <td><s:label label="Gateway Serial Number "
												value='%{lastName}' theme="simple"
												readonly="true" id="gatewaySerialNumber3"
												cssClass="textbox_sr_no" /></td>--%>
						<td> 
						<s:label label=" "
												value='%{empStatus}' theme="simple"
												readonly="true" id="expstatus"
												cssClass="textbox_sr_no" />
						</td>
						<s:if test="empStatus== 'Probation'">
						 <td> <input type="checkbox" name="status" label="status" id="clickstatus" class="checkbox"/></td> 
						</s:if>
						<s:else><td> <input type="checkbox" name="status" label="status" id="clickstatus" disabled class="checkbox"/></td> </s:else>
						
					<%-- 	<s:else test="empStatus== 'Probation'">
						<!-- <td> <input type="checkbox" name="status" label="status" id="clickstatus"></td> -->
						</s:else> --%>
						<%-- <td><s:property value="%{#parent.empStatus}" /></td><br/> --%>
						<%-- <s:if test="#parent.empStatus==Confirm">
						<td> <input type="checkbox" name="status" label="status" id="clickstatus"></td></s:if> --%>
						
					</tr>
				</s:iterator>
				
			</table>
			<script type="text/javascript">
$( "#emplistinfo #rowdatalist #expstatus" ).each( function( index ) {
	if ($(this).text()  == "Probation" ) {
	$( this ).css('color','red');
	}
	}); 

</script>
</form>	
</body>
</html>