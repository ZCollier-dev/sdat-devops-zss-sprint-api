# Build stage
FROM maven:3.9.8-eclipse-temurin-23 AS builder
WORKDIR /app

# Cache dependencies
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn -q -e dependency:go-offline

# Copy sources and build (skip tests for faster image)
COPY . .
RUN --mount=type=cache,target=/root/.m2 mvn -q -e clean package -DskipTests

# Run stage
FROM eclipse-temurin:23-jre
WORKDIR /app

# Add a non-root user for security
RUN useradd -ms /bin/bash spring && chown -R spring:spring /app
USER spring

# Copy boot jar
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
