<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    session = request.getSession();
    String stonm = session.getAttribute("stonm").toString();
    String stono = session.getAttribute("stono").toString();
    String userid = session.getAttribute("userid").toString();
    String apv_yn = session.getAttribute("apv_yn").toString();
%>
<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판</title>
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
<!-- Sidebar (hidden by default) -->
<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:40%;min-width:300px" id="mySidebar">
	<a href="javascript:void(0)" onclick="bask_close()" class="w3-button w3-right">◀</a>
	<div class="w3-center w3-padding-16">
		마이메뉴 
		<input type="button" title="메뉴관리" value="메뉴관리" class="w3-bar-item w3-black w3-button" id="btn_go_menu_admin" onclick="fn_go_menuAdmin()">
		<input type="button" title="주문받기" value="주문받기" class="w3-bar-item w3-black w3-button" id="btn_go_ordering" onclick="fn_go_ordering()">
		<input type="button" title="주문내역보기" value="주문내역보기" class="w3-bar-item w3-black w3-button" id="btn_go_order_list" onclick="fn_go_orderList()">
		<input type="button" title="QR생성" value="QR생성" class="w3-bar-item w3-black w3-button" id="btn_go_qr" onclick="fn_go_qr()">
	</div>
  	<a href="javascript:void(0)" onclick="bask_close()" class="w3-bar-item w3-button w3-left">닫기</a>
  
</nav>
<!-- Top menu -->
<div class="w3-top">
  <div class="w3-white" style="max-width:1200px;margin:auto">
    <div class="w3-button w3-padding-16 w3-left ">
    	<img src="/images/iconmonstr-friend-6-240.png" style="max-width:45px;" onclick="bask_open()">
    </div>
    <div class="w3-center w3-padding-16"><%=stonm%> 디지털메뉴판</div>
		<form id="top_frmParam"name="top_frmParam" method="POST" enctype="multipart/form-data" contentType="application/json">
			<input type="hidden" id="top_stono" name="stono" value="${userList[0].stono}">
		</form>
  </div>
</div>


</body>

<script> 

var url = document.location.href.split("/")[3]; 
if(url == 'login'){
	//alert("");
	
}

// 1:승인 0:미승
if(<%=apv_yn%> == 0){
	alert(" 아직 승인되지 않은 아이디입니다. \n 관리자에게 문의하세요.");
}

function fn_go_menuAdmin(){
	document.top_frmParam.action = "/menu_Res_Admin";
	document.top_frmParam.submit();
}

function fn_go_ordering(){
	document.top_frmParam.action = "/food";
	document.top_frmParam.submit();
}
function fn_go_orderList(){
	document.top_frmParam.action = "/foodList";
	document.top_frmParam.submit();
}
function fn_go_qr(){
	document.top_frmParam.action = "/tableQr";
	document.top_frmParam.submit();
}
function bask_open() {
  document.getElementById("mySidebar").style.display = "block";
}
 
function bask_close() {
  document.getElementById("mySidebar").style.display = "none";
}
</script>
</html>