<%@page import="eu.ensup.Student"%>
<%@page import="java.util.List"%>

<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	
	<!-- Masthead Heading-->
	<h1>Les informations de l'étudiant</h1>

	<div class="table-responsive text-nowrap">
		<!--Table-->
		<% Student student = (Student) session.getAttribute("student"); %>
		Id        	 : <%=student.getId()%>
		<br/><br/>
		First Name	 : <%=student.getFirstName()%>
		<br/><br/>
		Last Name 	 : <%=student.getLastName()%>
		<br/><br/>
		Mail Address : <%=student.getMailAdresse()%>
		<br/><br/>
		Address		 : <%=student.getAdress()%>
		<br/><br/>
		Phone Number : <%=student.getNumberPhone()%>
		<br/><br/>
		BirthDay	 : <%=student.getDateOfBirth()%>

	</div>

	<!--Section: Live preview-->

</div>




<!-- footer -->
<script>

</script>
<%@include file="footer.jsp"%>