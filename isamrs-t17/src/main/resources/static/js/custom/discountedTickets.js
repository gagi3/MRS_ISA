$('.card-wrapper').ready(function() {
  var username = localStorage.getItem('loggedIn');
  // username = "admin";
  var theatreID = localStorage.getItem('theatreID');
  $.ajax({
    url: "http://localhost:8080/api/admin/login/check/" + username,
    type: "GET",
    success:function() {
      $.ajax({
        url: "http://localhost:8080/api/theatre/tickets/discounted/"+username+"/"+theatreID,
        type: "GET",
        // headers: {"Authorization": localStorage.jwt},
        success: function(data) {
          console.log("FU");
          $.each(data, function (i) {
            var ticket = data[i];
            localStorage.setItem('ticketID', ticket.id);
            var sid = ticket.id;
            $('.card-wrapper').append('<div class="container-card100">\n'
                + '                  <div class="wrap-card100">\n'
                + '                    <span class="card100-form-title cardTitle" id="cardTitle">\n'
                + '                      '+ 'Show: ' + ticket.showName + '\n'
                + '                    </span>\n'
                + '                    <div class="card-data">\n'
                + '                      <span class="card100-form-text">\n'
                + '                        '+ 'Issue Date: ' + ticket.issueDate + '\n'
                + '                      </span>\n'
                + '                      <span class="card100-form-text">\n'
                + '                        '+ 'Price: ' + ticket.price + '\n'
                + '                      </span>\n'
                + '                      <span class="card100-form-text">\n'
                + '                        '+ 'Number: ' + ticket.number + '\n'
                + '                      </span>\n'
                + '                    </div>\n'
                + '\n'
                + '                    <div class="container-card100-form-btn repertoire-cont" id="repertoire-cont">\n'
                + '                      <div class="wrap-content100-form-btn">\n'
                + '                        <div class="topbar100-form-bgbtn"></div>\n'
                + '                        <button class="card100-form-btn repertoire-button" type="submit" id="screening-button" onclick="reserve()">\n'
                + '                          RESERVE\n'
                + '                        </button>\n'
                + '                      </div>\n'
                + '                    </div>\n'
                + '                </div>');
            })
        }
      })
    }
  })
});

function reserve() {
  var ticketID = localStorage.getItem('ticketID');
  var username = localStorage.getItem('loggedIn');
  $.ajax({
    url: "http://localhost:8080/api/theatre/tickets/discounted/reserve/"+username+"/"+ticketID,
    type: "POST",
    success: function () {
      console.log("Ticket reserved!");
    }
  })
}