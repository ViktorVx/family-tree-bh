FROM gradle:6.9.2-jdk17-alpine
COPY build.gradle.kts /tmp/
COPY settings.gradle.kts /tmp/
COPY /src /tmp/src/
WORKDIR /tmp/
RUN gradle build

FROM openjdk:17-oracle
COPY --from=0 /tmp/build/libs/family-tree-bh-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-Xms70m", "-Xmx70m", "-jar", "app.jar"]
EXPOSE 8080