<%@page import="model.MobileError"%> <%@page contentType="text/html"
                                             pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Staff Page</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
        <style>
            #form-insert {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                /*width: 50%;*/
            }
        </style>
    </head>
    <body>
        <% String msg = (String) request.getAttribute("INSERT_STATUS");
            if (msg
                    == null) {
                msg = "";
            } %> <% MobileError mobileError = (MobileError) request.getAttribute("USER_ERROR");
                    if (mobileError == null) {
                        mobileError
                                = new MobileError();
                    } %>

        <form
            class="m-5"
            id="form-insert"
            action="InsertProductStaffController"
            method="POST"
            >
            <div class="mb-3">
                <label for="mobileId" class="form-label">Id</label>
                <input
                    type="text"
                    class="form-control"
                    id="mobileId"
                    name="mobileId"
                    required
                    />
                <div id="emailHelp" class="form-text">MOBxxx</div>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <input
                    type="text"
                    class="form-control"
                    id="description"
                    name="mobileDescription"
                    required
                    />
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <input
                    type="text"
                    class="form-control"
                    id="price"
                    name="mobilePrice"
                    required
                    />
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input
                    type="text"
                    class="form-control"
                    id="name"
                    name="mobileName"
                    required
                    />
            </div>
            <div class="mb-3">
                <label for="year" class="form-label">Year of production</label>
                <input
                    type="text"
                    class="form-control"
                    id="year"
                    name="mobileYear"
                    required
                    />
            </div>
            <div class="mb-3">
                <label for="quantity" class="form-label">Quantity</label>
                <input
                    type="text"
                    class="form-control"
                    id="quantity"
                    name="mobileQuantity"
                    required
                    />
            </div>
            <div class="mb-3">
                <label for="notSale" class="form-label">Not Sale</label>
                <input
                    type="text"
                    class="form-control"
                    id="notSale"
                    name="mobileNotSale"
                    required
                    />
                <div id="emailHelp" class="form-text">0,1,NULL</div>
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="confirm" required />
                <label class="form-check-label" for="confirm"
                       >I agree with my data</label
                >
            </div>

            <div class="d-flex flex-row gap-3">
                <button type="submit" class="btn btn-success" id="back">Get back</button>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>

        <% if (!msg.isEmpty()) {%>
        <script>
            alert("<%= msg%>");
        </script>
        <% }%> <
        <script>
            document.querySelector("#back").addEventListener("click", function () {
                window.location.href = "staff.jsp";
            });
        </script>
    </body>
</html>
