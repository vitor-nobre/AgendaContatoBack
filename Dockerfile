FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar agenda-0.jar
ENTRYPOINT ["java","-jar","/agenda-0.jar"]