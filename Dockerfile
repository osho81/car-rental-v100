FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml --batch-mode --errors --fail-at-end -DskipTests clean package
FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/*.jar /home/app/app.jar
ENTRYPOINT ["java", "-jar", "/home/app/app.jar"]