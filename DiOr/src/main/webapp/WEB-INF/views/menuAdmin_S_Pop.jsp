<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판 관리 - 식당등록</title>
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
	<form method="post" action="menuAdmin_S_Ins">
		<table>
		    <th colspan="2" align="left">레스토랑 등록</th>
			<tr>
				<td id="title">레스토랑명</td>
				<td>
					<input type="text" name="storeName" maxlength="20">
				</td>
			</tr>
		</table>
		<input type="submit" value="등록"> <input type="reset" value="취소">
	</form>
	
	<hr>
	
	<form method="post" action="menuAdmin_S_Upd">
		<table>
		    <th colspan="2" align="left">레스토랑 수정</th>
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
                	운영<input type="radio" name="sYn" id="opyn" value="1">&nbsp;&nbsp;
                	미운영<input type="radio" name="sYn" id="opyn" value="0">
                </td>
			</tr>
			
		</table>
		<input type="submit" value="수정"> <input type="reset" value="취소">
	</form>
	
	<hr>
	
	<div style="max-width:1000px;margin:auto;text-align:center;vertical-align:center">
		<input type="button" value="닫기" onclick="javascript:window.close();">
	</div>
</body>

</html>