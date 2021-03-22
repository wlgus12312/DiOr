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

<body>
<!-- Top menu -->
<div class="w3-top">
  <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
    <div class="w3-center w3-padding-16"> 주문번호 : ${param.ordno} </div>
    <div id="tableno"></div>
    <form id="frmParam" name="frmParam" method="get" enctype="multipart/form-data" contentType="application/json">
		<input type="hidden" id="ordno" name="ordno" value="${ordno}">
	</form>
  </div>
</div>

<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">
	<!-- order status bar -->
	<div class="w3-row-padding">
		<button class="w3-bar-item w3-black w3-button w3-right" onclick="fn_refresh()" >새로고침</button>
		<br><br>
		<c:forEach items="${orderList}" var="item" varStatus="stsc">
			<h3 class ="w3-left"> ${item.stonm} - ${item.fdnm} </h3><br><br>
			<hr>
			<p class="w3-center">
				<span id="ordimg1${stsc.index}" class ="w3-left">주문&nbsp;&nbsp;</span>
				<span id="ordimg2${stsc.index}" class ="w3-center">조리중&nbsp;</span>
				<span id="ordimg3${stsc.index}" class ="w3-right" style="m">조리완료</span>
			</p>
		<hr>
		<br>
		</c:forEach>
	</div>
    <!-- table Grid-->
	<div class="w3-row-padding w3-padding-16 w3-center" >
	<table class= "w3-table-all">
		<tr>
			<th style="background-color:black; color:white;">주문번호</th>
			<th style="background-color:black; color:white;">음식점</th>
			<th style="background-color:black; color:white;">메뉴</th>
			<th style="background-color:black; color:white;">갯수</th>
			<th style="background-color:black; color:white;">주문상태</th>
			<th style="background-color:black; color:white;">주문시각</th>
		</tr>
		<c:forEach items="${orderList}" var="item" varStatus="stsc">
			<tr>
				<td> ${item.ordno} </td>
				<td> ${item.stonm} </td>
				<td> ${item.fdnm} </td>
				<td> ${item.ordcnt} </td>
				<td> ${item.ordstnm} </td>
				<td> ${item.rg_dt} </td>
			</tr>
	           
			<input type="hidden" id="stono${stsc.index}" name="stono" value="${item.stono}">
			<input type="hidden" id="stonm${stsc.index}" name="stonm" value="${item.stonm}">
			<input type="hidden" id="fdno${stsc.index}" name="fdno" value="${item.fdno}">
			<input type="hidden" id="fdnm${stsc.index}" name="fdnm" value="${item.fdnm}">
			<input type="hidden" id="ordstsc${stsc.index}" name="ordstsc" value="${item.ordstsc}">
	     </c:forEach>
	</table> 
	</div>     
</div>
</body>
<script>

window.onload = function(){
	//소켓커넥트
	
	var url = document.location.href.split("/")[3]; 
	var stono = ${storeList}+""; 
	console.log("Connect stono: " + stono[0]);
	
	connect(stono[0]); //단건커넥
	
/*	푸드코트 다건 커넥 로직	
	for(var i=0; i <= stono.length; i ++){
		connect(stono[i]); 
	}
*/	

	if(url == 'insOrder'){
		setTimeout(function(){
		console.log("Send stono: " + stono[0]);
			sendName(stono[0]);
				
/*	푸드코트 다건 메세지 send  	
	for(var i=0; i <= data.length; i ++){
  			sendName(stono[i]);
	}
*/
			document.frmParam.action = "/orderList";
			document.frmParam.submit();
		}, 500);
			
	} else {
		
		for(var i=0; i <= ${fn:length(orderList)}; i ++){
			//var stoNm = document.getElementById(eval("'stono"+i+"'")).value;
			
			var orstsc = document.getElementById(eval("'ordstsc"+i+"'")).value;
			if(orstsc == '0'){
				var stsc = 'ordimg1'+i;
				fn_showOrd(stsc);
			} else if (orstsc == '1'){
				var stsc = 'ordimg2'+i;
				fn_showOrd(stsc);
			} else {
				var stsc = 'ordimg3'+i;
				fn_showOrd(stsc);
			}
		}
		
		setTimeout(function(){fn_refresh(),3000});
	}
	
}

function fn_showOrd(stsc){
	var html = '<span class="arrow-right"></span>';
	$(eval("'#"+stsc+" *'")).remove();
	$(eval("'#"+stsc+"'")).append(html);
	
}


function fn_refresh(){
	window.location.reload();
}	

</script>
</html>