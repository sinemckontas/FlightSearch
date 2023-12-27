# Flight Search

Flight Search API implemented using Spring Boot.
Rest API implemented using Spring Web. Swagger & OpenAPI documentation included.
This project uses PostgreSQL with Spring Data.

For CRUD operations, JPA's CRUD Repository Interface is used from Spring Data.
The Search API includes two endpoints, one for one-way trips and the other for round trips.
The search parameters are optional meaning any combination of parameters can be used.

The authentication is implemented using Spring Security. (Basic HTTP Authentication, Swagger excluded)
A scheduled background job saves all flight data daily from a [Mock API](https://mockapi.io/).

After running the project, you can access the Swagger UI from http://localhost:8080/swagger-ui/index.html
