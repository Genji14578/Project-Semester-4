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
		<div>
			<p>${msg }</p>
		</div>
		<tr>
			<td>Id</td>
			<td>Account</td>
			<td>Date order</td>
			<td>Trade Type</td>
			<td>Invoice Total</td>
			<td>Status</td>
		</tr>
		<c:forEach var="invoice" items="${invoices.content }">
			<tr>
				<td><a
					href="${pageContext.request.contextPath }/admin/show/detail/${invoice.invoiceId }">${invoice.invoiceId }</a></td>
				<td>${invoice.account.username }</td>
				<td>${invoice.dateOrder }</td>
				<td>${invoice.tradeType }</td>
				<td>${invoice.invoiceTotal }</td>
				<td>${invoice.status }</td>
				<td><a
					href="${pageContext.request.contextPath }/admin/invoice/delete/${invoice.invoiceId }">Delete</a>
					| <a href="${pageContext.request.contextPath }/admin/invoice/update">Update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${!invoices.last && invoices.number > 0 }">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="?page=${invoices.number-1 }" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
			</a></li>
			<li class="page-item"><a class="page-link"
				href="?page=${invoices.number+1 }" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
			</a></li>
		</ul>
	</c:if>
	<c:if test="${invoices.number == 0 }">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="?page=${invoices.number+1 }" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
			</a></li>
		</ul>
	</c:if>
	<c:if test="${invoices.last }">
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="?page=${invoices.number-1 }" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
			</a></li>
		</ul>
	</c:if>
</body>
</html>