<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.io.File, java.util.UUID" %>
<%@ page import="java.awt.image.BufferedImage, javax.imageio.ImageIO" %>
<%@ page import="com.google.zxing.qrcode.QRCodeWriter, com.google.zxing.common.BitMatrix, com.google.zxing.BarcodeFormat, com.google.zxing.client.j2se.MatrixToImageWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String url = request.getParameter("sUrl");
	int nCheck = 1;
	String saveFileName = "";
	
	// url 확인
	//if(url == null || url.equals("") || !url.startsWith("http")) {
	if(url == null || url.equals("")) {
		nCheck = 0;
	} else {
		// 파일 설정
		File path = new File(application.getRealPath("/") + "qrcode/images/");
		saveFileName = UUID.randomUUID().toString().replace("-","");
		if(!path.exists()) path.mkdirs();
		
		// QRCode 생성
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix qrCode = writer.encode(url, BarcodeFormat.QR_CODE, 100, 100);
		
		BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(qrCode);
		
		ImageIO.write(qrImage, "PNG", new File(path, saveFileName + ".png"));
	}
	
%> 


<!DOCTYPE html>
<html>
<head>
  <title>QR코드 생성 완료</title>
</head>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<%
	String qrcode = "";

	File fPath = new File(".");

	if(nCheck == 1) {
		qrcode = request.getContextPath() + "/qrcode/images/" + saveFileName + ".png";
		out.print("<img id='qrimg' src='" + qrcode + "'/><p/>");
		out.print("<input type='text' id='qrtext' value='"+ qrcode +"'><p/>");
	} else {
		out.print("잘못된 URL 입니다.<p/>");
	}
%>

<script type="text/javaScript">	
	var qrText = $("#qrtext").val();
	
	opener.document.getElementById("hCode").value = qrText;
	opener.parent.fnQRRef();
	
	opener.document.getElementById("sFile").value = qrText;
	
	window.close();	
</script>
</html>