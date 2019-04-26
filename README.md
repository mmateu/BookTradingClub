Spring Boot Application to manage Book Trading Club as in *https://chrome-delivery.glitch.me/trades*  

## REQUIREMENTS
    1. JDK11
    2. Intellij IDEA Community Edition 2019.1 ( Possibly lower versions will suffice)
    
    This is maven project, so it might work with other IDEs. 

## LOCAL INSTALLATION   
    1.Import as a multi-module maven project to IDE of your preference  
    2.Navigate to presentation/src/main/java/com/example/BookTradingClubApplication and run it
***
To sign up, make POST request to *localhost:8080/user/signup*
with   
```json
{  
    "name":"xxx",  
    "password":"xxx"  
}
```

Resources:   
{book} 
```json
{  
    "title":"xxx",
    "author":"xxx"
}
```


  
Using basic authentication:

GET *localhost:8080/books* - get all(distinct) added books  
GET *localhost:8080/books/{id}* - get {id} book  
GET *localhost:8080/user/books* - get all users' books  
POST *localhost:8080/books* - add {book} to a user    
GET *localhost:8080/user/current* - get current user


