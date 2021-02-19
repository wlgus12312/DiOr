<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>레스토랑 등록 완료</title>
</head>

<script>
	self.window.alert("레스토랑 등록이 완료 되었습니다.");
	opener.location.reload();
	//window.close();
	location.href="menuAdmin_S_Pop";
</script>
</html>