# swagger-managed-spring-boot-web
Integrate Spring boot with Swagger, and support to be deployed inside external web container, such as Tomcat, Jetty.

## Based on

[https://github.com/swagger-api/swagger-samples/tree/master/java/java-spring-boot](https://github.com/swagger-api/swagger-samples/tree/master/java/java-spring-boot)

[https://github.com/shirdrn/swagger-managed-spring-boot](https://github.com/shirdrn/swagger-managed-spring-boot)

## Steps to start for test purpose:

1. Packaging WAR file using `mvn package`.

2. Copy packaged WAR file to `Tomcat` or `Jetty` web container folder.

3. Navigate Swagger UI by hitting: [http://localhost:8080/swagger-managed-spring-boot-web/swagger-ui.html](http://localhost:8080/swagger-managed-spring-boot-web/swagger-ui.html).