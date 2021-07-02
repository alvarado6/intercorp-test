# Documentations, Configurations and Support Tools
   El siguiente proyecto se ha realizado para cumplir con el test enviado para poder medir los 
conocimientos del participante

El proyecto se ha realizado usando las siguientes tecnologias

- Java 11
- Spring boot 
- Maven
- Base de datos H2
- Test unitarios con Junit5 y Mockito
- Docker
- Documentacion en swagger

## Instrucciones

- Se realizo la documentacion de la api en Swagger, la cual se puede ingresar desde la siguiente
  url: http://localhost:8080/swagger-ui.html# con el proyecto arriba
  
- Para poder visualizar la consola de la base de datos es necesario tener el proyecto corriendo 
  y ingresar a la siguiente url: http:localhost:8080/h2-console 
  Al ingresar a esta url va a pareder un cuadro de dialogo para poder realizar la conexion, 
  los parametros que debe usar para conectar son los siguientes:
  
    Saved Settings: Generic H2 (Embedded)
    Setting Name: Generic H2 (Embedded)
    Driver Class: org.h2.Driver
    JDBC URL: jdbc:h2:mem:testdb
    User Name: sa
    Password: password


## Documentation

docker build -t intercorp:v1 .