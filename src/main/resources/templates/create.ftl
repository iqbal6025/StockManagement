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
            Wastage
        </h1>
        <div>
            <form action="<#if isUpdate>/create</#if>" name="wastage"  method="POST">
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
                            <th>WastageID</th>
                            <td><input type="text" name="wastageId" value="3fa85f64-5717-4562-b3fc-2c963f66afa6" /></td>
                        </tr>
                        <tr>
                            <th>ProductCode</th>
                            <td><input type="text" name="productCode" value="<#if wastage.productCode??>${wastage.productCode}</#if>" /></td>
                        </tr>
                        <tr>
                            <th>ProductName</th>
                            <td><input type="text" name="productName" value="<#if wastage.productName??>${wastage.productName}</#if>" /></td>
                        </tr>
                        <tr>
                            <th>Price Per Unit</th>
                            <td><input type="text" name="pricePerUnit" value="<#if wastage.pricePerUnit??>${wastage.pricePerUnit}</#if>" /></td>
                        </tr>
                        <tr>
                            <th>Unit Measurement</th>
                            <td><input type="text" name="unitMeasurement" value="<#if wastage.unitMeasurement??>${wastage.unitMeasurement}</#if>" /></td>
                        </tr>
                        <tr>
                            <th>Quantity</th>
                            <td><input type="text" name="qty" value="<#if wastage.qty??>${wastage.qty}</#if>" /></td>
                        </tr>
                    </tbody>
                </table>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</body>
</html>