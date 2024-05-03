<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/resources/user/css/main.css"
	rel="stylesheet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="pagedListHolder" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/products" var="pagedLink">
	<c:param name="p" value="~" />
</c:url>
<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />


<div class="product-main">
	<div class="wrap">
		<br>
		<div class="product-top">
			<div>
				<h3 style="text-align: center">Category</h3>
				<div class="services-box">
					<div class="col_1_of_1 span_1_of_1">

						<p class="text1" style="text-align: center;">
							<a href="${pageContext.request.contextPath }/products/1/page/0">Electronic</a>
						</p>
					</div>
					<div class="col_1_of_1 span_1_of_1">

						<p class="text1" style="text-align: center;">
							<a href="${pageContext.request.contextPath }/products/2/page/0">Game</a>
						</p>
					</div>
					<div class="col_1_of_1 span_1_of_1">

						<p class="text1" style="text-align: center;">
							<a href="${pageContext.request.contextPath }/products/3/page/0">Accessories</a>
						</p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div style="margin-top: 50px">
				<c:forEach var="product" items="${pagedListHolder.pageList }">
					<div class="grid_1_of_4 images_1_of_4" style="margin-top: 30px">
						<a href=""><img
							src="${pageContext.request.contextPath }/resources/user/images/${product.photo}"
							height="100vh" alt=""><span class="zoom-icon"></span> </a>
						<h4>${product.productName }</h4>
						<p>${product.detail }</p>
						<a
							href="${pageContext.request.contextPath }/product/${product.id}"
							class="link">Read More</a>
					</div>
				</c:forEach>
			</div>

			<div class="clear"></div>

		</div>
		<div class="pagination">
			<div>
				<a
					href="${pageContext.request.contextPath }/products/${cate }/page/${back}"><img
					alt=""
					src="${pageContext.request.contextPath }/resources/user/images/back.png"></a>
				<a
					href="${pageContext.request.contextPath }/products/${cate }/page/${next}"><img
					alt=""
					src="${pageContext.request.contextPath }/resources/user/images/next.png"></a>
			</div>

		</div>
	</div>
</div>
<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />
