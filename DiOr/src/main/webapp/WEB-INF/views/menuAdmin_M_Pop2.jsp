<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판 관리 - 음식수정</title>
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
	function menuDel() {
		if(confirm("[" + document.getElementsByName("mName")[0].value + "] 메뉴를 정말로 삭제하시겠습니까?",0)) {
			//alert(document.getElementsByName("mNo")[0].value);
			window.open("/menuAdmin_M_Del?mNo="+document.getElementsByName("mNo")[0].value
			          , "음식 삭제"
			          , "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=450, height=320, top=30,left=150");
			opener.location.reload();			
		}
	}
</script>

<body>
	<form method="post" action="menuAdmin_M_Upd" enctype="multipart/form-data">
		<table>
		    <th colspan="2" align="left">음식 수정</th>
		    <c:forEach items="${menuList}" var="item" varStatus="stsc">
			<tr>
				<td id="title">식당명</td>
				<td>
					<input type="text" name="sName" maxlength="20" style="background-color:#e2e2e2;" value="${item.stonm}" readonly>               			
				</td>
			</tr>
			<tr>
				<td id="title">메뉴명</td>				
				<td>
					<input type="hidden" name="mNo" value="${item.fdno}">
					<input type="text" name="mName" maxlength="20" value="${item.fdnm}">
				</td>
			</tr>
			<tr>
				<td id="title">가격</td>
				<td>
					<input type="text" name="mPrice" maxlength="20" value="${item.fdprice}">
				</td>
			</tr>
			<tr>
				<td id="title">음식사진</td>
				<td>
					<img alt="" src="data:image/jpg;base64, ${item.vimg}">
					<input type="file" name="mImage" maxlength="20">
				</td>
			</tr>
			<tr>
				<td id="title">메뉴오픈여부</td>
                <td align="center">
                	<c:choose>
                		<c:when test="${item.fdopyn==1}">
		                	오픈<input type="radio" name="mYn" id="opyn" value="1" checked>&nbsp;&nbsp;
		                	미오픈<input type="radio" name="mYn" id="opyn" value="0">                		
                		</c:when>
                		<c:otherwise>
		                	오픈<input type="radio" name="mYn" id="opyn" value="1">&nbsp;&nbsp;
		                	미오픈<input type="radio" name="mYn" id="opyn" value="0" checked>                 		
                		</c:otherwise>
                	</c:choose>
                </td>
			</tr>			
			</c:forEach>			
		</table>
		<input type="submit" class="w3-bar-item w3-black w3-button" value="수정"> 
		<input type="reset" class="w3-bar-item w3-black w3-button" value="취소"> 
		<input type="button" class="w3-bar-item w3-black w3-button" value="삭제" onclick="menuDel()">
	</form>
	
	<hr>
	
	<div style="max-width:1000px;margin:auto;text-align:center;vertical-align:center">
		<input type="button" value="닫기" class="w3-bar-item w3-black w3-button" onclick="javascript:window.close();">
	</div>	
</body>

</html>