#Dockerfile for ROS inventory module du
FROM openjdk:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
EXPOSE 8093