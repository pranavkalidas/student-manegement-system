<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.student.details.StudentDetails"%>
<%@ page import="com.student.details.StudentReport"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student | Dashboard</title>
<link rel="stylesheet" href="main.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Finlandica:ital@1&display=swap"
	rel="stylesheet">
<script src="main.js"></script>
</head>
<body
	style="background-image: url('images/student.jpg'); background-size: cover;">
	<div class="title-bar">STUDENT MARKS MANAGEMENT SYSTEM</div>
	<div class="buttons" id="main-buttons">
		<button class="delete-button" id="delete-button"
			onclick="openDeleteForm();" ondblclick="closeDeleteForm()">
			DELETE <br> STUDENT
		</button>
		<button class="report-button" id="report-button"
			onclick="openReportForm();" ondblclick="closeReportForm()">
			GENERATE <br> REPORT
		</button>
		<button class="query-button" id="query-button"
			onclick="openQueryForm();" ondblclick="closeQueryForm()">
			VIEW <br> STUDENT
		</button>
		<button class="add-button" id="add-button" onclick="openAddForm();"
			ondblclick="closeAddForm()">
			ADD <br> STUDENT
		</button>
		<button class="update-button" id="update-button"
			onclick="openUpdateForm();" ondblclick="closeUpdateForm()">
			UPDATE <br> STUDENT
		</button>
	</div>

	<!--DELETE FORM-->
	<div class="popups">
		<form class="delete-form" action="Delete" method="post"
			id="delete-form" onsubmit="return validateDeleteForm()">
			<!-- <div class="form-close" >
                <button id="form-close" onclick=""></button>
            </div> -->
			<span><p>Enter Student ID</p> </span> <br> <input
				class="form-input" type="text" name="delete-stdid" id="delete-stdid">
			<br> <br>
			<button class="form-button" type="submit" name="getDelete"
				id="getDelete">DELETE</button>
			<br>
		</form>

		<form class="report-form" action="Report" method="post"
			id="report-form" onsubmit="return validateReportForm()">
			<span><p>Enter Student ID</p> </span> <br> <input
				class="form-input" type="number" name="report-stdid"
				id="report-stdid"> <br> <br>
			<button class="form-button" type="submit" name="getReport"
				id="getReport">GENERATE REPORT</button>
			<br>
		</form>

		<form class="query-form" action="Query" method="post" id="query-form">
			<span><p>Enter Student Name</p> </span> <br> <input
				class="form-input" type="text" name="query-stdname"
				id="query-stdname"><br> <br>
			<button class="form-button" type="submit" name="getQuery"
				id="getQuery">QUERY</button>
			<br>
		</form>

		<form action="Add" class="add-form" method="post" id="add-form"
			onsubmit="return validateAddForm()">
			<span><p>Student Name</p> </span> <input class="form-input"
				type="text" name="add-stdname" id="add-stdname"><br> <br>
			<span><p>Student Number</p> </span> <input class="form-input"
				type="text" name="add-stdid" id="add-stdid"><br> <br>
			<span><p>Subject 1</p></span> <input class="form-input" type="text"
				name="add-m1" id="add-m1"><br> <br> <span><p>Subject
					2</p></span> <input class="form-input" type="text" name="add-m2" id="add-m2"><br>
			<br> <span><p>Subject 3</p></span> <input class="form-input"
				type="text" name="add-m3" id="add-m3"><br> <br> <span><p>Subject
					4</p></span> <input class="form-input" type="text" name="add-m4" id="add-m4"><br>
			<br> <span><p>Subject 5</p></span> <input class="form-input"
				type="text" name="add-m5" id="add-m5"><br> <br>
			<button class="form-button" type="submit" name="getAdd" id="getAdd">ADD</button>
			<br>
		</form>

		<form class="update-form" action="Update" method="post"
			id="update-form" onsubmit="return validateUpdateForm()">
			<span><p>Enter Student ID</p> </span> <input class="form-input"
				type="text" name="update-stdid" id="update-stdid"><br>
			<br>
			<button class="form-button" type="submit" name="getUpdate"
				id="getUpdate">UPDATE</button>
			<br>
		</form>
	</div>
	<!-- TO PRINT SUCCESS -->

	<%
	String success = (String) session.getAttribute("success");
	if (success == "1") {
	%>
	<div class='success'>
		<p>SUCCESSFULL</p>
	</div>
	<%
	}
	session.setAttribute("success", "0");
	%>

	<!-- TO PRINT NO RECORD -->
	<%
	String noRecord = (String) session.getAttribute("noRecord");
	if (noRecord == "1") {
	%>
	<div class='alert'>
		<p>NO SUCH USER</p>
	</div>
	<%
	}
	session.setAttribute("noRecord", "0");
	%>

	<!-- TO PRINT THE STUDENT DETAILS -->
	<%
	String displayStd = (String) session.getAttribute("displayStd");
	if (displayStd == "1") {
		ArrayList<StudentDetails> students = (ArrayList<StudentDetails>) session.getAttribute("list");
	%>
	<table class='display-table'>
		<thead>
			<tr>
				<td>Student ID</td>
				<td>Student Name</td>
				<td>Student Subject 1</td>
				<td>Student Subject 2</td>
				<td>Student Subject 3</td>
				<td>Student Subject 4</td>
				<td>Student Subject 5</td>
			</tr>
		</thead>
		<%
		for (StudentDetails std : students) {
		%>
		<tbody class='display-table'>
			<tr>
				<td><%=std.getStdid()%></td>
				<td><%=std.getStdname()%></td>
				<td><%=std.getM1()%></td>
				<td><%=std.getM2()%></td>
				<td><%=std.getM3()%></td>
				<td><%=std.getM4()%></td>
				<td><%=std.getM5()%></td>
			</tr>
		</tbody>
		<%
		}
		session.setAttribute("displayStd", "0");
		}
		%>
	</table>

	<!-- TO CONFIRM DELETE -->
	<%
	String confirmDelete = (String) session.getAttribute("confirmDelete");
	if (confirmDelete == "1") {
	%>
	<form action="DeleteConfirm" method="POST">
		<div class='delete-confirm'>
			<input type="submit" value="Confirm Delete">
		</div>
	</form>
	<%
	}
	session.setAttribute("confirmDelete", "0");
	%>

	<!-- TO CONFIRM UPDATE -->
	<%
	String confirmUpdate = (String)session.getAttribute("confirmUpdate");
	ArrayList<StudentDetails> studentsUpdate = (ArrayList<StudentDetails>) session.getAttribute("list");
	if (confirmUpdate == "1") {
	%>
	<form action="UpdateConfirm" method="POST">
		<table class='display-table'>
			<thead>
				<tr>
					<td colspan='7'><b>UPDATE STUDENT DETAILS</b></td>
				</tr>
				<tr>
					<td>Student ID</td>
					<td>Student Name</td>
					<td>Student Subject 1</td>
					<td>Student Subject 2</td>
					<td>Student Subject 3</td>
					<td>Student Subject 4</td>
					<td>Student Subject 5</td>
				</tr>
			</thead>
			<%
			for (StudentDetails std : studentsUpdate) {
			%>
			<tbody class='display-table'>
			
				<tr>
					<td><input type='text' name='update-stdid'
						value="<%=std.getStdid()%>" readonly="readonly"></td>
					<td><input type='text' name='update-stdname'
						value="<%=std.getStdname()%>" readonly="readonly"></td>
					<td><input type='number' name='update-m1'
						value="<%=std.getM1()%>"></td>
					<td><input type='number' name='update-m2'
						value="<%=std.getM2()%>"></td>
					<td><input type='number' name='update-m3'
						value="<%=std.getM3()%>"></td>
					<td><input type='number' name='update-m4'
						value="<%=std.getM4()%>"></td>
					<td><input type='number' name='update-m5'
						value="<%=std.getM5()%>"></td>
				</tr>
				<tr>
					<td colspan="7"><input type="submit" value="SUBMIT"></td>
				</tr>
			</tbody>
			<%
		}
		session.setAttribute("confirmUpdate", "0");
		}
		%>
		</table>
	</form>

	<!-- TO PRINT REPORT -->
	<%
	String displayReport = (String) session.getAttribute("displayReport");
	if (displayReport == "1") {
		ArrayList<StudentReport> students = (ArrayList<StudentReport>) session.getAttribute("list");
	%>
	<table class='display-table'>
		<thead>
			<tr>
				<td>Student ID</td>
				<td>Student Name</td>
				<td>Student Subject 1</td>
				<td>Student Subject 2</td>
				<td>Student Subject 3</td>
				<td>Student Subject 4</td>
				<td>Student Subject 5</td>
				<td>Total</td>
				<td>Average</td>
				<td>Result</td>
			</tr>
		</thead>
		<%
		for (StudentReport std : students) {
		%>
		<tbody class='display-table'>
			<tr>
				<td><%=std.getStdid()%></td>
				<td><%=std.getStdname()%></td>
				<td><%=std.getM1()%></td>
				<td><%=std.getM2()%></td>
				<td><%=std.getM3()%></td>
				<td><%=std.getM4()%></td>
				<td><%=std.getM5()%></td>
				<td><%=std.getTotal()%></td>
				<td><%=std.getAvg()%></td>
				<td><%=std.getStatus()%></td>
			</tr>
		</tbody>
		<%
		}
		session.setAttribute("displayReport", "0");
		}
		%>
	</table>
</body>
</html>