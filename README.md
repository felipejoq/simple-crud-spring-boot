# 🧑‍💻 Simple CRUD exercise
This is a simple exercise RESTful API -> CRUD (Create, Read, Update and Delete) using Spring Boot, Spring Data JPA, Validation, and another.

## 🌎 Endpoints registry:

| URL                | METHOD | ARGS                  | RETURN Type | RETURN                  |
|--------------------|--------|-----------------------|-------------|-------------------------|
| /api/employee      | GET    | -                     | JSON        | Return all employee     |
| /api/employee/{id} | GET    | Id (Number)           | JSON        | Return one employee     |
| /api/employee      | POST   | Employee              | JSON        | Return employee created |
| /api/employee/{id} | PUT    | Employee, Id (Number) | JSON        | Return employee edited  |
| /api/employee/{id} | DELETE | Id (Number)           | JSON        | Return employee deleted |

### Summary how it is work
This exercise is an example Spring Boot App apply a structure packaging how next:

**`[ Client ] -> [ Controller ] -> [ Service ] -> [ Dao ] -> [ DB ]`**

**Request:**
```
- The client (postman) request to server.
- Controller in server recivied request and solicited this to Service.
- Service in turn use Repository for access to DB.
```

**Response:**
```
- Service obtains the data from DB through Repository.
- Service process these data, apply logic, or... apply bussiness logic.
- Controller recived Data from service.
- And Controller send Json format data to client.
```