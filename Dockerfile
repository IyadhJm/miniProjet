FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/miniprojet-1.0.0.jar miniprojet-1.0.0.jar

CMD ["java", "-jar", "/miniprojet-1.0.0.jar"]