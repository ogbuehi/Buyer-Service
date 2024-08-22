To run this application :

. First of all , change the database(MYSQL) configuration in the application.properties file to your own database username and password;

. Change the security configuration in the application.properties file also.

. Navigate to the main spring boot application class annotated with'@SpringBootApplication', right click and run the applicatioin.

. Using postman or any other tool:

-> use 'https//:8080/api/supplier/add' to add a supplier with all required inputs.

-> use 'https//:8080/api/supplier/get/pageNum=?pageSize=?' and input a location, company name, manufacturing process to get list of manufacturers matching the given criteria.
