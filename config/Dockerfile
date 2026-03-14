FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/config-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8686
ENTRYPOINT ["java","-jar","app.jar"]
