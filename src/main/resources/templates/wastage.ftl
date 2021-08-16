<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
     <script src="https://kit.fontawesome.com/5d9d02e7e5.js" crossorigin="anonymous"></script>
    <title>Wastage!</title>
    <style>
     button{
         margin-left:5px;
         margin-right:14px;
         margin-top:10px;
         margin-bottom:15px;
         height:140px;
         width:150px;
         border-radius:70px;
         box-shadow: 5px 5px 2px grey;
         text-align:center;
         
     }
    
   i{
   color:black;
   }
   
   .fx{
     display:flex;
     flex-direction:column;
   }
  .active{
    background-color:#A9A9A9;
    color:white;
  }
   .ci{
   position:relative;
   left:40px;
  }
  #add{
    position:relative;
    bottom:12px;
    width:70px;
    height:40px;
  }
  table th,td{
     text-align:center;
  }
    #closeButton,#status{
     float:right;
     margin-top:10px;
     margin-right:30px;
  }
    </style>
  </head>
  <body>
  
  
       <#import "nav.ftl" as nav>
       <@nav.navbar/>
        <#if !endDate?? >
          
        <@nav.addClose/>
       
     <#else> 
       <h3 id="status">Approved</h3>
       
     </#if>
      <div class="container">
        <#import "nav.ftl" as e>
        <@e.buttons/>

 <div class="row">
  <div class="col-10">
   <table class="table table-striped table-hover">
     <tr><th>PRODUCT CODE</th>
         <th>PRODUCT NAME</th>
         <th>PRICE PER UNIT</th>
         <th>UNIT MEASUREMENT</th>
         <th>QUANTITY</th>
         <th>ACTION</th>
     </tr>
     <#list wastList as wast>
     <tr>
        
         <td>${wast.productCode}</td>
         <td>${wast.productName?cap_first}</td>
         <td>${wast.pricePerUnit}</td>
         <td>${wast.unitMeasurement}</td>
         <td>${wast.qty}</td>
         <td><a href="/delete/${wast.wastageId}" id="delete"><i class="fas fa-trash-alt"></i></a></td>
     </tr>
     </#list>
    </table>

    </div>
    <div class="col-2">
      <a href="/create"><button id="add" class="btn btn-dark">ADD</button></a>
    </div>
    </div>
    
   
    
       <script>
          document.getElementsByTagName('button')[3].setAttribute("class","active");
         
     </script>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->
  </body>
</html>