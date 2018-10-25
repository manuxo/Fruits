<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="layouts/head.jsp" %>
</head>
<body>
	<header>
		<%@include file="layouts/header.jsp" %>
	</header>
	<main>
		<div class="container">
			<div class="row hide-on-large-only">
				<%@include file="layouts/dashboard.jsp" %>
			</div>
			<div class="row">
				<div class="col s12 m12 l12 xl12">
					<h2 class="center">Home</h2>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m12 l12 xl12">
					<div class="carousel">
						<a class="carousel-item" href="#one!"><img src="public/img/apples.png"></a>
						<a class="carousel-item" href="#two!"><img src="public/img/cucumbers.png"></a>
						<a class="carousel-item" href="#three!"><img src="public/img/pineapples.png"></a>
					</div>
				</div>
			</div>
		</div>
	</main>
	<footer class="page-footer">
		<%@include file="layouts/footer.jsp" %>
	</footer>
	<%@include file="layouts/bundles.jsp" %>
</body>
</html>