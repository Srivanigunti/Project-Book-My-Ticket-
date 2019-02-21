<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Theters LIst</title>
<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="../../../css/movie.css">
</head>
<body>
	<div class="container">
		<div class="row theaterHeader">
			<div class="col-sm-4">
				<img alt="movie name" src="${moviePoster}" class="theaterMovieImg"> 
			</div>
		</div>
		
		<div class="row timimgsBlock">
			<jstl:forEach var="dateFromTheatre" items="${dates}">
				<a href="/theatreShowingMovieByDate?dateAsString=${dateFromTheatre}"  class="timings"> 
					<strong>${dateFromTheatre}</strong>
				</a>
			</jstl:forEach>	
		</div>
		
		<div class="row">
			<jstl:forEach var="theatre" items="${theatres}">
				<div class="col-sm-12 theatersList"> 
					<div class="col-sm-4">
						<p><strong>${theatre.theatreName}</strong>(
					${theatre.theatreAddress.city}, ${theatre.theatreAddress.area})</p>
					</div>
					<div class="col-sm-8">
						<ul>
							<li><a href="chooseSeats?theatreName=${theatre.theatreName}&theatreState=${theatre.theatreAddress.state}
								&theatreCity=${theatre.theatreAddress.city}&theatreArea=${theatre.theatreAddress.area}&date=${theatre.date}
								&startTime=${theatre.startTime}">${theatre.startTime}</a></li>
							<!-- <li><a href="#">02:45 pM</a></li>
							<li><a href="#">04:45 pM</a></li> -->
						</ul>
					</div>
				</div>
			</jstl:forEach>	
		</div>
	</div>
</body>
</html> 