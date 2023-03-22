<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>Product</title>

<body>
	<!-- Breadcrumb Start -->
	<div class="breadcrumb-wrap">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Products</a></li>
				<li class="breadcrumb-item active">Product List</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Product List Start -->
	<div class="product-view">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-8">
					<div class="row">
						<div class="col-md-12">
							<div class="product-view-top">
								<div class="row">
									<div class="col-md-4">
										<div class="product-search">
											<input type="email" value="Search">
											<button>
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
									<div class="col-md-4">
										<div class="product-short">
											<div class="dropdown">
												<div class="dropdown-toggle" data-toggle="dropdown">Product
													short by</div>
												<div class="dropdown-menu dropdown-menu-right">
													<a href="#" class="dropdown-item">Newest</a> <a href="#"
														class="dropdown-item">Popular</a> <a href="#"
														class="dropdown-item">Most sale</a>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="product-price-range">
											<div class="dropdown">
												<div class="dropdown-toggle" data-toggle="dropdown">Product
													price range</div>
												<div class="dropdown-menu dropdown-menu-right">
													<a href="#" class="dropdown-item">$0 to $50</a> <a href="#"
														class="dropdown-item">$51 to $100</a> <a href="#"
														class="dropdown-item">$101 to $150</a> <a href="#"
														class="dropdown-item">$151 to $200</a> <a href="#"
														class="dropdown-item">$201 to $250</a> <a href="#"
														class="dropdown-item">$251 to $300</a> <a href="#"
														class="dropdown-item">$301 to $350</a> <a href="#"
														class="dropdown-item">$351 to $400</a> <a href="#"
														class="dropdown-item">$401 to $450</a> <a href="#"
														class="dropdown-item">$451 to $500</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<c:forEach var="item" items="${ allProductById }">
							<div class="col-md-4">
								<div class="product-item">
									<div class="product-title">
										<a href="#">${ item.name }</a>
										<div class="ratting">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<div class="product-image">
										<a href="product-detail.html"> <img
											src="<c:url value="/assets/UserTemplate/img/Products/${ item.img } "  /> "
											width="100%" height="100%" alt="Product Image">
										</a>
										<div class="product-action">
											<a href="<c:url value="/AddCart/${ item.id_Product } "/>"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
												class="fa fa-heart"></i></a> <a href="<c:url value="/ProductDetail/${ item.id_Product} "  />"><i
												class="fa fa-search"></i></a>
										</div>
									</div>
									<div class="product-price">
										<h3>
											<span> <fmt:formatNumber type="number"
													maxIntegerDigits="9" value=" ${ item.price }" /> VND
											</span>
										</h3>
										<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
											Now</a>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>

					<!-- Pagination Start -->
					<div class="col-md-12">
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<c:forEach var="item" begin="1"
									end="${ paginateInfo.totalPage }" varStatus="loop">
									<li class="page-item active"><a
										href='<c:url value = "/product/${ idCategory }/${ loop.index }"/>'
										class="page-link">${ loop.index }</a></li>


									<li class="page-item active"><c:if
											test="${ (loop.index) == paginateInfo.currentPage } }">
											<a
												href='<c:url value = "/product/${ idCategory }/${ loop.index }"/>'
												class="page-link">${ loop.index }</a>



										</c:if> <c:if test="${ (loop.index) != paginateInfo.currentPage } }">
											<a
												href='<c:url value = "/product/${ idCategory }/${ loop.index }"/>'>${ loop.index }</a>
										</c:if></li>






								</c:forEach>
							</ul>
						</nav>
					</div>


					<!-- Pagination Start -->
				</div>

				<!-- Side Bar Start -->
				<div class="col-lg-4 sidebar">
					<div class="sidebar-widget category">
						<h2 class="title">Category</h2>
						<nav class="navbar bg-light">
							<ul class="navbar-nav">
								<c:forEach var="item" items="${ dataCategory }">
									<li class="nav-item"><a class="nav-link"
										href='<c:url value = "/product/${ item.id_Cat }"/>'><i
											class="fa fa-adjust" aria-hidden="true"></i>${ item.name }</a></li>
								</c:forEach>
							</ul>
						</nav>
					</div>

					<div class="sidebar-widget widget-slider">
						<div class="sidebar-slider normal-slider">

							<c:forEach var="item" items="${ productSale }">
								<div class="col-lg-3">
									<div class="product-item">
										<div class="product-title">
											<a href="#">${ item.name }</a>
											<div class="ratting">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i>
											</div>
										</div>
										<div class="product-image">
											<a href="product-detail.html"> <img
												src="<c:url value="/assets/UserTemplate/img/Products/${ item.img } "  /> "
												alt="Product Image">
											</a>
											<div class="product-action">
												<a href="<c:url value="/AddCart/${ item.id_Product } "/>"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
													class="fa fa-heart"></i></a> <a href="<c:url value="/ProductDetail/${ item.id_Product} "  />"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
										<div class="product-price">
											<h3>
												<span> <fmt:formatNumber type="number"
														maxIntegerDigits="9" value=" ${ item.price }" /> VND
												</span> <span style="color: yellow;">${ item.sale }%</span>
											</h3>
											<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
												Now</a>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Product List End -->

	<!-- Brand Start -->
	<div class="brand">
		<div class="container-fluid">
			<div class="brand-slider">
				<div class="brand-item">
					<img src="img/brand-1.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-2.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-3.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-4.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-5.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-6.png" alt="">
				</div>
			</div>
		</div>
	</div>
	<!-- Brand End -->
</body>
