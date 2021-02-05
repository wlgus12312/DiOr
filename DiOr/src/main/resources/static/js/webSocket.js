function setConnected(connected) {
  if (connected) {
    $("#conversation").show();
  }
  else {
    $("#conversation").hide();
  }
  $("#greetings").html("");
}

function connect() {
 // var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  // SockJS와 stomp client를 통해 연결을 시도.
  stompClient.connect({}, function (frame) {
    //setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', function (ordering) {
      showGreeting(JSON.parse(ordering.body).content);
    });
  });
}

function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}

function sendOrder() {
  // /app/hello로 JSON 파라미터를 메세지 body로 전송.
  stompClient.send("/app/hello", {}, JSON.stringify({'name': '11111'}));

}
function showGreeting(message) {
	console.log("showGreeting" + message);
  //$("#greetings").append("<tr><td>" + message + "</td></tr>");
}
/*
$(function () {
  $("form").on('submit', function (e) {
    e.preventDefault();
  });
  $( "#connect" ).click(function() { connect(); });
  $( "#connect2" ).click(function() { connect2(); });
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#disconnect2" ).click(function() { disconnect2(); });
  $( "#send" ).click(function() { sendName(); });
  $( "#send2" ).click(function() { sendName2(); });
});*/