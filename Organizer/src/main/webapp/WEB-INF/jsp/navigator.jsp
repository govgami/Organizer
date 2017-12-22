<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>
<script type="text/javascript" src="resources/static/js/navigator.js"></script>
<script type="text/javascript" src="resources/springBootSGrid.js"></script>
<body>

	<nav class="navbar navbar-inverse" id=fixedTop>
		<div class="container-fluid" id="topNavi">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Welcome</a>
				<button type="button" class="navbar-toggle btn collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><span class="glyphicon glyphicon-menu-left"></span></button>
				<ul class="nav navbar-nav lined">
					<li class="nav-item inlined"><a class="nav-link" href="#">Item 1</a></li>
					<li class="nav-item inlined"><a class="nav-link" href="#">Item 2</a></li>
					<li class="nav-item inlined"><a class="nav-link" href="#">Item 3</a></li>
				</ul>
			</div>
			<div id="navbar" class="collapse">
				<ul class="nav navbar-nav">
					<li class="nav-item nav-line"><a class="nav-link" href="#">Home</a></li>
					<li class="nav-item nav-line"><a class="nav-link" href="/organizer">Issues</a></li>
					<li class="nav-item nav-line"><a class="nav-link" href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>