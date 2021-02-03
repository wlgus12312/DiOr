<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판 관리</title>
</head>

<body>

<div id="topmenu">
  <div style="max-width:1200px;margin:auto">디지털메뉴판 등록</div>
</div>


<div style="max-width:1200px;margin-top:10px">
	<form method="post" action="/menuAdminStore">
		<table>
		    <th>식당등록</th>
			<tr>
				<td id="title">식당ID</td>
				<td>
					<input type="text" name="storeId" maxlength="20">
				</td>
			</tr>
			<tr>
				<td id="title">식당명ID</td>
				<td>
					<input type="text" name="storeName" maxlength="20">
				</td>
			</tr>
		</table>
		<input type="submit" value="등록"><input type="reset" value="취소" >
	</form>
	<br><br>
	<form method="post" action="/menuAdminMenu">
		<table>
		    <th>메뉴등록</th>
			<tr>
				<td id="title">식당명</td>
				<td>
					<select name="selectStore">
                        <option value="">-- 식당을 선택하세요 --</option>
                        <c:forEach items="${storeList}" var="item" varStatus="stsc">                 
	                 		<option value="${item.stono}">
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
		</table>
		<input type="submit" value="등록"><input type="reset" value="취소" >
	</form>		
</div>
</body>
</html>