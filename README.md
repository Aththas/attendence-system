# Spring Boot Project Setup

This is a Spring Boot application that provides file-based login, logout basic functionalities. User Credentials in users.txt under resources/static folder.

## Prerequisites

Before you begin, make sure you have the following installed:

- **Java 21** (Java 8 or later can also work but upgrading is recommended for better performance and features).
  - You can verify if Java is installed by running:
    ```bash
    java -version
    ```
  - If you don’t have Java installed, you can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use OpenJDK.

- **Maven** (for building the project)
  - You can verify if Maven is installed by running:
    ```bash
    mvn -v
    ```
  - If not, you can download Maven from [Maven's website](https://maven.apache.org/).

- **IDE (Optional but recommended)**: 
  - IntelliJ IDEA, Eclipse, or Visual Studio Code are recommended for Spring Boot development.

## Getting Started

### Clone the Repository
    git clone https://github.com/Aththas/attendence-system.git

### Install Http-Server
    npm install -g http-server

## To setup frontend

##### 1. Go to the Client folder
    cd attendence-system/Client

##### 2. Setup frontend server on port 3000
    http-server -p 3000

## To setup backend

##### 1. Go to the Server folder
    cd attendence-system/Server

##### 2. Use maven to build the project
    mvn clean install

##### 3. Run the project
    mvn spring-boot:run


 

