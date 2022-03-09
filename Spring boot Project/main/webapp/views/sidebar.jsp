<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sidebar</title>
</head>
<body>
	<nav
		class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white"
		id="sidenav-main">
		<div class="scrollbar-inner">
			<!-- Brand -->
			<div class="sidenav-header  align-items-center">
				<a class="navbar-brand" href="javascript:void(0)">
					<img src="/assets/img/brand/logo.png" class="navbar-brand-img" alt="...">
				</a>
			</div>
			<div class="navbar-inner">
				<!-- Collapse -->
				<div class="collapse navbar-collapse" id="sidenav-collapse-main">
					<!-- Nav items -->
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link active" href="showdata"> 
								<i class="ni ni-tv-2 text-primary"></i> 
								<span class="nav-link-text">Dashboard</span>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="add" data-toggle="modal" data-target=".bd-example-modal-xl">
								<i class="ni ni-single-02 text-yellow"></i> 
								<span class="nav-link-text">Add Customer</span>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="showdata">
								<i class="ni ni-bullet-list-67 text-default"></i>
								<span class="nav-link-text">Show Customer</span>
							</a>
						</li>
					</ul>
					<!-- Divider -->
					<hr class="my-3">
				</div>
			</div>
		</div>
	</nav>
</body>
</html>