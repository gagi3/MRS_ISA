

$('.card-wrapper').ready(function() {
  var username = localStorage.getItem('loggedIn');
  // username = "admin";
  var showID = "2";
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
          localStorage.setItem('showID', movie.id);
          var sid = movie.id;
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
              + '                        <button class="card100-form-btn repertoire-button" type="submit" id="screening-button" onclick="screening()">\n'
              + '                          MAKE A SCREENING\n'
              + '                        </button>\n'
              + '                      </div>\n'
              + '                    </div>\n'
              + '                    <div class="container-card100-form-btn repertoire-cont" id="edit-button" onclick="edit()">\n'
              + '                      <div class="wrap-content100-form-btn">\n'
              + '                        <div class="topbar100-form-bgbtn"></div>\n'
              + '                        <button class="card100-form-btn repertoire-button" type="submit">\n'
              + '                          EDIT\n'
              + '                        </button>\n'
              + '                      </div>\n'
              + '                    </div>\n'
              + '                    <div class="container-card100-form-btn repertoire-cont" id="delete-button" onclick="del()">\n'
              + '                      <div class="wrap-content100-form-btn">\n'
              + '                        <div class="topbar100-form-bgbtn"></div>\n'
              + '                        <button class="card100-form-btn repertoire-button" type="submit">\n'
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

function edit() {
  var username = localStorage.getItem('loggedIn');
  var showID = localStorage.getItem('showID');
  console.log("Editing.");
  $.ajax({
    url: "http://localhost:8080/api/admin/login/check/" + username,
    type : "GET",
    success: function () {
      $(".container-card100").remove();
      $(".card-wrapper").append('<form id="editMovieForm" class="add100-form validate-form" action="#">\n'
          + '<div class="wrap-input100">\n'
          + '                    <input id="movieName" class="input100" type="text" name="movieName" required title="Movie name">\n'
          + '                    <span class="focus-input100" data-placeholder="Movie name"></span>\n'
          + '                  </div>\n'
          + '\n'
          + '                  <div class="wrap-input100">\n'
          + '                    <input id="actor1" class="input100" type="text" name="actor" required title="Actor (1)">\n'
          + '                    <span class="focus-input100" data-placeholder="Actor (1)"></span>\n'
          + '                  </div>\n'
          + '\n'
          + '                  <div class="wrap-input100">\n'
          + '                    <input id="actor2" class="input100" type="text" name="actor" required title="Actor (2)">\n'
          + '                    <span class="focus-input100" data-placeholder="Actor (2)"></span>\n'
          + '                  </div>\n'
          + '\n'
          + '                  <div class="wrap-input100">\n'
          + '                    <input id="actor3" class="input100" type="text" name="actor" required title="Actor (3)">\n'
          + '                    <span class="focus-input100" data-placeholder="Actor (3)"></span>\n'
          + '                  </div>\n'
          + '\n'
          + '                  <div class="wrap-input100">\n'
          + '                    <input id="genre" class="input100" type="text" name="genre" required title="Genre">\n'
          + '                    <span class="focus-input100" data-placeholder="Genre"></span>\n'
          + '                  </div>\n'
          + '\n'
          + '                  <div class="wrap-input100">\n'
          + '                    <input id="director" class="input100" type="text" name="director" required title="Director">\n'
          + '                    <span class="focus-input100" data-placeholder="Director"></span>\n'
          + '                  </div>\n'
          + '\n'
          + '                  <div class="wrap-input100">\n'
          + '                    <input id="length" class="input100" type="number" name="length" required title="Length">\n'
          + '                    <span class="focus-input100" data-placeholder="Length"></span>\n'
          + '                  </div>\n'
          + '\n'
          + '                  <div class="wrap-input100">\n'
          + '                    <input id="description" class="input100" type="text" name="description" required title="Description">\n'
          + '                    <span class="focus-input100" data-placeholder="Description"></span>\n'
          + '                  </div>'
          + '<div class="container-login100-form-btn">\n'
          + '                    <div class="wrap-login100-form-btn">\n'
          + '                      <div class="login100-form-bgbtn"></div>\n'
          + '                      <button class="login100-form-btn" type="submit" id="submit">\n'
          + '                        ADD\n'
          + '                      </button>\n'
          + '                    </div>\n'
          + '                  </div>'
          + '</form>'
      );
      $("#editMovieForm").submit(function(e){
        e.preventDefault();
        var movieName = $("#movieName").val();
        var actor1 = $("#actor1").val();
        var actor2 = $("#actor2").val();
        var actor3 = $("#actor3").val();
        var genre = $("#genre").val();
        var director = $('#director').val();
        var length = $('#length').val();
        var description = $('#description').val();

        var showDTO = {
          "id": "1",
          "name": movieName,
          "desc": description,
          "showType": "MOVIE",
          "genre": genre,
          "director": director,
          "actors": [
            actor1, actor2, actor3
          ],
          "length": length
        };

        $.ajax({
          url: "http://localhost:8080/api/show/edit/"+username+"/"+showID,
          type: "POST",
          datatype: "json",
          data: JSON.stringify(showDTO),
          contentType: "application/json",
          success: function (data) {
            window.location.href = "http://localhost:8080/show.html";
          },
          error: function (xhr, ajaxOptions, thrownError) {
            resp = $.parseJSON(xhr.responseText);
            alert(resp.error);
          }
        });
      })
      }
    })
};

function del() {
  debugger;
  console.log("Deletion.");
  var username = localStorage.getItem('loggedIn');
  var showID = localStorage.getItem('showID');
  $.ajax({
    url: "http://localhost:8080/api/show/delete/" + username + "/" + showID,
    type : "DELETE",
    success:function(){
        console.log("deleted");
    }
  })
};

function screening() {
  console.log("Screening.");
  var username = localStorage.getItem('loggedIn');
  var showID = localStorage.getItem('showID');
  var theatreID = localStorage.getItem('theatreID');
}