FROM openjdk:14.0.1-slim-buster
COPY build/libs/*.jar /var/app.jar
EXPOSE 8080
LABEL org.opencontainers.image.source="https://github.com/sildvauresberg/demo"
ENTRYPOINT ["java", "-jar", "/var/app.jar"]
