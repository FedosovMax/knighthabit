FROM openjdk:11.0.4-jre-slim

WORKDIR /usr/src/myapp

COPY target/knighthabit*.jar /knighthabit.jar

CMD ["java", "-jar", "/knighthabit.jar"]