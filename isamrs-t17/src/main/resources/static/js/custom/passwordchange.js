$(document).ready(function() {
	
	var usrnm = localStorage.getItem('loggedIn');
	
  $("#registerForm").submit(function(e) {
	  debugger;
    e.preventDefault();
    var username = $("#oldpassword").val();
    var password = $("#password").val();
    var password2 = $("#password2").val();


	var isnum = /^\d+$/.test(phoneNumber);
	
    if (password.length == 0  || password2.length == 0 ) {
      alert("All fields must be filled.");
    }  else if(password.length != password2.length) {
    	alert("Passwords must match");
    } else {
      var updateDTO = {
        "password": password,
    };
 

      $.ajax({
        url: "http://localhost:8080/api/user/passwordChange/"+usrnm,
        type: "POST",
        datatype: "json",
        data: JSON.stringify(updateDTO),
        contentType: "application/json",
        success: function (data) {
        	window.location.href = "http://localhost:8080/profile.html";
        },
        error: function (xhr, ajaxOptions, thrownError) {
          resp = $.parseJSON(xhr.responseText);
          alert(resp.error);
        }
      });
    }
  });
  
  
})