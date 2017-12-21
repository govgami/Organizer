function empty(){};

var validForm=false;

//// Handle click on "Delete" button
//function clickDelete(caller) {
//	console.log(caller);//-->>finally catched right object!
//	
//	console.log(caller.value);
//	var row = $(this).closest("tr");
//	var tds = row.find("input:checkbox");//("td:nth-child(2)");
//	//console.table([$("#issueClient").row(this).data()], ["Id"]);
//	//var data = $("#issueClient").row(this).data().Id;
//	//var data = caller.value;
//	console.log(tds.value);
////	$.each($tds, function() {                // Visits every single <td> element
////	    console.log($(this).text());
////   var ided=$.map(caller.value);
////   console.log(caller.data.value);
////   console.log("attempted innate table row removal "+ided.toString());
////   $(this).callAjax("removeModel/", ided);
//};

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
					//!!!! --- script uses direct addressing so alterations to table column require corrections in the script!!
					tableClient.row.add([
						obj.issueID,
						"<input type='checkbox' value='"+obj.issueID+"' id=''>",
						obj.issueName,
						obj.issueMemo,
						obj.issuePriority,
						"<button class='btn-v-update btn btn-mini btn-info'  type='button' onclick='$(this).clickUpdate($(this));' value='"+obj.issueID+"'><span class='glyphicon glyphicon-search'></span>Update</button>",
						"<button class='btn-v-delete btn btn-mini btn-warning'  type='button' onclick='$(this).clickDelete($(this));'><span class='glyphicon glyphicon-minus-sign'></span>Delete</button>"
					]).draw();
				});
			}
		},
	});
    

	
	$(window).on("load", empty());
	
	$("#buttonSearch").click(function(){
		tableClient.clear().draw();
		tableClient.ajax.reload();
		
	});
	
	$("#buttonInsert").click(function(){
		
		$(this).checkCompletedForm();

		$(this).callAjaxCreationForm("plan/", "");
		
		$(".form-control").val("");
		
	});
	
	$("#buttonUpdate").click(function(){
		
		$(this).checkCompletedForm();
console.log("Called edit: "+$("#id").text());
		$(this).callAjaxCreationForm("edit/", $("#id").text());
		$("#nav_collapse").click();
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
	
	$.fn.clickDelete=function(caller) {
		
		var row = $(this).closest("tr");
		var tds = row.find("input[type='checkbox']:checkbox");//("input:checkbox");//("td:nth-child(2)");

		console.log("attempted removal "+tds.val());
		$(this).callAjax("removeModel/", tds.val());
	};
	$.fn.clickUpdate=function(caller) {

		var row = $(this).closest("tr");
		var tds = row.find("input[type='checkbox']:checkbox");
		console.log("attempted access "+tds.val());
		
		$("#id").text(tds.val());

		$("#nav_collapse").click();
		
		tableClient.row(this).data();
		$("#name").val(row.find("td:nth-child(2)").text());//get wanted cell?
		$("#memo").val(row.find("td:nth-child(3)").text());
		$("#priority").val(row.find("td:nth-child(4)").text());
		var ttds=row.find("td:nth-child(0)");
		console.log(ttds);
		console.log(ttds.text());
		console.log(ttds.val());

	};
	
	$.fn.checkCompletedForm = function(){
		var nameValid = $("#name").val()!="";
		var priorityValid = $("#priority").val()!="";
		
		$(this).markFormField($("#name"), nameValid);
		$(this).markFormField($("#priority"), priorityValid);
		
		validForm=nameValid&&priorityValid;
	}
	
	$.fn.markFormField=function(element, validity){
		if(validity==false){
			$(element).addClass("wrong");
		}
		else{
			$(element).removeClass("wrong");
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
	
	$.fn.callAjaxCreationForm = function( method, id){
		console.log("used id: "+id);
		$.ajax({
			type: "POST",
			url: "/" + method,
			contentType:"application/json",
			  dataType:"json",
			timeout : 100000,
			data: JSON.stringify( { issueID: id, issueName: $("#name").val(), issueMemo: $("#memo").val(), issuePriority: $("#priority").val()}),
			
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
