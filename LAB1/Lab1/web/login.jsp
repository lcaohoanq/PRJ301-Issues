<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="./style/style.css">
    </head>
    <body>
        <div class="App">
            <section id="App-logo"></section>
            <section id="App-data">
                <div class="title">
                    <h1>Login</h1>
                </div>
                <form action="login" id="loginForm" method="post">
                    <div class="input-container">
                        <input class="form-control" autofocus placeholder="Username" type="username" id="username-login" name="userID">
                    </div>
                    <div class="input-container">
                        <input class="form-control" placeholder="Password" type="password" id="password-login" name="password">
                    </div>
                    <div class="submit-btn" id="submit-login">
                        <button>Submit</button>
                    </div>
                </form>
            </section>
        </div>
    </body>
</html>
