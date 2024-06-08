FROM maven:3.9.6-eclipse-temurin-21-alpine
LABEL authors="Kiiow"

RUN bash -c 'mkdir -p /var/app/{config,bin}'

WORKDIR /var/app

COPY app/src/main/resources ./config
COPY app/target/mixapi.jar ./bin

VOLUME [ "/var/app/config" ]

ENTRYPOINT ["java", "-jar", "./bin/mixapi.jar", "--spring.config.location=./config/application.yml"]

EXPOSE 3000
