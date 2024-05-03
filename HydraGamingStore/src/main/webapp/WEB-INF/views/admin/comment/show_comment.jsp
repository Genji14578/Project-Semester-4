<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<table border="1" class="table table-dark table-hover">
		<tr>
			<td>Comment Id</td>
			<td>Product Name</td>
			<td>Account Name</td>
			<td>Content</td>
			<td>Status</td>
			<td>Stars</td>
		</tr>
		<c:forEach var="comment" items="${comments }">
			<tr>
				<td>${comment.commentId }</td>
				<td>${comment.product.productName }</td>
				<td>${comment.account.username }</td>
				<td>${comment.content }</td>
				<td>${comment.status ? 'Active' : 'Inactive' }</td>
				<td>${comment.stars }</td>
				<td><a
					href="${pageContext.request.contextPath }/admin/comment/delete_comment/${comment.commentId }">Delete</a>
					| <a
					href="${pageContext.request.contextPath }/admin/comment/active/${comment.commentId }">Active</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>