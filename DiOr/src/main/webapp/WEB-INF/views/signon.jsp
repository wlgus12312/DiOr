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
  <script src="js/enscript.js"></script>
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

<body>

<div class="w3-top">
	<div class="w3-white" style="max-width:1200px;margin:auto">
		<div class="w3-center w3-padding-16">디지털메뉴판</div>
	</div>
	<div class="w3-center">
	<hr>
		<form id="frmParam"name="frmParam" method="post" enctype="multipart/form-data" contentType="application/json">
			<div class="w3-center">
				<input type="text" id="stonm" name="stonm" accesskey="L" placeholder="레스토랑이름" class="int" maxlength="41" value="">
			</div>
			<div class="w3-center">				
				<input type="text" id="userid" name="userid" accesskey="L" placeholder="관라지아이디" class="int" maxlength="41" value="">
			</div>
			<div class="w3-center">
				<input type="password" id="userpw" name="userpw" placeholder="관리자비밀번호" class="int" maxlength="16">
			</div>
			<div class="w3-center">
				<input type="text" id="tel" name="tel" accesskey="L" placeholder="관리자연락처" class="int" maxlength="41" value="">
			</div>		
			
			<input type="button" title="가입신청" value="가입신청" class="w3-bar-item w3-black w3-button" id="btn_sign_on" onclick="fn_signOn()">
		</form>
	</div>
</div>

</body>

<script> 

var url = document.location.href.split("/")[3]; 
if(url == 'insUser'){
	alert("가입신청이 완료되었습니다.");
	window.close();  
}


function fn_signOn(){
	document.getElementById("userpw").value = SHA256(document.getElementById("userpw").value);
	document.frmParam.action = "/insUser";
	document.frmParam.submit();
	
}
</script>
</html>