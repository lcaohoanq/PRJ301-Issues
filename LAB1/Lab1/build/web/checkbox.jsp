<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Options</title>
        <link rel="stylesheet" href="./style.css">
    </head>
    <body>
        <div class="title"> 
            <h1>Get Parameter Values Demo</h1>
        </div>

        <form action="product" method="post">
            <div>
                <input type="checkbox" name="options" value ="Servlet"> Servlet <br/>
                <input type="checkbox" name="options" value ="JSP"> JSP <br/>
                <input type="checkbox" name="options" value ="EJB"> EJB <br/>
                <input type="checkbox" name="options" value ="Tomcat"> Tomcat <br/>
                <input type="checkbox" name="options" value ="JBoss"> JBoss <br/>
                <input type="checkbox" name="options" value ="Others"> Others <br/>
            </div>
            <button>Choose</button>
        </form>

        <h3>You choose: </h3>
        <ul>
            <%
                String[] optionsList = (String[]) request.getAttribute("optionsList");
                if (optionsList != null) {
                    for (String option : optionsList) {
            %>
            <li><%= option%></li>
                <%
                        }
                    }
                %>
        </ul>
    </body>
</html>
