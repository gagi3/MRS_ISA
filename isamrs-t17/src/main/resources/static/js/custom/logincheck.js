$(document).ready(function() {
    var usrnm = localStorage.getItem('loggedIn');
    $.ajax({
      url: "http://localhost:8080/api/user/login/check/"+usrnm,
      type: "GET",
      headers: {"Authorization": localStorage.jwt},
      success: function(data) {
        if (usrnm != null) {
          sidebar();
          topbar();
        }
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

function topbar() {
  $('#loginn').remove();
  $('#signup').remove();
  $('#buttons').append('<li id="signup">\n'
      + '                        <a href="profile.html" id="log-but" name="Login2">\n'
      + '                          <div class="container-topbar100-form-btn">\n'
      + '                            <div class="wrap-topbar100-form-btn">\n'
      + '                              <div class="topbar100-form-bgbtn"></div>\n'
      + '                              <button class="topbar100-form-btn" type="submit" id="logout-link">\n'
      + '                               ' + localStorage.getItem('loggedIn') + '\n'
      + '                              </button>\n'
      + '                            </div>\n'
      + '                          </div>\n'
      + '                        </a>\n'
      + '                      </li>\n'
      + '<li id="loginn">\n'
      + '                        <a href="login.html" id="log-but" name="Login2">\n'
      + '                          <div class="container-topbar100-form-btn">\n'
      + '                            <div class="wrap-topbar100-form-btn">\n'
      + '                              <div class="topbar100-form-bgbtn"></div>\n'
      + '                              <button class="topbar100-form-btn" type="submit" id="logout-link">\n'
      + '                                LOGOUT\n'
      + '                              </button>\n'
      + '                            </div>\n'
      + '                          </div>\n'
      + '                        </a>\n'
      + '                      </li>\n');
  $("#loginn").click(function(e)
      {
        e.preventDefault();
        //remove cookie
        $.removeCookie("role", { path: '/' });
        $.removeCookie("jwt", { path: '/' });
        localStorage.removeItem("loggedIn");

        //redirect
        window.location.href = "index.html"
      }
  );
}

function sidebar() {
  $()
}