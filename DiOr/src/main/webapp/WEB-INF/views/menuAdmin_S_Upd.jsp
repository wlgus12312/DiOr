<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>레스토랑 수정 완료</title>
</head>

<script language="javascript">
	self.window.alert("레스토랑 수정이 완료 되었습니다.");
	opener.location.reload();
	//location.href="menuAdmin";
	location.href="menuAdmin_S_Pop";
</script>

</html>