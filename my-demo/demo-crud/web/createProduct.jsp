<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <form action="main" method="POST">

            <div>
                <label for="changeId">Id</label>
                <input id="changeId" type="text" name="productId" required><br>
            </div>
            <div>
                <label for="changeDate">Name</label>
                <input id="changeDate" type="text" name="productName" required><br>
            </div>
            <div >
                <label for="changeTime" >Description</label>
                <input  id="changeTime" type="text" name="productDescription" required><br>
            </div>
            <div >
                <label for="changePurpose" >Price</label>
                <input  id="changePurpose" type="text" name="productPrice" required><br>
            </div>
            <div>
                <label for="changePurpose" >Status</label>
                <input  id="changePurpose" type="text" name="productStatus" required><br>
            </div>

            <button type="submit" name="action" value="saveChangeCreateProduct">Save Change</button>
        </form>

    </body>
</html>
