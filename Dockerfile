FROM openjdk:17-jdk-alpine

WORKDIR /miniprojet-0.01-SNAPSHOT

COPY target/my-miniProjet-*.jar my-miniprojet-0.01-SNAPSHOT.jar

CMD ["java", "-jar", "my-miniProjet.jar"]