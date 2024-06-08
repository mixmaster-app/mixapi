# Mixapi

New mixmaster api version written in Java.

## Database schema

The database schema is available in the [mixmaster-data][mixmaster-data-respository] repository.

## How to ?

1. Override configuration

All the configuration of the application is present in `./app/srv/main/resources/application.yml`. If you need to edit some of the configuration you can do it in the `application-local.yml` yml file.

By doing so you can override the database connection or add some debugging config lines
```yaml
## Local database config
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/mixmaster?serverTimezone=UTC
    username: root
    password: root
  ## Show SQL request executed by JPA
#  jpa:
#    show-sql: true

## Increase debug logging level
#logging:
#  level:
#    org:
#      hibernate:
#        SQL: DEBUG
#        type: trace
```

2. Run the application

To execute the application you need to have `Java 21.x` and `maven` installed on your computer.

```shell
mvn spring-boot:run
```

3. Execute the tests

```shell
mvn test
```

4. Build the application Jar

```shell
mvn clean install
```

This command will build the application and create a jar file under the target folder, along with some other files.

You can then use the built jar file to launch the application

```shell
java -jar target\mixapi.jar
```

## Docker

To build the docker image and then launch it we use the following commands

```shell
docker build -t kiiow/mixapi:latest .
docker run -p 0.0.0.0:3000:3000/tcp kiiow/mixapi:latest
```

[mixmaster-data-respository]: https://github.com/mixmaster-app/mixmaster-data