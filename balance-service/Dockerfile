FROM openjdk

ADD ./target/balance-service-0.0.1-SNAPSHOT.jar balance-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/balance-service.jar"]