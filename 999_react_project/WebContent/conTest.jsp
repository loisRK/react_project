<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "util.DBUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>conTest</title>
</head>
<body>
	<h2>JSP 직접 DB연동</h2>
	<%
		out.println(DBUtil.getConnection());
	%>
</body>
</html>