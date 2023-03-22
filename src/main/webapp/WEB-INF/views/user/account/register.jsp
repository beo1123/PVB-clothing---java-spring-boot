<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<!-- Login Start -->
	<div class="login">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6">
					<div class="register-form">
						<h1>${ status }</h1>
						<form:form action="Register" method="POST" modelAttribute="user"
							id="form-register">
							<div class="row">

								<div class="col-md-6">
									<label>First Name</label>
									<form:input class="form-control" type="text"
										placeholder="First Name" path="first_name" id="firstname" />
									<span class="form-message"></span>
								</div>
								<div class="col-md-6">
									<label>Last Name</label>
									<form:input class="form-control" type="text"
										placeholder="Last Name" path="last_name" id="lastname" />
									<span class="form-message"></span>
								</div>
								<div class="col-md-6">
									<label>E-mail</label>
									<form:input class="form-control" type="email"
										placeholder="E-mail" path="email" id="email" />
									<span class="form-message"></span>

								</div>
								<div class="col-md-6">
									<label>Mobile No</label>
									<form:input class="form-control" type="text"
										placeholder="Mobile No" path="phone" id="phone" />
									<span class="form-message"></span>
								</div>
								<div class="col-md-6">
									<label>Address</label>
									<form:input class="form-control" type="text"
										placeholder="Address" path="address" id="address" />
									<span class="form-message"></span>

								</div>
								<div class="col-md-6">
									<label>Password</label>
									<form:input class="form-control" type="password"
										placeholder="Password" path="pasword" id="password" />
									<span class="form-message"></span>

								</div>

								
								<div class="col-md-12">
									<button class="btn">Submit</button>
								</div>

							</div>
						</form:form>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login-form">
						<h1>${ statusLogin }</h1>
						<form:form action="Login" method="POST" modelAttribute="user" id="form-login">
							<div class="row">
								<div class="col-md-6">
									<label>E-mail</label>
									<form:input class="form-control" type="email"
										placeholder="E-mail" path="email" id="email" />
									<span class="form-message"></span>

								</div>
								<div class="col-md-6">
									<label>Password</label>
									<form:input class="form-control" type="password"
										placeholder="Password" path="pasword" id="password" />
									<span class="form-message"></span>

								</div>

								<div class="col-md-12">
									<div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input"
											id="newaccount"> <label class="custom-control-label"
											for="newaccount">Keep me signed in</label>
									</div>
								</div>
								<div class="col-md-12">
									<button class="btn">Submit</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Login End -->

	<content tag="script"> <script>
		Validator({
			form : '#form-register',
			formGroupSelector : '.col-md-6',
			errorSelector : '.form-message',
			rules : [ Validator.isRequired('#email'),
					Validator.isRequired('#password'),
					Validator.isRequired('#firstname'),
					Validator.isRequired('#lastname'),
					Validator.isRequired('#phone'),
					Validator.isRequired('#address')

			],
		});
	</script> <script>
		Validator({
			form : '#form-login',
			formGroupSelector : '.col-md-6',
			errorSelector : '.form-message',
			rules : [ Validator.isRequired('#email'),
					Validator.isRequired('#password')
					

			],
		});
	</script> </content>
</body>
