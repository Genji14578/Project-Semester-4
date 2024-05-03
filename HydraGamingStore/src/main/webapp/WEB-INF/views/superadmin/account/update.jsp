<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript"
	href="${pageContext.request.contextPath }/resources/admin/plugins/jquery/jquery.js"></script>
<script type="text/javascript"
	href="${pageContext.request.contextPath }/resources/admin/plugins/jquery/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/sweetalert2-theme-bootstrap-4/bootstrap-4.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/sweetalert2-theme-bootstrap-4/bootstrap-4.css" />
</head>
<body>
	<s:form method="post" modelAttribute="account"
		action="${pageContext.request.contextPath }/super_admin/add">
		<table border="1">
			<tr>
				<td>Account Id</td>
				<td><s:input path="accountId" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><s:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:input path="password" /></td>
			</tr>
			<tr>
				<td>Full Name</td>
				<td><s:input path="fullname" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><s:select path="gender" items="${genders }" /></td>
			</tr>
			<tr>
				<td>Birth Day</td>
				<td><input name="birthday"
					value='<fmt:formatDate pattern="yyyy-MM-dd" value="${account.birthday }"/>'></td>
			</tr>
			<tr>
				<td>Date Created</td>
				<td><input name="dateCreated"
					value='<fmt:formatDate pattern="yyyy-MM-dd" value="${account.dateCreated }"/>'></td>
			</tr>
			<tr>
				<td>Point</td>
				<td><s:input path="point" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>