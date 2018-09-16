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

    if(usrnm != null){
    	var a = document.getElementById("site-name");
    	var a2 = document.getElementById("logo-but");
    	a.setAttribute("href", "http://localhost:8080/index2.html");
    	a2.setAttribute("href", "http://localhost:8080/index2.html");
    } else {
    	var a = document.getElementById("site-name");
    	var a2 = document.getElementById("logo-but");
    	a.setAttribute("href", "http://localhost:8080/index.html");
    	a2.setAttribute("href", "http://localhost:8080/index.html");
    }
    
    
});