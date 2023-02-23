FROM openjdk:17-jdk-alpine

COPY target/my-miniProjet-0.0.1-SNAPSHOT.jar my-miniProjet-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "my-miniProjet-0.0.1-SNAPSHOT.jar"]