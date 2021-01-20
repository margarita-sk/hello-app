FROM adoptopenjdk/openjdk15-openj9:jre-15.0.1_9_openj9-0.23.0-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]