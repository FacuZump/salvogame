$(function() {
  function showOutput(text) {
    $("#output").text(text);
  }

  function loadData() {
    $.get("/players")
    .done(function(data) {
      showOutput(JSON.stringify(data, null, 2));
    })
    .fail(function( jqXHR, textStatus ) {
      showOutput( "Failed: " + textStatus );
    });
  }

  function addPlayer() {
    var name = $("#email").val();
    if (name) {
      postPlayer(name);
    }
  }

  function postPlayer(userName) {
    $.post({
      headers: {
          'Content-Type': 'application/json'
      },
      dataType: "text",
      url: "/players",
      data: JSON.stringify({ "userName": userName })
    })
    .done(function( ) {
      showOutput( "Saved -- reloading");
      loadData();
    })
    .fail(function( jqXHR, textStatus ) {
      showOutput( "Failed: " + textStatus );
    });
  }
  $("#add_player").on("click", addPlayer);
  loadData();
});