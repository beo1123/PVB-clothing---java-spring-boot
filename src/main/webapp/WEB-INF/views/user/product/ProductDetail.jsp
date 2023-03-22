<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<head>
<meta charset="UTF-8">
<title>Product Detail</title>
</head>
<body>

	<!-- Breadcrumb Start -->
	<div class="breadcrumb-wrap">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Products</a></li>
				<li class="breadcrumb-item active">Product Detail</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Product Detail Start -->
	<div class="product-detail">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-8">
					<div class="product-detail-top">
						<div class="row align-items-center">
							<div class="col-md-5">
								<div class="product-slider-single normal-slider">
									<img
										src="<c:url value="/assets/UserTemplate/img/Products/${ productDetail.img } "  /> "
										alt="Product Image">
								</div>

							</div>
							<div class="col-md-7">
								<div class="product-content">
									<div class="title">
										<h2>${productDetail.name}</h2>
									</div>
									<div class="ratting">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i>
									</div>
									<div class="price">
										<h4>Price:</h4>
										<p>
											<c:if test="${ productDetail.sale != 0 }">

												<fmt:formatNumber type="number" maxIntegerDigits="9"
													value=" ${ (productDetail.price) - ((productDetail.price) * (productDetail.sale/100)) }" /> VND
													<span><fmt:formatNumber type="number"
														maxIntegerDigits="9" value=" ${ productDetail.price }" />
													VND</span>
											</c:if>

											<c:if test="${ productDetail.sale == 0 }">

												<fmt:formatNumber type="number" maxIntegerDigits="9"
													value=" ${ productDetail.price }" /> VND
											</c:if>

										</p>

										<br>
										<h4 style="color: red;">Sale: ${ productDetail.sale }%</h4>
									</div>									
									<div class="p-size">
										<h4>Size:</h4>
										<div class="btn-group btn-group-sm">
											<button type="button" class="btn">S</button>
											<button type="button" class="btn">M</button>
											<button type="button" class="btn">L</button>
											<button type="button" class="btn">XL</button>
										</div>
									</div>
									<div class="p-color">
										<h4>Color:</h4>
										<div class="btn-group btn-group-sm">
											<button type="button" class="btn">White</button>
											<button type="button" class="btn">Black</button>
											<button type="button" class="btn">Blue</button>
										</div>
									</div>
									<div class="action">
										<a class="btn" href="<c:url value="/AddCart/${ productDetail.id_Product } "/>"><i class="fa fa-shopping-cart"></i>Add
											to Cart</a> <a class="btn" href="#"><i
											class="fa fa-shopping-bag"></i>Buy Now</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row product-detail-bottom">
						<div class="col-lg-12">
							<ul class="nav nav-pills nav-justified">
								<li class="nav-item"><a class="nav-link active"
									data-toggle="pill" href="#description">Description</a></li>

							</ul>

							<div class="tab-content">
								<div id="description" class="container tab-pane active">
									<h4>${ productDetail.name }</h4>
									<p>${ productDetail.description }</p>
								</div>


							</div>
						</div>
					</div>

					<div class="product">
						<div class="section-header">
							<h1>Related Products</h1>
						</div>

						<div
							class="row align-items-center product-slider product-slider-3">
							<c:forEach var="item" items="${ productByCat }">
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
												width="100%" height="100%" alt="Product Image">
											</a>
											<div class="product-action">
												<a href="<c:url value="/AddCart/${ item.id_Product } "/>"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
													class="fa fa-heart"></i></a> <a
													href="<c:url value="/ProductDetail/${ item.id_Product} "  />"><i
													class="fa fa-search"></i></a>
											</div>
										</div>
										<div class="product-price">
											<h3>
												<span> <fmt:formatNumber type="number"
														maxIntegerDigits="9" value=" ${ item.price }" /> VND
												</span> <span style="color: yellow;">${ item.sale }% </span>
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
				<!-- Side Bar End -->
			</div>
		</div>
	</div>
	<!-- Product Detail End -->

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