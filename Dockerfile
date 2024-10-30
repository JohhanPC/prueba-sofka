# Imagen de OpenJDK para el contenedor
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Archivo JAR generado de la compilación en el contenedor
COPY target/customer-0.0.1-SNAPSHOT.jar customer.jar

# Puerto en el contenedor que se usará para acceder al servicio
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "customer.jar"]