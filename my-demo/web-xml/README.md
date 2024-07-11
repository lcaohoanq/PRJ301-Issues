- Default the entry point name is index.html when create a new project
- We can change by
  - adjust the web.xml
  ```xml
    <welcome-file-list>
      <welcome-file>poop.jsp</welcome-file>
    </welcome-file-list>
  ```
  - right click on project -> Properties -> Run -> Relative URL -> <poop.jsp>