<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판 관리 - 음식등록</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
  	<link rel="icon" type="image/png" sizes="16x16" href="/images/apple-touch-icon.png">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}
</style>
</head>

<body>
<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:10px">
	<form method="post" action="menuAdmin_M_Ins" enctype="multipart/form-data">
		<table class="w3-table-all">
		    <tr><th colspan="2" align="left" style="background-color:black; color:white;">음식 등록</th></tr>
			<tr>
				<td id="title">식당명</td>
				<td>
					<select name="selectStore">
                        <c:forEach items="${storeList}" var="item" varStatus="stsc">                 
	                 		<option value="${item.stono}" selected="selected">
	                 			${item.stonm}
	                        </option>
                        </c:forEach>
                    </select>                    			
				</td>
			</tr>
			<tr>
				<td id="title">메뉴명</td>
				<td>
					<input type="text" name="menuName" maxlength="20">
				</td>
			</tr>
			<tr>
				<td id="title">가격</td>
				<td>
					<input type="text" name="menuPrice" maxlength="20">
				</td>
			</tr>
			<tr>
				<td id="title">음식사진</td>
				<td>
					<input type="file" name="menuImage">
				</td>
			</tr>			
		</table>
		<input type="reset" class="w3-bar-item w3-black w3-button w3-right" value="취소">
		<input type="submit" class="w3-bar-item w3-black w3-button w3-right" value="등록">
	</form>
	
	<br><br>
	
	<div style="max-width:1000px;margin:auto;text-align:center;vertical-align:center">
		<input type="button" value="닫기" class="w3-bar-item w3-black w3-button" onclick="javascript:window.close();">
	</div>	
</div>
</body>

</html>