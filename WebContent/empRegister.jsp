<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration</title>
  <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
<style type="text/css">
.btn {
    background: #666666;
    color: #FFF;
    display: inline-block;
    border-radius: 4px;
    font-family: calibri;
    line-height: 2.5em;
    padding: 0 3em;
    text-decoration: none;
}
.dropdown
{
  width: 193px;
    height: 25px;
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
.multi_textbox
{
 width: 403px;
    height: 50px;
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
.textbox
{

    width: 177px;
    height: 25px;
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

body
{
    background-color: #fff;
    font-family: calibri;
    
}

#employeeprofileview
{
	width: 900px;
    margin: 20px auto;
    border-collapse: collapse;
    font-family: calibri;

    
}
#employeeprofileview tr
{
    border: 1px solid #4b4f52;
    height: 40px;
    text-align: center;
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
	border: 1px solid #4b4f52;text-align: left;padding-left: 10px;   height: 45px;
	
}
</style>
</head>
<body>
<s:form action="register">
<table id="employeeprofileview">
<tr>
<th colspan="4"> Please Enter Your Details Below</th>
</tr>
<tr>
<td>  
   <input id="empCode" name="empMasterDetails.empCode" placeholder="Employee Code" type="number" class="textbox" required autofocus/> 
 </td>
<td>
   <input id="firstName" name="empMasterDetails.firstName" placeholder="First Name" type="text" class="textbox" required autofocus/> 
                 
</td>
<td>
      <input id="lastName" name="empMasterDetails.lastName" placeholder="Last Name" type="text" class="textbox" required autofocus/> 
              
</td>
<td>
     <input id="emailId" name="employeeGenDetails.emailId" placeholder="Email Id" type="email" class="textbox" required autofocus/> 
               
</td>
</tr>
<tr>
<td>
   <input id="userName" name="empMasterDetails.userName" placeholder="UserName" type="text" class="textbox" required autofocus/> 
                  
</td>
<td>
    <input id="password" name="empMasterDetails.password" placeholder="Password:" type="password"  class="textbox" required autofocus/> 
                 
</td>
<td>
 <!--  <input id="empCode" name="employeeGenDetails.empGender" placeholder="Gender" type="text" class="textbox" required autofocus/>  --> 
							           <select id="someDropDown" placeholder="Please Select Gender" class="dropdown" name="employeeGenDetails.empGender">
							           <option value="">Select Gender</option>
							  <option value="Male">Male</option>
							  <option value="Female">Female</option>
							
							</select>
             
</td>
<td>
     <input id="dob" name="employeeGenDetails.dob" placeholder="Date of Birth" type="text" class="textbox" required autofocus onfocus="(this.type='date')"/> 
                
</td>
</tr>
<tr>
<td>
     <input id="doj" name="employeeGenDetails.doj" placeholder="Date of Joining" type="text" class="textbox" required autofocus onfocus="(this.type='date')"/> 
                
</td>
<td>
   <input id="passportNo" name="employeeGenDetails.passportNo" placeholder="Passport No" type="text" class="textbox" /> 
                
</td>
<td>
    <input id="panNo" name="employeeGenDetails.panNo" placeholder="PAN No" type="text" class="textbox" /> 
                 
</td>
<td>
    <input id="accountNo" name="employeeGenDetails.accountNo" placeholder="A/C Number" type="number" class="textbox" required autofocus/> 
                
</td>
</tr>
<tr>
<td>
 <!--     <input id="maritalStatus" name="employeeGenDetails.maritalStatus" placeholder="Marital Status" type="text" class="textbox" required autofocus/>  -->
                             <select id="someDropDown" placeholder="Please Select Gender" class="dropdown" name="employeeGenDetails.maritalStatus">
							           <option value="">Select Marital Status</option>
							  <option value="Married">Married</option>
							  <option value="UnMarried">UnMarried</option>
							
							</select>
</td>
<td>
   <input id="anniversaryDate" name="employeeGenDetails.anniversaryDate" placeholder="Anniversary Date" type="text" class="textbox" onfocus="(this.type='date')"/> 
                 
</td>
<td>
    <input id="mobileNumber" name="empAddressDetails.mobileNo" placeholder="Mobile Number" type="number" class="textbox" required autofocus/> 
                 
</td>
<td>
   <input id="mobileNumberType" name="empAddressDetails.mobNumbertype" placeholder="Mobile Number Type" type="text" class="textbox" /> 
                 
</td>
</tr>
<tr>
<td colspan="2">
     <textarea id="permanentAddress" name="empAddressDetails.permanentAdd" placeholder="Permanent Address" type="text" class="multi_textbox" required autofocus> </textarea>
                
</td>
<td colspan="2">
    <textarea id="presentAddress" name="empAddressDetails.presentAdd" placeholder="Employee Present Address" type="text" class="multi_textbox" required autofocus> </textarea>
                 
</td>

</tr>
<tr>
<th colspan="4"">
     Family Details
</th>
</tr>
<tr>
<td>
      <input id="empCode" name="empFamilyDetailsBean.fname" placeholder="Father Name" class="textbox"  /> 
              
</td>
<td>
  <input id="foccupation" name="empFamilyDetailsBean.foccupation" placeholder="Occupation" type="text" class="textbox"  /> 
                  
</td>
<td>
    <input id="fmobileNo" name="empFamilyDetailsBean.fmobileNo" placeholder="Mobile Number"  class="textbox"  /> 
                 
</td>
<td></td>

</tr>
<tr>
<td>
   <input id="name" name="empFamilyDetailsBean.name" placeholder="Mother Name" type="text" class="textbox"  /> 
                 
</td>
<td>
     <input id="occupation" name="empFamilyDetailsBean.occupation" placeholder="Occupation" type="text" class="textbox"  /> 
               
</td>
<td>
   <input id="mobileNo" name="empFamilyDetailsBean.mobileNo" placeholder="Mobile Number"  class="textbox"  /> 
                 
</td>
<td>             
</td>
</tr>
<tr>
<td>
  <input id="empCode" name="empFamilyDetailsBean.noOfSiblings" placeholder="Total No of Siblings" type="text" class="textbox"  /> 
   
</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<th colspan="4">
   Education Details
</th>
</tr>

<tr>
<td>
    <input id="empCode" name="empEducationDetails.tenthDegree" placeholder="10th Examination" type="text" class="textbox"  required autofocus/> 
                
</td>
<td>
    <input id="firstName" name="empEducationDetails.tenthUniversity" placeholder="School/University" type="text" class="textbox"  required autofocus/> 
                 
</td>
<td>
    <input id="lastName" name="empEducationDetails.tenthYearOfPass" placeholder="Year of Passing" type="number" class="textbox"  required autofocus/> 
                 
</td>
<td>
     <input id="emailId" name="empEducationDetails.tenthGrade" placeholder="Grade %"  type="number" class="textbox"  required autofocus/> 
               
</td>
</tr>
<tr>
<td>
     <input id="empCode" name="empEducationDetails.twelveDegree" placeholder="12th Examination" type="text" class="textbox"  required autofocus/> 
                
</td>
<td>
      <input id="firstName" name="empEducationDetails.twelveUniversity" placeholder="School/University" type="text" class="textbox"  required autofocus/> 
              
</td>
<td>
     <input id="lastName" name="empEducationDetails.twelveYearOfPass" placeholder="Year of Passing" type="number" class="textbox"  required autofocus/> 
                
</td>
<td>
     <input id="emailId" name="empEducationDetails.twelveGrade" placeholder="Grade %" type="number" class="textbox"  required autofocus/> 
               
</td>
</tr>
<tr>
<td>
     <input id="empCode" name="empEducationDetails.graduationDegree" placeholder="Graduation Examination" type="text" class="textbox"  required autofocus/> 
                
</td>
<td>
    <input id="firstName" name="empEducationDetails.graduationUniversity" placeholder="School/University" type="text" class="textbox"  required autofocus/> 
                
</td>
<td>
    <input id="lastName" name="empEducationDetails.graduationYearOfPass" placeholder="Year of Passing" type="number" class="textbox"  required autofocus/> 
                 
</td>
<td>
      <input id="emailId" name="empEducationDetails.graduationGrade" placeholder="Grade %" type="number" class="textbox"  required autofocus/> 
               
</td>
</tr>
<tr>
<td>
     <input id="empCode" name="empEducationDetails.pgDegree" placeholder="Post Graduation Examination" type="text" class="textbox"  /> 
                
</td>
<td>
        <input id="firstName" name="empEducationDetails.pgUniversity" placeholder="School/University" type="text" class="textbox"  /> 
             
</td>
<td>
    <input id="lastName" name="empEducationDetails.pgYearOfPass" placeholder="Year of Passing" type="number" class="textbox"  /> 
                 
</td>
<td>
    <input id="emailId" name="empEducationDetails.pgGrade" placeholder="Grade %" type="number" class="textbox"  /> 
                
</td>
</tr>
<tr>
<th colspan="4">  Professional Details</th>
</tr>
<tr>
<td>
     <input id="department" name="empProfessionalInfoBean.department" placeholder="Department Name" type="text" class="textbox"  required autofocus/> 
                
</td>
<td>
   <input id="designation" name="empProfessionalInfoBean.designation" placeholder="Designation" type="text" class="textbox"  required autofocus/> 
                 
</td>
<td>
     <input id="empManager" name="empProfessionalInfoBean.empManager" placeholder="Employee Manager Code" type="text" class="textbox"  required autofocus/> 
                
</td>
<td>
    <input id="doj" name="empProfessionalInfoBean.doj" placeholder="Date Of Joining" type="text" class="textbox"  required autofocus onfocus="(this.type='date')"/> 
                 
</td>
</tr>
<tr>
<td>
     <input id="totalExp" name="empProfessionalInfoBean.totalExp" placeholder="Total Experience" type="text" class="textbox"  required autofocus/> 
                
</td>
<td>
  <!--  <input id="empStatus" name="empProfessionalInfoBean.empStatus" placeholder="Employee Status" type="text" class="textbox"  required autofocus/> --> 
                   
                              <select id="someDropDown" placeholder="Please Select Status" class="dropdown" name="empProfessionalInfoBean.empStatus">
							           <option value="">Select Status</option>
							  <option value="Confirm">Confirm</option>
							  <option value="Probation">Probation</option>
							
							</select>
             
</td>
<td>
     <input id="ctc" name="empProfessionalInfoBean.ctc" placeholder="Current C.T.C" type="text" class="textbox"  required autofocus/> 
                
</td>
<td></td>
</tr>
<tr>
<td colspan="4">
     <input value="submit" type="submit" class="btn"></input> 
</td>
</tr>
</table>
   
   	</s:form>
    </body>


</body>
</html>




