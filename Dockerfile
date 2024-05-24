# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-alpine

# Copy the jar file into the image
COPY target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Specify the start command
ENTRYPOINT ["java","-jar","/app.jar"]

