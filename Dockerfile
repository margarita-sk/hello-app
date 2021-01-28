FROM maven:3.6.3-openjdk-11 AS maven
COPY . .
RUN mvn clean package

FROM adoptopenjdk/openjdk15-openj9:jre-15.0.1_9_openj9-0.23.0-alpine
COPY --from=maven target/hello-app-01.jar ./target/hello-app-01.jar
CMD ["java", "-jar", "./target/hello-app-01.jar"]