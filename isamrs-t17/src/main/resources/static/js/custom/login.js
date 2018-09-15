/**
 * 
 */
$("#loginForm").submit(function (e) {
      e.preventDefault();
      debugger;
      var username = $("#username").val();
      var password = $("#password").val();
      console.log(username);
      console.log(password);
      var loginDTO = {"username": username, "password": password};

      $.ajax({
        url: "http://localhost:8080/api/user/login",
        type: "POST",
        data: JSON.stringify(loginDTO),
        contentType: "application/json",
        success: function(data) {
          $.cookie('jwt', String(data.jwt));
          $.cookie('role', String('USER'));
          localStorage.jwt = data.jwt;
          localStorage.role = 'USER';
          localStorage.setItem('loggedIn', username);
          window.location.href = "http://localhost:8080/index.html";
        },
        error: function(xhr, ajaxOptions, thrownError) {
          resp = $.parseJSON(xhr.responseText);
          alert(resp.error);
        }
      });
    });