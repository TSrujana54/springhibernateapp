<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${msg }</h1>
<h2>Add Team Details</h2>
<table border="1">
<form method="post" action="addTeam">
	<tr><td>Team Id : <input type="text" name="teamId"/></td></tr>
	<tr><td>Team Name<input type="text" name="teamName"/></td></tr>
	<tr><td>No of Players<input type="text" name="noOfPlayers"/></td></tr>
	<tr><td><input type="submit" value="Add Team"/></td></tr>
	</form>
</table>

<h2>List of Team</h2>

<table border="1">
	<tr>
	<th>Team Id</th>
	<th>Team Name</th>
	<th>No of Players</th>
	</tr>
	<c:forEach items="${teamList}" var="item">
	<tr>
		<td>${item.teamId}</td>
		<td>${item.teamName}</td>
		<td>${item.noOfPlayers}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>