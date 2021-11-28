FROM eclipse-temurin:11.0.12_7-jre-focal
COPY build/libs/HelloVault-0.0.1-SNAPSHOT.jar service/app.jar
ENTRYPOINT ["java","-jar","service/app.jar","--debug"]
EXPOSE 8889