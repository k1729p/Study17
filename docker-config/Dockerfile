FROM maven AS MAVEN_TOOL
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean install

FROM eclipse-temurin:21
COPY --from=MAVEN_TOOL /tmp/target/Study17-jar-with-dependencies.jar application.jar
ENTRYPOINT ["java","-jar","application.jar"]