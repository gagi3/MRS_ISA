/**
 * 
 */
var emailRegex = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;

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

    if (username.length == 0 || password.length == 0 || firstName.length == 0  || phoneNumber.length == 0 || city.length == 0 || address.length == 0) {
      alert("All fields must be filled.");
    } else if (password != password2) {
      alert("Passwords don't match.");
    } else if(password.length < 8) {
    	alert("Password must contain at least 8 characters.");
    } /*else if(!emailRegex.test(String(email).toLowerCase())) {     Regularan izraz za proveru Email adrese
		alert("Neispravna email adresa!");
    }*/ else {
      var registerDTO = {
        "username": username,
        "password": password,
        "firstName": firstName,
        "lastName": lastName,
        "phoneNumber": phoneNumber,
        "address": address,
        "city": city
      };
 

      $.ajax({
        url: "http://localhost:8080/api/user/register",
        type: "POST",
        datatype: "json",
        data: JSON.stringify(registerDTO),
        contentType: "application/json",
        success: function (data) {
        	window.location.href = "http://localhost:8080/login.html";
        },
        error: function (xhr, ajaxOptions, thrownError) {
          resp = $.parseJSON(xhr.responseText);
          alert(resp.error);
        }
      });
    }
  });