<%@page import="model.UserError"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <title>Register</title>
        <link rel="icon" type="image/png" href="./resources/favicon.ico" />
        <link rel="stylesheet" href="./style/util/reset.css" />
        <link rel="stylesheet" href="./style/util/commons.css" />
        <link rel="stylesheet" href="./style/component/register/register.css" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10/dist/sweetalert2.all.min.js"></script>
    </head>
    <body>
        <%
            String msg = (String) request.getAttribute("INSERT_SUCCESS");
            if (msg == null) {
                msg = "";
            }

            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
        %>

        <div class="App">
            <section id="App-logo">
                <!--<img src="./resources/logo.png" alt="Snake-Logo" />-->
            </section>
            <section id="App-data">
                <div class="title">
                    <h1>Sign Up</h1>
                </div>
                <form id="registerForm" action="MainController">
                    <div class="form-floating mb-3">
                        <input
                            autofocus="autofocus"
                            class="form-control"
                            placeholder="UserID"
                            type="text"
                            id="username"
                            name="userID"
                            />
                        </br>
                        <div id="invalid-feedback"> 
                            <p style="color: red; margin-top: 1vh; text-align: left; padding-left: 50px; font-style: italic"><%= userError != null ? userError.getUserID() : ""%></p>
                        </div>
                    </div>
                    <div class="form-floating mb-3">
                        <input
                            autofocus="autofocus"
                            class="form-control"
                            placeholder="Name"
                            type="text"
                            id="username"
                            name="name"
                            />
                        </br>
                        <div id="invalid-feedback"> 
                            <p style="color: red; margin-top: 1vh; text-align: left; padding-left: 50px ; font-style: italic"><%= userError != null ? userError.getName() : ""%></p>
                        </div>
                    </div>
                    <div class="form-floating mb-3">
                        <input
                            class="form-control"
                            placeholder="Password"
                            type="password"
                            id="password"
                            name="password"
                            />
                        </br>
                        <div id="invalid-feedback"> 
                            <p style="color: red; margin-top: 1vh; text-align: left; padding-left: 50px; font-style: italic"><%= userError != null ? userError.getPassword() : ""%></p>
                        </div>
                    </div>
                    <div class="form-floating mb-3">
                        <input
                            class="form-control"
                            placeholder="Confirm Password"
                            type="password"
                            id="confirmPassword"
                            name="confirm"
                            />
                        </br>
                        <div id="invalid-feedback"> 
                            <p style="color: red; margin-top: 1vh; text-align: left; padding-left: 50px; font-style: italic"><%= userError != null ? userError.getConfirm() : ""%> </p>
                        </div>
                    </div>
                    <div class="submit-btn">
                        <button name="action" value="Register">Submit</button>
                    </div>
                    <div class="policy">
                        <input type="checkbox" id="tickBox" name="tickBox" />
                        <p>I Agree to the&nbsp;</p>
                        <a href="#"> Term & Condition</a>
                    </div>
                    <div id="invalid-feedback"> 
                        <p style="color: red; text-align: left; padding-left: 50px; font-style: italic"><%= userError != null ? userError.getTickBox() : ""%> </p>
                    </div>
                </form>
                <div class="bottom-btn" name="">
                    <p>Have account?</p>
                    <a href="./login.jsp">Sign in here</a>
                </div>
            </section>
        </div>
        <%
            if (!msg.isEmpty()) {
        %>
        <script>
            alert('<%= msg%>');
        </script>
        <%
            }
        %>
        <!--<script src="./controller/login.js"></script>-->
    </body>
</html>
