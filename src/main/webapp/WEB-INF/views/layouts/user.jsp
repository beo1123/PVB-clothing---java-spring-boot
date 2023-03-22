<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="MasterLayout"/></title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="eCommerce HTML Template Free Download" name="keywords">
<meta content="eCommerce HTML Template Free Download" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
	rel="stylesheet">

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link href="<c:url value="/assets/UserTemplate/lib/slick/slick.css" />"
	rel="stylesheet">
<link
	href="<c:url value = "/assets/UserTemplate/lib/slick/slick-theme.css" />"
	rel="stylesheet">

<!-- Template Stylesheet -->
<link href="<c:url value = "/assets/UserTemplate/css/style.css" />"
	rel="stylesheet">

</head>

<body>


	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>
	
	<decorator:body />
	
	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>


	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="<c:url value="/assets/UserTemplate/lib/easing/easing.min.js" />"></script>
	<script
		src="<c:url value="/assets/UserTemplate/lib/slick/slick.min.js" />"></script>

	<!-- Template Javascript -->
	<script src="<c:url value="/assets/UserTemplate/js/main.js" />"></script>
	<script src="<c:url value="/assets/UserTemplate/js/validator.js" />"></script>
	<decorator:getProperty property="page.script" />


</body>
</html>
