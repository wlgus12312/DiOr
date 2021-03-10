<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

.container{
    border:4px solid #ddd;
    display: block;
    width:100%;
    height:100%;

    overflow: hidden;
    position:relative;
    
}
.container img{
    position:absolute;
    left:0%;
    top:-10%
}

.w3-image-ratio { 
	position: relative; 
	top: 0; 
	left: 0; 
	right: 0; 
	bottom: 0; 
	max-width: 100%; 

	padding-top: 75%


}

</style>
</head>


<body>
<!-- Vue -->
<!-- <script src="https://cdn.jsdelivr.net/npm/vue"></script> -->
<!-- <script src="menu.js"></script>
<div id="app">
  {{ message }}
</div> -->

<!-- Sidebar (hidden by default) -->
<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:40%;min-width:300px" id="mySidebar">
	<a href="javascript:void(0)" onclick="bask_reset()" class="w3-button w3-left"><h5>초기화</h5></a>
	<a href="javascript:void(0)" onclick="bask_close()" class="w3-button w3-right">◀</a>
	<div class="w3-center w3-padding-16">
		장바구니
	</div>

	<form id="frmParam" name="frmParam" method="post" enctype="multipart/form-data" contentType="application/json">
		<input type="hidden" id="tableno" name="tableno" value="${param.tableno}">
		<div id="basketTit"></div>
	</form>
  
  	<a href="javascript:void(0)" onclick="order()" class="w3-bar-item w3-button w3-left">주문</a>
  
</nav>

<!-- Top menu -->
<div class="w3-top">
  <div class="w3-white" style="max-width:1200px;margin:auto">
    <!-- <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div> -->
    <div class="w3-button w3-padding-16 w3-left ">
    	<img src="/images/iconmonstr-friend-6-240.png" style="max-width:45px;" onclick="bask_open()">
    		<div id="foodcnt" class="w3-red"></div>
    </div>
    <div class="w3-center w3-padding-16">디지털메뉴판</div>
    <%-- <div id="tableno">${param.tableno}</div> --%>
  </div>
</div>

<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">
   <!-- First Photo Grid-->
   <div class="w3-row-padding w3-padding-16 w3-center" >
      
      <c:forEach items="${menuList}" var="item" varStatus="stsc">
      	<div class="w3-quarter">
      	<hr>${item.stonm} <br>
		<img class="w3-image" alt="${item.stonm}" src="data:image/jpeg;base64, ${item.viewImg}" > 
		<h5>${item.fdnm}<br>${item.fdprice} 원</h5>
		<button id="btn" class="w3-bar-item w3-black w3-button" onclick="fn_shoppingBag(${stsc.index})">담기</button>
			<input type="hidden" id="stono${stsc.index}" name="stono" value="${item.stono}">
			<input type="hidden" id="stonm${stsc.index}" name="stonm" value="${item.stonm}">
			<input type="hidden" id="fdno${stsc.index}" name="fdno" value="${item.fdno}">
			<input type="hidden" id="fdnm${stsc.index}" name="fdnm" value="${item.fdnm}">
			<input type="hidden" id="fdprice${stsc.index}" name="fdprice" value="${item.fdprice}">
		</div>
      </c:forEach> 
   </div>     
</div>
</body>
<script>
//connect();

var foodCnt = 0;
var html = '';	

	function fn_shoppingBag(data){
		foodCnt = foodCnt + 1;
		$('#foodcnt *').remove();
		var html = '<p>'+ foodCnt + '</p>';
		$('#foodcnt').append(html);
		
		console.log("data: " + data);
		
		var paTableno = 'tableno'+data;
		var paStono = 'stono'+data;
		var paStonm = 'stonm'+data;
		
		var paFdno = 'fdno'+data; 
		console.log("paFdno " + paFdno);
		
		var paFdnm = 'fdnm'+data;
		var paFdprice = 'fdprice'+data; 
		
		var paFdNoId = document.getElementById(paFdno).value; 
		console.log("paFdNoId " + paFdNoId);
		
		var bafdno = 'bafdno' + paFdNoId; 
		console.log("bafdno " + bafdno); 
		
		
		if(!document.getElementById(bafdno)){
			console.log("없음");
			var contentFrm = '<div id="' + 'bafdno' + paFdNoId + '">' 
				           + '<input type="hidden" name ="stono" id="' + 'bstono'+ paFdNoId +'" value="' + document.getElementById(paStono).value + '">' 
						   + '<input type="hidden" name ="fdno" id="' + 'bfdno'+ paFdNoId +'" value="' + document.getElementById(paFdno).value + '">' 
						   + '<input type="hidden" name ="fdprice" id="' + 'bfdprice'+ paFdNoId +'" value="' + document.getElementById(paFdprice).value + '">' 
						   + '<input type="hidden" name ="ordcnt" id="' + 'bfdcnt'+ paFdNoId +'" value="1">' 
						   + '<br>------------------------'
				           + '<br>가게이름: ' + document.getElementById(paStonm).value
				           + '<br>메뉴이름: ' + document.getElementById(paFdnm).value 
				           + '<br>금액: ' + document.getElementById(paFdprice).value 
				           + '<br><span id="'+'bcnt'+ paFdNoId + '">수량: <span>1</span></span>'
				           + '<br>------------------------'
				           + '</div>';
				          
			
			html = contentFrm;
			$('#basketTit').append(html);
			
		} else {
		    console.log("있음");
		    var fdcntId = 'bfdcnt'+ paFdNoId;
			var cntId = 'bcnt' + paFdNoId;
			
		    var cnt = Number(document.getElementById(eval("'"+fdcntId+"'")).value);
		    cnt = cnt + 1;
			
			console.log('cnt '+ cnt); 
			console.log('fdcntId '+fdcntId);
			
			document.getElementById(eval("'"+fdcntId+"'")).value = cnt;
			
			var contentFrm = '<span>' + cnt + '</span>' ;	
			html = contentFrm;
			$(eval("'#"+cntId+" *'")).remove();
			$(eval("'#"+cntId+"'")).append(html);
		}
		
	}
	
	function order(){
		
		
		document.frmParam.action = "/insOrder";
		document.frmParam.submit();
	
		//소켓으로보내기. 
		//sendO();
		//setTimeout(2000);
		
		//alert("dd");
		//alert("before")
		//setTimeout(() => alert("after"), 3000)
		

	}
	
	function returnMessage(message){
	   alert("주문성공"+message);
	}

	function bask_open() {
	  document.getElementById("mySidebar").style.display = "block";
	}
	 
	function bask_close() {
	  document.getElementById("mySidebar").style.display = "none";
	}
	
	function bask_reset() {
		foodCnt = 0;
		html = '';	
	  	$('#basketTit *').remove();
	  	$('#foodcnt *').remove();
	  	
	}
	

</script>
</html>
            