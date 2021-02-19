<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판 관리 - 음식등록</title>
</head>

<body>
	<form method="post" action="menuAdmin_M_Ins">
		<table>
		    <th colspan="2" align="left">음식 등록</th>
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
			<tr>
				<td id="title">음식사진</td>
				<td>
					<input type="file" name="menuImage" maxlength="20">
				</td>
			</tr>			
		</table>
		<input type="submit" value="등록"> <input type="reset" value="취소">
	</form>
	
	<hr>
	
	<div style="max-width:1000px;margin:auto;text-align:center;vertical-align:center">
		<input type="button" value="닫기" onclick="javascript:window.close();">
	</div>	
</body>

</html>