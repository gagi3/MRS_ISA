$("#addMovieForm").submit(function(e) {
  debugger;
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
      "showType": "PLAY",
      "genre": genre,
      "director": director,
      "actors": [
        actor1, actor2, actor3
      ],
      "length": length
    };


    $.ajax({
      url: "http://localhost:8080/api/show/movie/add",
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