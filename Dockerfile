
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]

FROM alpine:latest
LABEL Name=gitactionsawsproject Version=0.0.1
RUN apk add --no-cache fortune
ENTRYPOINT ["sh", "-c", "fortune -a | cat"]
