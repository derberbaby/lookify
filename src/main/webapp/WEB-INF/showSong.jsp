<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
	<p>Title: <c:out value="${song.name}"/></p>
    <p>Artist: <c:out value="${song.artist}"/></p>
    <p>Rating (1-10): <c:out value="${song.rating}"/></p>
    <a href="songs/delete/${song.id}">Delete</a>

</body>
</html>