FROM openjdk:8
ADD build/libs/webservices-0.0.1-SNAPSHOT.jar webservices-0.0.1-SNAPSHOT.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "webservices-0.0.1-SNAPSHOT.jar"]