<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>Check Out</title>
</head>
<body>
	<!-- Breadcrumb Start -->
	<div class="breadcrumb-wrap">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Products</a></li>
				<li class="breadcrumb-item active">Checkout</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Checkout Start -->
	<div class="checkout">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-8">
					<div class="checkout-inner">

						<form:form action="Checkout" method="POST"
							modelAttribute="invoice">
							<c:if test="${ empty loginInfo }">
								<h2 style="color: red;">You must login to place an order!!!!</h2>
							</c:if>
							<div class="billing-address">
						
								<h2>Billing Address</h2>
								<div class="row">
									<div class="col-md-6">
										<label>Full Name</label>
										<form:input class="form-control" type="text"
											placeholder="Full Name" path="full_Name" />
									</div>

									<div class="col-md-6">
										<label>E-mail</label>
										<form:input class="form-control" type="email"
											placeholder="E-mail" path="email" />

									</div>
									<div class="col-md-6">
										<label>Mobile No</label>
										<form:input class="form-control" type="text"
											placeholder="Mobile No" path="phone" />
									</div>
									<div class="col-md-6">
										<label>Address</label>
										<form:input class="form-control" type="text"
											placeholder="Address" path="address" />

									</div>
									<c:if test="${not empty loginInfo }">
										<c:if test="${ not empty Cart }">
											<div class="col-md-12">
												<a href=""><button onclick="AlertOrder()">Confirm
														Order</button></a>
											</div>
										</c:if>
									</c:if>



								</div>
							</div>
							
						</form:form>


					</div>
				</div>
				<div class="col-lg-4">
					<div class="checkout-inner">
						<div class="checkout-summary">
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



					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Checkout End -->
</body>

<content tag="script"> <script>
	function AlertOrder() {
		alert("Thanks for Your Order");
	}
</script> </content>
