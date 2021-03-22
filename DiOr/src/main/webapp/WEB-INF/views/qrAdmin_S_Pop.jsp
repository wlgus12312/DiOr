<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>QR관리 - QR등록</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
  	<link rel="icon" type="image/png" sizes="16x16" href="/images/apple-touch-icon.png">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
.w3-bar-block .w3-bar-item {padding:20px}
</style>  
</head>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javaScript">
    function fnQRCreate()
    {
    	var url = "/qrAdmin_S_Code?sUrl=";
    	var content = document.getElementsByName("sUrl")[0].value;
    	//alert(url + content);    	
    	
    	window.open(url + content
		          , "QR코드 생성"
		          , "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=550, height=480, top=30,left=150");
    	
    	//location.href = url + content;    	
    }  
    
    function fnQRRef() {
    	 var content = $("#hCode").val();
    	 //alert(content);
         $("#sImg").attr("src", content);
    }
</script>

<body>
<!-- !PAGE CONTENT! -->
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:10px">
	<!-- <form method="post" action="menuAdmin_S_Ins">  -->	
	
	<form method="post" action="qrAdmin_S_Ins" enctype="multipart/form-data">
		<table class="w3-table-all">
			<tr><th colspan="2" align="left" style="background-color:black; color:white;">QR등록</th></tr>
			<tr>
				<td id="title">QR구분</td>
				<td align="center">
                	식당 &nbsp;&nbsp;<input type="radio" name="sYn" id="opyn" value="0" class="w3-radio">&nbsp;&nbsp;
                	음식 &nbsp; <input type="radio" name="sYn" id="opyn" value="1" class="w3-radio">
                </td>
			</tr>
			<tr>
				<td id="title">QR코드(URL)</td>
				<td>
					<input type="text" id="sUrl" name="sUrl" maxlength="20">
					<input type="button" id="execute" value="QR생성" onclick="fnQRCreate()">
				</td>
			</tr>
			<tr>
				<td id="title">QR이미지</td>
				<td>
					<!-- <img alt="" id="sImg" src="data:image/jpg;base64, ${item.vimg}" width="100" height="100">  -->
					<!-- <img id="sImg" style="display:none" onload="this.style.display='block'"/>  -->
					<img id="sImg" alt="" width="100" height="100"/>
					<input type="hidden" id="hCode" name="hCode">
					<br><br><input type="file" id="sFile" name="sFile" value="파일">
				</td>
			</tr>
		</table>
		<input type="reset" class="w3-bar-item w3-black w3-button w3-right" value="취소">
		<input type="submit" class="w3-bar-item w3-black w3-button w3-right" value="등록">
	</form>
	
	<br><br>
	
	<div style="max-width:1000px;margin:auto;text-align:center;vertical-align:center">
		<input type="button" class="w3-bar-item w3-black w3-button" value="닫기" onclick="javascript:window.close();">
	</div>
</div>
</body>

</html>