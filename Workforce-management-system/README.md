# Workforce Management System
# Members
Dagmawi Elias Lewi ---------- UGR/2645/14
Nobel Tibebe Alemayehu ------ UGR/5954/14

## Overview
The Workforce Management System is a web application designed to manage employee data, schedules, and tasks efficiently. It leverages Spring Boot for the backend, Vaadin for the frontend, and MySQL as the database.

## Features
- Employee management: Add, update, and delete employee records.
- Schedule management: Create and manage work schedules.
- Task management: Assign and track tasks for employees.
- User authentication and authorization.

## Technologies Used
- **Spring Boot**: Backend framework.
- **Vaadin**: Frontend framework.
- **MySQL**: Database.
- **Hibernate**: ORM for database interactions.
- **Maven**: Build and dependency management tool.

## Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher

## Setup Instructions
1. **Clone the repository**:
    ```bash
    git clone <repository-url>
    cd Workforce-management-system
    ```

2. **Create the database**:
    ```sql
    CREATE DATABASE workforcedb;
    ```

3. **Configure the database connection**:
    Update the `src/main/resources/application.properties` file with your MySQL credentials.

4. **Build the project**:
    ```bash
    mvn clean install
    ```

5. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

6. **Access the application**:
    Open your browser and navigate to `http://localhost:8080`.

## Project Structure
- `src/main/java/com/example/application`: Contains the main application code.
- `src/main/resources`: Contains the application properties and static resources.
- `src/test`: Contains the test cases.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

## License
This project is licensed under the MIT License.
