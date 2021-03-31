var stompClient = null;

function connect(stono) {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  // SockJS와 stomp client를 통해 연결을 시도.
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/food'+stono, function (greeting) {
//      showGreeting(JSON.parse(greeting.body).content);
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

function sendName(stono) {
  // /app/hello로 JSON 파라미터를 메세지 body로 전송.
  stompClient.send("/app/food"+stono,
                   {}, //헤더
				  ''); 
}

//음식점 접속
function connectFood(stono) {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  // SockJS와 stomp client를 통해 연결을 시도.
  stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/food'+ stono, function (msgList) {
      //food1Order(msgList);
	  food1Order(JSON.parse(msgList.body));
    });
  });
}

//음식점 주문내역
function food1Order(msgList) {
	
	var msgOrdno = "";
	var msgFdno  = "";
		
	for(var i = 0; i < msgList.length; i++){
		
		msgOrdno = msgList[i].ordno;
		msgFdno  = msgList[i].fdno;
		
		$("#orderList").append("<tr>");
		$("#orderList").append("<td>" + msgOrdno + "</td>");
		$("#orderList").append("<td>" + msgFdno  + "</td>");
		$("#orderList").append("<td>" + msgList[i].ordcnt + "</td>");
		$("#orderList").append("<td>" + msgList[i].fdnm   + "</td>");
		$("#orderList").append("<td><button class='w3-bar-item w3-black w3-button w3-right' onclick=stOrder("+ msgOrdno + ","+ msgFdno + ")>조리시작</button></td>");
		$("#orderList").append("<td><button class='w3-bar-item w3-black w3-button w3-right' onclick=edOrder("+ msgOrdno + ","+ msgFdno + ")>조리완료</button></td>");
		$("#orderList").append("</tr>");
	}	    
}

//음식점 조리시작
function stOrder(ordno, fdno) {	
	//조리시작	
	$.ajax({
		url:'/stOrder',
		type:'POST',
		dataType:'text',
		data:{
			ordno:ordno,
			fdno:fdno
		},
		success:function(data) { 
			alert("조리시좍~"); 
		}
	});		
	
}
//음식점 조리완료
function edOrder(ordno, fdno) {	
	//조리완료
		$.ajax({
		url:'/edOrder',
		type:'POST',
		dataType:'text',
		data:{
			ordno:ordno,
			fdno:fdno
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