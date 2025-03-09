FROM eclipse-temurin:23-jdk

WORKDIR /app

# Instala o psql (cliente PostgreSQL)
RUN apt-get update && \
    apt-get install -y postgresql-client

COPY pom.xml mvnw ./
COPY .mvn .mvn

RUN chmod +x mvnw

RUN ./mvnw clean dependency:resolve

COPY src ./src

EXPOSE 8080 35729

CMD ["./mvnw", "spring-boot:run"]