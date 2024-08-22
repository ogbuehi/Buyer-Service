To run this application :

. First of all , change the database(MYSQL) configuration in the application.properties file to your own database table name, username and password;
   https://github.com/ogbuehi/Supplier-Service/blob/master/src/main/resources/application.properties

. Navigate to the main spring boot application class annotated with'@SpringBootApplication', right click and run the application.
   https://github.com/ogbuehi/Supplier-Service/blob/master/src/main/java/com/javatask/SupplierService/SupplierServiceApplication.java

   OR -If you use Maven, run the following command in a terminal window (in the complete) directory: 
   
   ./mvnw spring-boot:run

. Using your web browser, postman or any other rest client to run the service:

-> use 'localhost:8080/api/supplier/add' 

   To add a supplier with all required inputs.

-> use 'localhost:8080/api/supplier/get?pageNum=1&pageSize=10'

   Input a location, company name, manufacturing process in the request body to get list of manufacturers matching the given criteria.

.  Using terminal window to run the service:
   run the service with curl (in a separate terminal window), by running the following command :
   
   To add a supplier:
   
   $ curl http://localhost:8080/api/supplier/add    

   To get list of manufacturers matching the given criteria:
   
   $ curl http://localhost:8080/api/supplier/get?pageNum=1&pageSize=5   
