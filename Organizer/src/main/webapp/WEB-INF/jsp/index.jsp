<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!-- ENCODING HTML 5, necessary for bootstrap -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example Organizer</title>
 
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>
<script src="resources/springBootS.js"></script>
 
 
 
 
</head>
<body>
<script src="resources/springBootS.js"></script>
 
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
			<button type="button" id="buttonSearch" class="btn btn-info" onclick="bingTitle()">
				Search <span class="glyphicon glyphicon-search"></span>
			</button>
			<button type="button" id="buttonInsert" class="btn btn-success">
				<span class="glyphicon glyphicon-plus-sign"></span> Insert
			</button>
			<button type="button" id="buttonDelete" class="btn btn-warning">
				<span class="glyphicon glyphicon-minus-sign"></span> Delete
			</button>
			<button type="button" id="buttonStupid" class="btn btn-warning" onclick="changeButtonText()">
				Check <span class="glyphicon glyphicon-minus-sign"></span>
			</button>
		</div>
	</form>
</div>
 
 
</body>
</html>