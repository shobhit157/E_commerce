# E-Commerce Application
A scalable e-commerce backend built with Spring Boot and microservices architecture.
This project is a backend system for an e-commerce platform, built using Spring Boot with a microservices architecture. It includes User Management, Product Search, Order Management, and Authentication & Authorization. It leverages Spring Security, JWT, and OAuth (Okta) for secure access.
#Features:
- Microservices architecture with Eureka service discovery.
- Secure authentication using JWT & Okta OAuth.
- RESTful APIs for product search, order management, and user authentication.
- MySQL database for structured data storage.
- JUnit testing for controllers & services.

#Main Components:
- E-Commerce Service - Manages product searches & orders.
- User Service - Handles user authentication & profiles.


## API Endpoints
| Endpoint | Method | Description |
|---------|--------|------------|
| `/api/products` | GET | Get all products |
| `/api/products/{id}` | GET | Get product by ID |
| `/api/orders` | POST | Create a new order |
| `/api/users/register` | POST | Register a new user |
| `/api/users/login` | POST | Authenticate user |
