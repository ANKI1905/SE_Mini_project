# SE_Mini_project
To run The project after cloning:
	Extract the project
	cd MEAL_ON
	Configure the application.properties in /src/main/resources/ file according to your system as;
		spring.datasource.username="your_database_user"
		spring.datasource.password="your_user_password"
	
	import the .sql file to create tables and database as:
		mysql -u "your_database_user" -p > meal_on.sql
	
	Then run the project as;
		mvn install / mvn clean install
		mvn spring-boot:run
			#wait for the dependencies to get installed
		

Database:
	Name of table: Snake Case
	Name of attributes: Snake Case 
*******this_is_snake_case************
