ByteCupids Backend - Technical Documentation
===========================================

Overview
--------
ByteCupids Backend is a Spring Boot application written in Java (with some Kotlin build tooling), following a layered (Clean/DDD-inspired) architecture. It provides authentication, user management, and lab resource APIs, with JWT-based security and PostgreSQL persistence.

Tech Stack
----------
- Java 17
- Spring Boot 3.2.x
- Spring Data JPA
- Spring Security (JWT)
- PostgreSQL
- Gradle (Kotlin DSL)

Directory Structure
-------------------
::

    .
    ├── build.gradle.kts
    ├── settings.gradle.kts
    ├── src/
    │   ├── main/
    │   │   ├── java/com/java/bytecupidsbackend/
    │   │   │   ├── application/
    │   │   │   ├── domain/
    │   │   │   ├── infrastructure/
    │   │   │   └── presentation/
    │   │   └── resources/
    │   └── test/
    └── ...

Layered Architecture
--------------------

1. **Presentation Layer**
   - **Controllers**: REST API endpoints.
   - **DTOs**: Data Transfer Objects for requests/responses.

2. **Application Layer**
   - **Use Cases**: Business logic, orchestrates domain and infrastructure.

3. **Domain Layer**
   - **Models**: Core business entities.
   - **Repositories**: Interfaces for data access.

4. **Infrastructure Layer**
   - **Persistence**: JPA entities, repository adapters.
   - **Security**: JWT provider, security config.
   - **Config**: Spring configuration classes.

5. **Resources**
   - **application.properties**: Environment and DB config.

Key Components
--------------

Main Application Entry Point
~~~~~~~~~~~~~~~~~~~~~~~~~~~
- `ByteCupidsBackendApplication.java`
  - Standard Spring Boot main class.

Build/Dependency Management
~~~~~~~~~~~~~~~~~~~~~~~~~~~
- `build.gradle.kts`
  - Declares dependencies for Spring Boot, JPA, Security, JWT, PostgreSQL, and testing.

Presentation Layer
~~~~~~~~~~~~~~~~~~

Controllers
^^^^^^^^^^^
- `AuthController`
  - `POST /bytecupids/auth/register`: Register a new user.
  - `POST /bytecupids/auth/login`: Login and receive JWT tokens.
- `LibraryResourceController`
  - `POST /bytecupids/lab/get_resources`: Get resources for a module.
- `LabModulesController`
  - `POST /bytecupids/lab/get_modules`: Get all lab modules.
- `LabTopicsController`
  - `POST /bytecupids/lab/get_topics`: Get topics for a module.

DTOs
^^^^
- `LoginRequest`: `{ email, password }`
- `LoginResponse`: `{ accessToken, refreshToken, user, message, status, error, success, code, timestamp }`
- `RegisterRequest`: `{ username, email, password }`
- `RegisterResponse`: `{ user, message, status, error, success, code, timestamp }`
- `LabTopicsRequest`: `{ moduleId, accessToken }`
- `LabTopicsResponse`: `{ topics, message, status, error, timestamp, code, success }`
- (Similar DTOs for library resources and modules.)

Application Layer
~~~~~~~~~~~~~~~~~

Use Cases
^^^^^^^^^
- `LoginUserUseCase`
  - Validates user credentials, generates JWT tokens, returns `LoginResponse`.
- `RegisterUserUseCase`
  - Registers a new user, hashes password, returns `RegisterResponse`.
- (Other use cases for modules, topics, and resources.)

Domain Layer
~~~~~~~~~~~~

Models
^^^^^^
- `User`: `{ uuid, username, email, password }`
- `Module`, `Topic`, `LibraryResource`: Represent lab modules, topics, and resources.

Repositories
^^^^^^^^^^^^
- `UserRepository`
  - `Optional<User> findByEmail(String email)`
  - `void save(User user)`
- (Similar interfaces for modules, topics, and resources.)

Infrastructure Layer
~~~~~~~~~~~~~~~~~~~~

Persistence
^^^^^^^^^^^
- **Entities**: JPA-mapped classes for `UserEntity`, `ModuleEntity`, `TopicEntity`, `LibraryResourceEntity`.
- **Adapters**: Implement repository interfaces using JPA repositories.

Security
^^^^^^^^
- `JwtProvider`
  - Generates JWT and refresh tokens for users.
  - Uses HS512 and a base64-encoded secret.
- `SecurityConfig`
  - Configures Spring Security for JWT authentication.

Configuration
^^^^^^^^^^^^^
- `application.properties`
  - Sets up DB connection, JPA, and SQL initialization.
  - Example:
    ::
      spring.datasource.url=jdbc:postgresql://...
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true

How to Extend/Modify
--------------------
- **Add a new API**: Create a new controller and DTOs in `presentation`, add a use case in `application`, update domain models/repositories if needed, and implement persistence in `infrastructure`.
- **Change DB schema**: Update JPA entities and domain models, adjust repositories and adapters.
- **Add authentication/authorization**: Update `SecurityConfig` and/or `JwtProvider`.

Testing
-------
- Test structure mirrors main package, but no test files were found in this scan.

Summary
-------
This backend is modular, with clear separation of concerns. All business logic is in use cases, data access is abstracted via repositories, and security is handled with JWT. The codebase is ready for extension and easy for new contributors to understand. 