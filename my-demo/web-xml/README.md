# Context path
- Create a new project in Netbeans it's required to define a context path
# Entry point
- Default the entry point name is `index.html` when create a new project
- We can change by
  - adjust the `web.xml`
  ```xml
    <welcome-file-list>
      <welcome-file>poop.jsp</welcome-file>
    </welcome-file-list>
  ```
  - right click on project -> Properties -> Run -> Relative URL -> `poop.jsp` xD
# Create a new Servlet

- When create a new Servlet, i named it HelloServlet, it's come with options:
  - Keep default (not add to web.xml)
  - Change the URL Patterns or Servlet Name
  - Add information to web.xml 

![image](https://github.com/lcaohoanq/PRJ301-Issues/assets/136492579/e609cc55-c42b-4734-8f9b-dcc8ff2fd69c)

### Keep default: Netbeans will using a @ notation, to address this Servlet
  - ```java
    @WebServlet(name = "HelloServlet", urlPatterns = {"/HelloServlet"})
    ```
  - When we access through the URL, it will be `localhost:8080/context-path-name/HelloServlet`

![image](https://github.com/lcaohoanq/PRJ301-Issues/assets/136492579/35353217-86cb-46e3-8e8c-be669ee810ac)

### Change the URL Patterns or Servlet Name
  - ```java
    @WebServlet(name = "ByeServlet", urlPatterns = {"/byebye"})
    ```
    - When we access through the URL, it will be `localhost:8080/context-path-name/byebye`

### Add information to web.xml: we will not have a WebServlet notation

![image](https://github.com/lcaohoanq/PRJ301-Issues/assets/136492579/a4f4b898-4b8f-4543-b681-a9eeb7eecb7d)

![image](https://github.com/lcaohoanq/PRJ301-Issues/assets/136492579/657971c3-5b6a-4450-b0bb-8293d30d4a5d)

![image](https://github.com/lcaohoanq/PRJ301-Issues/assets/136492579/1c5035aa-1317-42e0-8f38-7e00f0379232)

# Init Parameter

- Define a some default value
- If duplicate `param-name` it will work with the first one
- How to retrieve the value
```java
ServletContext sc = getServletContext();
String var = sc.getInitParameter(“db_username");
```

![image](https://github.com/lcaohoanq/PRJ301-Issues/assets/136492579/069fe6a5-ef71-4913-99fd-e7f00b2f1551)

![image](https://github.com/lcaohoanq/PRJ301-Issues/assets/136492579/9d273149-2a83-4b73-80f8-070cfcea7a83)

![image](https://github.com/lcaohoanq/PRJ301-Issues/assets/136492579/35341006-ed1e-4610-ad51-553bd03e7063)


