FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD tw-wallet-sync/build/libs/tw-wallet-sync-0.0.1-SNAPSHOT.jar /app/tw-wallet-sync.jar
ADD tw-wallet-webapp/build/libs/tw-wallet-webapp-0.0.1-SNAPSHOT.jar /app/tw-wallet-webapp.jar

WORKDIR /app

RUN apk update
RUN apk add openssl
RUN apk add curl

USER 1000

CMD ["java", "-jar", "tw-wallet-sync.jar"]
CMD ["java", "-jar", "tw-wallet-webapp.jar"]