<!doctype html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1>
            <#if !isUpdate>Create</#if>
            Purchase
        </h1>
        <div>
            <form action="<#if isUpdate>/addpurchase</#if>" name="purchase"  method="POST">
                <table class="table">
                    <tbody>
                    <thead>
                        <tr>
                            <th>Field</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tbody>
               
                        <tr>
                            <th>PurchaseID</th>
                            <td><input type="text" name="purchaseId" value="3fa85f64-5717-4562-b3fc-2c963f66afa6" /></td>
                        </tr>
                     
                        <tr>
                            <th>Order Status</th>
                            <td><input type="text" name="purchaseOrderStatus" value="<#if purchase.purchaseOrderStatus??>${purchase.purchaseOrderStatus}</#if>" /></td>
                        </tr>
                        <tr>
                            <th>Total Amount</th>
                            <td><input type="text" name="totalAmount" value="<#if purchase.totalAmount??>${purchase.totalAmount}</#if>" /></td>
                        </tr>
                        <tr>
                            <th>TransferType</th>
                            <td><input type="text" name="transferType" value="<#if purchase.transferType??>${purchase.transferType}</#if>" /></td>
                        </tr>
                       
                    </tbody>
                </table>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</body>
</html>