#FROM openjdk:17
#EXPOSE 8080
#ADD target/discovery-service.jar discovery-service.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","discovery-service.jar"]

# Utilisez une image Maven pour effectuer le build
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

# Utilisez l'image OpenJDK pour exécuter l'application
FROM openjdk:17
EXPOSE 8080
COPY --from=build /app/target/discovery-service.jar discovery-service.jar
ENTRYPOINT ["java", "-jar", "discovery-service.jar"]