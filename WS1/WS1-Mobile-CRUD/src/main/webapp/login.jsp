<%@page import="model.UserError"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <title>Login</title>
        <style>
            @import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");
        </style>
        <link rel="icon" type="image/png" href="./resources/favicon.ico" />
        <link rel="stylesheet" href="./style/util/reset.css" />
        <link rel="stylesheet" href="./style/util/commons.css" />
        <link rel="stylesheet" href="./style/component/login/login.css" />
        <link rel="stylesheet" href="./style/component/google/google-btn.css" />
    </head>
    <body>

        <%
            String successMsg = (String) request.getAttribute("success");
            String failMsg = (String) request.getAttribute("fail");

            String msg = "";
            if (successMsg != null) {
                msg = successMsg;
            } else if (failMsg != null) {
                msg = failMsg;
            }
        %>

        <%
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
                    <h1>Sign In</h1>
                </div>
                <form action="MainController" method="POST">
                    <div class="form-floating mb-3">
                        <input
                            autofocus="autofocus"
                            class="form-control"
                            placeholder="Username"
                            type="username"
                            id="username"
                            name="user"
                            />
                        </br>
                        <div id="invalid-feedback"> 
                            <p style="color: red; margin-top: 1vh; text-align: left; padding-left: 50px; font-style: italic"><%= userError != null ? userError.getUserID() : ""%></p>
                        </div>
                    </div>
                    <div class="form-floating mb-3">
                        <input
                            class="form-control"
                            placeholder="Password"
                            type="password"
                            id="password"
                            name="pass"
                            />
                        </br>
                        <div id="invalid-feedback"> 
                            <p style="color: red; margin-top: 1vh; text-align: left; padding-left: 50px; font-style: italic"><%= userError != null ? userError.getUserID() : ""%></p>
                        </div>
                    </div>
                    <div class="forgot-password">
                        <a href="#">Forgot password?</a>
                    </div>
                    <div class="submit-btn">
                        <button name="action" value="Login">Submit</button>
                    </div>
                </form>
                <form action="GoogleLoginController" method="POST">
                    <div class="google-button">
                        <button class="google-btn" id="log-google">
                            <div class="google-icon-wrapper">
                                <img
                                    class="google-icon"
                                    src="https://upload.wikimedia.org/wikipedia/commons/c/c1/Google_%22G%22_logo.svg"
                                    />
                            </div>
                            <div class="btn-text"><p>Sign in with Google</p></div>
                        </button>
                    </div>
                </form>
                <div class="bottom-btn">
                    <p>Not a member?</p>
                    <a href="./register.jsp">Sign up here</a>
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
    </body>
</html>
