var stompClient = null;

function setConnected(connected) {

  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", connected);
  if (connected) {
    $("#conversation").show();
  }
  else {
    $("#conversation").hide();
  }
  $("#greetings").html("");
}

function setConnected2(connected) {
  $("#connect2").prop("disabled", connected);
  $("#disconnect2").prop("disabled", !connected);
  if (connected) {
    $("#conversation2").show();
  }
  else {
    $("#conversation2").hide();
  }
  $("#greetings2").html("");
}

function connect() {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  // SockJS와 stomp client를 통해 연결을 시도.
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', function (greeting) {
      showGreeting(JSON.parse(greeting.body).content);
    });
  });
}

function connect2() { 
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  // SockJS와 stomp client를 통해 연결을 시도.
  stompClient.connect({}, function (frame) {
    //setConnected2(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings2', function (greeting) {
      showGreeting2(JSON.parse(greeting.body).content);
    });
  });
}

function connectOrder() { 
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  // SockJS와 stomp client를 통해 연결을 시도.
  stompClient.connect({}, function (frame) {
    //setConnected2(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', function (greeting) {
      showOrder(3);
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

function disconnect2() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}

function sendName() {
  // /app/hello로 JSON 파라미터를 메세지 body로 전송.
  stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));

}

function sendO() {
	alert("1");
  // /app/hello로 JSON 파라미터를 메세지 body로 전송.
	socket.onopen = function(e){
  		stompClient.send("/app/hello", {}, JSON.stringify({'name': "주문"}));
	}
}

function sendName2() {
  // /app/hello로 JSON 파라미터를 메세지 body로 전송.
  stompClient.send("/app/hi", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
  $("#greetings").append("<tr><td>" + message + "</td></tr>");
}
function showGreeting2(message) {
  $("#greetings2").append("<tr><td>" + message + "</td></tr>");
}

function showOrder(message) {
	alert(message);
  //$("#greetings2").append("<tr><td>" + message + "</td></tr>");
}

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
});