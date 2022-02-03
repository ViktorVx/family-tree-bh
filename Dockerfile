FROM gradle:6.9.2-jdk11-alpine
COPY build.gradle /tmp/
COPY settings.gradle /tmp/
COPY /src /tmp/src/
WORKDIR /tmp/
RUN gradle build

FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.6_10
COPY --from=0 /tmp/build/libs/family-tree-bh-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-Xms70m", "-Xmx70m", "-jar", "app.jar"]
EXPOSE 8080