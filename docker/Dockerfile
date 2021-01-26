FROM maven:3.5.2-jdk-11 AS build
COPY src /hello-app
COPY pom.xml /hello-app
RUN mvn -f /hello-app/pom.xml clean package

FROM adoptopenjdk/openjdk15-openj9:jre-15.0.1_9_openj9-0.23.0-alpine
COPY --from=build /target/hello-app-01.jar /docker/hello-app-01.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/docker/hello-app-01.jar"]