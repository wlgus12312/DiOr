<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판 관리 - 음식삭제 완료</title>
</head>

<script language="javascript">
	self.window.alert("음식 삭제가 완료 되었습니다.");
	opener.location.reload();
	
	window.close();	
	window.opener.close();	
	window.opener.parent.location.reload();
</script>

</html>