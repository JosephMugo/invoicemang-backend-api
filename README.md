# invoicemang-backend-api
#### <i>Joseph Mugo</i>

InvoiceMang is an invoice management web application that allows you to create, view, update, and delete invoices in a user-friendly dashboard. The web application ensures that you can access your invoices anytime from anywhere.

### Application Quickstart
---
- setup mysql database 
- create new resources directory
- create new file "application.properties"
- #### input properties
  ###### `spring.jpa.hibernate.ddl-auto=update`
  ###### `spring.datasource.url=<i>Your-Database-Url</i>`
  ###### `spring.datasource.username=<i>Your-Database-Username</i>`
  ###### `spring.datasource.password==<i>Your-Database-Password</i>`
  ###### `spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`
 ---
 ### Run Application
 ##### Run java class: "<i>InvoicemangBackendApiApplication</i>"
 ---
 ### Error Codes
 200 - OK
 
 403 - Created
 
 404 - Not Found
 
 ---
 
 ### Endpoints
Base URL: http://localhost:8000 (spring boot default path)
| Method     | Path| Info     | Parameters/Body  | Request |
| :---        |    :----:   |           :----:   |           :----:   |         ---: |
| GET | /invoices | gets all invoices in database | N/A | GET /invoices | 
| GET | /invoices/{<i>invoiceId</i>} | gets invoice by id | N/A | GET /invoices/1 |
| POST | /invoices | post new invoice to database | {} | POST /invoices |
| PUT | /invoices/{<i>invoiceId</i>} | update invoice by id | {} | PUT /invoices/1 | 
| DELETE | /invoices/{<i>invoiceId</i>} | delete invoice by id | N/A | DELETE /invoices/1 | 
---
### Dependencies
spring-boot-starter-data-jpa

spring-boot-starter-web

mysql-connector-java

lombok

spring-boot-starter-test

spring-boot-starter-validation
