# Quiz-app
Microservices architecture for a Quiz app. It basically contains 4 services: Quiz, Question, Service-registry, and Api-gateway.
# Tech used:
Programming Language: Java
Framework: Spring, Spring boot, JPA, API Gateway
DB: PostgreSql
# Rest APIs
Quiz service using Api-gateway
Post http://localhost:8761/quiz/quiz/create
Get http://localhost:8761/quiz/quiz/get/{id}
Post http://localhost:8761/quiz/submit/{id}

Question service using Api-gateway
Get http://localhost:8761/question/questions/allquestions
Post http://localhost:8761/question/questions/addquestion
Get http://localhost:8761/question/questions/questionCat/{category}
Post http://localhost:8761/question/questions/genrate
Post http://localhost:8761/question/questions/getQuestions
Post http://localhost:8761/question/questions/getScore
