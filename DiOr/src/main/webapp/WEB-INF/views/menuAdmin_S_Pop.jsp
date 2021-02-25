<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판 관리 - 식당등록</title>
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
	function fnChange(val, text) 
	{ 
		if(val != "") { 
			document.getElementsByName("sId")[0].value = val.substr(0,1);
			document.getElementsByName("sName")[0].value = text;
			if(val.substr(2,1) == "1") {
				document.getElementsByName("sYn")[0].checked = true;
			} else {
				document.getElementsByName("sYn")[1].checked = true;
			} 
		}
	}
</script>

<body>
<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:10px">
	<form method="post" action="menuAdmin_S_Ins">
		<table class="w3-table-all">
			<tr><th colspan="2" align="left" style="background-color:black; color:white;">레스토랑 등록</th></tr>
			<tr>
				<td id="title">레스토랑명</td>
				<td>
					<input type="text" name="storeName" maxlength="20">
				</td>
			</tr>
		</table>
		<input type="reset" class="w3-bar-item w3-black w3-button w3-right" value="취소">
		<input type="submit" class="w3-bar-item w3-black w3-button w3-right" value="등록">
	</form>
	
	<br><br>
	
	<form method="post" action="menuAdmin_S_Upd">
		<table class="w3-table-all">
		    <tr><th colspan="2" align="left" style="background-color:black; color:white;">레스토랑 수정</th></tr>
			<tr>
				<td id="title">식당목록</td>
				<td>
					<select name="sList" onchange="fnChange(this.value, this.options[this.selectedIndex].text)">
                        <option value="">-- 식당을 선택하세요 --</option>
                        <c:forEach items="${storeList}" var="item" varStatus="stsc">                 
	                 		<option value="${item.stono},${item.stoopyn}">
	                 			${item.stonm}
	                        </option>
                        </c:forEach>
                    </select>                    			
				</td>
			</tr>		    
			<tr>
				<td id="title">식당ID</td>
				<td>
					<input type="text" name="sId" maxlength="20" style="background-color:#e2e2e2;" readonly>
				</td>
			</tr>
			<tr>
				<td id="title">식당명</td>
				<td>
					<input type="text" name="sName" maxlength="20">
				</td>
			</tr>

			<tr>
				<td id="title">운영여부</td>
                <td align="center">
                	운영 &nbsp;&nbsp;<input type="radio" name="sYn" id="opyn" value="1" class="w3-radio">&nbsp;&nbsp;
                	미운영 &nbsp; <input type="radio" name="sYn" id="opyn" value="0" class="w3-radio">
                </td>
			</tr>
		</table>
		<input type="reset" class="w3-bar-item w3-black w3-button w3-right" value="취소">
		<input type="submit" class="w3-bar-item w3-black w3-button w3-right" value="수정">
	</form>
	
	<br><br>
	
	<div style="max-width:1000px;margin:auto;text-align:center;vertical-align:center">
		<input type="button" class="w3-bar-item w3-black w3-button" value="닫기" onclick="javascript:window.close();">
	</div>
</div>
</body>

</html>