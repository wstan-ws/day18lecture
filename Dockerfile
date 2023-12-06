#Build Stage
FROM maven:3-eclipse-temurin-21 AS builder

LABEL MAINTAINER="wstan.ws97@gmail.com"
LABEL APPLICATION="Health Check Application"

WORKDIR /app

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN mvn package -Dmaven.test.skip=true

#Publish Stage
FROM openjdk:21-jdk

WORKDIR /app

COPY --from=builder /app/target/day18lecture-0.0.1-SNAPSHOT.jar healthcheck.jar

ENTRYPOINT ["java", "-jar", "healthcheck.jar"]

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD curl -s -f http://localhost:8080/demo/healthz || exit 1