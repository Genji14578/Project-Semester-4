<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	<s:form method="post" modelAttribute="invoice"
		action="${pageContext.request.contextPath }/admin/invoice/update">
		<table border="1">
			<tr>
				<td>Account Id</td>
				<td><s:select path="account.accountId" items="${accounts }"
						itemLabel="username" itemValue="accountId" /></td>
			</tr>
			<tr>
				<td>Trade type</td>
				<td><s:select path="tradeType" items="${payment }" /></td>
			</tr>
			<tr>
				<td>Date Order</td>
				<td><input name="dateOrder"
					value='<fmt:formatDate pattern="yyyy-MM-dd" value="${invoice.dateOrder }"/>'></td>
			</tr>
			<tr>
				<td>Invoice Total</td>
				<td><s:input path="invoiceTotal" /></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><s:select path="status" items="${statuss }" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>