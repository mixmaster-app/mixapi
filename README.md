# Mixapi

New mixmaster api version written in Java.

## Database schema

The database schema is available in the [mixmaster-data][mixmaster-data-respository] repository.

## How to ?

1. Override configuration

All the configuration of the application is present in `./app/srv/main/resources/application.yml`. If you need to edit some of the configuration you can do it in the `application-local.yml` yml file.

2. Run the application

To execute the application you need to have `Java 21.x` and `maven` installed on your computer.

```shell
mvn spring-boot:run
```

3. Execute the tests

```shell
mvn test
```

## Docker

To build the docker image and then launch it we use the following commands

```shell
docker build -t kiiow/mixapi:latest .
docker run -p 0.0.0.0:3000:3000/tcp kiiow/mixapi:latest
```

[mixmaster-data-respository]: https://github.com/mixmaster-app/mixmaster-data