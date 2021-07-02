FROM openjdk:12
VOLUME /tmp
EXPOSE 8080
ADD ./target/intercorp-test-0.0.1-SNAPSHOT.jar intercorp.jar
ENTRYPOINT ["java","-jar","/intercorp.jar"]