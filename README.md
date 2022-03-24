# Тестовое задание
###Задача: спроектировать и разработать API для системы опросов пользователей.

***Функционал для администратора системы:***

- авторизация в системе (регистрация не нужна)
- добавление/изменение/удаление опросов. Атрибуты опроса: название, дата старта, дата окончания, описание. После создания поле "дата старта" у опроса менять нельзя
- добавление/изменение/удаление вопросов в опросе. Атрибуты вопросов: текст вопроса, тип вопроса (ответ текстом, ответ с выбором одного варианта, ответ с выбором нескольких вариантов)

***Функционал для пользователей системы:***

- получение списка активных опросов
- прохождение опроса: опросы можно проходить анонимно, в качестве идентификатора пользователя в API передаётся числовой ID, по которому сохраняются ответы пользователя на вопросы; один пользователь может участвовать в любом количестве опросов
- получение пройденных пользователем опросов с детализацией по ответам (что выбрано) по ID уникальному пользователя

***Использовать следующие технологии: Spring Framework.***

***Результат выполнения задачи:***
- исходный код приложения в github (только на github, публичный репозиторий)
- инструкция по разворачиванию приложения (в docker или локально)
- документация по API
## Solution

***Prerequisites***:

- Java 17
- PostgreSQL 14.2

***Launch instructions***\
PostgreSQL
>**Database:** fabrique-polls\
**User:** fabrique\
**Password:** fabrique


To run application type
> java -jar poll-service.jar

API documentation
> http://localhost:8080/swagger-ui.html


##To implement task used following stack
- Spring Boot
- Spring Data
- Spring Security
- Flyway
- Swagger
- PostgreSQL 14.2
- Hibernate
- Git
- Java 17
- Apache Maven
- ~~Docker~~