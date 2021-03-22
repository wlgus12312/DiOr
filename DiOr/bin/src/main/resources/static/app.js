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

function sendName() {
  // /app/hello로 JSON 파라미터를 메세지 body로 전송.
  console.log("name : " + $("#name").val());

  stompClient.send("/app/food1",
                   {}, //헤더
				  ''); 
                   //JSON.stringify({'name': $("#name").val(), 'age' : $("#age").val()}));
 
}

function sendO() {
  // /app/hello로 JSON 파라미터를 메세지 body로 전송.
  	stompClient.send("/app/hello", {}, JSON.stringify({'name': "주문"}));

}

function showGreeting(message) {
  $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

function showOrder(message) {
	//alert(message);
	console.log("333333333");
  //$("#greetings2").append("<tr><td>" + message + "</td></tr>");
}


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


$(function () {
  $("form").on('submit', function (e) {
    e.preventDefault();
  });
  $( "#connect" ).click(function() { connect(); });
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#send" ).click(function() { sendName(); });
});