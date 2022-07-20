FROM openjdk

ADD ./target/migration-money-app-0.0.1-SNAPSHOT.jar migration-money-app.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","/migration-money-app.jar"]