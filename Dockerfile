FROM khipu/openjdk17-alpine:latest
ARG JAR_FILE=target/poll-service.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]