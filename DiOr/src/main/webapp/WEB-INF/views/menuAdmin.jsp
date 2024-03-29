<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판 관리</title>
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
	function storeAdd() {
		window.open("/menuAdmin_S_Pop"
		          , "레스토랑 등록"
		          , "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=450, height=480, top=30,left=150");
	}
	
	function foodAdd() {
		window.open("/menuAdmin_M_Pop"
		          , "음식 등록"
		          , "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=450, height=330, top=30,left=150");
	}
	
	function foodMod(val) {
		window.open("/menuAdmin_M_Pop2?menuId="+val
		          , "음식 수정"
		          , "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=550, height=480, top=30,left=150");		
	}
	
	function qrAdmin() {
		location.href = "/qrAdmin";
	}	
</script>

<body>
<!-- Top menu -->
<div class="w3-top">
  <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
    <div class="w3-center w3-padding-16"> 디지털메뉴판 등록 </div>
  </div>
</div>
<hr>
<div class="w3-main w3-content w3-padding" style="max-width:auto;margin-top:50px">
	<table align="center">
		<tr>
			<td width="305px" align="left"><input type="button" class="w3-bar-item w3-black w3-button" value="레스토랑 추가/수정" onclick="storeAdd();"></td>
			<td width="305px" align="center"><input type="button" class="w3-bar-item w3-black w3-button" value="QR관리" onclick="qrAdmin();"></td>
			<td width="305px" align="right"><input type="button" class="w3-bar-item w3-black w3-button" value="음식 추가" onclick="foodAdd();"></td>
		</tr>
	</table>
	<!-- table Grid-->
	<div class="w3-row-padding w3-padding-16 w3-center" >
	<table class= "w3-table-all w3-cell-row">
		<tr align="center">
			<td width="120px" style="background-color:black; color:white;">레스토랑</td>
			<td width="140px" style="background-color:black; color:white;">음식명</td>
			<td width="80px" style="background-color:black; color:white;">메뉴사진</td>
			<td width="100px" style="background-color:black; color:white;">금액</td>
			<td width="70px" style="background-color:black; color:white;">메뉴수정</td>
			<td width="100px" style="background-color:black; color:white;">메뉴오픈여부</td>
		</tr>
		<c:forEach items="${storeList}" var="item" varStatus="stsc">
		<tr>
			<td align="left">${item.stonm}</td>
			<td align="left">${item.fdnm}</td>
			<td>
				<img alt="" src="data:image/jpg;base64, ${item.vimg}" width="140" height="140">
			</td> 
			<td align="right">${item.fdprice}</td>
			<td align="center"><input type="button" class="w3-bar-item w3-black w3-button" value="수정" name= "menuId" id="${item.fdno}" onclick="foodMod(this.id);"></td>
			<td align="center">${item.fdop_yn}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>
</html>