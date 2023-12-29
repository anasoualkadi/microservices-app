# Utilisez une image Maven pour effectuer le build
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Utilisez -Dspring.profiles.active pour activer le profil 'dev'
RUN mvn clean install -Dspring.profiles.active=dev -DskipTests

# Utilisez l'image OpenJDK pour exécuter l'application
FROM openjdk:17
EXPOSE 8083
COPY --from=build /app/target/billing-service.jar billing-service.jar
ENTRYPOINT ["java", "-jar", "billing-service.jar", "--spring.profiles.active=dev"]