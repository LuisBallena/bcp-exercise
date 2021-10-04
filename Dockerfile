FROM openjdk:11-jre-slim

WORKDIR /opt

#practical case
ADD /target/*.jar /opt/ms/app.jar

EXPOSE 8080
CMD ["java", "-jar", "/opt/ms/app.jar"]
