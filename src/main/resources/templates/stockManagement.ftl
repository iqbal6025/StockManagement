<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
     <script src="https://kit.fontawesome.com/5d9d02e7e5.js" crossorigin="anonymous"></script>
    
    <title>Stock Management</title>
    <style>
    #openStock,#closeStock{
    background-color:wheat;

    width:150px;
    height:150px;
    border-radius: 15px;
    margin-right: 20px;
    box-shadow: 5px 5px 3px gray;
    margin:20px;
    }
   #closeStock{
    background-color:grey;
    color:white;
   }
   #check{
      color:#90ee90;
      margin-left:15px;
   }
   #eye{
     color:black;
   }
   .fx{
     display:flex;
     flex-direction:column;
   }
   .check{
     visibility: hidden;
   }
  
   
    </style>
  </head>
  <body>
  <script>
  function approved(){
	   alert("Approved");
	   document.getElementById("check").setAttribute("class","check");
  }
   
  </script>
  
    
  <#import "nav.ftl" as nav>
       <@nav.navbar/>
  <div class="container">
    <h4>Stock Management</h4>
    <a href="summary.ftl"><button id="openStock"><span class="fx"><i class="fas fa-envelope-open-text fa-2x"></i><b>OPEN STOCK</b></span></button></a>
    <button class="active" id="closeStock"><span class="fx"><i class="fas fa-envelope fa-2x"></i></i><b>CLOSED STOCK</b></span></button>
  
  
    <!--  close stock list -->
    <div class="col-11">
    <table class="table table-striped table-hover">
     <tr><th>STOCK START DATE</th>
         <th>STOCK CLOSED DATE</th>
         <th>OPENING STOCK</th>
         <th>CLOSING STOCK</th>
         <th>COST OF SALES</th>
         <th>ACTION</th>
     </tr>
     <#list close_stock as close>
      
     <tr>
         <td>${close.stock_start_date}</td>
         <td>${close.stock_end_date}</td>
         <td>${close.opening_stock_value}</td>
         <td>${close.closing_stock_value}</td>
         <td>${close.cost_of_sales}</td>
         <td><a href="/closeStock/${close.stockID}" ><i id="eye"  class="fas fa-eye"></i></a><#if close.stockPeriodStatus == 'draft'><a onclick="approved()" id="check" href="/approve/${close.stockID}"><i   class="fas fa-check"></i></a></#if></td>
     </tr>
    </#list>
    </table>
    </div>
  </div>
    
     <script>
      function(){alert("Welcome");}();
       
      document.getElementById("check").addEventListener("click",function(){
    	  document.alert("Approved");
      })
   
     
        
        function getDetail(value){
        	${closeList}
        	alert(value);
        }
   </script>
   
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->
    <script src="stock.js"></script>
  </body>
</html>