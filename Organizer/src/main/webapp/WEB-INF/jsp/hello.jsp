<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>
<script type="text/javascript" src="resources/springBootSGrid.js"></script>
	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->

	<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<link rel="stylesheet" type="text/css" href="resources/static/css/dark.css" />

</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" id=fixedTop>
		<div class="container-fluid" id="topNavi">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Welcome</a>
				<button type="button" class="navbar-toggle btn collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><span class="glyphicon glyphicon-menu-left"></span></button>
				<ul class="nav navbar-nav navbar-center lined">
					<li class="nav-item lined"><a class="nav-link lined" href="#">Item 1</a></li>
					<li class="nav-item lined"><a class="nav-link lined" href="#">Item 2</a></li>
					<li class="nav-item lined"><a class="nav-link lined" href="#">Item 3</a></li>
				</ul>
			</div>
			<div id="navbar" class="collapse">
				<ul class="nav navbar-nav navbar-left">
					<li class="nav-item nav-line active"><a class="nav-line" href="#">Home</a></li>
					<li class="nav-item nav-line"><a class="nav-line" href="/organizer">Issues</a></li>
					<li class="nav-item nav-line"><a class="nav-line" href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container main-content">

		<div class="starter-template">
			<h1>Welcome</h1>
			<h2>${message}</h2>
			Where you'd like to go?
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			''<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			'<br>
			''<br>
			'<br>

			
		</div>

	</div>

</body>

</html>