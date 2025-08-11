# ---------- Build stage (Java 23 + Maven) ----------
    FROM openjdk:23-bullseye AS builder
    ENV DEBIAN_FRONTEND=noninteractive
    
    # Install Maven
    RUN apt-get update \
     && apt-get install -y --no-install-recommends maven \
     && rm -rf /var/lib/apt/lists/*
    
    WORKDIR /app
    
    # Cache Maven dependencies
    COPY pom.xml .
    RUN mvn -B -q -e dependency:go-offline
    
    # Copy all sources and build
    COPY . .
    RUN mvn -B -q -e clean package -DskipTests
    
    # ---------- Runtime stage (Java 23 JRE) ----------
    FROM openjdk:23-bullseye
    WORKDIR /app
    
    # Security: run as non-root
    RUN useradd -ms /bin/bash spring && chown -R spring:spring /app
    USER spring
    
    COPY --from=builder /app/target/*.jar /app/app.jar
    
    EXPOSE 8080
    ENTRYPOINT ["java","-jar","/app/app.jar"]
    