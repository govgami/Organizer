/**
 * 
 */

$.get("navigator.jsp", function(data){
    $("#navigator").replaceWith(data);
});
//$(function(){
//  $("#navigator").load("/navigator.jsp");
//});