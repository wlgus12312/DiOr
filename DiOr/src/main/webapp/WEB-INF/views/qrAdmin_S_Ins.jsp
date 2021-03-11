<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>QR코드 등록완료</title>
</head>

<script>
	self.window.alert("QR코드 등록이 완료 되었습니다.");
	opener.location.reload();
	window.close();
</script>
</html>