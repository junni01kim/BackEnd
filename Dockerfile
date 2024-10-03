FROM openjdk:21-jdk-slim

CMD ["./mvnw","clean","package"]

ARG JAR_FILE_PATH=build/libs/daou-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE_PATH} daou-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "daou-0.0.1-SNAPSHOT.jar", "-Dspring.profiles.active=local"]