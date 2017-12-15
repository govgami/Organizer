function empty(){};
function createRow(){}
function deleteRows(){}

function changeButtonText(){ document.getElementById("buttonStupid").innerHtml='???';
document.getElementById("buttonStupid").firstElementChild.text='Stupid';};
	
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
		},
		error: function(e){
			alert("ERROR: ", e);
		}
	});
} 
	

