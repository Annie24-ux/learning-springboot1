# Learning Spring Boot

This repository contains all the projects created while learning Spring Boot. Each project focuses on different aspects of Spring Boot development, covering topics such as RESTful APIs, authentication, database integration, and more. The goal of this repository is to document the learning process, experiment with different features, and build real-world applications.

## Getting Started
To run the projects in this repository, ensure you have the following installed:
- Java 17 or later
- Spring Boot (latest version)
- Maven or Gradle
- MySQL or SQL-based database
- Postman or any API testing tool
- IntelliJ IDEA or VS Code (Recommended IDEs)

Each project contains its own setup instructions, dependencies, and configurations. Refer to individual project directories for more details.

## Projects
### 1. Nkomazi Businesses (CRUD Operations)
**Description:**
This project is a RESTful API that manages business listings in the Nkomazi region. It provides CRUD (Create, Read, Update, Delete) operations to store and manage business details.

**Features:**
- RESTful API endpoints for managing businesses
- Spring Boot with JPA and Hibernate
- MySQL database integration
- DTO (Data Transfer Object) implementation
- Exception handling and validation
- Swagger documentation for API endpoints

**Technology Stack:**
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger (API Documentation)

**Endpoints:**
- `POST /api/businesses` – Add a new business
- `GET /api/businesses` – Retrieve all businesses
- `GET /api/businesses/{id}` – Get a business by ID
- `PUT /api/businesses/{id}` – Update business details
- `DELETE /api/businesses/{id}` – Remove a business listing

### 2. Photos-Clone
**Description:**
This is a simple photo-sharing application that allows users to upload, retrieve, and manage images. The application follows a REST API structure and integrates cloud storage for storing images.

**Features:**
- Upload and retrieve images
- Store images in a cloud storage service (planned for future integration)
- Generate URLs for accessing images
- Exception handling and response formatting
- Authentication (JWT-based authentication in progress)

**Technology Stack:**
- Java
- Spring Boot
- Spring Security (planned for authentication)
- MySQL/SQL-based database

**Endpoints:**
- `POST /api/photos/upload` – Upload an image
- `GET /api/photos/{id}` – Retrieve an image
- `DELETE /api/photos/{id}` – Delete an image

## Future Projects
- **User Authentication & Authorization:** Implementing JWT-based authentication with role-based access control.
- **E-commerce API:** Developing a backend for an online store with product management, cart functionality, and payment integration.
- **Task Management Application:** Creating a RESTful API for managing tasks, assigning users, and tracking progress.

## Contribution
As this is a learning repository, contributions are welcome! Feel free to fork this repository, improve the projects, or suggest new ideas.

## Contact
For any inquiries, reach out via GitHub issues or connect via email.

---
This repository will be continuously updated as more projects are added and improvements are made.

