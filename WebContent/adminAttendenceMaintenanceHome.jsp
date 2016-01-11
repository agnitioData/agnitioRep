<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   
<s:form action="uploadAttendence" method="GET" enctype="multipart/form-data">
   <s:file name="uploadFile" label="Choose File" />
   <s:textfield name="emp"></s:textfield>
   <s:submit value="Upload" name="Upload" align="center" />
</s:form>

<%-- <form action="uploadAttendence" method="post" enctype="multipart/form-data">
      <!-- <label for="myFile">Upload your file</label>
      <input type="file" name="myFile" />
      <input type="submit" value="Upload"/> -->
      
      
      
      	<s:file name="fileUpload" label="Select a File to upload" size="40" />
		<s:submit value="submit" name="submit" />
		
			<s:file name="fileUpload" id="fileUpload" label="Select a File to upload" />  
            <s:submit value="Upload" name="submit" align="center" /> 
   </form> --%>

</body>
</html>