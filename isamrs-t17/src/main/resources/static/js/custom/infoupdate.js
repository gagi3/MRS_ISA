$(document).ready(function() {
	
	var usrnm = localStorage.getItem('loggedIn');
	
  $("#registerForm").submit(function(e) {
	  debugger;
    e.preventDefault();
    var username = $("#usernameReg").val();
    var password = $("#passwordReg").val();
    var password2 = $("#passwordRep").val();
    var firstName = $("#firstName").val();
    var lastName = $("#lastName").val();
    var phoneNumber = $('#phoneNumber').val();
    var city = $('#city').val();
	var address = $('#address').val();  

	var isnum = /^\d+$/.test(phoneNumber);
	
    if (firstName.length == 0  || phoneNumber.length == 0 || city.length == 0 || address.length == 0) {
      alert("All fields must be filled.");
    }  else if(!isnum) {
    	alert("Phone Number can contain only numbers");
    } else {
      var updateDTO = {
        "firstName": firstName,
        "lastName": lastName,
        "phoneNumber": phoneNumber,
        "address": address,
        "city": city
      };
 

      $.ajax({
        url: "http://localhost:8080/api/user/infoupdate/"+usrnm,
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