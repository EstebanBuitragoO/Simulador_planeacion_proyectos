# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**Simulador_planeacion_proyectos** is a Java Swing desktop application for project planning and management. It uses JPA with EclipseLink as the ORM and MariaDB as the database.

## Architecture

The application follows a layered MVC architecture:

- **Models**: JPA entities representing domain objects (UserModel, ProjectModel, TaskModel, DependencyModel)
- **Views**: Swing GUI components using CardLayout for authentication flow
- **Controllers**: Business logic layer that orchestrates between Views and Services
- **Services**: Application services containing business rules and validation
- **ORM**: Data access layer with JPA repositories and utility classes

### Key Components

- **Main Entry Point**: `spp_mysql.SPP_Mysql` - launches the authentication window
- **Authentication Flow**: `Views.JFAuth` uses CardLayout to switch between login and register panels
- **Database**: Configured for MariaDB at `localhost:3306/spp` (see persistence.xml)
- **JPA Configuration**: `META-INF/persistence.xml` with persistence unit "sppPU"

## Build and Run Commands

### Prerequisites
- Java 17
- MariaDB server running on localhost:3306
- Database named "spp" (will be auto-created if using DDL generation)

### Maven Commands
```bash
# Compile the project
mvn compile

# Run the application
mvn exec:java

# Build JAR package
mvn package

# Clean build artifacts
mvn clean
```

### NetBeans Integration
The project includes `nbactions.xml` for NetBeans IDE integration with run, debug, and profile actions.

### Database Setup
- The application expects MariaDB running on localhost:3306
- Database user: root (no password)
- Database name: spp
- Tables are auto-created via `eclipselink.ddl-generation=create-tables`

## Development Notes

### JPA Configuration
- Persistence unit: "sppPU"
- Provider: EclipseLink
- Entities are explicitly listed in persistence.xml
- DDL generation enabled for development

### Package Structure
- `Models.*`: JPA entity classes
- `Views.*`: Swing UI components
- `Controllers.*`: Business controllers
- `Services.*`: Application services
- `ORM.*`: Data access layer with utilities and exceptions

### Database Credentials
Database connection details are in `src/main/resources/META-INF/persistence.xml`. Update these for different environments.