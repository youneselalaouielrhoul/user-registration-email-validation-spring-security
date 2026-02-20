# 🔐 Spring Security User Registration with Email Validation

A full-stack user authentication system built with **Spring Boot 3.4** and **Spring Security 6**, featuring secure user registration with email-based account verification.

---

## ✨ Features

- **User Registration** — Sign up with first name, last name, username, email, and password
- **Email Verification** — Confirmation email sent via Gmail SMTP with a unique token link
- **Time-Limited Tokens** — Verification tokens expire after 15 minutes for security
- **Password Encryption** — Passwords hashed using BCrypt before storage
- **Role-Based Access Control** — Users assigned roles (e.g. `USER`) upon registration
- **Account Locking** — Support for locking/unlocking user accounts
- **Protected Routes** — All routes require authentication except registration endpoints
- **Form-Based Login** — Spring Security's built-in login/logout functionality
- **Server-Side Rendering** — Thymeleaf templates for registration, confirmation, and home pages

---

## 🛠️ Tech Stack

| Layer          | Technology                          |
|----------------|-------------------------------------|
| Framework      | Spring Boot 3.4.2                   |
| Security       | Spring Security 6                   |
| Database       | PostgreSQL                          |
| ORM            | Spring Data JPA / Hibernate         |
| Templating     | Thymeleaf + Thymeleaf Spring Security Extras |
| Email          | Spring Mail (Gmail SMTP)            |
| Build Tool     | Maven                               |
| Java Version   | 21                                  |

---

## 📁 Project Structure

```
src/main/java/com/yar05/auth_demo/
├── AuthenticationDemoApplication.java   # Main application entry point
├── config/
│   ├── PasswordConfig.java              # BCrypt password encoder bean
│   └── SecurityConfig.java              # Spring Security filter chain configuration
├── controller/
│   ├── AuthenticationController.java    # Registration & token confirmation endpoints
│   └── HomeController.java             # Home page controller
├── entity/
│   ├── Role.java                        # User role enum
│   ├── Token.java                       # Email confirmation token entity
│   └── User.java                        # User entity (implements UserDetails)
├── repository/
│   ├── TokenRepository.java             # Token data access
│   └── UserRepository.java             # User data access
└── service/
    ├── EmailService.java                # Email sending logic
    ├── TokenService.java                # Token CRUD operations
    └── UserService.java                 # User registration, authentication & token confirmation
```

---

## ⚙️ Prerequisites

- **Java 21** or higher
- **Maven 3.8+**
- **PostgreSQL** installed and running
- **Gmail account** with an [App Password](https://support.google.com/accounts/answer/185833) generated

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/youneselalaouielrhoul/user-registration-email-validation-spring-security.git
cd user-registration-email-validation-spring-security
```

### 2. Set up PostgreSQL

Create a database named `authDb`:

```sql
CREATE DATABASE authDb;
```

### 3. Configure `application.properties`

Update `src/main/resources/application.properties` with your credentials:

```properties
# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/authDb
spring.datasource.username=<your-postgres-username>
spring.datasource.password=<your-postgres-password>

# Email (Gmail SMTP)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<your-email@gmail.com>
spring.mail.password=<your-gmail-app-password>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### 4. Run the application

```bash
./mvnw spring-boot:run
```

The application will start on **http://localhost:8080**.

---

## 📖 How It Works

1. **Register** — Navigate to `/register` and fill in the registration form
2. **Email Sent** — A confirmation email with a unique token link is sent to your email
3. **Confirm** — Click the link in the email (valid for 15 minutes) to verify your account
4. **Login** — Once verified, log in at `/login` with your username and password
5. **Access** — Authenticated users can access protected routes like the home page

---

## 🔒 Security Configuration

- `/register/**` endpoints are **publicly accessible**
- All other endpoints require **authentication**
- Uses Spring Security's default **form login** and **logout**
- Passwords are encoded with **BCrypt**
- Users must **verify their email** before the account is enabled

---

## 📬 Email Setup (Gmail)

To use Gmail SMTP, you need to generate an **App Password**:

1. Go to [Google Account Security](https://myaccount.google.com/security)
2. Enable **2-Step Verification** if not already enabled
3. Navigate to **App Passwords**
4. Generate a new app password for "Mail"
5. Use the generated 16-character password in `application.properties`

---
