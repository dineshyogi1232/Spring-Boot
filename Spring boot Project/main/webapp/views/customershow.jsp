<%@page import="com.customercrudapplication.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description"
		content="Start your development with a Dashboard for Bootstrap 4.">
	<meta name="author" content="Creative Tim">
	<title>Customer Dashboard</title>
	<jsp:include page="allcss.jsp"></jsp:include>
</head>
<body>
	<!-- Sidebar -->
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div class="main-content" id="panel">
		<!-- Navbar -->
		<jsp:include page="navbar.jsp"></jsp:include>
		<!-- Page content -->
		<div class="container-fluid mt--6">
			<div class="row"></div>
			<jsp:include page="maincontent.jsp"></jsp:include>
			<c:if test="${not empty success }">
				<div class="alert success text-center" role="alert">
					<strong>Success!</strong> ${success}
				</div>
			</c:if>
			<c:if test="${not empty error }">
				<div class="alert error text-center" role="alert">
					<strong>Success!</strong> ${error}
				</div>
			</c:if>
			<!-- Footer -->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	<!-- Argon Scripts & Bootstrap tooltips -->
	<jsp:include page="alljs.jsp"></jsp:include>
</body>
</html>