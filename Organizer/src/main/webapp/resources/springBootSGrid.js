$(document).ready(function(){
	
	// Activated the table
	var issueClient = $(document.getElementById('issueClient')).DataTable({
		"autoWidth": false,
		"columnDefs": [
			{"targets": [ 0 ],
		     "visible": true,
		     "searchable": false}
		],
		"ajax": {
			"url": "/allUsagesModel",
			"type": "POST",
			"success" :  function(data){
				$.each(data, function(ind, obj){
					
					issueClient.row.add([
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
	
	$(document.getElementById("buttonSearch").onclick=function(){
		issueClient.clear().draw();
		issueClient.ajax.reload();
		
	});
	
	$(document.getElementById("buttonInsert").onclick=function(){
		$(this).callAjax("planModel", "");
		
		$(".form-control").val("");
		
	});
	
	$(document.getElementById("buttonDelete").onclick=function(){
		
		var valuesChecked = $("#issueClient input[type='checkbox']:checkbox:checked").map(
			     					function () {
			     						return this.value;
			     					}).get().join(",");
		
		$(this).callAjax("removeModel", valuesChecked);
		
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

$(document.getElementById("buttonStupid").onclick=function(){document.getElementById("buttonStupid").innerHTML='bing!'});