function empty(){};
function changeButtonText(){ document.title=(document.getElementById("buttonStupid").textContent);
document.getElementById("buttonStupid").textContent="Stupid";};

$(document).ready(function(){
	
	// Activated the table
	var tableClient = $('#issueClient').DataTable({
		"autoWidth": false,
		"columnDefs": [
			{"targets": [ 0 ],
		     "visible": false,
		     "searchable": false,
		     }
		],
		"ajax": {
			"url": "/allUsagesModel",
			"type": "POST",
			"success" :  function(data){
				$.each(data, function(ind, obj){
					
					tableClient.row.add([
						obj.issueID,
						"<input type='checkbox' value='"+obj.issueID+"' id=''>",
						obj.issueName,
						obj.issueMemo,
						obj.issuePriority,
						"<button class='btn-v-delete'  type='button'><span class='glyphicon glyphicon-minus-sign'>Delete</button>"
						     
					]).draw();
				});
			}
		},
	});


    // Handle click on "Delete" button
    $('#issueClient thead').on('click', '.btn-delete', function (e) {
       var data = table.row( $(this).parents('tr') ).data();
       var ided=$.map(data.issueID);
       $(this).callAjax("removeModel/", ided);
    } );
    
	
	$(window).on("load", empty());
	
	$("#buttonSearch").click(function(){
		tableClient.clear().draw();
		tableClient.ajax.reload();
		
	});
	
	$("#buttonInsert").click(function(){
		$(this).callAjax("planModel/", "");
		
		$(".form-control").val("");
		
	});
	
	$("#buttonDelete").click(function(){
		
		var valuesChecked = $("#issueClient input[type='checkbox']:checkbox:checked").map(
			     					function () {
			     						return this.value;
			     					}).get().join(",");
		
		$(this).callAjax("removeModel/", valuesChecked);
		
	});
	
	$.fn.callAjax = function( method, checkeds ){
		$.ajax({
			type: "POST",
			url: "/" + method,
			dataType: "json",
			timeout : 100000,
			data: { issueName: $("#name").val(), issueMemo: $("#memo").val(), issuePriority: $("#priority").val(), checked: checkeds },
			
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
