FROM eclipse-temurin:21-jre-jammy

ARG DEPENDENCY=target/wx-shop*.jar
COPY ${DEPENDENCY} application.jar

ENTRYPOINT ["java","-jar","/application.jar"]
