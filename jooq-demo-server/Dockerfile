FROM openjdk:17-alpine
LABEL authors="wmwei"
RUN mkdir -p /opt
COPY target/jooq-demo-server-0.0.1-SNAPSHOT.jar /opt
WORKDIR /opt
RUN mv jooq-demo-server-0.0.1-SNAPSHOT.jar jooq-demo-server.jar
EXPOSE 9098
ENTRYPOINT ["java", "-jar","jooq-demo-server.jar"]