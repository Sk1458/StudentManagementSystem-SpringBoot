# Student Management System

## Project Overview

The **Student Management System** is a web application built using **Spring Boot**, **Thymeleaf**, and **JPA**. It allows users to perform CRUD (Create, Read, Update, Delete) operations on student records. The system is designed to be user-friendly, providing an intuitive interface to manage student details such as name, roll number, course, age, branch, and city.

## Features

- **View Students**: Displays a list of all students in a table format.
- **Add Student**: Allows users to add a new student to the system by entering details in a form.
- **Update Student**: Enables users to edit the details of an existing student.
- **Delete Student**: Allows users to remove a student from the system.
- **Status Page**: Displays a confirmation message after performing an action (such as adding or updating a student).

## Tech Stack

- **Backend**: Java, Spring Boot, JPA (Hibernate)
- **Frontend**: Thymeleaf, HTML, CSS
- **Database**: MySQL (or any other database of your choice)
- **Version Control**: Git

### Prerequisites

Before running the project, ensure you have the following installed:

- Java 17 or higher
- Maven or Gradle (for building the project)
- IDE (such as IntelliJ IDEA or Eclipse) to run the project

---

## Screenshots

### Home Page
![home](https://github.com/user-attachments/assets/407b10b0-b474-43c2-b08a-2a1e17cb2acf)

### Insert Student Page
![insert](https://github.com/user-attachments/assets/6076a5fa-21cb-4ee9-b0bd-b174620c3f99)

### View Students
![view](https://github.com/user-attachments/assets/81d7c28b-fd23-4fa0-aca9-8be1ac005068)

### Search Students
![search](https://github.com/user-attachments/assets/c702d245-8b92-4b10-bb7a-1650997ca993)

---

### How to run the project

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/student-management-system.git
   cd student-management-system

2. **Configure the database:**
    - Open the application.properties or application.yml file located in:
      ```bash
       src/main/resources/.
      
    - Update the database credentials:
      ```bash
      spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
      spring.datasource.username=your-username
      spring.datasource.password=your-password

3. **Run the project:**
    - Open the project in any Java-supported IDE (e.g., IntelliJ IDEA, Eclipse).
    - Run the project as a Spring Boot application.

4. **Access the application:**
    - Once the project is running, open your browser and visit:
      ```bash
      http://localhost:<your-selected-port>/home
    - Replace "your-selected-port" with the port number configured in your application.
  
## Project Directory Structure

```bash
SpringBoot_Web-Jpa-Sql-Thyme-DevTools2
    │
    ├───.mvn
    │   └───wrapper
    ├───.settings
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───com
    │   │   │       └───example
    │   │   │           └───demo
    │   │   │                  / All the .Java files are here
    │   │   └───resources
    │   │       │   application.properties
    │   │       │
    │   │       ├───static
    │   │       └───templates
    │   │                     / All the HTML pages are here
    │   └───test
    │       └───java
    │           └───com
    │               └───example
    │                   └───demo
    └───target
        ├───classes
        │   ├───com
        │   │   └───example
        │   │       └───demo
        │   │                / All the .class files are here
        │   ├───META-INF
        │   │   └───maven
        │   │       └───CSE21
        │   │           └───SpringBoot_Web-Jpa-Sql-Thyme-DevTools2
        │   │                   pom.properties
        │   │                   pom.xml
        │   │
        │   └───templates
        └───test-classes
            └───com
                └───example
                    └───demo
              
