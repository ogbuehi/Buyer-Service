DESCRIPTION :

This is a customer or buyer service application where the buyer(user) has to: 

- first create an account to be stored in a database.
  
- then the buyer can be logged in after providing credentials to access the available suppliers.

 TO GET THIS APPLICATION UP AND RUNNING IN YOUR SYSTEM:
  
  MAKE CHANGES:
  
 . Change the database(MYSQL) configuration in the application.properties file to your own database table name, username and password.
 
   https://github.com/ogbuehi/Supplier-Service/blob/master/src/main/resources/application.properties

  RUN THE APPLICATION:

 . Navigate to the main spring boot application class annotated with'@SpringBootApplication', right click and run the application.
 
   https://github.com/ogbuehi/Supplier-Service/blob/master/src/main/java/com/javatask/SupplierService/SupplierServiceApplication.java

 . OR -If you use Maven, run the following command in a terminal window (in the complete) directory: 
   
   ./mvnw spring-boot:run

   TEST API :

   To add a supplier:

   - localhost:8080/api/supplier/add_supplier

   To add a buyer:

   - localhost:8080/api/buyer/add_buyer

   To search for suppliers:

   - localhost:8080/api/buyer/find_suppliers
