# Stage 1: Build
FROM amazoncorretto:21-alpine3.20-jdk AS builder
WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew bootJar

# Stage 2: Runtime
FROM amazoncorretto:21-alpine3.20
WORKDIR /app
COPY --from=builder /app/build/libs/demo-cicd-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

