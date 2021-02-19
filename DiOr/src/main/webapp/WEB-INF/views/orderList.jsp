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
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}

</style>
</head>

<body>
<!-- Top menu -->
<div class="w3-top">
  <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
    <div class="w3-center w3-padding-16">디지털메뉴판</div>
    <div id="tableno"></div>
    <form id="frmParam" name="frmParam" method="get" enctype="multipart/form-data" contentType="application/json">
		<input type="hidden" id="ordno" name="ordno" value="${param.ordno}">
	</form>
  </div>
</div>

<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">
   <!-- First Photo Grid-->
   <div class="w3-row-padding w3-padding-16 w3-center" >
   	   <table class= "w3-table-all w3-cell-row">
	   <c:forEach items="${orderList}" var="item" varStatus="stsc">
		           	<tr>
		           		<td> ${item.ordno} </td>
		            	<td> ${item.ords} </td>
		            	<td> ${item.stono} </td>
		            	<td> ${item.stonm} </td>
		            	<td> ${item.fdno} </td>
		            	<td> ${item.fdnm} </td>
		            	<td> ${item.ordcnt} </td>
		            	<td> ${item.ordstsc} </td>
		            	<td> ${item.ordstnm} </td>
		            	<td> ${item.rg_dt} </td>
		            	<td> ${item.ud_dt} </td>
		           </tr>
	           
	           <input type="hidden" id="stono${stsc.index}" name="stono" value="${item.stono}">
	           <input type="hidden" id="stonm${stsc.index}" name="stonm" value="${item.stonm}">
	           <input type="hidden" id="fdno${stsc.index}" name="fdno" value="${item.fdno}">
	           <input type="hidden" id="fdnm${stsc.index}" name="fdnm" value="${item.fdnm}">
	           <input type="hidden" id="fdprice${stsc.index}" name="fdprice" value="${item.fdprice}">
	      </c:forEach> 
	    </table> 
   </div>     
</div>
</body>
<script>

window.onload = function(){
	//document.frmParam.action = "/orderList";
	//document.frmParam.submit();
}	

</script>
</html>