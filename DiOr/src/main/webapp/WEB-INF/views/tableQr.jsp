<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file = "start.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <title>디지털주문</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js" 
          integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
          integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=" crossorigin="anonymous"></script>       
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
  <link rel="icon" type="image/png" sizes="16x16" href="/images/apple-touch-icon.png">
     
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <script src="/app.js"></script>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}
.arrow-right {
  position: absolute;
  display: inline-block;
  width: 0;
  height: 0;
  border-top: 8px solid transparent;
  border-right: 8px solid transparent;
  border-bottom: 8px solid transparent;
  border-left: 8px solid black;
  margin-left: 9px;
  animation: horizontal 0.7s ease-in-out infinite;
}

@keyframes horizontal {
  0% {
    margin-left: 9px;
  }
  50% {
    margin-left: 11px;
  }
  100% {
    margin-left: 9px;
  }
}
</style>
</head>
<!-- <img class="w3-image"src="data:image/png;base64, ${qrCode}" > -->
<script> 
	function createQr(){

		$.ajax({
			url:'/createQr',
			type:'POST',
			dataType:'json',
			data:{
				stono:<%=stono%>,
				tableno:$("#tablenoQ").val(),
			},
			success:function(data) {			
				var imgTag = "";
				imgTag += "<div style='width:50%; border:1px solid black; float:left;'><label>" + "테이블번호 : " + $("#tablenoQ").val() + "</label>";
				imgTag += "<img height='280' width='180' class='w3-image' src='data:image/png;base64," + data.qrCode + "'></div>";
				$("#qrImg").append(imgTag);
			}
		});				
	}
	
	
	//페이지 로딩 시 qr코드 불러오기
	window.onload = function(){
		
		$.ajax({
			url:'/selectQr',
			type:'POST',
			dataType:'json',
			data:{
				stono:<%=stono%>,				
			},
			success:function(data) {
				
				for(var i = 0; i < data.length; i++){					
					var imgTag = "";
					imgTag += "<div style='width:50%; border:1px solid black; float:left;'><label>" + "테이블번호 : " + data[i].FDNO + "</label>";
					imgTag += "<img height='280' width='180' class='w3-image' src='data:image/png;base64," + data[i].QIMG + "'></div>";
					$("#qrImg").append(imgTag);		
				}			
			}
		});		
	
	
	
	}
	
	function fn_print(){
		var inbody = document.body.innerHTML; // 이전 body 영역 저장
		document.body.innerHTML = document.getElementById('qrImg').innerHTML;
		window.print();
		document.body.innerHTML = inbody; // 이전 body 영역으로 복구
	}	
</script>

<body>
	<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">
		<div class="w3-left">
			<form id="qrfrm" method="post">		
				<span>테이블 번호 : </span><input id="tablenoQ">
				<button onclick="createQr()">QR코드 생성</button>
			</form>
		</div>
		<div class="w3-right">
			<button onclick="fn_print()">프린트</button>
		</div>
		<br><br>
		<div id="qrImg" style='width:100%;'>
		</div>
	</div>
</body>
</html>