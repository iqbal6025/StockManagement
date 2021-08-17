<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
     <script src="https://kit.fontawesome.com/5d9d02e7e5.js" crossorigin="anonymous"></script>
<title>Hello, world!</title>
<style>
    .date{
		float:right;
		margin-right:100px;
		
		color:gray;
	}
	.btn{
		
		margin-left:30px;
	}
	.closeback{
	   margin-left:50px;
	   margin-top:20px;
	   color:gray;
	}
	.far{
	  color:black;
	}
</style>
</head>
<body>
   
	<nav class="navbar navbar-light bg-light">
		<form class="container-fluid justify-content-start">
			<button class="btn btn-outline-success me-2" type="button">Save as draft</button>
			
		</form>
		
	</nav>
	 
	 <#import "nav.ftl" as bk>
	<@bk.back/>
	<h4 class="date">(${Day?cap_first!" "} ${Date!" "}.${month!""}.${year!" "}) To (${endDate})</h4>
	
	
   <div class="container">
   <form action="/EndSession"  method="POST">
	<table class="table">
		<thead class="table-dark">
			<th>PRODUCT CODE</th>
			<th>PRODUCT NAME</th>
			<th>UNIT MEASUREMENT</th>
			<th>PRICE PER UNIT</th>
			<th>QTY</th>
		</thead>
		
		<#list addProduct_ as addproduct>
		<tbody>
			<td>${addproduct.productCode}</td>
			<td>${addproduct.productName}</td>
			<td>${addproduct.unitMeasurement}</td>
			<td>${addproduct.pricePerUnit}</td>
			<td>${addproduct.qty}</td>
		</tbody>
		</#list> 
		
	</table>
	<button class="btn btn-sm btn-outline-secondary" type="submit">Submit</button>
	</form>
	</div>
	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->
</body>
</html>