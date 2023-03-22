# Boxinator-server

This repository contains a REST API for the Boxinator application.

### Running locally

1. Setup keycloak with the instructions from [this](https://github.com/EaCase/keycloak-docker-compose) repository.
2. Setup Postgres instance.
3. Create an `application.properties` file into `src/main/resources/` folder, and copy the file below. Replace the
   postgres, SMTP and client registration url properties. No need to touch other config when using keycloak from step 1.

```properties
# Postgres
spring.datasource.url={postgres_url}
spring.datasource.username={postgres_username}
spring.datasource.password={postgres_password}
# SMTP - If using smtp2go, need to only replace the top 3
mail.auth.username={username}
mail.auth.password={password}
mail.smtp.sender={sender_email}
mail.smtp.auth=true
mail.smtp.starttls.enable=true
mail.smtp.host=mail.smtp2go.com
mail.smtp.port=2525
# Client registration url for temporary accounts
client.url.registration={url}
# Auth client - Keycloak config - If following Step 1. all this will be correct
auth.url.login=http://localhost:8083/realms/Boxinator/protocol/openid-connect/token
auth.url.users=http://localhost:8083/admin/realms/Boxinator/users
auth.client=boxinator-client
auth.secret=Gsu5dxrNxUoX0LFdV9V90mENa51CGHiX
# Keycloak 'Boxinator' client id
auth.client.id=db095150-691c-4def-be44-2fdb448d5e8f
# Keycloak admin role id
auth.role.admin.id=bcf5b412-471c-4eb8-90e0-9fcead8fd5d3
# Keycloak user role id
auth.role.user.id=01ab668a-ee5f-49bd-b5ac-0b0ef3cbc1a2
# Jwt - If following Step 1. all this will be correct
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8083/realms/Boxinator
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=${spring.security.oauth2.resourceserver.jwt.issuer-uri}/protocol/openid-connect/certs
jwt.auth.converter.resource-id=boxinator-client
jwt.auth.converter.principal-attribute=preferred_username
# Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.sql.init.mode=always
spring.jpa.show-sql=true
spring.jpa.defer-datasource-initialization=true
# Swagger
springdoc.swagger-ui.operationsSorter=method
```