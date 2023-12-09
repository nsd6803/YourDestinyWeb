FROM openjdk:17-jdk-slim-buster

COPY target/YourDestinyWeb-0.0.1-SNAPSHOT.jar /app/myproject.jar

WORKDIR /app

CMD ["java", "-jar", "myproject.jar"]
