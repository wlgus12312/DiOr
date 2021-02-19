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
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}
</style>
</head>
<script>
var list1 = new Array();

<c:forEach items="${menuList}" var="item1">
list1.push("${item1.stono}");
list1.push("${item1.stonm}");
list1.push("${item1.fdnm}");
</c:forEach>

	for (var i = 0; i < list1.length; i++) {
	    //alert(list1[i]);
	}
     
//	var str = "${testList[0].stonm}";
//	console.log(str);
//	$("#stonm").append(str);

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


</script>
<body>
<!-- Sidebar (hidden by default) -->
<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:40%;min-width:300px" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()"
  class="w3-bar-item w3-button">Close Menu</a>
  <a href="#food" onclick="w3_close()" class="w3-bar-item w3-button">Food</a>
  <a href="#about" onclick="w3_close()" class="w3-bar-item w3-button">About</a>
</nav>
<!-- Top menu -->
<div class="w3-top">
  <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
    <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div>
    <div class="w3-right w3-padding-16">Mail</div>
    <div class="w3-center w3-padding-16">디지털메뉴판</div>
  </div>
</div>

<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">
	<!-- First Photo Grid-->
	<c:forEach items="${menuList}" var="item" varStatus="stsc">
	
		<div class="w3-row-padding w3-padding-16 w3-center" id="row${stsc.index}">
		  <div class="w3-quarter">
		  ${item.stonm}
		    <img src="/images/pork_cutlet.png" alt="Sandwich" style="width:100%">
		    <h3>${item.fdnm}</h3>
		    <p>${item.fdprice} 원</p>
		  </div>
            <input type="hidden" id="stono" value="${item.stono}">
			<%-- <input type="button" id="stonm" value="${item.stonm}"> --%>
			<input type="hidden" id="stono" value="${item.fdnm}">
			<input type="hidden" id="stono" value="${item.fdprice}">
			<p>
		</div>
	 </c:forEach>	
	  
		  <!-- 
		  <div class="w3-quarter">
		    <img src="/w3images/steak.jpg" alt="Steak" style="width:100%">
		    <h3>Let Me Tell You About This Steak</h3>
		    <p>Once again, some random text to lorem lorem lorem lorem ipsum text praesent tincidunt ipsum lipsum.</p>
		  </div>
		  <div class="w3-quarter">
		    <img src="/w3images/cherries.jpg" alt="Cherries" style="width:100%">
		    <h3>Cherries, interrupted</h3>
		    <p>Lorem ipsum text praesent tincidunt ipsum lipsum.</p>
		    <p>What else?</p>
		  </div>
		  <div class="w3-quarter">
		    <img src="/w3images/wine.jpg" alt="Pasta and Wine" style="width:100%">
		    <h3>Once Again, Robust Wine and Vegetable Pasta</h3>
		    <p>Lorem ipsum text praesent tincidunt ipsum lipsum.</p>
		  </div> -->
		
	  
</div>
</body>
</html>