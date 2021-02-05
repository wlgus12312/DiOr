<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
  <title>디지털주문</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
  	<link rel="icon" type="image/png" sizes="16x16" href="/images/apple-touch-icon.png">
  	
  <script src="https://code.jquery.com/jquery-3.5.1.min.js" 
          integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
          integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs="
  crossorigin="anonymous"></script>
  	
  	
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<!--   <script src="/js/menu.js"></script> 
  <script src="/js/webSocket.js"></script>   -->	
  <script src="/app.js"></script>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}
</style>
</head>

<script>
//alert(getParam("tableno"));
//var tableno = getParam("tableno");
//document.getElementById("tableno").value = tableno;

function getParam(sname) {

    var params = location.search.substr(location.search.indexOf("?") + 1);

    var sval = "";

    params = params.split("&");

    for (var i = 0; i < params.length; i++) {

        temp = params[i].split("=");

        if ([temp[0]] == sname) { sval = temp[1]; }

    }

    return sval;  

}

function fn_basket(data){
	console.log("data" + data);
    var frmRow = 'row'+data;
    console.log("frmRow" + frmRow);
    var dataFrm = document.frmRow; 
    //var signUpFormTxt = document.getElementById("tableno").value;

	connectOrder();
    sendO();
    
	//dataFrm.action = "/hello";
	//dataFrm.submit();
}

function returnMessage(message){
	alert("주문성공"+message);
}

</script>
<body>
<!-- Vue -->
<!-- <script src="https://cdn.jsdelivr.net/npm/vue"></script> -->
<!-- <script src="menu.js"></script>
<div id="app">
  {{ message }}
</div> -->

<!-- Sidebar (hidden by default) 
<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:40%;min-width:300px" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()"
  class="w3-bar-item w3-button">Close Menu</a>
  <a href="#food" onclick="w3_close()" class="w3-bar-item w3-button">Food</a>
  <a href="#about" onclick="w3_close()" class="w3-bar-item w3-button">About</a>
</nav>
-->
<!-- Top menu -->
<div class="w3-top">
  <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
    <!-- <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div> -->
    <div class="w3-button w3-padding-16 w3-right "><img src="/images/iconmonstr-friend-6-240.png" style="max-width:50px;"></div>
    <div class="w3-center w3-padding-16">디지털메뉴판</div>
    <div id="tableno"></div>
  </div>
</div>

<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">
	<!-- First Photo Grid-->
	<div class="w3-row-padding w3-padding-16 w3-center" >
	
          <input type="text" id="name" class="form-control" placeholder="Your name here...">
	
		<c:forEach items="${menuList}" var="item" varStatus="stsc">
			<form id="row${stsc.index}" name="row${stsc.index}" method="post">
			  <div class="w3-quarter">
			  ${item.stonm}
			    <img src="/images/pork_cutlet.png" alt="Sandwich" style="width:100%">
			    <h5>${item.fdnm}<br>${item.fdprice} 원</h5>
			    <buton id="btn" class="w3-bar-item w3-black w3-button" onclick="fn_basket(${stsc.index})">담기</buton>
			    <p>
			  </div>
			  
			  <input type="hidden" id="tableno" name="tableno" value="${tableno}">
			  <input type="hidden" id="stono" name="stono" value="${item.stono}">
			  <input type="hidden" id="fdno" name="fdno" value="${item.fdno}">
			  <input type="hidden" id="fdprice" name="fdprice" value="${item.fdprice}">
			</form>
		</c:forEach>	
			
	</div>	  
</div>
</body>
</html>