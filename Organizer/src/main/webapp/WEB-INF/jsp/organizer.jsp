<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!-- ENCODING HTML 5, necessary for bootstrap -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example Organizer</title>
 
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>
<script type="text/javascript" src="resources/springBootSGrid.js"></script>
 	<link rel="stylesheet" type="text/css" href="resources/static/css/dark.css" />
 
 
 
</head>
<body>
 
 
  <nav class="navbar navbar-default navbar-fixed-top" id="fixedTop">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Organizer</a>
				<button type="button" class="navbar-toggle btn collapsed" id="nav_collapse" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><span class="glyphicon glyphicon-menu-left"></span></button>
				
			</div>
			
			<div id="navbar" class="collapse">
			
		<form class="form-horizontal">	
		<div class="form-group collapse">
			<label class="control-label col-sm-1" for="id">Id:</label>
			<div class="col-sm-10">
				<input type="number" class="form-control-valid" id="id" placeholder="Id" required>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control-valid" id="name" placeholder="Name" required>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="memo">Memo:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control-valid" id="memo" placeholder="Memo">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="priority">Priority:</label>
			<div class="col-sm-10">
				<input type="number" class="form-control-valid" id="priority" placeholder="Priority" required>
			</div>
		</div>
			<button type="button" id="buttonInsert" class="btn btn-success">
				<span class="glyphicon glyphicon-plus-sign"></span> New
			</button>
			<button type="button" id="buttonUpdate" class="btn btn-primary">
				<span class="glyphicon glyphicon-plus-sign"></span> Update
			</button>
		</form>
			</div>
		</div>
	</nav>
<div class="container main-content">
		<h2>Considered issues</h2>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<button type="button" id="buttonSearch" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Refresh
			</button>
			<button type="button" id="buttonDelete" class="btn btn-warning">
				<span class="glyphicon glyphicon-minus-sign"></span> Delete
			</button>
		</div>
		<div>
			<table id="issueClient" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th class="col-sm-1" data-field="tid">Id</th>
						<th class="col-sm-1" data-field="tcheckDelete"></th>
						<th class="col-sm-3" data-field="tname">Name</th>
						<th class="col-sm-3" data-field="tmemo">Memo</th>
						<th class="col-sm-1" data-field="tpriority">Priority</th>
						<th class="col-sm-1" data-field="edition"></th>
						<th class="col-sm-1" data-field="deletion"></th>
					</tr>
				</thead>
			</table>
		</div>
	</form>
</div>
 
 
</body>
</html>