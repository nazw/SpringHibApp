<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="createAnnouncement">Add Announcement</a>
<a href="dashBoard">dashBoard</a>
	<table align="left" border="1">
		<tr>
			<th>Title</th>
			<th>Status</th>		
			<th>type</th>
			<th>view</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${announcementsList}" var="announcement">
			<tr>
				<td><c:out value="${announcement.announcementTitle}"/></td>
				<td><c:out value="${announcement.accountStatus}"/></td>			
				<td><c:out value="${announcement.announcementType}"/></td>
				<td><a href="viewAnnouncement?id=${announcement.announcementId}">View</a></td>
				<td><a href="editAnnouncement?id=${announcement.announcementId}">Edit</a></td>
				<td><a href="deleteAnnouncement?id=${announcement.announcementId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>