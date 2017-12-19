function empty(){};
function changeButtonText(){ document.title=(document.getElementById("buttonStupid").textContent);
document.getElementById("buttonStupid").textContent="Stupid";};

var validForm=false;

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
    $('.btn-v-delete').on('click', function (e) {
       var data = $(this).closest("tr");//.parents('tr').text();
       console.log(data);
       var ided=$.map(data.issueID);
       console.log("attempted removal "+ided.toString());
       $(this).callAjax("removeModel/", ided);
    } );
    
	
	$(window).on("load", empty());
	
	$("#buttonSearch").click(function(){
		tableClient.clear().draw();
		tableClient.ajax.reload();
		
	});
	
	$("#buttonInsert").click(function(){
		
		$(this).checkCompletedForm();

		$(this).callAjaxCreationForm("planModel/", "");
		
		$(".form-control").val("");
		
	});
	
	$("#buttonDelete").click(function(){
		
		var valuesChecked = $("#issueClient input[type='checkbox']:checkbox:checked").map(
			     					function () {
			     						return this.value;
			     					}).get().join(",");
		console.log("attempted removal "+valuesChecked);
		$(this).callAjax("removeModel/", valuesChecked);
		
	});
	
	$.fn.checkCompletedForm = function(){
		var nameValid = $("#name").val()!="";
		console.log("nameValidity "+nameValid.toString());
		var priorityValid = $("#priority").val()!="";
		console.log("priorityValidity "+priorityValid.toString()+" v:"+$("#priority").val().toString());
		
		$(this).markFormField($("#name"), nameValid);
		$(this).markFormField($("#priority"), priorityValid);
		
		validForm=nameValid&&priorityValid;
	}
	
	$.fn.markFormField=function(element, validity){
		if(validity==false){
			$(element).className="form-control-wrong";
		}
		else{
			$(element).className="form-control-valid";
		}
	}
	
	$.fn.callAjax = function( method, checkeds ){
		$.ajax({
			type: "POST",
			url: "/" + method,
			contentType:"application/json; charset=utf-8",
			dataType: "json",
			timeout : 100000,
			data: JSON.stringify({checkeds}),
			
			success: function(data){
				tableClient.clear().draw();
				tableClient.ajax.reload();
			},
			error: function(e){
				alert("Not recognized gathering of checked items", e);
			}
		});
	} 
	
	$.fn.callAjaxCreationForm = function( method){
		$.ajax({
			type: "POST",
			url: "/" + method,
			contentType:"application/json",
			  dataType:"json",
			timeout : 100000,
			data: JSON.stringify( { issueName: $("#name").val(), issueMemo: $("#memo").val(), issuePriority: $("#priority").val()}),
			
			success: function(data){
				tableClient.clear().draw();
				tableClient.ajax.reload();
			},
			error: function(e){
				if(!validForm){
				alert("Incorrect issue parameters", e);
				}
			}
		});
	} 
	 
});
