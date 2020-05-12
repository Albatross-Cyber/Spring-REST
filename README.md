# Spring-REST

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e6902c13616242a497ca7e802fa9c896)](https://app.codacy.com/manual/Albatross-Cyber/Spring-REST?utm_source=github.com&utm_medium=referral&utm_content=Albatross-Cyber/Spring-REST&utm_campaign=Badge_Grade_Dashboard)

Spring Boot REST API Documentation with Swagger using SpringFox.

This is a simple RESTful CRUD (Create Read Update Delete) application providing set of endpoints for Creating, Retrieving, Updating and Deleting of employees saved in MySQL database.



### Usage

An application expose 5 REST endpoints for *Employee* entity and they are:

* **GET** `{baseURL}/v2/employees` - lists all *Employees* (as Json array),
* **GET** `{baseURL}/v2/employees/{id}` - gets single *Employee* (as Json) by its `{id}`,
* **POST** `{baseURL}/v2/employees` - creates a new *Employee* which is passed in the BODY of the request,
* **PUT** `{baseURL}/v2/employees/{id}` - updates an existing *Employee* (with an `{id}`) passed in the body of the request,
* **DELETE** `{baseURL}/v2/employees/{id}`- deletes an existing *Employee* by its `{id}`.

If you run this application locally the {baseUrl} would be http://localhost:8080.

All available endpoints are listed on Swagger UI page which can be entered, when application is running, under http://localhost:8080/swagger-ui.html URL.

![image](https://user-images.githubusercontent.com/65066310/81662561-65424c80-945b-11ea-957f-c527f9b005b5.png)

