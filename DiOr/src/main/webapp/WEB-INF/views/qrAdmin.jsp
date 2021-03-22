<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>QR관리</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
  	<link rel="icon" type="image/png" sizes="16x16" href="/images/apple-touch-icon.png">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}
</style>
  	  
</head>

<script type="text/javascript">
	function qrAdd() {
		window.open("/qrAdmin_S_Pop"
		          , "QR등록"
		          , "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=450, height=460, top=30,left=150");
	}
	
	function foodMod(val) {
		window.open("/menuAdmin_M_Pop2?menuId="+val
		          , "음식 수정"
		          , "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=550, height=480, top=30,left=150");		
	}
	
	function menuAdmin() {
		location.href = "/menuAdmin";
	}		
		
</script>

<body>
<!-- Top menu -->
<div class="w3-top">
  <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
    <div class="w3-center w3-padding-16"> QR코드 관리페이지 </div>
  </div>
</div>
<hr>
<div style="max-width:auto;margin-top:50px">
	<table align="center">
		<tr>
			<td width="305px" align="left"><input type="button" class="w3-bar-item w3-black w3-button" value="QR코드 등록" onclick="qrAdd();"></td>
			<td width="305px" align="right"><input type="button" class="w3-bar-item w3-black w3-button" value="메뉴관리" onclick="menuAdmin();"></td>
		</tr>
	</table>
	<!-- table Grid-->
	<div class="w3-row-padding w3-padding-16 w3-center" >
	<table class= "w3-table-all w3-cell-row">
		<tr align="center">
			<td width="80px" style="background-color:black; color:white;">QR구분</td>
			<td width="200px" style="background-color:black; color:white;">QR주소</td>
			<td width="100px" style="background-color:black; color:white;">QR이미지</td>
			<td width="80px" style="background-color:black; color:white;">QR수정</td>
		</tr>
		<c:forEach items="${qrList}" var="item" varStatus="stsc">
		<tr>
			<c:choose>
				<c:when test="${item.qdiv==0}">
					<td align="left">식당</td>
				</c:when>
				<c:otherwise>
					<td align="left">음식</td>
				</c:otherwise>
			</c:choose>
			<td align="left">${item.url}</td>
			<td>
				<!-- <img alt="" src="data:image/jpg;base64, ${item.vimg}" width="100" height="100">  -->
				<img alt="" src="${item.qimg}" width="100" height="100">
			</td> 
			<td align="center"><input type="button" class="w3-bar-item w3-black w3-button" value="수정" name= "menuId" id="${item.qr_seq}" onclick="foodMod(this.id);"></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>
</html>