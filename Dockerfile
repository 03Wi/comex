FROM ubuntu:latest
RUN apt-get update && apt-get install -y openjdk-17-jdk
LABEL author="0303"
WORKDIR /app
COPY target/comex-0.0.1-SNAPSHOT.jar comex.jar
EXPOSE 8080
CMD ["java", "-jar", "comex.jar"]

#Tiene errores, no me da el tiempo para corregirlos

