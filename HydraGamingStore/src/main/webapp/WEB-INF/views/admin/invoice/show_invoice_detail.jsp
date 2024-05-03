<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
			<td>ProductName</td>
			<td>Amount</td>
			<td>Price</td>
			<td>Total</td>
		</tr>
		<c:forEach var="invoice_detail" items="${invoice_details }">
			<tr>
				<td>${invoice_detail.product.productName }</td>
				<td>${invoice_detail.amount }</td>

				<td>${invoice_detail.price }</td>
				<td>${invoice_detail.total }</td>
				<!--  <td><a href="${pageContext.request.contextPath }/admin/delete/${invoice.invoiceId }">Delete</a></td> -->
			</tr>
		</c:forEach>
	</table>
</body>
</html>