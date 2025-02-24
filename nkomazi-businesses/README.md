# Learning Spring Boot

This repository contains all the projects created while learning Spring Boot. Each project will focus on different aspects of Spring Boot development, covering topics such as RESTful APIs, authentication, database integration, and more.

## Projects

### 1. Business Directory (Nkomazi)

#### Overview
The first project in this repository is a Business Directory for Nkomazi. This project allows business owners to create accounts and add their businesses. They can also edit business details. For simplicity, authentication (login/logout) will be skipped for now.

#### Features
- Create a new business
- Edit business details
- Retrieve all businesses
- Retrieve a specific business by ID
- Delete a business

#### API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| **POST** | `/businesses` | Create a new business |
| **GET** | `/businesses` | Retrieve all businesses |
| **GET** | `/businesses/{id}` | Retrieve a specific business by ID |
| **PUT** | `/businesses/{id}` | Update business details |
| **DELETE** | `/businesses/{id}` | Delete a business |

#### Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- H2 Database (for development)
- RESTful API principles

#### How to Run the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/learning-springboot.git
   cd learning-springboot/business-directory
   ```
2. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```
3. The API will be accessible at `http://localhost:8080`

---
More projects will be added as I progress in learning Spring Boot!

