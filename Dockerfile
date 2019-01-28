FROM openjdk:8-jdk-alpine
COPY ./target/spring-boot-appointment-0.0.1-SNAPSHOT.jar /usr/src/appointment/
WORKDIR /usr/src/appointment
EXPOSE 8080
CMD ["java", "-jar", "spring-boot-appointment-0.0.1-SNAPSHOT.jar"]