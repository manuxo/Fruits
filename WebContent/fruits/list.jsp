<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../layouts/head.jsp" %>
</head>
<body>
	<header>
		<%@include file="../layouts/header.jsp" %>
	</header>
	<main>
		<div class="container">
			<div class="row hide-on-large-only">
				<%@include file="../layouts/dashboard.jsp" %>
			</div>
			<div class="row">
				<div class="col s12 m12 l12 xl12">
					<h2 class="center">Fruits</h2>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m12 l12 xl12">
					<table class="responsive-table">
						<thead>
							<tr>
								<th>Fruit number</th>
								<th>Name</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${fruits}" var="fruit">
								<tr>
									<td>
										<c:out value="${fruit.id}" />
									</td>
									<td>
										<c:out value="${fruit.name}" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</main>
	<footer class="page-footer">
		<%@include file="../layouts/footer.jsp" %>
	</footer>
	<%@include file="../layouts/bundles.jsp" %>
</body>
</html>