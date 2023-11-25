FROM openjdk:17

ARG JAR_FILE=build/libs/*.jar
COPY $JAR_FILE app.jar

COPY src/main/resources /src/main/resources

ENTRYPOINT ["java", "-jar", "/app.jar"]
