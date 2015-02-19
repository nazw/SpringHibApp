<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="getAnnouncements">Manage Announcements</a>


	
			<ul>
				<li>Title : <c:out value="${announcement.announcementTitle}"/></li>
				<li>Body ; <c:out value="${announcement.announcementBody}"/></li>
				<li>Created User : <c:out value="${announcement.systemUser.userId}"/></li>
				<li>Created Date : <fmt:formatDate value="${announcement.createdDate}" type="date" /></li>
				<li>Expiry Date : <fmt:formatDate value="${announcement.expiryDate}" type="date" /></li>
				<li>Status : <c:out value="${announcement.accountStatus}"/></li>
				<li>Category : <c:out value="${announcement.announcementCategory}"/></li>
				<li>Type : <c:out value="${announcement.announcementType}"/></li>		
			</ul>
	

	
	
</body>
</html>