$(document).ready(function() {
    console.log(localStorage.getItem('loggedIn'));
    var usrnm = localStorage.getItem('loggedIn');
    $.ajax({
      url: "http://localhost:8080/api/user/login/check/"+usrnm,
      type: "GET",
      headers: {"Authorization": localStorage.jwt},
      success: function(data) {
        console.log('success');
      }
    })
    
    $.ajax({
	    url: "http://localhost:8080/api/profile/show/"+usrnm,
	    type: "GET",
	    success: function(data) {
	      $.each(data, function(i) {
	        var user = data[i];
	        console.log(user);
	      })
	    }
    })
 });

/*$(document).ready(function () {

	
	var usrnm = localStorage.getItem('loggedIn'); 
	
	$.ajax({
		type: "GET",
		url : "http://localhost:8080/api/profil/show" + usrnm,
		success(function(data) {
			
				
		})
	})
})*/