# Articles Chatbot API

[Demo](https://articles-chatbot-api.herokuapp.com/articles_category)

## Description

This API was developed for the [application](https://github.com/viniciusaugutis/articles-chatbot-front). The application consists of a tool for generating content in blogs, using a chatbot. The chatbot provides the user with all the structure and ideas for a blogger to structure the information and content he wants to publish, through a questionnaire, where at the end the user is shown the template of how his article was and he can customize it.

The chatbot database was for an article publication in the area of ​​architecture and construction, but can be applied to any area, and it is necessary to change the data in the database.

## Features
- [x] RestFul API
- [x] Search for articles
- [x] Search for articles category
- [x] Search for keywords
- [x] Search for questionary and questions
- [x] See API [Swagger](https://articles-chatbot-api.herokuapp.com/swagger-ui.html) 

## Technologies
- [x] SpringBoot
- [x] SpringData
- [x] JPA Criteria
- [x] Flyway
- [x] Swagger
- [x] PostgreSQL
- [x] Junit
- [X] Google Trends

## To run
 
- Create database articles-chatbot in your PostgreSQL and add your password of database in application.properties
- Use an IDE such as intellij or STS and run as springboot app
- Or mvn clean package and java -jar target/application.jar
