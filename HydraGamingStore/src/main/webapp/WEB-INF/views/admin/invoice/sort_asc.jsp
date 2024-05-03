<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" href="${pageContext.request.contextPath }/resources/admin/plugins/jquery/jquery.js"></script>
<script type="text/javascript" href="${pageContext.request.contextPath }/resources/admin/plugins/jquery/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/admin/sweetalert2-theme-bootstrap-4/bootstrap-4.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/admin/sweetalert2-theme-bootstrap-4/bootstrap-4.css" />
</head>
<body>
	<table border="1" class="table table-dark table-hover">
		<div class="alert alert-success" role="alert">
			<p>${msg }</p>
		</div>
		<tr>
			<td>Id</td>
			<td>Date order</td>
			<td>Trade Type</td>
			<td>Invoice Total</td>
			<td>Status</td>
		</tr>
		<c:forEach var="invoice" items="${invoices }">
			<tr>
				<td>${invoice.invoiceId }</td>
				<td>${invoice.dateOrder }</td>
				<td>${invoice.tradeType }</td>
				<td>${invoice.invoiceTotal }</td>
				<td>${invoice.status }</td>
				<td><a href="${pageContext.request.contextPath }/admin/invoice/delete/${invoice.invoiceId }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>