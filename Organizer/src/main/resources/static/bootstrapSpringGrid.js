$(document).ready(function(){
	
	// Activated the table
	var issueClient = $('#issueClient').DataTable({
		"autoWidth": false,
		"columnDefs": [
			{"targets": [ 0 ],
		     "visible": false,
		     "searchable": false}
		],
		"ajax": {
			"url": "/allUsages",
			"type": "POST",
			"success" :  function(data){
				$.each(data, function(ind, obj){
					
					issueClient.row.add([
						obj.issueId,
						"<input type='checkbox' value='"+obj.issueId+"' id=''>",
						obj.issueName,
						obj.issueMemo,
						obj.issuePriority
					]).draw();
				});
			}
		},
	});
    
	
	$(window).load(function() {
		
	});
	
	$("#buttonSearch").click(function(){
		issueClient.clear().draw();
		issueClient.ajax.reload();
		
	});
	
	$("#buttonInsert").click(function(){
		$(this).callAjax("plan", "");
		
		$(".form-control").val("");
		
	});
	
	$("#buttonDelete").click(function(){
		
		var valuesChecked = $("#issueClient input[type='checkbox']:checkbox:checked").map(
			     					function () {
			     						return this.value;
			     					}).get().join(",");
		
		$(this).callAjax("remove", valuesChecked);
		
	});
	
	$.fn.callAjax = function( method, checkeds ){
		$.ajax({
			type: "POST",
			url: "/" + method,
			dataType: "json",
			timeout : 100000,
			data: { name: $("#name").val(), memo: $("#memo").val(),
						priority: $("#priority").val(), checked: checkeds },
			
			success: function(data){
				issueClient.clear().draw();
				issueClient.ajax.reload();
			},
			error: function(e){
				alert("ERROR: ", e);
			}
		});
	} 
	 
});