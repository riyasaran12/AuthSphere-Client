# AuthSphere Client

AuthSphere Client is a Spring Boot application that acts as an **OAuth 2.0 / OpenID Connect client** for the AuthSphere Identity Provider.

It demonstrates how an application can use a centralized Identity Provider to provide **Single Sign-On (SSO)** without handling user credentials itself.

## 🔐 Authentication Flow

The client uses the **Authorization Code Flow with PKCE**.

```text
User
 │
 │ 1. Access protected resource
 ▼
AuthSphere Client
 │
 │ 2. Redirect to Authorization Server
 ▼
AuthSphere Identity Provider
 │
 │ 3. User authenticates
 │
 │ 4. Authorization Code
 ▼
AuthSphere Client
 │
 │ 5. Exchange Code for Tokens
 ▼
AuthSphere Identity Provider
 │
 │ 6. Access Token + ID Token
 ▼
AuthSphere Client
 │
 │ 7. Create authenticated session
 ▼
Protected Resource
