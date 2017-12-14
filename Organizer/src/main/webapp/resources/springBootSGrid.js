$(document).ready(function(){
	
	// Activated the table
	var tableClient = $('#issueClient').DataTable({
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
					
					tableClient.row.add([
						obj.issueID,
						"<input type='checkbox' value='"+obj.issueID+"' id=''>",
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
		tableClient.clear().draw();
		tableClient.ajax.reload();
		
	});
	
	$("#buttonInsert").click(function(){
		$(this).callAjax("insertClient", "");
		
		$(".form-control").val("");
		
	});
	
	$("#buttonDelete").click(function(){
		
		var valuesChecked = $("#tableClient input[type='checkbox']:checkbox:checked").map(
			     					function () {
			     						return this.value;
			     					}).get().join(",");
		
		$(this).callAjax("deleteClient", valuesChecked);
		
	});
	
	$.fn.callAjax = function( method, checkeds ){
		$.ajax({
			type: "POST",
			url: "/BootstrapSpringProject/" + method,
			dataType: "json",
			timeout : 100000,
			data: { name: $("#name").val(), lastname: $("#lastname").val(), dateBirth: $("#dateBirth").val(), 
						register: $("#register").val(), checked: checkeds },
			
			success: function(data){
				tableClient.clear().draw();
				tableClient.ajax.reload();
			},
			error: function(e){
				alert("ERROR: ", e);
			}
		});
	} 
	 
});

$(document.getElementById("buttonStupid").onclick=function(){document.getElementById("buttonStupid").innerHTML='bing!'});