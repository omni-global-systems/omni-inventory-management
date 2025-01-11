Here’s a sample README for the `inventory-management` microservice:

---

# Inventory Management Microservice

This is the Inventory Management microservice for managing product inventory in a restaurant. It allows restaurants to track their stock, manage suppliers, place orders, and handle order items. The service is built using Spring Boot and interacts with a PostgreSQL database.

## Features
- Manage products in inventory (CRUD operations)
- Manage suppliers for products
- Place orders for products and track order items
- Track product restock thresholds
- Track product supply history
- Flyway for database migrations
- RESTful API for interaction

## Prerequisites
- Java 17 or later
- Maven 3.x or later
- PostgreSQL 17.x (or compatible)
- Spring Boot 3.x

## Setup Instructions

### 1. Clone the Repository
Clone this repository to your local machine:

```bash
git clone https://github.com/your-org/inventory-management.git
```

### 2. Configure Database
Ensure you have PostgreSQL running. Create a database named `inventory_management` and a schema `inventory_management`.

You can configure the database connection details in the `application.yml` file:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/inventory_management
    username: your-db-username
    password: your-db-password
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  flyway:
    enabled: true
    locations: classpath:db/migration
```

### 3. Build the Application
Build the project using Maven:

```bash
mvn clean install
```

### 4. Run the Application
Run the application using the following command:

```bash
mvn spring-boot:run
```

The application will start on port `8080` by default.

### 5. Access the API
The microservice exposes the following endpoints:

#### Products
- **GET** `/products`: List all products
- **GET** `/products/{id}`: Get details of a specific product by ID
- **POST** `/products`: Create a new product
- **PUT** `/products/{id}`: Update an existing product
- **DELETE** `/products/{id}`: Delete a product

#### Suppliers
- **GET** `/suppliers`: List all suppliers
- **GET** `/suppliers/{id}`: Get details of a specific supplier by ID
- **POST** `/suppliers`: Create a new supplier
- **PUT** `/suppliers/{id}`: Update an existing supplier
- **DELETE** `/suppliers/{id}`: Delete a supplier

## Database Schema
The database schema includes tables for products, suppliers
![Inventory-Management](https://github.com/user-attachments/assets/0b8a0913-9009-4cc4-9fc1-3381b5073457)


### Database Migrations
Flyway is used for handling database migrations. The migration scripts are located in the `src/main/resources/db/migration/` directory.

## Running Tests

To run unit tests and integration tests, use the following command:

```bash
mvn test
```

## Troubleshooting
- **Database connection issues**: Check your database URL, username, and password in the `application.yml` file.
- **Flyway migration issues**: Ensure that the migration scripts are placed in the correct directory (`src/main/resources/db/migration`).
- **Port conflicts**: If port 8080 is already in use, you can change the port in the `application.yml` file:

```yaml
server:
  port: 9090
```

## Contribution
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

This README provides basic instructions for setting up, running, and using the Inventory Management microservice. Adjust it as needed based on your project's specifics or additional features!
