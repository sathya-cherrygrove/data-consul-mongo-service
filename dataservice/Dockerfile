FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY /target/dataservice-0.0.1-SNAPSHOT.jar dataservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dataservice.jar"]