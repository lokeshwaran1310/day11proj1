# 🐞 Issue Tracker System (Spring Boot + PostgreSQL)

A simple Issue/Bug Tracking System developed using Spring Boot, Spring Data JPA, and PostgreSQL. It allows managing users, projects, and bugs with status and priority tracking.

---

## ✅ Features

- User Management (Create, Update, Delete, Get)
- Project Management (Create, Update, Delete, Get)
- Bug Tracking
  - Assign to Users
  - Track by Status (Open, Closed, In Progress, etc.)
  - Filter by Project, Status, and Priority
- Custom DTOs for Bug Statistics
  - Bugs by Status, Priority, and Project
- RESTful API Endpoints
- Pagination Support (where applicable)

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Hibernate
- Maven

---

## 🧩 Modules

### 📁 Domain
- `User`: Represents system users (developers, testers, etc.)
- `Project`: Represents software projects
- `Bug`: Represents bugs/issues assigned to users

### 📁 Repository
- `UserRepository`
- `ProjectRepository`
- `BugRepository` (includes custom queries)

### 📁 Service
- Business logic for managing entities

### 📁 Controller
- REST API Endpoints

### 📁 DTOs
- `StatusCountDto`, `PriorityCountDto`, `ProjectBugCountDto`: Custom output formats for reports

---

## 🔗 Endpoints (Sample)

- `GET /users` — List all users  
- `POST /users` — Create a new user  
- `PUT /users/{id}` — Update user  
- `DELETE /users/{id}` — Delete user  

- `GET /bugs/status/{status}` — Filter bugs by status  
- `GET /bugs/project/{projectId}` — Filter bugs by project  
- `GET /bugs/priority/{priority}` — Filter bugs by priority  
- `GET /bugs/stats/status` — Count bugs by status  
- `GET /bugs/stats/priority` — Count bugs by priority  
- `GET /bugs/stats/project` — Bug count by project  

---

## ⚙️ Configuration

### `application.properties`

```properties
# PostgreSQL DB connection
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server
server.port=8085
```

---

## 📊 Sample DTO Response

```json
[
  {
    "status": "Open",
    "count": 10
  },
  {
    "status": "Closed",
    "count": 5
  }
]
```

---

## 🧪 Run & Test

1. Clone the repo  
2. Update DB credentials in `application.properties`  
3. Run the Spring Boot application  
4. Use Postman or Swagger to test APIs

---

## 📝 License

This project is licensed under the [MIT License](LICENSE).

---

## 👨‍💻 Author / Developer

**Lokeshwaran M**  

---
