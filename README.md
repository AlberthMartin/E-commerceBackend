# E-commerce Backend built with Java Spring Boot, MySQL, Spring Security & JWT

I built this project to deepen my understanding of how to develop a professional backend using Java Spring Boot. In my university courses, I learned Java, but not how to create production-ready REST APIs or implement role-based authentication with Spring Security and JWT. This project also helped me refresh my skills in designing relational databases with MySQL.

## Complete Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- Spring Security
- Spring Web
- JWT Authentication
- MySQL Database
- Maven
- Lombock
- Postman for API Testing
- Java Spring Boot Architecture (Controller -> Service -> Repository -> Model, Dto's )

## Features Summary
  - CRUD for Products and Categories
  - Cart Management (each User has 1  cart and can **add, remove and update items**)
  - Order Management and Checkout
  - JWT-based Login and Authorization
  - Role-Based API Security with Spring Security & JWT

## Database Diagram (MySQL)
<img width="808" height="913" alt="image" src="https://github.com/user-attachments/assets/a995ed85-caa9-458d-a1f1-e65e58cc5e5b" />


## REST API endpoints
All endpoints are prefixed with /api/v1/

### AuthController, /auth
| Method   | Endpoint  | Description                                 |
| -------- | --------- | ------------------------------------------- |
| **POST** | `/login`  | Authenticate a user and return a JWT token. |
| **POST** | `/logout` | Invalidate user session / JWT token.        |

### CartController, /carts
| Method     | Endpoint                     | Description                               |
| ---------- | ---------------------------- | ----------------------------------------- |
| **GET**    | `/{cartId}/my-cart`          | Retrieve a user’s current cart.           |
| **DELETE** | `/{cartId}/clear`            | Remove all items from a cart.             |
| **GET**    | `/{cartId}/cart/total-price` | Calculate total price of items in a cart. |


### CartItemController, /cartItems
| Method     | Endpoint                                           | Description                          |
| ---------- | -------------------------------------------------- | ------------------------------------ |
| **POST**   | `/item/add?productId={id}&quantity={q}`            | Add a product to the cart.           |
| **DELETE** | `/cart/{cartId}/item/{itemId}/remove`              | Remove an item from a specific cart. |
| **PUT**    | `/cart/{cartId}/item/{itemId}/update?quantity={q}` | Update item quantity in a cart.      |

### CategoryController, /categories
| Method     | Endpoint                    | Description                 |
| ---------- | --------------------------- | --------------------------- |
| **GET**    | `/all`                      | Get all product categories. |
| **POST**   | `/add`                      | Add a new category.         |
| **GET**    | `/category/{id}/category`   | Get category by ID.         |
| **GET**    | `/category/{name}/category` | Get category by name.       |
| **PUT**    | `/category/{id}/update`     | Update a category by ID.    |
| **DELETE** | `/category/{id}/delete`     | Delete a category by ID.    |

### ImageController, /images
| Method     | Endpoint                    | Description                                            |
| ---------- | --------------------------- | ------------------------------------------------------ |
| **POST**   | `/upload`                   | Upload product images (`MultipartFile` + `productId`). |
| **GET**    | `/image/download/{imageId}` | Download an image by ID.                               |
| **PUT**    | `/image/{imageId}/update`   | Update an existing image.                              |
| **DELETE** | `/image/{imageId}/delete`   | Delete an image by ID.                                 |

### OrderController, /orders
| Method   | Endpoint             | Description                               |
| -------- | -------------------- | ----------------------------------------- |
| **POST** | `/order?userId={id}` | Create a new order for a user.            |
| **GET**  | `/{orderId}/order`   | Get order details by order ID.            |
| **GET**  | `/{userId}/order`    | Get all orders placed by a specific user. |

### ProductController, /products
| Method     | Endpoint                                                 | Description                         |
| ---------- | -------------------------------------------------------- | ----------------------------------- |
| **GET**    | `/all`                                                   | Get all products.                   |
| **GET**    | `/product/{id}/product`                                  | Get product by ID.                  |
| **GET**    | `/products/{name}/products`                              | Get products by name.               |
| **GET**    | `/product/by-brand?brand={brand}`                        | Get products by brand.              |
| **GET**    | `/product/{category}/all/products`                       | Get products by category.           |
| **GET**    | `/products/by/brand-and-name?brand={b}&name={n}`         | Get products by brand and name.     |
| **GET**    | `/products/by/category-and-brand?category={c}&brand={b}` | Get products by category and brand. |
| **GET**    | `/product/count/by-brand/and-name?brand={b}&name={n}`    | Count products by brand and name.   |
| **POST**   | `/add` *(ADMIN only)*                                    | Add a new product.                  |
| **PUT**    | `/product/{id}/update` *(ADMIN only)*                    | Update an existing product.         |
| **DELETE** | `/product/{id}/delete` *(ADMIN only)*                    | Delete a product.                   |

### UserController, /users
| Method     | Endpoint           | Description            |
| ---------- | ------------------ | ---------------------- |
| **GET**    | `/{userId}/user`   | Retrieve a user by ID. |
| **POST**   | `/create`          | Create a new user.     |
| **PUT**    | `/{userId}/update` | Update user details.   |
| **DELETE** | `/{userId}/delete` | Delete a user.         |


## Folder Structure
<img width="205" height="291" alt="image" src="https://github.com/user-attachments/assets/3d3552c6-e022-423e-af50-85728e6ba835" />

## Reflection
This project helped me: 
- Deeply understand the Spring Boot backend architecture.
- Build a fully functional REST API using best practices.
- Learn Spring Security and JWT authentication hands-on.
- Strengthen my understanding of JPA relationships and DTO patterns.
- Gain confidence in building real-world backend applications.

## How to Run the Project
1. Clone repo
2. Update your resources/application.properties, example structure from my project:
```bash
spring.application.name=shoppingCartBackend

spring.datasource.url=jdbc:mysql://localhost:3306/shoppingdb
spring.datasource.username=shoppinguser
spring.datasource.password=password123

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

##update = database is saved
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
##To show database in terminal
spring.jpa.properties.hibernate.format_sql=true

api.prefix=/api/v1

spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB

## 1 hour
auth.token.expirationInMils=3600000
auth.token.jwtSecret=YOUR_JWT_SECRET
```
3. Run the project
```bash
mvn spring-boot:run
```
4. Test the API using Postman
