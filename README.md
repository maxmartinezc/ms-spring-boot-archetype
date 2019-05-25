# Archetype - Spring Boot Microservice
Archetype for the creation of projects for spring boots. Tested with version 2.1.5.RELEASE

# Features

## Properties Available
![properties](https://user-images.githubusercontent.com/18618236/57994387-f53cf880-7a8a-11e9-8f91-d13081198ef9.png)

## Project Structure
![project-structure](https://user-images.githubusercontent.com/18618236/57994360-d3437600-7a8a-11e9-91b4-a694a2099fc3.png)

## Swagger setup ready
![swagger-v2](https://user-images.githubusercontent.com/18618236/58139857-afa73980-7c0a-11e9-8ac0-234f30e69cb7.png)

## Custom Exceptions Handler
### Error codes enum
* BusinessException: Exception as "BAD REQUEST" (HTTP 400). It must be launched manually.
* MethodArgumentNotValidException: Exception as "BAD REQUEST" (HTTP 400). This is automatically launches when Java bean validation fail
* CustomNotFoundException: Exception as "NOT FOUND" (HTTP 404). It must be launched manually.
* ErrorCodesEnum:

![error codes enum](https://user-images.githubusercontent.com/18618236/57994605-e276f380-7a8b-11e9-8f08-63a3df4aa9e5.png)

### Output example for MethodArgumentNotValidException when Java bean validation fail
![custom exception](https://user-images.githubusercontent.com/18618236/57994562-c1ae9e00-7a8b-11e9-846a-3e3b084b0d4a.png)

## Database Config
### H2
If you don't choose database, you get H2 as default:
![h2-cfg](https://user-images.githubusercontent.com/18618236/58139761-3e678680-7c0a-11e9-8526-808468148e63.png)

#### Login to H2 console
Ex.: http://localhost:5000/demo/v1/h2-console (pwd: demo)
![h2-login](https://user-images.githubusercontent.com/18618236/58139768-4c1d0c00-7c0a-11e9-89be-16ff0083a473.png)

###  MySQL
If you choose mysql "si", you get:
![bd-config](https://user-images.githubusercontent.com/18618236/57994873-37673980-7a8d-11e9-8b72-4ccaf3516af6.png)

### PostgreSQL
If you choose postgresql "si", you get:
![pgsql](https://user-images.githubusercontent.com/18618236/57995001-d7bd5e00-7a8d-11e9-9d9a-0f2264624794.png)

## Profile setup ready
![pom-profiles](https://user-images.githubusercontent.com/18618236/58139969-33f9bc80-7c0b-11e9-8eb7-97ecb96664f0.png)

## CORS setup ready
![cors-time-zone](https://user-images.githubusercontent.com/18618236/58140220-458f9400-7c0c-11e9-8b3a-32f4e034acfb.png)

## Model Mapper Integration
http://modelmapper.org/getting-started/

## Bonus
* RUN Validator (RUN is a valid "ID" for chilean people):
  * Java API for bean validation (@Run)
  * FunctionUtil class with validation function for RUN

# Install
## Step 1:
Archetype Catalog; Create or update your local catalog (archetype-catalog.xml) in .m2 folder with:
```
<?xml version="1.0" encoding="UTF-8"?>  
<archetype-catalog xsi:schemaLocation="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-catalog/1.0.0 http://maven.apache.org/xsd/archetype-catalog-1.0.0.xsd"  
    xmlns="http://maven.apache.org/plugins/maven-archetype-plugin/archetype-catalog/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <archetypes>
    <archetype>
      <groupId>cl.example</groupId>
      <artifactId>ms-spring-boot-arquetype</artifactId>
      <version>1.0.0</version>
      <description>Spring Boot Microservice Arquetype</description>
    </archetype>
  </archetypes>
</archetype-catalog>
```

## Step 2
Install arquetype
1) Download project and import in eclipse.
2) Install archetype as jar in your maven repository
![install arq](https://user-images.githubusercontent.com/18618236/57996237-40a7d480-7a94-11e9-94ca-0dc9ff559733.png)


## Step 3:
![1](https://user-images.githubusercontent.com/18618236/57995800-076e6500-7a92-11e9-8859-d8b27b0a47c5.png)

## Step 4:
Click next

![2](https://user-images.githubusercontent.com/18618236/57995816-1b19cb80-7a92-11e9-8043-bf6001c7de97.png)

## Step 5:
Select arquetype from maven catalog
![3](https://user-images.githubusercontent.com/18618236/57995828-2836ba80-7a92-11e9-93b0-21cbc66cd90c.png)

## Step 6:
![maven-new-project](https://user-images.githubusercontent.com/18618236/58140156-0b25f700-7c0c-11e9-8384-89d3657f31fa.png)

Click finish and enjoy!
