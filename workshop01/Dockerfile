FROM maven:3.5-jdk-11 AS build
RUN mvn package -f pom.xml

FROM gcr.io/distroless/java
EXPOSE 8080
ENTRYPOINT ["java","-jar","/target/this9is3me-0.0.1-SNAPSHOT.jar"]