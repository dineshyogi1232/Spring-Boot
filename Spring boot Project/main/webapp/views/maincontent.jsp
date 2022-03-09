<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Main Content page</title>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.table .delBtn').on('click', function(event) {
				event.preventDefault();
				var href = $(this).attr('href');
				$('#modal-notification #delRef').attr('href', href);
				$('#modal-notification').modal();
			});
		});
	</script>
</head>
<body>
	<div class="row">
		<div class="col-xl-12">
			<jsp:include page="customermodel.jsp"></jsp:include>
			<div class="card">
				<div class="card-header border-0">
					<div class="row align-items-center">
						<div class="col">
							<h3 class="mb-0">Customer Data</h3>
						</div>
						<div class="col text-right">
							<button type="submit" class="btn btn-primary" id="add"
								style="color: white" data-toggle="modal"
								data-target=".bd-example-modal-xl">
								<i class="fas fa-plus"></i>
							</button>
						</div>
					</div>
				</div>
				<div class="table-responsive">
					<form id="myform">
						<!-- Show table -->
						<table class="table align-items-center table-flush" id="tbl">
							<thead class="thead-light">
								<tr>
									<c:forEach items="${tableHeading}" var="field">
										<th scope="col">
											<c:out value="${field}"></c:out>
										</th>
									</c:forEach>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty listOfCustomers}">
									<p>${nodata}</p>
								</c:if>
								<c:forEach items="${listOfCustomers}" var="user">
									<tr>
										<td>${user.id}</td>
										<td>${user.firstName}&nbsp;${user.lastName}</td>
										<td>${user.dateOfBirth}</td>
										<td>${user.mobile}</td>
										<td>${user.address1}&nbsp;${user.address2}</td>
										<td><c:choose>
												<c:when test="${user.gender=='1'}">
													Male
												</c:when>
												<c:otherwise>
													Female 
												</c:otherwise>
											</c:choose>
										<td>
											<a id="update" href=""
											onclick="updateCustomer('${user.id}')" data-toggle="modal"
											data-target=".bd-example-modal-xl">
												<i class="fas fa-edit"></i>
											</a> 
										&ensp;<a href="/customer/delete/${user.id}" class="delBtn" id="delete">
													<i class="fa fa-trash"></i>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>

					<!-- Delete Model -->
					<div class="row">
						<div class="col-md-4">
							<div class="modal fade" id="modal-notification" tabindex="-1"
								role="dialog" aria-labelledby="modal-notification"
								aria-hidden="true">
								<div class="modal-dialog modal-danger modal-dialog-centered modal-" role="document">
									<div class="modal-content bg-gradient-danger">
										<div class="modal-header">
											<h6 class="modal-title" id="modal-title-notification">
												Your attention is required
											</h6>
											<button type="button" class="close" data-dismiss="modal" aria-label="Close">
												<span aria-hidden="true">×</span>
											</button>
										</div>
										<div class="modal-body">
											<div class="py-3 text-center">
												<i class="ni ni-bell-55 ni-3x"></i>
												<h4 class="heading mt-4">
													You should read this!
												</h4>
												<p>If you can delete the data after that you can not get data.</p>
											</div>
										</div>
										<div class="modal-footer">
											<a href="" id="delRef">
												<button type="submit" class="btn btn-white">Delete</button>
											</a>
											<button type="button" class="btn btn-link text-white ml-auto" data-dismiss="modal">
												Close
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>