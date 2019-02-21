-<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<script src="webjars/jquery/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="../../../css/movie.css">
</head>
<body>
	<form action="theatreShowingMovie">
		<div class="container">
			<div class="row"> 
				<div class="col-sm-4">
					<img src="${moviePoster}"  class="moviePoster"/>
				</div>
				<div class="col-sm-8"> 
					<h1>${movie.movieName}</h1>
					<!-- Booking movie Button -->
					<div>
						<a href="/theatreShowingMovie?movieName=${movie.movieName}" class="btn_bookTicket">Book Ticket</a>
					</div>
					<h3>Summary</h3>
					
					<strong>SYNOPSIS</strong>
					<p>${movie.description}</p>
					
					<strong>CAST</strong><br>
					<div class="row cast">
						<jstl:forEach var="cast" items="${movie.cast}">
							<div class="col-sm-3">
								<a href=""><img src="${cast.photo}"  class="castImg"/></a>
								<p class="actorName">${cast.name}</p>
								<p class="actorRole">${cast.role}</p>
							</div>
						</jstl:forEach>
					</div>
					
					<strong>CREW</strong>
					<div class="row cast">
						<jstl:forEach var="crew" items="${movie.crew}">
							<div class="col-sm-3">
								<a href=""><img src="${crew.photo}"  class="castImg"/></a>
								<p class="actorName">${crew.name}</p>
								<p class="actorRole">${crew.role}</p>
							</div>
						</jstl:forEach>
					</div>
					
				</div>
			</div>
		</div>
	</form>
</body>
</html>