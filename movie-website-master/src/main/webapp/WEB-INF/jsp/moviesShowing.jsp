<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<jstl:forEach var="movie" items="${movies}">
				<div class="col-sm-3">
					<!-- <input type="text" name="movieName" value=${movie.movieName} -->
					<a href="getMovieDetails?movieName=${movie.movieName}"><img src="${movie.moviePoster}" class="movieImg"/></a>
				</div>
			</jstl:forEach>
		</div>
	</div>
</body>
</html>