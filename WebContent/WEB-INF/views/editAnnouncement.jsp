<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>


	<form:form method="POST" action="updateAnnouncement"
		modelAttribute="announcement">
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="announcementTitle" /></td>
			</tr>
			<tr>
				<td>Body</td>
				<td><form:textarea path="announcementBody" rows="5" cols="20" /></td>
			</tr>
			<tr>
				<td>Expiry Date</td>
				<td><form:input path="expiryDate" placeholder="yyyy-MM-dd" /></td>
			</tr>

			<tr>
				<td>Account Status</td>
				<td><form:select path="accountStatus"
						items="${accountStatusList}">
						<option value="0">---Please Select---</option>
					</form:select></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><form:checkboxes path="announcementCategory"
						items="${categoryList}" /></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><form:radiobuttons path="announcementType" /></td>
			</tr>

			<tr>
				<form:hidden path="announcementId"/>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>