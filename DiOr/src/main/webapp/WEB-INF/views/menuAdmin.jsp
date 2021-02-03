<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.sql.*" %>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>디지털메뉴판 관리</title>
</head>

<body>
<%
	/*
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//jdbc드라이버
	Connection conn = null; //JSP와 DB연결
	Statement  stmt = null;	//SQL 실행
	ResultSet  rs   = null;	//DB 조회값 저장
	
	Map<Integer, String>  mrs = new HashMap<Integer, String>();
	int lno    = 0;
	String trs = "";
	
	try {
		conn = DriverManager.getConnection("jdbc:sqlserver://192.168.0.210:1433;databaseName=brain_DB","brain","q1w2e3r4!");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from tb_store");
		
		
		while(rs.next()) {
			//out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getInt(3)+"<br>");
			//out.println(rs.getString(2)+"<br>");
			
			trs = rs.getString(2);
			mrs.put(lno, trs);
			lno++;
		}
		
	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		conn.close();
		stmt.close();
		rs.close();
	}
	*/
%>

<div id="topmenu">
  <div style="max-width:1200px;margin:auto">디지털메뉴판 등록</div>
</div>


<div style="max-width:1200px;margin-top:10px">
	<form method="post" action="">
		<table>
		    <th>식당등록</th>
			<tr>
				<td id="title">식당ID</td>
				<td>
					<input type="text" name="id" maxlength="20">
				</td>
			</tr>
			<tr>
				<td id="title">식당명ID</td>
				<td>
					<input type="text" name="name" maxlength="20">
				</td>
			</tr>
		</table>
		<input type="submit" value="등록"><input type="reset" value="취소" >
	</form>
	<br><br>
	<form method="post" action="">
		<table>
		    <th>메뉴등록</th>
			<tr>
				<td id="title">식당명</td>
				<td>
					<select name="store_name">
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
					<input type="text" name="name" maxlength="20">
				</td>
			</tr>
			<tr>
				<td id="title">가격</td>
				<td>
					<input type="text" name="price" maxlength="20">
				</td>
			</tr>			
		</table>
		<input type="submit" value="등록"><input type="reset" value="취소" >
	</form>		
</div>
</body>
</html>