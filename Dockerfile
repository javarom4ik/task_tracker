#FROM maven:3.8.4-openjdk-17 AS builder
#WORKDIR /app
#
#COPY . .
#RUN mvn clean package -DskipTests
#
#FROM openjdk:17
#WORKDIR /app
#EXPOSE 8080
#COPY --from=builder /app/task-tracker-backend/target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]
