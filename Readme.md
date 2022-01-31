# Legalizations online

## Development
- Front-end is located in [tramites-online-front](https://github.com/pattyt0/tramites-online-front)


## Execution
Run Spring application
```shell
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.datasource.password=<mysqlPasswordValue>"
```

Creating executable jar and send the application configuration variables
```shell
mvn clean package
java -jar target/tramites-0.0.1-SNAPSHOT.jar --spring.datasource.password=<mysqlPasswordValue>
```

## API documentation
- [Swagger API](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config)
- [Swagger UI](http://localhost:8080/v3/api-docs/)

### Collaborators
- Almanza Perez Ronald
- Alvarez Ramos Luis Henrry
- Molina Villamor Patricia
- Nieva Ponce de Leon Adriana Lucero