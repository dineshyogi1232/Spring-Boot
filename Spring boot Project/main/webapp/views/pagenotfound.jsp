<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Sorry,Something went to wrong</title>
	<!-- Google font -->
	<link
		href="https://fonts.googleapis.com/css?family=Montserrat:200,400,700"
		rel="stylesheet">
	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet"
		href="/pagenotfound/css/style.css" />
</head>
<body>
	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1>Oops!</h1>
				<h2>
					<c:if test="${not empty message }">
						<div class="alert success" role="alert">
							<p >${message}</p>	
						</div>
					</c:if>
				</h2>
			</div>
			<a href="showdata">Go TO Homepage</a>
		</div>
	</div>
</body>
</html>