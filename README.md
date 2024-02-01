## Task API 
A simple RESTful API for managing tasks made with Spring Boot.

> Database Setup
> - Create a database named `taskdb`
> - Create a user with username `taskuser` and password `taskpass`
> - Grant all privileges to the user on the database
> - Update the `application.properties` file with the correct database url, username and password


### Create a Task
```http
POST /tasks
```
#### Request
```json
{
    "title": "Task 1",
    "description": "Description of task 1",
    "status": "pending"
}
```
#### Response
```json
{
    "id": 1,
    "title": "Task 1",
    "description": "Description of task 1",
    "priority": 1,
    "createdBy": "user1"
} 
```

### Get All Tasks
```http
GET /tasks
```
#### Response
```json
[
    {
        "id": 1,
        "title": "Task 1",
        "description": "Description of task 1",
        "priority": 1,
        "createdBy": "user1"
    }
]
```

### Get User Tasks
```http
GET /tasks/:user
```
#### Response
```json
[
    {
        "id": 1,
        "title": "Task 1",
        "description": "Description of task 1",
        "priority": 1,
        "createdBy": "user1"
    }
]
```

### Get Subset of Tasks
```http
GET /tasks?sortBy=title&sortDirection=asc&page=1&pageSize=10

``` 
#### Response
```json
[
    {
        "id": 1,
        "title": "Task 1",
        "description": "Description of task 1",
        "priority": 1,
        "createdBy": "user1"
    },
    {
        "id": 2,
        "title": "Task 2",
        "description": "Description of task 2",
        "priority": 2,
        "createdBy": "user2"
    }
]
```