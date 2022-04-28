
FROM openjdk:8
EXPOSE 8080
ADD target/springboot-0.0.1-SNAPSHOT.jar springboot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/springboot-0.0.1-SNAPSHOT.jar","--DB=mysql-svc"]

#FROM openjdk:8
#VOLUME /tmp
#COPY target/springboot-reactjs-backend.jar springboot-reactjs-backend.jar
#ENTRYPOINT ["java","-jar","/springboot-reactjs-backend.jar","--spring.profiles.active=prod","--DB=mysql-svc"]