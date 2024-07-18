# Usa una imagen base con JDK 22
FROM openjdk:22-jdk-slim

# Copia el archivo JAR de la aplicación al contenedor
COPY build/libs/Cursos-universidad-0.0.1-SNAPSHOT-plain.jar app.jar

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]


