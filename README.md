# Alpha Api

`http://localhost:8081/swagger-ui.html`

## Spring boot application that covers the following:
- Two entities: Product and Client which both extends an AbstractEntity
- Product should never be deleted instead in should be softdeleted with a boolean flag
- Client on the other hand can be hard deleted
- exposes 4 endpoints
- 2 for deleting a client/ Product
- 2 for retrieving a list client / Product
- By default all deleted entities are excluded from result
- if a flag in the query is set to true ex: includeDeleted, all softdelete elements should be returned
- the application is expected to run and have pre-populated data

## Used
- Postgresql DB
- JAVA 11
- Spring Boot 2.6.*
- Rest APIs
- Swagger 
- Data JPA
- Pagination
- Lombok
- Model Mapper
- Devtools
- Actuator