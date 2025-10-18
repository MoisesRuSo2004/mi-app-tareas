# Usa una imagen base con Java 17
FROM eclipse-temurin:17-jdk

# Crea una carpeta para la app
WORKDIR /app

# Copia el JAR al contenedor
COPY mistareasapp.jar /app/mistareasapp.jar

# Expone el puerto que usa Spring Boot (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "mistareasapp.jar"]
