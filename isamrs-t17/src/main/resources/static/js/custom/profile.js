$(document).ready(function() {
    var usrnm = localStorage.getItem('loggedIn');
    
    $.ajax({
      url: "http://localhost:8080/api/user/login/check/"+usrnm,
      type: "GET",
      headers: {"Authorization": localStorage.jwt},
      success: function(data) {
    	  
        console.log(usrnm, 'success');
      }
    });
    
    $.ajax({
	    url: "http://localhost:8080/api/user/show/"+usrnm,
	    type: "GET",
	    success: function(data) {
	    	console.log('This part is not executed');
	    }
    })
    
 });
