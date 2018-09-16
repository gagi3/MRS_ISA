

$('.card-wrapper').ready(function() {
  var username = localStorage.getItem('loggedIn');
  username = "admin";
  var showID = "1";
  debugger;
  $.ajax({
    url: "http://localhost:8080/api/admin/login/check/" + username,
    type: "GET",
    success:function() {
      $.ajax({
        url: "http://localhost:8080/api/show/view/"+username+"/"+showID,
        type: "GET",
        // headers: {"Authorization": localStorage.jwt},
        success: function(data) {
          console.log("FU");
          var movie = data;
          $('.card-wrapper').append('<div class="container-card100">\n'
              + '                  <div class="wrap-card100">\n'
              + '                    <span class="card100-form-title cardTitle" id="cardTitle">\n'
              + '                      '+ movie.name + '\n'
              + '                    </span>\n'
              + '                    <div class="card-data">\n'
              + '                      <span class="card100-form-text">\n'
              + '                        '+ 'Length: ' + movie.length + ' minutes' + '\n'
              + '                      </span>\n'
              + '                      <span class="card100-form-text">\n'
              + '                        '+ 'Genre: ' + movie.genre + '\n'
              + '                      </span>\n'
              + '                      <span class="card100-form-text">\n'
              + '                        '+ 'Director: ' + movie.director + '\n'
              + '                      </span>\n'
              + '                      <span class="card100-form-text">\n'
              + '                        '+ 'Actors: ' + '\n' + movie.actors[0] + ', ' + movie.actors[1] + ', ' + movie.actors[2] + '\n'
              + '                      </span>\n'
              + '                      <span class="card100-form-text">\n'
              + '                        '+ 'Description: ' + movie.desc + '\n'
              + '                      </span>\n'
              + '                    </div>\n'
              + '\n'
              + '                    <div class="container-card100-form-btn repertoire-cont" id="repertoire-cont">\n'
              + '                      <div class="wrap-content100-form-btn">\n'
              + '                        <div class="topbar100-form-bgbtn"></div>\n'
              + '                        <button class="card100-form-btn repertoire-button" type="submit" id="screening-button">\n'
              + '                          MAKE A SCREENING\n'
              + '                        </button>\n'
              + '                      </div>\n'
              + '                    </div>\n'
              + '                    <div class="container-card100-form-btn repertoire-cont" id="repertoire-cont">\n'
              + '                      <div class="wrap-content100-form-btn">\n'
              + '                        <div class="topbar100-form-bgbtn"></div>\n'
              + '                        <button class="card100-form-btn repertoire-button" type="submit" id="edit-button">\n'
              + '                          EDIT\n'
              + '                        </button>\n'
              + '                      </div>\n'
              + '                    </div>\n'
              + '                    <div class="container-card100-form-btn repertoire-cont" id="repertoire-cont">\n'
              + '                      <div class="wrap-content100-form-btn">\n'
              + '                        <div class="topbar100-form-bgbtn"></div>\n'
              + '                        <button class="card100-form-btn repertoire-button" type="submit" id="delete-button">\n'
              + '                          DELETE\n'
              + '                        </button>\n'
              + '                      </div>\n'
              + '                    </div>\n'
              + '                    <div class="container-card100-form-btn repertoire-cont" id="repertoire-cont">\n'
              + '                      <div class="wrap-content100-form-btn">\n'
              + '                        <div class="topbar100-form-bgbtn"></div>\n'
              + '                        <button class="card100-form-btn repertoire-button" type="submit" id="repertoire-button">\n'
              + '                          \n'
              + '                        </button>\n'
              + '                      </div>\n'
              + '                    </div>\n'
              + '                </div>');
        }
      })
    }
  })

});

$("#delete-button").submit(function () {
  var username = localStorage.getItem('loggedIn');
  username = "admin";
  var showID = "1";
  $.ajax({
    url: "http://localhost:8080/api/show/delete/" + username + "/" + showID,
    type : "DELETE",
    success:function(){
        console.log("deleted");
    }
  })
});