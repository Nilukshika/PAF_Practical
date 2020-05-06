<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Doctor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.2.1.min.js"></script>
	<script src="Components/Doctor.js"></script>
	<meta charset="ISO-8859-1">

	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">

				<h1>Doctor Service</h1>
				<form id="formDoctor" name="formDoctor" >
					Doctor Name: 
					<input id="DocName" name="DocName" type="text"class="form-control form-control-sm">
					 <br> Doctor NIC:
					<input id="DocNIC" name="DocNIC" type="text"class="form-control form-control-sm"> 
					<br> Gender: 
					<input id="Gender" name="Gender" type="text"class="form-control form-control-sm"> 
					<br> Registered No: 
					<input id="ReqNo" name="ReqNo" type="text"class="form-control form-control-sm">
					<br> Specialized:
					<input id="Specialized" name="Specialized" type="text"class="form-control form-control-sm"> 
					<br> Email: 
					<input id="Email" name="Email" type="text"  class="form-control form-control-sm"> 
					<br>
					  <input id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary">
		<input type="hidden" id="hidDoctorIDSave" name="hidDoctorIDSave" value="">
				</form>


				<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
  
   <br>
   <div id="divDotorGrid">
   
   <%
   
      Doctor doctorobj = new Doctor();
      out.print(doctorobj.readdoctor());
   %>
   </div>

			</div>
		</div>
	</div>

</body>
</html>