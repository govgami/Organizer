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
 
 
<div class="container">
	<h2>Considered issues</h2>
 
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" placeholder="Name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="memo">Memo:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="memo" placeholder="Memo">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="priority">Priority:</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="priority" placeholder="Priority">
			</div>
		</div>
		<div class="form-group">
			<button type="button" id="buttonSearch" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Search
			</button>
			<button type="button" id="buttonInsert" class="btn btn-success">
				<span class="glyphicon glyphicon-plus-sign"></span> Insert
			</button>
			<button type="button" id="buttonDelete" class="btn btn-warning">
				<span class="glyphicon glyphicon-minus-sign"></span> Delete
			</button>
			<button type="button" id="buttonStupid" class="btn btn-warning" onclick="changeButtonText()">
				<span class="glyphicon glyphicon-minus-sign"></span> Check
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
						<th class="col-sm-2" data-field="tpriority">Priority</th>
					</tr>
				</thead>
			</table>
		</div>
	</form>
</div>
 
 
</body>
</html>