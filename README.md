# 🔓 AuthSphere Client

A sample **OAuth 2.0 / OpenID Connect client application** built with Spring Boot and Spring Security. AuthSphere Client demonstrates how a real-world application delegates authentication to the **AuthSphere Identity Provider**, using the OAuth 2.0 Authorization Code Flow with PKCE instead of implementing its own login system.

## 🚀 Tech Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Spring Boot | Application framework |
| Spring Security | OAuth2 Client / login integration |
| OAuth 2.0 | Authorization protocol |
| OpenID Connect | Authentication / identity layer |
| Maven | Build and dependency management |

## ✨ Features

- 🔐 **Delegated Authentication** - no local login system, no password handling
- 🌐 **OAuth 2.0 Login** - integrates with Spring Security's OAuth2 Client
- 🪪 **OIDC Identity** - reads authenticated user info from the ID Token
- 🎟️ **Session Management** - authenticated session created after token exchange
- 🔗 **SSO-ready** - works alongside other apps registered with AuthSphere
- 🛡️ **PKCE Support** - secure authorization code exchange

## 📂 Project Structure

```
AuthSphere-Client/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── .mvn/
│   └── wrapper/
│
├── mvnw
├── mvnw.cmd
├── pom.xml
├── .gitignore
├── .gitattributes
└── README.md
```

## 🛠️ Installation & Setup

### Prerequisites

- Java (JDK 17+ recommended)
- Maven (or use the included `mvnw` wrapper)
- A running instance of **[AuthSphere](#)** (the Identity Provider)

### 1. Clone the repository

```bash
git clone https://github.com/riyasaran12/AuthSphere-Client.git
cd AuthSphere-Client
```

### 2. Configure the OAuth2 client

Configure the client registration in `src/main/resources/application.properties`:

```properties
spring.security.oauth2.client.registration.authsphere.client-id=authsphere-client
spring.security.oauth2.client.registration.authsphere.client-secret=<client-secret>
spring.security.oauth2.client.registration.authsphere.scope=openid,profile
spring.security.oauth2.client.registration.authsphere.redirect-uri=http://localhost:8080/login/oauth2/code/authsphere
spring.security.oauth2.client.registration.authsphere.authorization-grant-type=authorization_code

spring.security.oauth2.client.provider.authsphere.issuer-uri=http://localhost:9000

server.port=8080
```

> ⚠️ Do not commit real client secrets or other sensitive credentials. Use environment variables or a secure secret-management mechanism for production.

### 3. Start AuthSphere (the Identity Provider) first

AuthSphere must be running on `http://localhost:9000` before starting the client.

### 4. Start AuthSphere Client

**macOS/Linux:**
```bash
./mvnw spring-boot:run
```

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

AuthSphere Client starts on `http://localhost:8080`

## 🔄 Authentication Flow

```
User → GET / (client) → not authenticated
     → redirected to AuthSphere /oauth2/authorize
     → user authenticates with AuthSphere
     → redirected back with authorization code
     → client exchanges code + PKCE verifier at /oauth2/token
     → AuthSphere issues Access Token + ID Token
     → client creates authenticated session
```

## 🔑 Key Concepts

- OAuth 2.0 Authorization Code Flow
- OpenID Connect login
- Proof Key for Code Exchange (PKCE)
- Spring Security `oauth2Login`
- Token-based authenticated sessions

## 🔗 Related Repository

This client depends on **[AuthSphere](#)**, the Identity Provider and Authorization Server that issues tokens and authenticates users.

## 📄 License

ISC

## 🚧 Status

This project is under active development, focused on demonstrating OAuth2 login integration against the AuthSphere Identity Provider.
