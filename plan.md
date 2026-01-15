# Quiz Management System — Plan

## 1. Overview

This document outlines the assumptions, scope, and technical approach for building a **Quiz Management System** with an Admin Panel for quiz creation and a Public Page for quiz participation and result display. The focus is on delivering a **production‑ready, minimal, and reliable system** within limited time.

---

## 2. Assumptions

* Authentication is **out of scope** for the initial version; We can implement with basic auth like pre-authorize at API leve.
* Quizzes are **publicly accessible** via a unique URL.
* A quiz attempt is anonymous (no user login).
* Results are shown immediately after quiz submission.
* Single admin user assumed.

---

## 3. Scope

### In Scope (MVP)

#### Admin Panel

* Create a quiz with:

    * Quiz title
    * Multiple questions
    * Question types:

        * Multiple Choice (single correct)
        * True / False
        * Text (manual correctness check via exact match)
* Define correct answers
* Publish quiz (generate public link)

#### Public Quiz Page

* View quiz
* Answer questions
* Submit quiz
* View results:

    * Score
    * Correct vs incorrect answers

#### Backend

* REST APIs for:

    * Quiz creation
    * Fetch quiz by ID
    * Submit quiz answers

---

### Out of Scope (for now)

* User authentication & profiles
* Quiz attempt history
* Timed quizzes
* Advanced analytics
* Question banks & reuse

---

### Backend

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate

### Database

* H2-Database

### IDE & Tools

* Intellij
* Git & GitHub
* Postman for API testing

---

## 6. Database Schema (Initial)

### Quiz

| Column    | Type        |
| --------- | ----------- |
| id        | BIGINT (PK) |
| title     | VARCHAR     |
| published | BOOLEAN     |

### Question

| Column   | Type                         |
|----------| ---------------------------- |
| id       | BIGINT (PK)                  |
| quiz_id  | BIGINT (FK)                  |
| type     | ENUM (MCQ, TRUE_FALSE, TEXT) |
| question | TEXT                         |

### Option (for MCQ)

| Column      | Type        |
|-------------| ----------- |
| id          | BIGINT (PK) |
| question_id | BIGINT (FK) |
| text        | VARCHAR     |
| is_correct  | BOOLEAN     |


---

## 7. API Design (Sample)

* `POST /api/admin/quizzes`
* `GET /api/quizzes/{id}`
* `POST /api/quiz/{id}/submit`

---

## 8. Development Approach

1. Create PLAN.md
2. Initialize Git repository
3. Backend:

    * Entity & schema design
    * Quiz creation APIs
    * Submission & evaluation logic
4. Manual testing
5. Documentation & demo recording

---

## 9. Commit Strategy

* Initial project setup
* Backend entities & repositories
* Quiz APIs
* Submission & result display
* Final polish & documentation

---

## 10. Scope Changes During Implementation

* Submit quiz and view results are part on same api

---

## 11. Reflection (What I’d Do Next)

If I had more time, I would:
* Could have used DTO's and map struct for getting the list of entites inside an entity.
* Add unit test and integration tests
* Used constructor injection instead for @Autowired
* Add frontend
* Deploy this project
* Add authentication and role‑based access

---

## 12. Deliverables Checklist

* [ ] GitHub repo
* [ ] PLAN.md
* [ ] Minimum 4 commits
* [ ] Screen + audio recording
* [ ] Demo walkthrough
* [ ] Deployment link (optional)
