<%@page import="com.customercrudapplication.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Model Page</title>
</head>
<body>
	<div class="modal fade bd-example-modal-xl" tabindex="-1" role="dialog"
		aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-xl modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-center" id="exampleExtraLargeModalScrollableTitle">
						Customer Add/Update Form
					</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="form" method="POST" action="save">
						<!-- 2 column grid layout with text inputs for the first and last names -->
						<div class="row mb-4">
							<div class="col">
								<div class="form-outline">
									<input type="text" hidden="hidden" id="id" class="form-control" name="id" />
								</div>
								<div class="form-outline">
									<input type="text" id="${fields[0]}"
										class="form-control" name="${fields[0]}"
										onkeypress="return (event.charCode > 64 &&
										event.charCode < 91) || (event.charCode > 96 &&
										event.charCode < 123)"
										placeholder="Enter your ${fields[0]}" />
								</div>
							</div>
							<div class="col">
								<div class="form-outline">
									<input type="text" id="${fields[1]}"
										class="form-control"
										onkeypress="return (event.charCode > 64 &&
										event.charCode < 91) || (event.charCode > 96 &&
										event.charCode < 123)"
										placeholder="Enter your ${fields[1]}"
										name="${fields[1]}" />
								</div>
							</div>
						</div>
						<!-- Date of Birth & Mobile Number input -->
						<div class="row mb-4">
							<div class="col">
								
								<div class="form-outline">
									<input type="date" id="${fields[2]}" onkeydown="return false"
									 	onfocus="this.max=new Date().toISOString().split('T')[0]"
										class="form-control" name="${fields[2]}"/>
								</div>
							</div>
							<div class="col">
								<div class="form-outline">
									<input type="number" id="${fields[3]}"
										class="form-control" name="${fields[3]}"
										placeholder="Enter your ${fields[3]}" onkeyup="checkemobile();" />
										<span id="mobile_status" style="color: red;"></span>
								</div>
							</div>
						</div>
						<!-- Address1 Text input -->
						<div class="form-outline mb-4">
							<input type="text" id="${fields[4]}"
								class="form-control" name="${fields[4]}"
								placeholder="Enter your ${fields[4]}" />
						</div>
						<!--Address2 Text input -->
						<div class="form-outline mb-4">
							<input type="text" id="${fields[5]}"
								class="form-control" name="${fields[5]}"
								placeholder="Enter your ${fields[5]}" />
						</div>
						<!-- Age and Gender input -->
						<div class="row mb-4">
							<div class="col">
								<div class="form-outline">
									<input type="number" id="${fields[6]}"
										readonly="readonly" class="form-control"
										name="${fields[6]}"
										placeholder="Enter your ${fields[6]}" />
								</div>
							</div>
							<div class="col">
								<div class="form-outline">
									<select class="form-select form-control"
										aria-label="Default select example"
										id="${fields[7]}" name="${fields[7]}">
										<option value="0" selected="selected" disabled="disabled">Please select your gender...</option>
										<option value="1">Male</option>
										<option value="2">Female</option>
									</select>
								</div>
							</div>
						</div>
						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="text" class="form-control"
								id="${fields[8]}" name="${fields[8]}"
								placeholder="Enter your ${fields[8]}" onkeyup="checkemail();"/>
								 <span id="email_status" style="color: red;"></span>
						</div>
						<!-- Submit button -->
						<button type="submit" id="btn" class="btn btn-primary btn-block mb-4">
							Submit
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>