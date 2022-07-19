FROM openjdk

ADD ./target/clientes-service-0.0.1-SNAPSHOT.jar clientes-service.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/clientes-service.jar"]