FROM openjdk:11
EXPOSE 20033
ADD target/bbu-app-server-0.0.1-SNAPSHOT.war bbu-pos-api.jar
ENTRYPOINT ["java","-jar","/bbu-pos-api.jar"]