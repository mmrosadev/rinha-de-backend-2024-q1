# Rinha de Backend 2024 - Q1

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0+-6DB33F.svg)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Compose-blue)](https://docs.docker.com/compose/)

This repository presents a solution for the **Rinha de Backend 2024 - Q1** challenge.

---

## Challenge Description

The challenge consists of implementing a **RESTful API** with the following features:

- Create financial transactions for customers.
- Retrieve a customer's statement and current balance.
- Support high concurrency and availability.

More details and rules can be found in the [official challenge repository](https://github.com/zanfranceschi/rinha-de-backend-2024-q1).

---

## Technologies Used

- **Java 17**
- **Spring Boot**
- **NGINX** (as a load balancer)
- **Docker & Docker Compose**
- **Swagger/OpenAPI** for documentation
- **PostgreSQL** (as the database)

---

## Architecture

The application is composed of:

- 2 replicas of the Spring Boot API.
- 1 **NGINX** instance acting as a **load balancer**.
- 1 **PostgreSQL** database instance.

This structure simulates an environment with **high availability and horizontal scalability**.

---

## How to Run the Project

### Prerequisites

- Docker
- Docker Compose

### Running the Application

```bash
docker compose up --build
```

The API will be available at: http://localhost:9999