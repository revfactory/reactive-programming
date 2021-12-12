# reactive-programming

### Microservices
- customer
- profiles
- edge

### Customer (7001)
- Spring Boot R2dbc
- Spring Boot Webflux
- Kotlin (Java 17)
- r2dbc-h2

### Profiles (7003)
- RSocket
- Spring Webflux
- Kotlin (Java 17)

### edge (8080)
- RSocket
- Spring Webflux
- Kotlin (Java 17)
- Graphql

### Start
- http://localhost:8080/customerProfiles
- http://localhost:8080/graphiql
- graphql
```
query {
  customers {
    id
    name
    profile {
      id
      registered
    }
  }
}
```
