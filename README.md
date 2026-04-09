# SpringAssignment1 — CSC313: Object-Oriented Programming

**Group:** CSC 313 Group 9  
**Institution:** University of Fort Hare — Department of Computer Science  
**Module:** CSC313: Object-Oriented Programming  
**Submission Date:** 10 April 2026  

---

## Group Members

| # | Full Name |
|---|-----------|
| 1 | Lukhanyile Mthwazi (224056213) |
| 2 | Samnkelisiwe Mathe (223000926) |
| 3 | Okuhle Genge(224097337) |
| 4 | Orilwela Sadiki(202372554) |
| 5 | Nkosinathi Mbewana(224005032) |
| 6 | Musa Joseph(202250466) |

---

## Project Overview

This project is a full-stack Spring Boot REST API application built as part of Assignment 1 for CSC313. It demonstrates core object-oriented programming concepts including classes, objects, methods, validation, and CRUD operations.

The application manages Computer Science department course information through a REST API backend and a browser-based HTML/JavaScript frontend dashboard.

---

## Project Structure

```
SpringAssignment1/
├── src/
│   └── main/
│       ├── java/com/codewithus/springassignment11/
│       │   ├── SpringAssignment11Application.java   # App entry point + REST Controller
│       │   └── course.java                          # Course model with validation
│       └── resources/
│           └── static/
│               └── index.html                       # Frontend dashboard
└── pom.xml                                          # Maven dependencies
```

---

## Tech Stack

| Technology | Details |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 4.0.5 |
| Build Tool | Maven |
| Validation | Jakarta Bean Validation (JSR-380) |
| Frontend | HTML, CSS, JavaScript (Vanilla) |
| Server Port | 8080 (default) |

---

## Dependencies

| Dependency | Purpose |
|---|---|
| `spring-boot-starter-web` | REST controller support and embedded Tomcat |
| `spring-boot-starter-validation` | Bean Validation annotations |

---

## Part A — Course Display

The `/api/courses/department` endpoint returns all courses grouped by category (Foundation, Undergraduate, Honours). These are displayed on the frontend dashboard under the **Department View** section.

### Pre-loaded Courses

| ID | Course Name | Category |
|----|-------------|----------|
| 1 | CSC111F: Introduction to Computing | Foundation |
| 2 | CSC121F: Computer Literacy For Science | Foundation |
| 3 | CSC212: Data Structures | Undergraduate |
| 4 | CSC211: Advanced Programming | Undergraduate |
| 5 | CSC121: Elementary Computer Programming | Undergraduate |
| 6 | CSC313: Object Oriented Programming | Undergraduate |
| 7 | CSC411: Advanced Artificial Intelligence | Honours |
| 8 | CSC411: CSC513 Distributed And Parallel Computing | Honours |
| 9 | CSC411: CSC502 Research Methods | Honours |
| 10 |CSC411: CSC501 Research Project | Honours |

### Endpoint

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/courses/department` | Returns all courses grouped by category |

---

## Part B — CRUD Operations

Full Create, Read, Update, and Delete functionality is implemented via REST endpoints and connected to the frontend dashboard.

### API Endpoints

| Method | Endpoint | Description | Response |
|--------|----------|-------------|----------|
| GET | `/api/courses` | Retrieve all courses | 200 OK |
| GET | `/api/courses/{id}` | Retrieve a single course by ID | 200 OK / null if not found |
| POST | `/api/courses` | Add a new course | 200 OK |
| PUT | `/api/courses/{id}` | Update an existing course | 200 OK / "Course not found" |
| DELETE | `/api/courses/{id}` | Delete a course by ID | 200 OK / "Course not found" |

### Request Body (POST and PUT)

```json
{
  "id": 4,
  "name": "Introduction to Machine Learning",
  "category": "Honours"
}
```

### Validation Rules

| Field | Annotation | Rule |
|-------|-----------|------|
| `id` | `@NotNull` | ID cannot be null |
| `name` | `@NotBlank` | Course name cannot be empty |
| `name` | `@Size(min=3, max=100)` | Name must be between 3 and 100 characters |
| `category` | `@NotBlank` | Category cannot be empty |

---

## Frontend Dashboard

The application includes a browser-based dashboard at `http://localhost:8080` that allows users to:

- View all courses in a clean table
- Add a new course using a form (ID, Name, Category)
- Delete a course directly from the table
- View courses grouped by department level (Foundation, Undergraduate, Honours)

The dashboard communicates with the Spring Boot backend via JavaScript `fetch()` API calls.

---

## How to Run

1. Clone the repository:
```bash
git clone https://github.com/Luke-Mthwazi/SpringAssignment1.git
```

2. Open the project in **IntelliJ IDEA**

3. Allow Maven to download all dependencies

4. Run `SpringAssignment11Application.java`

5. Open your browser and go to:
```
http://localhost:8080
```

6. To test the REST API directly, use **Postman** and send requests to:
```
http://localhost:8080/api/courses
```

---

## Key Concepts Demonstrated

- Object-Oriented Programming with Java classes and objects
- RESTful API design using Spring MVC annotations (`@RestController`, `@GetMapping`, `@PostMapping`, etc.)
- Bean Validation (JSR-380) for input data integrity
- In-memory data management using Java `ArrayList`
- Stream API for grouping and filtering data
- Frontend-backend integration using JavaScript `fetch()` API
- Version control and collaboration using Git and GitHub

---

*CSC313 Group 9 — University of Fort Hare — 2026*
