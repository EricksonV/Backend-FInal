#FROM adopFROM openjdk:8-jre
FROM openjdk:8-jre

# Se copia el jar del proyecto a la imagen
#ARG JAR_FILE
#ADD target/${JAR_FILE} /usr/share/servicio/servicio.jar

ARG JAR_FILE=target/BackendDynamoDB-1.0-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]

# Puerto utilizado la aplicación:
EXPOSE 80