
$.ajax({
  url: "/allUsagesModel",
  type:"POST",
  dataType: "json",
  success: function( result ) {
	  $.each(data, function(ind, obj){
			
			$("#tableClient").row.add([
				obj.issueID,
				"<input type='checkbox' value='"+obj.issueID+"' id=''>",
				obj.issueName,
				obj.issueMemo,
				obj.issuePriority
			]).draw();
	  })
  }
		});

