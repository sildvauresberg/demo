FROM openjdk:14.0.1-slim-buster
COPY *.jar /var/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/var/app.jar"]
