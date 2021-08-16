<#macro navbar>
 <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                  <a class="navbar-brand" href="#">
                    <i class="fas fa-hand-holding-usd fa-2x"></i>
                   Stock
                  </a>
                </div>
        </nav>
</#macro>

<#macro back><h4 class="closeback"><a href="/summary.ftl"><i class="far fa-arrow-alt-circle-left"></i></a>  ADD STOCK</h4></#macro>

<#macro buttons>
<h4><a href="/back"><i class="far fa-arrow-alt-circle-left"></i></a>  Stock Period</h4>

       <a href="summary.ftl"><button id="summary"><span class="fx"><i class="fas fa-book-reader fa-2x"></i><b>SUMMARY</b></span></button></a>
       <a href="Opening.ftl">
        <button id="opening">
        <span class="fx"><span class="fa-stack ci">
   				 <i class="fa fa-comment fa-stack-2x"></i>
   				 <strong class="fa-stack-1x fa-stack-text fa-inverse">${open_size}</strong>
  				</span><b>OPENING</b></span>
  		</button></a>
       
        <a href="purchase.ftl">
        <button id="purchaseOrder">
        <span class="fx"><span class="fa-stack ci">
   				 <i class="fa fa-comment fa-stack-2x"></i>
   				 <strong class="fa-stack-1x fa-stack-text fa-inverse">${purchase_size}</strong>
  				</span><b>PURCHASE</b></span>
  		</button></a>
       
        <a href="wastage.ftl">
        <button id="wastage">
        <span class="fx"><span class="fa-stack ci">
   				 <i class="fa fa-comment fa-stack-2x"></i>
   				 <strong class="fa-stack-1x fa-stack-text fa-inverse">${wast_size}</strong>
  				</span><b>WASTAGE</b></span>
  		</button></a>
  		
       <a href="#">
        <button id="transferSite">
        <span class="fx"><span class="fa-stack ci">
   				 <i class="fa fa-comment fa-stack-2x"></i>
   				 <strong class="fa-stack-1x fa-stack-text fa-inverse">0</strong>
  				</span><b>SITE TRANSFER</b></span>
  		</button></a>
       
        <a href="StockBalance.ftl">
        <button id="stockBalance">
        <span class="fx"><span class="fa-stack ci">
   				 <i class="fa fa-comment fa-stack-2x"></i>
   				 <strong class="fa-stack-1x fa-stack-text fa-inverse">${balance_size}</strong>
  				</span><b>STOCK BALANCE</b></span>
  		</button></a>
  		
</#macro>
<#macro addClose>
<a href="/EndSession"><input id="closeButton" type="button" value="End Stock" class="btn btn-dark close"></a>
</#macro>

<#macro stylesheet>
 button{
         margin-left:5px;
         margin-right:14px;
         margin-top:10px;
         margin-bottom:15px;
         height:140px;
         width:150px;
         border-radius:15px;
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
</#macro>