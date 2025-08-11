# ---------- Build stage (Java 23 + Maven) ----------
    FROM eclipse-temurin:23-jdk AS builder
    ENV DEBIAN_FRONTEND=noninteractive
    
    # Install Maven
    RUN apt-get update \
     && apt-get install -y --no-install-recommends maven \
     && rm -rf /var/lib/apt/lists/*
    
    WORKDIR /app
    
    # Cache deps
    COPY pom.xml .
    RUN mvn -B -q -e dependency:go-offline
    
    # Build
    COPY . .
    RUN mvn -B -q -e clean package -DskipTests
    
    # ---------- Runtime stage (Java 23 JRE) ----------
    FROM eclipse-temurin:23-jre
    WORKDIR /app
    
    # (Optional) run as non-root
    RUN useradd -ms /bin/bash spring && chown -R spring:spring /app
    USER spring
    
    # Copy fat jar from builder
    COPY --from=builder /app/target/*.jar /app/app.jar
    
    EXPOSE 8080
    ENTRYPOINT ["java","-jar","/app/app.jar"]
    