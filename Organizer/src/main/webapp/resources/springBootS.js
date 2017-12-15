function empty(){};
function createRow(){}
function deleteRows(){}

function changeButtonText(){ document.title=(document.getElementById("buttonStupid").textContent);
document.getElementById("buttonStupid").textContent="Stupid";};
	
function bingTitle(){ document.title="bing"};

function addIssue(){
	
	call("planModel", "");
	
	$(".form-control").val("");
	
};


function call( method, checkeds ){
	$.ajax({
		type: "POST",
		url: "/" + method,
		dataType: "json",
		timeout : 100000,
		data: { issueName: $("#name").val(), issueMemo: $("#memo").val(), issuePriority: $("#priority").val(), checked: checkeds },
		
		success: function(data){
			document.getElementById("tableClient").clear().draw();
			document.getElementById("tableClient").ajax.reload();
			alarm("Called ajax");
		},
		error: function(e){
			alert("ERROR: ", e);
		}
	});
} 
	

