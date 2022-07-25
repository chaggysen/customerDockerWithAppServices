# base docker image
FROM openjdk:11
LABEL maintainer="Sen Wang"
ADD target/custom-docker-with-appservice-0.0.1-SNAPSHOT.jar custom-docker-with-appservice.jar
ENTRYPOINT ["java", "-jar", "custom-docker-with-appservice.jar"]