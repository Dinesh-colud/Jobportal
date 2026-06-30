# 🚀 Job Portal Backend API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-success)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

---

# 📌 Overview

Job Portal Backend API is a secure RESTful backend application built using **Java**, **Spring Boot**, **Spring Security**, and **JWT Authentication**.

The application enables users to securely register, log in, manage job postings, and apply for jobs while following clean architecture and REST API best practices.

---

# ✨ Features

## Authentication

* User Registration
* User Login
* JWT Authentication
* BCrypt Password Encryption
* Stateless Authentication

## User Module

* Create User
* Update User
* Delete User
* Get User by ID
* Get All Users

## Job Module

* Create Job
* Update Job
* Delete Job
* Get Job by ID
* Get All Jobs

## Application Module

* Apply for Job
* Update Application
* Delete Application
* View Applications

## Additional Features

* DTO Pattern
* Bean Validation
* Global Exception Handling
* Custom Exceptions
* Swagger Documentation
* MySQL Integration

---

# 🛠 Tech Stack

| Technology      | Used        |
| --------------- | ----------- |
| Java            | 17          |
| Spring Boot     | 4.x         |
| Spring Security | ✔           |
| JWT             | JJWT 0.12.7 |
| Spring Data JPA | ✔           |
| Hibernate       | ✔           |
| MySQL           | ✔           |
| Maven           | ✔           |
| Swagger OpenAPI | ✔           |
| Lombok          | ✔           |

---

# 🏗 Project Architecture

```
                Client
                   │
                   ▼
          REST Controllers
                   │
                   ▼
              Service Layer
                   │
                   ▼
            Repository Layer
                   │
                   ▼
                 MySQL
```

---

# 📂 Project Structure

```
src
 ├── authenticationDTO
 ├── config
 ├── controller
 ├── entity
 ├── exception
 ├── repositories
 ├── security
 │     ├── jwt
 │     └── services
 ├── service
 ├── serviceImpl
 └── JobPortalApplication
```

---

# 🗄 Database Design

## User

| Column   | Type   |
| -------- | ------ |
| id       | Long   |
| name     | String |
| email    | String |
| password | String |
| role     | Enum   |

---

## Job

| Column      | Type          |
| ----------- | ------------- |
| id          | Long          |
| title       | String        |
| description | String        |
| company     | String        |
| location    | String        |
| salary      | Double        |
| createdAt   | LocalDateTime |

---

## Application

| Column    | Type          |
| --------- | ------------- |
| id        | Long          |
| status    | String        |
| appliedAt | LocalDateTime |
| user      | ManyToOne     |
| job       | ManyToOne     |

---

# 🔐 JWT Authentication Flow

```
Client Login
      │
      ▼
AuthenticationManager
      │
      ▼
UserDetailsService
      │
      ▼
Database
      │
      ▼
JWT Token Generated
      │
      ▼
Client Stores Token
      │
      ▼
Authorization: Bearer <TOKEN>
      │
      ▼
JWT Filter
      │
      ▼
Protected API
```

---

# 📚 REST API Endpoints

## Authentication

| Method | Endpoint         |
| ------ | ---------------- |
| POST   | /api/auth/signup |
| POST   | /api/auth/login  |

---

## Users

| Method | Endpoint        |
| ------ | --------------- |
| POST   | /api/users      |
| GET    | /api/users      |
| GET    | /api/users/{id} |
| PUT    | /api/users/{id} |
| DELETE | /api/users/{id} |

---

## Jobs

| Method | Endpoint       |
| ------ | -------------- |
| POST   | /api/jobs      |
| GET    | /api/jobs      |
| GET    | /api/jobs/{id} |
| PUT    | /api/jobs/{id} |
| DELETE | /api/jobs/{id} |

---

## Applications

| Method | Endpoint               |
| ------ | ---------------------- |
| POST   | /api/applications      |
| GET    | /api/applications      |
| GET    | /api/applications/{id} |
| PUT    | /api/applications/{id} |
| DELETE | /api/applications/{id} |

---

# 📖 Swagger

Open Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI Documentation

```
http://localhost:8080/v3/api-docs
```

---

# ⚙ Installation

Clone Repository

```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/jobportal.git
```

Navigate

```bash
cd jobportal
```

Run

```bash
mvn spring-boot:run
```

---

# 🔧 Configure Database

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobportal

spring.datasource.username=root

spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

---

# 🔑 JWT Configuration

```properties
jwt.secret=YOUR_SECRET_KEY

jwt.expiration=86400000
```

---

# 🧪 Testing

The APIs were tested using:

* Swagger UI
* Postman

---

# 📸 Screenshots

Add screenshots here after uploading them.

* Swagger UI
* Login API
* JWT Token Response
* Database Tables

---

# 📈 Future Enhancements

* Role Based Authorization
* Refresh Token
* Docker
* Microservices
* API Gateway
* Config Server
* Service Discovery
* Kafka
* AWS Deployment

---

# 💡 Key Learnings

Through this project I learned:

* Spring Boot REST API Development
* Layered Architecture
* DTO Pattern
* Spring Data JPA
* Entity Relationships
* Bean Validation
* Global Exception Handling
* Spring Security
* JWT Authentication
* Swagger Documentation

---

# 👨‍💻 Author

**Dinesh Rajbhar**

Java Backend Developer

GitHub:
https://github.com/Dinesh-colud

LinkedIn:
www.linkedin.com/in/dinesh-rajbhar-8a9010333

---

## ⭐ Support

If you found this project useful, consider giving it a **⭐ Star** on GitHub.
