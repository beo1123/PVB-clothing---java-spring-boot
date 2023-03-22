<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<title>Cart</title>
</head>


<body>
	<!-- Breadcrumb Start -->
	<div class="breadcrumb-wrap">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Products</a></li>
				<li class="breadcrumb-item active">Cart</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Cart Start -->
	<div class="cart-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-8">
					<div class="cart-page-inner">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead class="thead-dark">
									<tr>
										<th>Product</th>
										<th>Price</th>
										<th>Discount</th>
										<th>Quantity</th>
										<th>Total</th>
										<th>Edit</th>
										<th>Remove</th>
									</tr>
								</thead>
								<tbody class="align-middle">

									<c:forEach var="item" items="${Cart}">
										<tr>
											<td>
												<div class="img">
													<a
														href="<c:url value="/ProductDetail/${ item.value.product.id_Product} "  />"><img
														src="<c:url value="/assets/UserTemplate/img/Products/${ item.value.product.img }" />"></a>
													<p>${ item.value.product.name }</p>
												</div>
											</td>
											<td><span> <fmt:formatNumber type="number"
														maxIntegerDigits="9" value="${ item.value.product.price }" />
													VND
											</span></td>
											<td><span> ${ item.value.product.sale }% </span></td>
											<td>
												<div class="qty">
													<button class="btn-minus">
														<i class="fa fa-minus"> </i>
													</button>
													<input type="number" min="1" max="100"
														value="${ item.value.quanty }"
														id="quanty-cart-${ item.value.product.id_Product }">
													<button class="btn-plus">
														<i class="fa fa-plus"></i>
													</button>
												</div>
											</td>
											<td><span> <fmt:formatNumber type="number"
														maxIntegerDigits="9" value="${ item.value.totalPrice }" />
													VND
											</span></td>
											<td>
												<button data-id="${ item.value.product.id_Product}"
													class="edit-cart" type="button">
													<i class="fa fa-edit"></i>
												</button>
											</td>
											<td><a
												href="<c:url value="/DeleteCart/${ item.value.product.id_Product }"/>"
												type="button"> <i class="fa fa-trash"></i></a></td>
										</tr>
									</c:forEach>


								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="cart-page-inner">
						<div class="row">
							<div class="col-md-12"></div>
							<div class="col-md-12">
								<div class="cart-summary">
									<div class="cart-content">
										<c:if test="${ not empty Cart }">
											<h1>Cart Summary</h1>

											<c:forEach var="item" items="${Cart}">
												<p>
													<a
														href="<c:url value="/ProductDetail/${ item.value.product.id_Product} "  />"><img
														src="<c:url value="/assets/UserTemplate/img/Products/${ item.value.product.img }" />"
														width="60px" height="60px"></a> ${ item.value.product.name }<span><fmt:formatNumber
															type="number" maxIntegerDigits="9"
															value="${ item.value.totalPrice }" /> VND</span>
												</p>

											</c:forEach>
											<h2>
												Grand Total<span><fmt:formatNumber type="number"
														maxIntegerDigits="9" value=" ${ TotalPrice }" /> VND</span>
											</h2>
										</c:if>

										<c:if test="${ empty Cart }">
											<h1 style="color: red">Your Cart is empty!</h1>


										</c:if>
									</div>
									<div class="cart-btn">
										<a href="<c:url value = "/Checkout"/>"><button>Checkout</button></a>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Cart End -->


	<content tag="script"> <script>
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quanty = $("#quanty-cart-" + id).val();
			window.location = "EditCart/" + id + "/" + quanty;

		});
	</script> </content>

</body>
