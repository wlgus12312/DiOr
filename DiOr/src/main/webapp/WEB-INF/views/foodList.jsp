<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
  <title>디지털주문 리스트</title>
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
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}

</style>
</head>

<body>

<!-- Top menu -->
<%@ include file = "start.jsp" %>

<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">
   <div class="w3-row-padding w3-padding-16 w3-center">
       <table id="conversation" class="w3-table-all">
           <thead style="">               
               <tr>
                   <th style="background-color:black; color:white;">주문번호</th>
                   <!-- <th style="background-color:black; color:white;">메뉴번호</th>  -->
                   <th style="background-color:black; color:white;">주문수량</th>
                   <th style="background-color:black; color:white;">메뉴</th>
                   <th style="background-color:black; color:white;">시작</th>
                   <th style="background-color:black; color:white;">완료</th>
               </tr>                 
           </thead>
           <tbody id="orderList">
           <c:forEach items="${storeList}" var="item" varStatus="stsc">
			   <tr>
				   <td align="center">${item.ordno}</td>
				   <!-- <td align="center">${item.fdno}</td>  --> 
				   <td align="center">${item.ordcnt}</td>
				   <td align="center">${item.fdnm}</td>
				   <td align="center">${item.rg_dt}</td>
				   <td align="center">${item.ud_dt}</td>
			   </tr>           
           </c:forEach>        
           
           </tbody>
       </table>
   </div>     
</div>
</body>
</html>