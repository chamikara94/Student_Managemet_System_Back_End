FROM openjdk:17-jdk-alpine
WORKDIR /opt
EXPOSE 8001
COPY ./target/Student_Info-0.0.1-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


