<%@page import="eu.ensup.Course"%>
<%@page import="eu.ensup.Student"%>

<%@page import="java.util.List"%>
<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
<br /> <br /> <br /> <br /> <br /> <br />
	<%List<Course> listCours = (List<Course>) session.getAttribute("courses");%>
	<h1>Associé un cour a un etudiant</h1>
	<form action="EtudiantCoursServlet" method="post">
	<% Student student = (Student) session.getAttribute("student");%>
		<input type="text" id="mail" class="form-control" name="mail" value="<%=student.getMailAdresse()%>">
	  	<select name="listeCours">
				<% 
				        for (Course course : listCours)
				        {
				         
				%>
					   <option name="cours" value="<%=course.getThemeCourse()%>"><%=course.getThemeCourse()%></option>
				<%
				        }
				%>
		</select>
			<br/> <br/>
			<div class="text-center mb-2">
					<button type="submit" class="btn btn-primary mb-4">Submit</button>
			</div>
</div>

<!-- footer -->
<%@include file="footer.jsp"%>