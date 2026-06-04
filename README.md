# ms-comentarios

Microservicio encargado de la gestión de comentarios de la plataforma SocialCloud.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.4.6
- Spring Security
- JWT
- Spring Data JPA
- MySQL
- Maven

---

## Configuración Base de Datos

Crear la base de datos:

```sql
CREATE DATABASE socialcloud_comentarios;
```

Configurar en:

```properties
src/main/resources/application.properties
```

```properties
spring.application.name=ms-comentarios

server.port=8084

spring.datasource.url=jdbc:mysql://localhost:3306/socialcloud_comentarios
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

## Compilar proyecto

```bash
mvn clean install
```

---

## Ejecutar proyecto

```bash
mvn spring-boot:run
```

O ejecutar la clase:

```text
MsComentariosApplication.java
```

---

## Generar artefacto JAR

```bash
mvn clean package
```

Archivo generado:

```text
target/ms-comentarios-0.0.1-SNAPSHOT.jar
```

---

## Seguridad JWT

Las rutas están protegidas mediante JWT.

Header requerido:

```http
Authorization: Bearer TOKEN
```

---

## Endpoints

### Crear comentario

```http
POST /api/comentarios
```

Body:

```json
{
  "publicacionId": 1,
  "usuarioId": 1,
  "contenido": "Este es mi primer comentario"
}
```

### Obtener todos los comentarios

```http
GET /api/comentarios
```

### Obtener comentario por ID

```http
GET /api/comentarios/{id}
```

### Obtener comentarios por publicación

```http
GET /api/comentarios/publicacion/{publicacionId}
```

### Obtener comentarios por usuario

```http
GET /api/comentarios/usuario/{usuarioId}
```

### Actualizar comentario

```http
PUT /api/comentarios/{id}
```

### Eliminar comentario

```http
DELETE /api/comentarios/{id}
```

---

## Estructura del Proyecto

```text
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
```

---

## Autor

Proyecto desarrollado para la asignatura:

**JVY0101 - Java: Diseño y Construcción de Soluciones Nativas en Nube**
