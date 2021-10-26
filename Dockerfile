FROM openjdk:11-jdk

MAINTAINER suchen nan.su1314@gmail.com

VOLUME /tmp

ARG docker_artifact_file

COPY ${docker_artifact_file} /springboot-security.jar

RUN bash -c 'touch /springboot-security.jar'

EXPOSE 8080
ENTRYPOINT ["java", "-jar","/springboot-security.jar"]