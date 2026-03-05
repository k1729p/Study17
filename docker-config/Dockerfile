FROM maven:3.9.11-eclipse-temurin-25 AS maven_tool
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean install

FROM eclipse-temurin:25
COPY --from=maven_tool /tmp/target/Study17-jar-with-dependencies.jar application.jar
ENTRYPOINT ["java","-jar","application.jar"]