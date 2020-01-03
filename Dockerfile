FROM openjdk:8

COPY target/demo-0.0.1-SNAPSHOT.jar /demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/demo.jar"]