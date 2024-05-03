<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
		<div class="alert alert-success" role="alert">
			<p>${msg }</p>
		</div>
		<tr>
			<td>Id</td>
			<td>Username</td>
			<td>Full Name</td>
			<td>Gender</td>
			<td>Birth Day</td>
			<td>Date Created</td>
			<td>Point</td>
		</tr>
		<c:forEach var="account" items="${accounts.content }">
			<tr>
				<td>${account.accountId }</td>
				<td>${account.username }</td>
				<td>${account.fullname }</td>
				<td>${account.gender }</td>
				<td>${account.birthday }</td>
				<td>${account.dateCreated }</td>
				<td>${account.point }</td>
				<td><a
					href="${pageContext.request.contextPath }/super_admin/delete/${account.accountId }">Delete</a>
					| <a href="${pageContext.request.contextPath }/super_admin/add">Add</a>
					| <a href="${pageContext.request.contextPath }/super_admin/update">Update</a>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${!accounts.last && accounts.number > 0 }">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="?page=${accounts.number-1 }" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
			</a></li>
			<li class="page-item"><a class="page-link"
				href="?page=${accounts.number+1 }" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
			</a></li>
		</ul>
	</c:if>
	<c:if test="${accounts.number == 0 }">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="?page=${accounts.number+1 }" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
			</a></li>
		</ul>
	</c:if>
	<c:if test="${accounts.last }">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="?page=${accounts.number-1 }" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
			</a></li>
		</ul>
	</c:if>
</body>
</html>