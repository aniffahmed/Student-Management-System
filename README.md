# Student Management System (Spring Boot CRUD)

This is a beginner-friendly and interview-ready Spring Boot 4 CRUD project using Java 25, Maven, JPA, H2, Lombok, and Validation.

## Tech Stack

- Java 25
- Spring Boot 4
- Maven
- Spring Web
- Spring Data JPA
- H2 database
- Lombok
- Validation
- Postman

## Project Structure

```text
student-management-system/
|-- pom.xml
|-- .gitignore
|-- README.md
|-- postman/
|   |-- student-management-system.postman_collection.json
`-- src/
    `-- main/
        |-- java/
        |   `-- com/example/studentmanagementsystem/
        |       |-- StudentManagementSystemApplication.java
        |       |-- controller/
        |       |   `-- StudentController.java
        |       |-- service/
        |       |   |-- StudentService.java
        |       |   `-- impl/
        |       |       `-- StudentServiceImpl.java
        |       |-- repository/
        |       |   `-- StudentRepository.java
        |       |-- entity/
        |       |   `-- Student.java
        |       |-- exception/
        |       |   |-- ResourceNotFoundException.java
        |       |   |-- ErrorResponse.java
        |       |   `-- GlobalExceptionHandler.java
        |       `-- config/
        |           `-- CorsConfig.java
        `-- resources/
            `-- application.properties
```

## API Endpoints

1. Create Student
   - `POST /students`

2. Get All Students
   - `GET /students`

3. Get Student By Id
   - `GET /students/{id}`

4. Update Student
   - `PUT /students/{id}`

5. Delete Student
   - `DELETE /students/{id}`

## Sample JSON Requests

### 1) Create Student - `POST /students`

```json
{
  "name": "Alice Johnson",
  "email": "alice.johnson@example.com",
  "department": "Computer Science",
  "age": 21
}
```

### 2) Get All Students - `GET /students`

No request body.

### 3) Get Student By Id - `GET /students/1`

No request body.

### 4) Update Student - `PUT /students/1`

```json
{
  "name": "Alice Johnson Updated",
  "email": "alice.updated@example.com",
  "department": "Information Technology",
  "age": 22
}
```

### 5) Delete Student - `DELETE /students/1`

No request body.

## Local Database Configuration

Configured in `src/main/resources/application.properties`:

- URL: `jdbc:h2:file:./data/studentdb...`
- Username: `sa`
- Password: empty
- Hibernate DDL: `update` (auto table creation/update)

The database is stored locally under the `data/` directory.

## Sample SQL (Optional)

If you want to insert data manually:

```sql
INSERT INTO students (name, email, department, age)
VALUES ('Bob Martin', 'bob.martin@example.com', 'Mechanical', 20);
```

## How to Run

1. Open this project in your IDE.
2. Run the application locally.
3. The embedded H2 database will be created automatically under `data/`.
4. Build the project:

   ```bash
   mvn clean install
   ```

5. Run the app:

   ```bash
   mvn spring-boot:run
   ```

6. Test endpoints using Postman or import collection from:

   - `postman/student-management-system.postman_collection.json`

## Request Flow (Controller to Database)

1. Client sends HTTP request (for example `POST /students`).
2. `StudentController` receives the request and validates input using `@Valid`.
3. Controller calls `StudentService`.
4. `StudentServiceImpl` applies business logic.
5. Service calls `StudentRepository`.
6. `StudentRepository` talks to the embedded H2 database using JPA/Hibernate.
7. Response travels back Service -> Controller -> Client.

## What Each Class Does

1. `StudentManagementSystemApplication`:
   - Starts the Spring Boot application.

2. `Student`:
   - JPA entity mapped to database table.
   - Contains validation rules.

3. `StudentRepository`:
   - Data access layer.
   - Inherits CRUD methods from `JpaRepository`.

4. `StudentService`:
   - Defines service methods for CRUD operations.

5. `StudentServiceImpl`:
   - Implements business logic and calls repository.

6. `StudentController`:
   - Exposes REST APIs and returns HTTP responses.

7. `ResourceNotFoundException`:
   - Thrown when a student is not found.

8. `ErrorResponse`:
   - Standard structure for API error responses.

9. `GlobalExceptionHandler`:
   - Handles all exceptions globally and returns proper status codes.

10. `CorsConfig`:
    - Configures CORS policy for local development.

## Why Repository Extends JpaRepository

Because `JpaRepository<Student, Long>` already provides ready-made methods like:

- `save()`
- `findAll()`
- `findById()`
- `delete()`

So you write less code, avoid boilerplate, and focus on business logic.

## Why These Annotations Are Used

- `@RestController`:
  Marks class as REST API controller. Returns JSON responses.

- `@Service`:
  Marks class as service/business layer bean.

- `@Repository`:
  Marks interface as data access component and enables exception translation.

- `@Entity`:
  Maps Java class to database table.

## Interview Questions from This Project

1. What is layered architecture and why is it useful?
2. Why do we use `JpaRepository` instead of writing JDBC code manually?
3. What is the role of `@Valid` and where does validation happen?
4. Difference between `@Controller` and `@RestController`?
5. Why do we use constructor injection?
6. What is `@ControllerAdvice` and why do we need global exception handling?
7. What does `spring.jpa.hibernate.ddl-auto=update` do?
8. What happens when a student ID does not exist?
9. Why is `StudentService` an interface?
10. How does Spring Boot auto-configure datasource and JPA?
