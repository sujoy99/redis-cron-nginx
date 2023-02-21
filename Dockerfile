#Dockerfile for Spring app
#FROM openjdk:8-jdk-alpine
#ADD . /spring-app
#WORKDIR /spring-app
#EXPOSE 8085:8080
#ENTRYPOINT sudo ./mvnw spring-boot:run

FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/redis-0.0.1-SNAPSHOT.jar /opt/app/
ENTRYPOINT ["java","-jar","/opt/app/redis-0.0.1-SNAPSHOT.jar"]