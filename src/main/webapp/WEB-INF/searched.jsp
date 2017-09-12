<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<p>Songs by Artist: ${searchedArtist}</p>
	<form method="POST" action="/search">
	    <input type="text" name="searchQuery">
	    <input type="submit" value="New Search">
	</form>

    <table class="table">
    		<tr>
    			<th>Name</th>
    			<th>Artist</th>
    			<th>Rating</th>
    			<th>Actions</th>
    		</tr>
    <c:forEach items="${songs}" var="song">
        <tr>        
            <td><c:out value="${song.name}"/></td>
            <td>${song.artist}</td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/songs/delete/${song.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>