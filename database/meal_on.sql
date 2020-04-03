DROP DATABASE IF EXISTS meal_on;
CREATE DATABASE meal_on;
USE meal_on;

-- Delete the schemas
DROP TABLE IF EXISTS mess;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS mess_staff;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS snacks_menu;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS student_bill;
DROP TABLE IF EXISTS stud_absentee;
DROP TABLE IF EXISTS review_rating;
DROP TABLE IF EXISTS menu_review;
DROP TABLE IF EXISTS staff_salary;
DROP TABLE IF EXISTS snacks_token;




-- Create Schemas

CREATE TABLE IF NOT EXISTS mess (
  `messId`			INT(11) AUTO_INCREMENT,
  `name` 			VARCHAR(50) NOT NULL,
  `password` 		VARCHAR(100) NOT NULL,
  `messAdmin` 		VARCHAR(50) NOT NULL,
  `rate` 			INT(11) NOT NULL,
   PRIMARY KEY (messId)
);

CREATE TABLE IF NOT EXISTS student (
  `MIS` 			BIGINT(20) UNSIGNED NOT NULL,
  `name` 			VARCHAR(40) NOT NULL,
  `roomNo` 		VARCHAR(20) NOT NULL,
  `yearOfStudy` 	tinyint(4) NOT NULL,
  `contact` 		int(10) NOT NULL,
  `email` 			VARCHAR(50) NOT NULL,
  `password` 		VARCHAR(100) NOT NULL,
  `messId` 		int(11) NOT NULL,
   PRIMARY KEY (MIS),
   FOREIGN KEY (messId) REFERENCES mess(messId) ON DELETE CASCADE
); 

CREATE TABLE IF NOT EXISTS mess_staff (
  `staffId` 		int(11) NOT NULL AUTO_INCREMENT,
  `name` 			varchar(30) NOT NULL,
  `messId` 		int(11) NOT NULL,
  `accountNo` 		bigint(20) NOT NULL,
  `contact` 		bigint(20) NOT NULL,
  `address` 		varchar(50) NOT NULL,
   PRIMARY KEY (staffId),
   FOREIGN KEY (messId) REFERENCES mess(messId) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS menu (
  `menuId` 		int(11) NOT NULL,
  `name` 			varchar(30) NOT NULL,
  `messId` 		int(11) NOT NULL,
   PRIMARY KEY (menuId),
   FOREIGN KEY (messId) REFERENCES mess(messId) ON DELETE CASCADE
);


CREATE TABLE  IF NOT EXISTS snacks_menu (
  `snacksId` 		int(11) NOT NULL,
  `name`			varchar(30) NOT NULL,
  `price` 			int(11) NOT NULL,
  `messId` 		int(11) NOT NULL,
   PRIMARY KEY (snacksId),
   FOREIGN KEY (messId) REFERENCES mess(messId) ON DELETE CASCADE
); 

CREATE TABLE  IF NOT EXISTS inventory (
  `inventoryId` 	int(11) NOT NULL,
  `name` 			varchar(30) NOT NULL,
  `stock` 			int(11) NOT NULL,
  `avgPrice` 		int(11) NOT NULL,
  `messId` 		int(11) NOT NULL,
   PRIMARY KEY (inventoryId),
   FOREIGN KEY (messId) REFERENCES mess(messId) ON DELETE CASCADE
);
  
CREATE TABLE  IF NOT EXISTS student_bill (
  `MIS` bigint(20) UNSIGNED NOT NULL,
  `Month` varchar(20) NOT NULL,
  `nosOfMeals` tinyint(4) NOT NULL DEFAULT '62',
  `currBill` int(11) NOT NULL,
  `payStatus` tinyint(1) NOT NULL,
  `prevBill` int(11) NOT NULL,
   PRIMARY KEY (MIS, Month),
   FOREIGN KEY (MIS) REFERENCES student(MIS) ON DELETE CASCADE
   
);

CREATE TABLE  IF NOT EXISTS stud_absentee (
  `MIS` bigint(20) UNSIGNED NOT NULL,
  `from` date NOT NULL,
  `to` date NOT NULL,
  `type` char(1) NOT NULL,
   FOREIGN KEY (MIS) REFERENCES student(MIS),
   FOREIGN KEY (MIS) REFERENCES student_bill(MIS)
);

CREATE TABLE  IF NOT EXISTS review_rating(
  `reviewId` 		int(11) NOT NULL,
  `MIS` 			bigint(11) UNSIGNED NOT NULL,
  `menuId` 		int(11) NOT NULL,
  `rating` 			int(11) NOT NULL,
  `comments` 		int(11) NOT NULL,
  PRIMARY KEY (reviewId),
  FOREIGN KEY (MIS) REFERENCES student(MIS),
  FOREIGN KEY (menuId) REFERENCES menu(menuId)
);

CREATE TABLE  IF NOT EXISTS menu_review (
  `menuId` int(11) NOT NULL,
  `avgRating` int(11) NOT NULL,
  `commentOverview` varchar(500) NOT NULL,
  FOREIGN KEY (menuId) REFERENCES menu(menuId)
);

CREATE TABLE  IF NOT EXISTS staff_salary (
  `staffId` int(11) NOT NULL,
  `NosOfLeaves` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (staffId, month),
  FOREIGN KEY (staffId) REFERENCES mess_staff(staffId)
);

CREATE TABLE IF NOT EXISTS snacks_token(
  `Datetime` 		datetime NOT NULL,
  `MIS` 			bigint(20) UNSIGNED NOT NULL,
  `snacksId` 		int(11) NOT NULL,
  `id` 				int(11) NOT NULL,
  `price` 			int(11) NOT NULL,
   PRIMARY KEY(Datetime, MIS, snacksId, id),
   FOREIGN KEY(MIS) REFERENCES student(MIS),
   FOREIGN KEY(snacksId) REFERENCES snacks_menu(snacksId)  
) ;
