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
    stompClient.subscribe('/topic/food1', function (msgList) {
      //food1Order(msgList);
	  food1Order(JSON.parse(msgList.body));
    });
  });
}
//음식점1 주문내역
function food1Order(msgList) {	
	for(var i = 0; i < msgList.length; i++){
		$("#orderList").append("<tr>");
		$("#orderList").append("<td>" + msgList[i].ordno + "</td>");
		$("#orderList").append("<td>" + msgList[i].fdno + "</td>");
		$("#orderList").append("<td>" + msgList[i].ordcnt + "</td>");
		$("#orderList").append("<td>" + msgList[i].fdnm + "</td>");
		$("#orderList").append("<td><button onclick=stOrder("+ msgList[i].ordno + ","+  msgList[i].ords + ")>조리시작</button></td>");
		$("#orderList").append("<td><button onclick=edOrder("+ msgList[i].ordno + ","+  msgList[i].ords + ")>조리완료</button></td>");
		$("#orderList").append("</tr>");
	}	    
}

//음식점 조리시작
function stOrder(ordno, ords) {	
	//조리시작	
	$.ajax({
		url:'/stOrder',
		type:'POST',
		dataType:'text',
		data:{
			ordno:ordno,
			ords:ords
		},
		success:function(data) { 
			alert("조리시좍~"); 
		}
	});		
	
}
//음식점 조리완료
function edOrder(ordno, ords) {	
	//조리완료
		$.ajax({
		url:'/edOrder',
		type:'POST',
		dataType:'text',
		data:{
			ordno:ordno,
			ords:ords
		},
		success:function(data) { 
			alert("조리종료");
		}
	});		
}




$(function () {
  $("form").on('submit', function (e) {
    e.preventDefault();
  });
  $( "#connect" ).click(function() { connect(); });
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#send" ).click(function() { sendName(); });
});