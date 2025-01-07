# Task Manager
## Overview
The Task Manager is a simple Spring Boot application that allows users to create, update, delete, and view tasks. This project demonstrates the fundamentals of Java, OOP principles, RESTful APIs, and Spring Boot features such as Spring Data JPA for database interaction.

The main purpose of this application is to allow users to manage their daily tasks efficiently.

## Features
- **Add a new task** with a description and status.
- **Update** task details (e.g., mark a task as completed).
- **Delete** a task.
- **List** all tasks with filter options (e.g., by status).
- **View** task details.

## Technologies
The following technologies are used in this project:
- **Java 17**: Core programming language.
- **Spring Boot**: Backend framework for building RESTful services.
- **Spring Data JPA**: Used for interacting with a relational database.
- **H2 Database**: In-memory database for testing and development.
- **JUnit 5**: For unit testing.
- **Mockito**: For mocking dependencies in tests.
- **Maven**: For dependency management.

## Setup and Installation
**Prerequisites**
To run this application, ensure you have the following installed:

- Java 17 or later
- Maven 3.6 or later

## Steps to Run the Project
1- **Clone the repository**:

```bash
git clone https://github.com/guteingenieur/task-manager.git
cd task-manager
```

2- **Run the application**: You can use Maven to run the Spring Boot application:

```bash
mvn spring-boot:run
```

3- **Access the application**: The API will be accessible at `http://localhost:8080/api/tasks`.

### H2 Database Console
The H2 database can be accessed through a web interface for debugging or viewing data.

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `-blank-`


## API Endpoints

| HTTP Method	 | Endpoint           | Description               |
|--------|--------------------|---------------------------|
| GET    | `/api/tasks`        | Retrieve all tasks             |
| GET   | `/api/tasks/{id}`        | Retrieve task by ID         |
| POST    | `/api/tasks`   | Create a new task |
| PUT    | `/api/tasks/{id}`   | Update task by ID       |
| DELETE | `/api/tasks/{id}`   | Delete a task by ID       |

## Example Task Object
``` json
{
  "id": 1,
  "description": "Complete project documentation",
  "status": "In Progress"
}
```

## Testing
The application includes unit tests and integration tests to ensure the functionality of the core components. Run the tests using Maven:

```bash
mvn test
```

## Future Improvements
- Add user authentication and authorization.
- Add the ability to assign tasks to specific users.
- Implement task categorization (e.g., personal, work).

## Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue for any bugs or feature requests. Before submitting a pull request, ensure the code passes all tests and follows the code style guidelines.
