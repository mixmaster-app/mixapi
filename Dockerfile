FROM maven:3.9.6-eclipse-temurin-21-alpine
LABEL authors="Kiiow"

RUN bash -c 'mkdir -p /var/app/{config,bin}'

WORKDIR /var/app

COPY app/src/main/resources ./config
COPY app/target/mixapi-0.0.1-SNAPSHOT.jar ./bin

VOLUME [ "/var/app/config" ]

ENTRYPOINT ["java", "-jar", "./bin/mixapi-0.0.1-SNAPSHOT.jar", "--spring.config.location=./config/application.yml"]

# RUN chmod 755 /var/app

EXPOSE 3000
