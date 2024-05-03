<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="${pageContext.request.contextPath }/resources/user/js/review.js"></script>

<div class="product-main">
	<div class="wrap">
		<div class="single">
			<div class="cont span_3_of_bottom1">
				<div class="grid images_3_of_2">
					<div id="container">
						<div id="products_example">
							<img alt=""
								src="${pageContext.request.contextPath }/resources/user/images/${product.photo}">
						</div>
					</div>
				</div>
				<div class="desc1 span_3_of_2">
					<h3>
						${product.productName }<span class="smallText"></span>
					</h3>
					<div class="std">
						<p>${product.detail }</p>
					</div>
					<p class="stock">
						Availability: <span>${product.amount }</span>
					</p>

					<div class="price1" style="height: 19px;">
						<span class="reducedfrom">$${product.price }</span>
					</div>
					<div class="row-product1">

						<div class="clear"></div>
					</div>
					<div class="row-product">
						<p class="no-rating">
						<div id="reviewContainer">
							<a id="reviewButton"><img
								src="${pageContext.request.contextPath }/resources/user/images/plus.png"
								alt="" /><span>Review this Product</span></a>
							<div id="reviewBox">
								<form id="reviewForm"
									action="${pageContext.request.contextPath }/product/review/product_id=${product.id}"
									method="get">
									<div>
										<span><label>Content</label></span> <span><input
											name="content" type="text" class="textbox"></span>
									</div>
									<div>
										<span><label>Star</label></span> <span><input
											name="star" type="number" class="textbox" min="1" max="5"></span>
									</div>
									<div>
										<span><input type="submit" value="Review"></span>

									</div>
								</form>
							</div>
						</div>
						</p>

						<p class="email-friend">
							<a
								href="${pageContext.request.contextPath }/cart/index?id=${product.id}">ADD
								to Cart</a>
						</p>
						<div class="clear"></div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="single-bottom1">
					<h6>Details</h6>
					<p class="prod-desc">${product.detail }</p>
				</div>

				<div class="single-bottom2">
					<h6>Comment</h6>
					<form action="">

						<c:forEach var="comment" items="${comments }">


							<table border="1" bordercolor="black">
								<tr>
									<td><img alt=""
										src="${pageContext.request.contextPath }/resources/user/images/avatar.png"></td>
									<td><p class="" style="margin: 5px 20px 10px 5px">${comment.account.username }</p></td>
									<td><p class="prod-desc">${comment.content }</p></td>
								</tr>
							</table>
					</form>

					<div style="border-color: black;"></div>
					</c:forEach>


				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
