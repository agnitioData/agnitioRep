<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR Policies</title>
<style type="text/css">
html, body {
    margin: 0;
    padding: 0;
    border: 0;
    height: 100%;
    overflow: hidden;
}
object {
    width: 100%;
    height: 100%;
    border: 0
}
</style>
<script language="javascript">
    function handleMessage(msg) {
      alert('got message '+msg);
    }
    function setupHandler() {
      document.getElementById("myPdf").messageHandler = { onMessage: handleMessage };
    }
</script>
</head>
<body onLoad="setupHandler();">



<object id="myPdf" type="application/pdf" data="./HRPolicies/Guest House Policy.pdf">

</object>

</body>
</html>