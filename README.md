# Mixapi

Unofficial API for the game [mixmaster FR][mixmaster-fr-website].\
_[wikipedia link][mixmaster-wikipedia]_

## Database schema

The database schema is available in the [mixmaster-data][mixmaster-data-repository] repository.

You can also use [Hibernate][hibernate-database-init-docs] to initialise the database schema on API startup.

```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: update
```

## How to ?

### 1. Override configuration

All the configuration of the application is present in `./app/srv/main/resources/application.yml`. If you need to edit some of the configuration you can do it in the `application-local.yml` yml file.

By doing so you can override the database connection or add some debugging config lines
```yaml
# Local database config
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/mixmaster?serverTimezone=UTC
    username: root
    password: root
  # Show SQL request executed by JPA
  jpa:
    show-sql: true

# Increase debug logging level
logging:
  level:
    org:
      hibernate:
        SQL: DEBUG
        type: trace
```

### 2. Maven commands

```shell
# Run the application
mvn spring-boot:run


# Execute the tests
mvn test


# Build the application
mvn clean install
```

## Docker

To build the docker image and then launch it we use the following commands

```shell
docker build -t kiiow/mixapi:latest .
docker run -p 0.0.0.0:3000:3000/tcp kiiow/mixapi:latest
```

## Dev environment

To setup your own dev environment you'll need:

 - Java SDK 21.x ([Download java][download-java-history])
 - Maven 3.x ([Download maven][download-maven-history])

If you want to set up MySQL locally you can use the `docker\dev\docker-compose.yml` file to do so (On Windows this will require you to [install docker-desktop][docker-desktop-install-docs]).

For any configuration changes required you can create an `app\src\main\resources\application-local.yml` file which will override the main `application.yml` configs (cf. **How to ?**).

[mixmaster-data-repository]: https://github.com/mixmaster-app/mixmaster-data
[mixmaster-fr-website]: https://mixmaster-online.fr/
[mixmaster-wikipedia]: https://en.wikipedia.org/wiki/Mix_Master

[download-java-history]: https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html
[download-maven-history]: https://maven.apache.org/docs/history.html
[docker-desktop-install-docs]: https://docs.docker.com/desktop/install/windows-install/
[hibernate-database-init-docs]: https://docs.spring.io/spring-boot/docs/1.1.0.M1/reference/html/howto-database-initialization.html
