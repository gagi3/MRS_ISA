$("#addTheatreForm").submit(function(e) {
  debugger;
  e.preventDefault();
  var theatreName = $("#theatreName").val();
  var type = $("#type").val();
  var address = $("#address").val();
  var city = $("#city").val();
  var description = $('#description').val();

  if (theatreName.length == 0 || type.length == 0 || address.length == 0 || city.length == 0 || description.length == 0) {
    alert("All fields must be filled.");
  } else {
    var theatreDTO = {
      "id": "1",
      "name": theatreName,
      "address": {
        "id" : "1",
        "address" : address,
        "city" : city
      },
      "desc": description,
      "theatreType": type,
      "rating": "0.0",
    };

    var username = localStorage.getItem('loggedIn');


    $.ajax({
      url: "http://localhost:8080/api/theatre/theatres/add/"+username,
      type: "POST",
      datatype: "json",
      data: JSON.stringify(theatreDTO),
      contentType: "application/json",
      success: function (data) {
        window.location.href = "http://localhost:8080/theatres.html";
      },
      error: function (xhr, ajaxOptions, thrownError) {
        resp = $.parseJSON(xhr.responseText);
        alert(resp.error);
      }
    });
  }
});

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
    url: "http://localhost:8080/api/theatre/theatres",
    type: "GET",
    // headers: {"Authorization": localStorage.jwt},
    success: function(data) {
      console.log("FU");
      $.each(data, function(i) {
        var theatre = data[i];
        console.log(theatre);
        console.log(theatre.name);
        console.log(theatre.rating);
        console.log(getStars(theatre.rating));
        $('.card-wrapper').append('<div class="container-card100">\n'
            + '                  <div class="wrap-card100">\n'
            + '                    <span class="card100-form-title cardTitle" id="cardTitle">\n'
            + '                      '+ theatre.name + '\n'
            + '                    </span>\n'
            + '                    <div class="card-data">\n'
            + '                      <span class="card100-form-text">\n'
            + '                        '+ theatre.address.address + ', ' + theatre.address.city + '\n'
            + '                      </span>\n'
            + '                      <span class="card100-form-text">\n'
            + '                        '+ theatre.desc + '\n'
            + '                      </span>\n'
            + '                    </div>\n'
            + '                    <div class="rating">\n'
            // + '                      <span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>\n'
            + getStars(theatre.rating)
            + '                    </div>\n'
            + '\n'
            + '                    <div class="container-card100-form-btn repertoire-cont" id="repertoire-cont">\n'
            + '                      <div class="wrap-content100-form-btn">\n'
            + '                        <div class="topbar100-form-bgbtn"></div>\n'
            + '                        <button class="card100-form-btn repertoire-button" type="submit" id="repertoire-button">\n'
            + '                          REPERTOIRE\n'
            + '                        </button>\n'
            + '                      </div>\n'
            + '                    </div>\n'
            + '                  </div>\n'
            + '                </div>');
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

