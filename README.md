ms-comentarios

Microservicio encargado de la gestión de comentarios de la plataforma SocialCloud.

Tecnologías utilizadas
Java 17
Spring Boot 3.4.6
Spring Security
JWT
Spring Data JPA
MySQL
Maven
Configuración Base de Datos

Crear la base de datos:

CREATE DATABASE socialcloud_comentarios;

Configurar en:

src/main/resources/application.properties
spring.application.name=ms-comentarios

server.port=8084

spring.datasource.url=jdbc:mysql://localhost:3306/socialcloud_comentarios
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
Compilar proyecto
mvn clean install
Ejecutar proyecto
mvn spring-boot:run

O ejecutar la clase:

MsComentariosApplication.java
Generar artefacto JAR
mvn clean package

Archivo generado:

target/ms-comentarios-0.0.1-SNAPSHOT.jar
Seguridad JWT

Las rutas están protegidas mediante JWT.

Header requerido:

Authorization: Bearer TOKEN
Endpoints
Crear comentario
POST /api/comentarios

Body:

{
  "publicacionId": 1,
  "usuarioId": 1,
  "contenido": "Este es mi primer comentario"
}
Obtener todos los comentarios
GET /api/comentarios
Obtener comentario por ID
GET /api/comentarios/{id}
Obtener comentarios por publicación
GET /api/comentarios/publicacion/{publicacionId}
Obtener comentarios por usuario
GET /api/comentarios/usuario/{usuarioId}
Actualizar comentario
PUT /api/comentarios/{id}
Eliminar comentario
DELETE /api/comentarios/{id}
Estructura del Proyecto
src/main/java/com/socialcloud/ms_comentarios
│
├── Config
├── Controller
├── Dto
├── Entity
├── Exception
├── Repository
├── Security
├── Service
└── MsComentariosApplication
Autor

Diego Alejandro González

Asignatura

JVY0101 - Java: Diseño y Construcción de Soluciones Nativas en Nube

Proyecto

SocialCloud

Microservicio de comentarios desarrollado con arquitectura de microservicios utilizando Spring Boot, JWT, MySQL y Maven.
