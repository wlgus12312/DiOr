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
		<c:forEach items="${userList}" var="item" varStatus="stsc">
		    <div>${item.stonm} </div>
			<div>${item.userid}</div>
			<hr>
		</c:forEach>
		<form id="frmParam"name="frmParam" method="POST" enctype="multipart/form-data" contentType="application/json">
			<input type="hidden" id="stono" name="stono" value="${userList[0].stono}">
		</form>
		<div class="w3-quarter">
			<input type="button" title="메뉴관리" value="메뉴관리" class="w3-bar-item w3-black w3-button" id="btn_go_menu_admin" onclick="fn_go_menuAdmin()">
			<input type="button" title="주문받기" value="주문받기" class="w3-bar-item w3-black w3-button" id="btn_go_ordering" onclick="fn_go_ordering()">
			<input type="button" title="주문내역보기" value="주문내역보기" class="w3-bar-item w3-black w3-button" id="btn_go_order_list" onclick="fn_go_orderList()">
			<input type="button" title="QR생성" value="QR생성" class="w3-bar-item w3-black w3-button" id="btn_go_qr" onclick="fn_go_qr()">
		</div>
	</div>
</div>

</body>

<script> 

var url = document.location.href.split("/")[3]; 
if(url == 'login'){
	//alert("");
	
}

const userid = "${userList[0].userid}"; 
const apv_yn = "${userList[0].apv_yn}";
const stono = "${userList[0].stono}";
const stonm = "${userList[0].stonm}";

// 1:승인 0:미승
if(apv_yn == 0){
	alert(" 아직 승인되지 않은 아이디입니다. \n 관리자에게 문의하세요.");
}

function fn_go_menuAdmin(){
	document.frmParam.action = "/menu_Res_Admin";
	document.frmParam.submit();
}

function fn_go_ordering(){
	document.frmParam.action = "/food";
	document.frmParam.submit();
}
function fn_go_orderList(){

}
function fn_go_qr(){

}
</script>
</html>