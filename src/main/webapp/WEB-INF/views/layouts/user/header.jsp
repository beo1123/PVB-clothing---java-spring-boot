<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Top bar Start -->
<div class="top-bar">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-6">
				<i class="fa fa-envelope"></i> pvbclothing@gmail.com
			</div>
			<div class="col-sm-6">
				<i class="fa fa-phone-alt"></i> 012345678
			</div>
		</div>
	</div>
</div>
<!-- Top bar End -->

<!-- Nav Bar Start -->
<div class="nav">
	<div class="container-fluid">
		<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			<a href="#" class="navbar-brand">MENU</a>
			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-between"
				id="navbarCollapse">
				<div class="navbar-nav mr-auto">
					<a href="<c:url value = "/Home"/>" class="nav-item nav-link active">Home</a>
					<a href="<c:url value = "/Product"/>" class="nav-item nav-link">Products</a>
					<a href="<c:url value = "/ListCart"/>" class="nav-item nav-link">Cart</a>
					<a href="<c:url value = "/Checkout"/>" class="nav-item nav-link">Checkout</a>
					<c:if test="${ empty loginInfo }">
						<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-toggle="dropdown">More Pages</a>
						<div class="dropdown-menu">
							<a href="<c:url value = "/Register"/>" class="dropdown-item">Login & Register</a> 
						</div>
					</div>
					</c:if>
					
				</div>
				<c:if test="${not empty loginInfo }">
				<div class="navbar-nav ml-auto">
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Hi, ${ fullName }</a>
                                <div class="dropdown-menu">
                                    <a href="<c:url value = "/Logout"/>" class="dropdown-item">Log Out</a>                                  
                                </div>
                            </div>
                        </div>
                 </c:if>

			</div>
		</nav>
	</div>
</div>
<!-- Nav Bar End -->

<!-- Bottom Bar Start -->
<div class="bottom-bar">
	<div class="container-fluid">
		<div class="row align-items-center">
			<div class="col-md-3">
				<div class="logo">
					<a href="<c:url value = "/Home"/>"> <img
						style="max-height: 60px"
						src="<c:url value = "/assets/UserTemplate/img/logoNew-removebg-preview.png"/>"
						alt="Logo" />
					</a>
				</div>
			</div>
			<div class="col-md-6">
				<div class="search">
					<input type="text" placeholder="Search">
					<button>
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="user">				

					<c:if test="${ Cart == null }">
						<a href="<c:url value = "/ListCart"/>" class="btn cart"> <i
							class="fa fa-shopping-cart"></i> <span>(0) (0 VND) </span>



						</a>
					</c:if>

					<c:if test="${ Cart != null }">
						<a href="<c:url value = "/ListCart"/>" class="btn cart"> <i
							class="fa fa-shopping-cart"></i> <span>(${ TotalQuanty })
								(<fmt:formatNumber type="number" maxIntegerDigits="9"
									value=" ${  TotalPrice } " /> VND)
						</span>



						</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Bottom Bar End -->
