<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

		//조리시작	
		$.ajax({
			url:'/createQr',
			type:'POST',
			dataType:'json',
			data:{
				stono:$("#stono").val(),
				tableno:$("#tableno").val(),
			},
			success:function(data) {			
				var imgTag = "";
				imgTag = "<img class='w3-image' src='data:image/png;base64," + data.qrCode + "'>";
				$("#qrImg").append(imgTag);
			}
		});		
		
	}

</script>

<body>
<div class="w3-top">
	<div class="w3-white" style="max-width:1200px;margin:auto">
		<div class="w3-center w3-padding-16">테이블 QR 생성</div>
	</div>
	<form id="qrfrm" method="post">
		<input id="stono">
		<input id="tableno">
		<button onclick="createQr()">QR코드 생성</button>
	</form>
	<form id="qrImg">
		
	</form>
</div>

</body>
</html>