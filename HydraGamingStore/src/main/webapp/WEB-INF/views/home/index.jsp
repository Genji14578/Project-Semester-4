<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="main">
	<div class="wrap">
		<div class="content-top">
			<div class="cont span_2_of_3">
				<h3>
					HERE IS <span class="red"> OUR NEW PRODUCTS</span>
				</h3>
				<p>Our new product consist of electronics, games, accessories</p>
			</div>
			<div>${err='donothaveaccount'?'err':'' }</div>

			<div class="rsidebar span_1_of_3">
				<img src="images/graph.png" alt="" />
			</div>
			<div class="clear"></div>
		</div>
		<div class="content-middle">
			<div class="our-mission" id="team">
				<div id="ca-container" class="ca-container">
					<div class="ca-wrapper">

						<c:forEach var="product" items="${products1 }">
							<div class="ca-item ca-item-1">
								<div class="ca-item-main">
									<div class="ca-icon">
										<img
											src="${pageContext.request.contextPath }/resources/user/images/${product.photo}"
											height="80%">
									</div>
									<h3>
										<a
											href="${pageContext.request.contextPath }/product/${product.id}"
											style="font-size: 11">${product.productName }</a><a></a>
									</h3>
									<h4>
										<span>${product.detail }</span>
									</h4>
								</div>
							</div>
						</c:forEach>
					</div>




				</div>
				<script type="text/javascript">
					$('#ca-container').contentcarousel();
				</script>
			</div>
		</div>
		<br>
		<div class="content-middle-bottom">
			<div class="our-mission" id="team1">
				<div id="ca-container1" class="ca-container">
					<div class="ca-wrapper">

						<c:forEach var="product" items="${products2 }">
							<div class="ca-item ca-item-1">
								<div class="ca-item-main">
									<div class="ca-icon">
										<img
											src="${pageContext.request.contextPath }/resources/user/images/${product.photo}"
											height="80%">
									</div>
									<h3>
										<a
											href="${pageContext.request.contextPath }/product/${product.id}"
											style="font-size: 10">${product.productName }</a><a></a>
									</h3>
									<h4>
										<span>${product.detail }</span>
									</h4>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>


				<!-- the jScrollPane script -->
				<script type="text/javascript">
					$('#ca-container1').contentcarousel();
				</script>
			</div>
		</div>
		<div class="heading">
			<h3>
				HydraGamingStore<span class="red">is a new Sale Company</span>
			</h3>
		</div>
		<div class="sap_tabs">
			<div id="horizontalTab2">
				<ul class="resp-tabs-list">
					<li>Quality</li>
					<li>Style</li>
					<li>Design</li>

					<div class="clear"></div>
				</ul>
				<div class="resp-tabs-container">
					<div class="tab-1">
						<div class="tab-content">
							<div class="cont span_2_of_3">
								<h3>Quatity of Hydra is the best</h3>
								<p>Our products was bought from many famous resources</p>
							</div>
							<div class="rsidebar span_1_of_3">
								<img src="images/footer-banner.png" alt="" />
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="tab-2">
						<div class="tab-content">
							<div class="cont span_2_of_3">
								<h3>Fresh and Comfotable</h3>
								<p>
									Do not worry about our asmmosphere, because you will always
									feels <a style="color: red">MANIFICENT</a>
								</p>
							</div>
							<div class="rsidebar span_1_of_3">
								<img src="images/footer-banner.png" alt="" />
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="tab-3">
						<div class="tab-content">
							<div class="cont span_2_of_3">
								<h3>Modern and Royal</h3>
								<p>Our designers is on the top of the world so be cool and
									enjoy it</p>
							</div>
							<div class="rsidebar span_1_of_3">
								<img src="images/footer-banner.png" alt="" />
							</div>
							<div class="clear"></div>
						</div>
					</div>

				</div>
			</div>
			<script type="text/javascript">
				$(document).ready(function() {
					$('#horizontalTab2').easyResponsiveTabs({
						type : 'default', //Types: default, vertical, accordion           
						width : 'auto', //auto or any width like 600px
						fit : true
					// 100% fit in a container
					});
				});
			</script>
		</div>
	</div>
</div>
