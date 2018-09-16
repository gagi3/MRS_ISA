$("#addMovieForm").submit(function(e) {
  debugger;
  var username = localStorage.getItem('loggedIn');
  username = encodeURIComponent(username);
  var usr = {"username": username};
  e.preventDefault();
  var movieName = $("#movieName").val();
  var actor1 = $("#actor1").val();
  var actor2 = $("#actor2").val();
  var actor3 = $("#actor3").val();
  var genre = $("#genre").val();
  var director = $('#director').val();
  var length = $('#length').val();
  var description = $('#description').val();

  if (movieName.length == 0 || actor1.length == 0 || actor2.length == 0 ||
      actor3.length == 0 || genre.length == 0 || director.length == 0 || length.length == 0 || description.length == 0) {
    alert("All fields must be filled.");
  } else {
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
      url: "http://localhost:8080/api/show/movie/add/"+usr.username,
      type: "POST",
      datatype: "json",
      data: JSON.stringify(showDTO),
      contentType: "application/json",
      success: function (data) {
        window.location.href = "http://localhost:8080/shows.html";
      },
      error: function (xhr, ajaxOptions, thrownError) {
        resp = $.parseJSON(xhr.responseText);
        alert(resp.error);
      }
    });
  }
});


// Get all theatres

// $('.card-wrapper').ready(function() {
//   $.ajax({
//     url: "http://localhost:8080/api/user/theatres/all",
//     type: "GET",
//     headers: {"Authorization": localStorage.jwt},
//     success: function(data) {
//       $('.card-wrapper').append(data);
//     }
//   })
// });

// Get all theatres 2

function getStars(rating) {
  debugger;
  var output = "";
  if (rating == 1) {
    output = '<i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star"></i>';
  } else if (rating > 1 && rating < 2) {
    output = '<i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-half"></i><i class="zmdi zmdi-star"></i>';
  } else if (rating == 2) {
    output = '<i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i>';
  } else if (rating > 2 && rating <3) {
    output = '<i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-half"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i>';
  } else if (rating == 3) {
    output = '<i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i>';
  } else if (rating > 3 && rating < 4) {
    output = '<i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-half"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i>';
  } else if (rating == 4) {
    output = '<i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i>';
  } else if (rating > 4 && rating < 5) {
    output = '<i class="zmdi zmdi-star-half"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i>';
  } else if (rating == 5) {
    output = '<i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i><i class="zmdi zmdi-star"></i>';
  } else {
    output = '<i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i><i class="zmdi zmdi-star-outline"></i>';
  }
  return output;
}

$('.card-wrapper').ready(function() {
  debugger;
  $.ajax({
    url: "http://localhost:8080/api/show/movies",
    type: "GET",
    // headers: {"Authorization": localStorage.jwt},
    success: function(data) {
      console.log("FU");
      $.each(data, function(i) {
        var movie = data[i];
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
            + '                    </div>\n'
            + '                    <div class="rating">\n'
            // + '                      <span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>\n'
            + getStars(movie.rating)
            + '                    </div>\n'
            + '\n'
            + '                    <div class="container-card100-form-btn repertoire-cont" id="repertoire-cont">\n'
            + '                      <div class="wrap-content100-form-btn">\n'
            + '                        <div class="topbar100-form-bgbtn"></div>\n'
            + '                        <button class="card100-form-btn repertoire-button" type="submit" id="repertoire-button">\n'
            + '                          SCREENINGS\n'
            + '                        </button>\n'
            + '                      </div>\n'
            + '                    </div>\n'
            + '                  </div>\n'
            + '                </div>');
      })
    }
  })
});