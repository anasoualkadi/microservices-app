# Utilisez une image Maven pour effectuer le build
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Utilisez -Dspring.profiles.active pour activer le profil 'dev'
RUN mvn clean install -Dspring.profiles.active=dev

# Utilisez l'image OpenJDK pour exécuter l'application
FROM openjdk:17
EXPOSE 8080
COPY --from=build /app/target/gateway.jar gateway.jar
ENTRYPOINT ["java", "-jar", "gateway.jar", "--spring.profiles.active=dev"]