# 🔐 AuthSphere

A centralized **Identity Provider (IdP) and OAuth 2.0 Authorization Server** built with Spring Boot and Spring Security. AuthSphere provides authentication and authorization for applications using **OAuth 2.0, OpenID Connect (OIDC), Authorization Code Flow, PKCE, JWTs, and RSA-based signing**, enabling Single Sign-On (SSO) across multiple client applications.

## 🚀 Tech Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Spring Boot | Application framework |
| Spring Security | Security framework |
| Spring Authorization Server | OAuth 2.0 / OIDC authorization server |
| OAuth 2.0 | Authorization protocol |
| OpenID Connect | Authentication / identity layer |
| JWT | Token format |
| RSA | JWT signing |
| PostgreSQL | Persistent storage |
| JPA / Hibernate | Database access |
| Maven | Build and dependency management |

## ✨ Features

- 🏢 **Centralized Identity Provider** - single source of truth for authentication
- 🔑 **OAuth 2.0 Authorization Code Flow** - industry-standard authorization
- 🪪 **OpenID Connect (OIDC)** - identity layer on top of OAuth 2.0
- 🛡️ **PKCE Support** - protects authorization codes from interception
- 🔏 **JWT Access & ID Tokens** - signed with RSA public/private key pairs
- 🌐 **Single Sign-On (SSO)** - one login across multiple applications
- 📋 **OAuth 2.0 Client Registration** - manage registered client apps
- 🔎 **JWK Set & OIDC Discovery Endpoints** - standards-compliant metadata
- 🗄️ **PostgreSQL Persistence** - users and client data storage

## 📂 Project Structure

```
AuthSphere/
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
- PostgreSQL
- Maven (or use the included `mvnw` wrapper)

### 1. Clone the repository

```bash
git clone https://github.com/riyasaran12/AuthSphere.git
cd AuthSphere
```

### 2. Configure PostgreSQL

Create the database:

```sql
CREATE DATABASE authsphere;
```

Configure the credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/authsphere
spring.datasource.username=<username>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=9000
```

> ⚠️ Do not commit real passwords, private keys, client secrets, or other sensitive credentials. Use environment variables or a secure secret-management mechanism for production.

### 3. Start AuthSphere

**macOS/Linux:**
```bash
./mvnw spring-boot:run
```

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

AuthSphere starts on `http://localhost:9000`

## 🔗 OAuth 2.0 Endpoints

| Endpoint | Method | Description |
|---|---|---|
| `/oauth2/authorize` | GET | Starts the authorization flow |
| `/oauth2/token` | POST | Exchanges an authorization code for tokens |
| `/oauth2/jwks` | GET | Public keys (JWK Set) for JWT verification |
| `/.well-known/openid-configuration` | GET | OpenID Connect discovery document |

## 🏗️ Architecture

Applications delegate authentication to AuthSphere instead of implementing their own login systems:

```
User → Client Application (:8080) → AuthSphere IdP (:9000) → PostgreSQL / RSA Keys
```

AuthSphere authenticates the user and issues an authorization code, which the client exchanges (server-to-server, with PKCE verification) for an access token and ID token.

## 🔑 Key Concepts

- Authorization Code Flow
- Proof Key for Code Exchange (PKCE)
- Access Tokens & ID Tokens
- RSA public/private key JWT signing
- Client Registration
- Centralized Authentication & Token-based Authorization

## 🔗 Related Repository

The corresponding OAuth 2.0 / OpenID Connect client application is **[AuthSphere-Client](#)**, which communicates with this Identity Provider using OAuth 2.0 and OpenID Connect.

## 📄 License

ISC

## 🚧 Status

This project is under active development. Current focus: Identity Provider setup, OAuth 2.0 Authorization Code Flow, OIDC authentication, PKCE, JWT issuance, and integration with the AuthSphere Client.
