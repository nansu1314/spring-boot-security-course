FROM openjdk:11-jdk

MAINTAINER suchen nan.su1314@gmail.com

VOLUME /tmp

#ARG docker_artifact_file

COPY target/demo-0.0.1-SNAPSHOT.jar /springboot-security.jar

RUN bash -c 'touch /springboot-security.jar'

EXPOSE 8080
ENTRYPOINT ["java", "-jar","/springboot-security.jar"]