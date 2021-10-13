FROM openjdk:11.0.10-jdk-slim-stretch
VOLUME /tmp
ARG JAR_FILE=app.jar
# ENV JDK_JAVA_OPTIONS="Xms120m -Xmx512m"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080