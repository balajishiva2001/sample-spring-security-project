# 🛡️ Sample Spring Security Project

A Spring Boot application demonstrating authentication and authorization using Spring Security.  
Secure your REST APIs with role-based access control and JWT tokens.

---

## 🔧 Features

- 🔐 User authentication with JWT tokens  
- 🔒 Role-based access control for protected endpoints  
- ⚙️ Secure REST API endpoints  
- 🚀 Built using Spring Boot for rapid development  

---

## 📦 Tech Stack

- Backend: Java 17 & Spring Boot  
- Security: Spring Security with JWT  
- Build Tool: Maven  

---

## 🛠️ Setup Instructions

### 1️⃣ Prerequisites

Ensure you have the following installed:

- ☕ Java 17 — https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html  
- 📦 Maven — https://maven.apache.org/install.html  
- 🖥️ Your favorite IDE (IntelliJ IDEA, VS Code, etc.)  
- 🔧 Git — https://git-scm.com/downloads  

---

### 2️⃣ Clone the Repository
```bash
git clone https://github.com/balajishiva2001/sample-spring-security-project.git  
cd sample-spring-security-project
```

---

### 3️⃣ Build the Project

Using Maven Wrapper:
```bash
./mvnw clean install
```
Or Maven directly:
```bash
mvn clean install
```

---

### 4️⃣ Run the Application

Start the Spring Boot server:
```bash
./mvnw spring-boot:run
```
Or:
```bash
mvn spring-boot:run
```
Access the app at: http://localhost:8080

---

### 5️⃣ API Endpoints

Method | Endpoint             | Description                       
-------|----------------------|-----------------------------------
POST   | /api/auth/login      | Authenticate user and get JWT     
GET    | /api/user/profile    | Access protected user profile     

> Note: Protected endpoints require the `Authorization: Bearer <JWT>` header.

---

### 6️⃣ (Optional) Run Tests
```bash
./mvnw test
```
Or:
```bash
mvn test
```

---

## 📂 Project Structure
```
sample-spring-security-project/  
├── src/  
│   ├── main/  
│   │   ├── java/com/example/demo/    # Source code: controllers, services, security configs  
│   │   ├── resources/                # Config files (application.properties)  
│   └── test/                        # Test cases  
├── mvnw                            # Maven wrapper scripts  
├── pom.xml                        # Maven build file  
└── README.md                      # This file  
```

---

## 📌 Future Improvements

- ➕ Add user registration and profile management  
- 🔒 Enhance security with refresh tokens  
- 📚 Add Swagger UI for API documentation  
- ⚙️ Integrate OAuth2 login  

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork, create branches, and submit pull requests.  
Let’s build secure and scalable applications together! 🚀

---

## 📜 License

This project is licensed under the MIT License. See the LICENSE file for details.

---

## 🙋 Author

Balaji Shiva  
GitHu
