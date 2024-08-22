To run this application :

. First of all , change the database(MYSQL) configuration in the application.properties file to your own database table name, username and password;
   {https://github.com/ogbuehi/Supplier-Service/blob/master/src/main/resources/application.properties}

. Navigate to the main spring boot application class annotated with'@SpringBootApplication', right click and run the application.

. Using your web browser, postman or any other rest client:

-> use 'localhost:8080/api/supplier/add' to add a supplier with all required inputs.

-> use 'localhost:8080/api/supplier/get?pageNum=1&pageSize=10' and input a location, company name, manufacturing process to get list of manufacturers matching the given criteria.
