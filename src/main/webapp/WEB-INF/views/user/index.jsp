<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>Home</title>
<body>
	<!-- Main Slider Start -->
	<div class="header">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<nav class="navbar bg-light">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link" href="<c:url value = "/Home"/>"><i
									class="fa fa-home"></i>Home</a></li>
							<c:forEach var="item" items="${ category }">
								<li class="nav-item"><a class="nav-link"
									href='<c:url value = "/product/${ item.id_Cat }"/>'><i class="fa fa-adjust"
										aria-hidden="true"></i>${ item.name }</a></li>
							</c:forEach>


						</ul>
					</nav>
				</div>
				<div class="col-md-6">
					<div class="header-slider normal-slider">
						<c:forEach var="item" items="${ slides }">
							<div class="header-slider-item">
								<img
									src="<c:url value ="/assets/UserTemplate/img/Slides/${ item.img }" />"
									alt="Slider Image" width="100%" height="400px" />
								<div class="header-slider-caption">
									<p>${ item.caption }</p>
									<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Shop
										Now</a>
								</div>
							</div>
						</c:forEach>



					</div>
				</div>
				<div class="col-md-3">
					<div class="header-img">
						<div class="img-item">
							<img
								src=" <c:url value ="/assets/UserTemplate/img/category-1.jpg" />" />
							<a class="img-text" href="">
								<p>Some text goes here that describes the image</p>
							</a>
						</div>
						<div class="img-item">
							<img
								src=" <c:url value ="/assets/UserTemplate/img/category-2.jpg" />" />
							<a class="img-text" href="">
								<p>Some text goes here that describes the image</p>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Main Slider End -->


	<!-- Brand Start -->
	<div class="brand">
		<div class="container-fluid">
			<div class="brand-slider">
				<div class="brand-item">
					<img src="<c:url value ="/assets/UserTemplate/img/brand-1.png" />"
						alt="" />
				</div>
				<div class="brand-item">
					<img src="<c:url value ="/assets/UserTemplate/img/brand-2.png" />"
						alt="">
				</div>
				<div class="brand-item">
					<img src="<c:url value ="/assets/UserTemplate/img/brand-3.png" />"
						alt="">
				</div>
				<div class="brand-item">
					<img src="<c:url value ="/assets/UserTemplate/img/brand-4.png" />"
						alt="">
				</div>
				<div class="brand-item">
					<img src="<c:url value ="/assets/UserTemplate/img/brand-5.png" />"
						alt="">
				</div>
				<div class="brand-item">
					<img src="i<c:url value ="/assets/UserTemplate/img/brand-6.png" />"
						alt="">
				</div>
			</div>
		</div>
	</div>
	<!-- Brand End -->

	<!-- Feature Start-->
	<div class="feature">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-lg-3 col-md-6 feature-col">
					<div class="feature-content">
						<i class="fab fa-cc-mastercard"></i>
						<h2>Secure Payment</h2>
						<p>Lorem ipsum dolor sit amet consectetur elit</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 feature-col">
					<div class="feature-content">
						<i class="fa fa-truck"></i>
						<h2>Worldwide Delivery</h2>
						<p>Lorem ipsum dolor sit amet consectetur elit</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 feature-col">
					<div class="feature-content">
						<i class="fa fa-sync-alt"></i>
						<h2>90 Days Return</h2>
						<p>Lorem ipsum dolor sit amet consectetur elit</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 feature-col">
					<div class="feature-content">
						<i class="fa fa-comments"></i>
						<h2>24/7 Support</h2>
						<p>Lorem ipsum dolor sit amet consectetur elit</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Feature End-->


	<!-- Call to Action Start -->
	<div class="call-to-action">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-md-6">
					<h1>call us for any queries</h1>
				</div>
				<div class="col-md-6">
					<a href="tel:0123456789">+012-345-6789</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Call to Action End -->

	<!-- Featured Product Start -->
	<div class="featured-product product">
		<div class="container-fluid">
			<div class="section-header">
				<h1>Featured Product</h1>
			</div>
			<c:if test="">

			</c:if>
			<div class="row align-items-center product-slider product-slider-4">
				<c:forEach var="item" items="${ productHightLight }">
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
										class="fa fa-heart"></i></a> <a href="<c:url value="/ProductDetail/${ item.id_Product} "  />"><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="product-price">
								<h3>
									<span>  <fmt:formatNumber type="number"
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
		</div>
	</div>
	<!-- Featured Product End -->

	<!-- Newsletter Start -->
	<div class="newsletter">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<h1>Subscribe Our Newsletter</h1>
				</div>
				<div class="col-md-6">
					<div class="form">
						<input type="email" value="Your email here">
						<button>Submit</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Newsletter End -->

	<!-- Recent Product Start -->
	<div class="recent-product product">
		<div class="container-fluid">
			<div class="section-header">
				<h1>Discount Product</h1>
			</div>
			<div class="row align-items-center product-slider product-slider-4">

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
	<!-- Recent Product End -->

	<!-- Review Start -->
	<div class="review">
		<div class="container-fluid">
			<div class="row align-items-center review-slider normal-slider">
				<div class="col-md-6">
					<div class="review-slider-item">
						<div class="review-img">
							<img
								src="<c:url value="/assets/UserTemplate/img/review-1.jpg " />"
								alt="Image">
						</div>
						<div class="review-text">
							<h2>Customer Name</h2>
							<h3>Profession</h3>
							<div class="ratting">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Curabitur vitae nunc eget leo finibus luctus et vitae lorem</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="review-slider-item">
						<div class="review-img">
							<img
								src="<c:url value="/assets/UserTemplate/img/review-2.jpg " />"
								alt="Image">
						</div>
						<div class="review-text">
							<h2>Customer Name</h2>
							<h3>Profession</h3>
							<div class="ratting">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Curabitur vitae nunc eget leo finibus luctus et vitae lorem</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="review-slider-item">
						<div class="review-img">
							<img
								src="<c:url value="/assets/UserTemplate/img/review-3.jpg " />"
								alt="Image" />
						</div>
						<div class="review-text">
							<h2>Customer Name</h2>
							<h3>Profession</h3>
							<div class="ratting">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Curabitur vitae nunc eget leo finibus luctus et vitae lorem</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Review End -->
</body>
