var stompClient = null;

/*function setConnected(connected) {
  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", !connected);
  if (connected) {
    $("#conversation").show();
  }
  else {
    $("#conversation").hide();
  }
  $("#greetings").html("");
}*/

//음식점1 접속
function connectFood1() {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  // SockJS와 stomp client를 통해 연결을 시도.
  stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/food1', function (greeting) {
      food1Order(JSON.parse(greeting.body).content);
    });
  });
}

//음식점1 주문내역
function food1Order(message) {
  $("#orderList").append("<tr><td>" + message + "</td></tr>");
}


function connect() {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  // SockJS와 stomp client를 통해 연결을 시도.
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/food1', function (greeting) {
      showGreeting(JSON.parse(greeting.body).content);
    });
  });
}

/*function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}*/



function sendName() {
  // /app/hello로 JSON 파라미터를 메세지 body로 전송.
  stompClient.send("/app/food1", {}, JSON.stringify({'name': $("#name").val()}));
}

/*function showGreeting(message) {
  $("#greetings").append("<tr><td>" + message + "</td></tr>");
}*/

$(function () {
  $("form").on('submit', function (e) {
    e.preventDefault();
  });
  $( "#connect" ).click(function() { connect(); });
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#send" ).click(function() { sendName(); });
});