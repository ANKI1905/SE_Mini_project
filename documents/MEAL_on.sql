DROP DATABASE IF EXISTS Meal_On;
CREATE DATABASE Meal_On;
USE Meal_On;

-- Delete the schemas
DROP TABLE IF EXISTS Mess;
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Mess_staff;
DROP TABLE IF EXISTS Menu;
DROP TABLE IF EXISTS Snacks_menu;
DROP TABLE IF EXISTS Inventory;
DROP TABLE IF EXISTS Student_Bill;
DROP TABLE IF EXISTS Stud_Absentee;
DROP TABLE IF EXISTS Review_rating;
DROP TABLE IF EXISTS Menu_Review;
DROP TABLE IF EXISTS Staff_Salary;
DROP TABLE IF EXISTS Snacks_token;




-- Create Schemas

CREATE TABLE IF NOT EXISTS Mess (
  `Mess_id`			INT(11) ,
  `Name` 			VARCHAR(50) NOT NULL,
  `Password` 		VARCHAR(100) NOT NULL,
  `Mess_Admin` 		VARCHAR(50) NOT NULL,
  `Rate` 			INT(11) NOT NULL,
   PRIMARY KEY (Mess_Id)
);

CREATE TABLE IF NOT EXISTS Student (
  `MIS` 			BIGINT(20) UNSIGNED NOT NULL,
  `Name` 			VARCHAR(40) NOT NULL,
  `Room_no` 		VARCHAR(20) NOT NULL,
  `Year_of_Study` 	tinyint(4) NOT NULL,
  `Contact` 		int(10) NOT NULL,
  `Email` 			VARCHAR(50) NOT NULL,
  `password` 		VARCHAR(100) NOT NULL,
  `Mess_id` 		int(11) NOT NULL,
   PRIMARY KEY (MIS),
   FOREIGN KEY (Mess_id) REFERENCES Mess(Mess_id) ON DELETE CASCADE
); 

CREATE TABLE IF NOT EXISTS Mess_staff (
  `staff_id` 		int(11) NOT NULL,
  `Name` 			varchar(30) NOT NULL,
  `Mess_id` 		int(11) NOT NULL,
  `Account_no` 		bigint(20) NOT NULL,
  `contact` 		bigint(20) NOT NULL,
  `Address` 		varchar(50) NOT NULL,
   PRIMARY KEY (staff_id),
   FOREIGN KEY (Mess_id) REFERENCES Mess(Mess_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Menu (
  `Menu_id` 		int(11) NOT NULL,
  `Name` 			varchar(30) NOT NULL,
  `Mess_id` 		int(11) NOT NULL,
   PRIMARY KEY (Menu_id),
   FOREIGN KEY (Mess_id) REFERENCES Mess(Mess_id) ON DELETE CASCADE
);


CREATE TABLE  IF NOT EXISTS Snacks_menu (
  `Snacks_id` 		int(11) NOT NULL,
  `Name`			varchar(30) NOT NULL,
  `Price` 			int(11) NOT NULL,
  `Mess_id` 		int(11) NOT NULL,
   PRIMARY KEY (Snacks_id),
   FOREIGN KEY (Mess_id) REFERENCES Mess(Mess_id) ON DELETE CASCADE
); 

CREATE TABLE  IF NOT EXISTS Inventory (
  `Inventory_Id` 	int(11) NOT NULL,
  `Name` 			varchar(30) NOT NULL,
  `Stock` 			int(11) NOT NULL,
  `Avg_Price` 		int(11) NOT NULL,
  `Mess_id` 		int(11) NOT NULL,
   PRIMARY KEY (Inventory_Id),
   FOREIGN KEY (Mess_id) REFERENCES Mess(Mess_id) ON DELETE CASCADE
);
  
CREATE TABLE  IF NOT EXISTS Student_Bill (
  `MIS` bigint(20) UNSIGNED NOT NULL,
  `Month` varchar(20) NOT NULL,
  `Nos_of_meals` tinyint(4) NOT NULL DEFAULT '62',
  `curr_Bill` int(11) NOT NULL,
  `pay_status` tinyint(1) NOT NULL,
  `prev_bill` int(11) NOT NULL,
   PRIMARY KEY (MIS, Month),
   FOREIGN KEY (MIS) REFERENCES Student(MIS) ON DELETE CASCADE
   
);

CREATE TABLE  IF NOT EXISTS Stud_Absentee (
  `MIS` bigint(20) UNSIGNED NOT NULL,
  `From` date NOT NULL,
  `To` date NOT NULL,
  `Type` char(1) NOT NULL,
   FOREIGN KEY (MIS) REFERENCES Student(MIS),
   FOREIGN KEY (MIS) REFERENCES Student_Bill(MIS)
);

CREATE TABLE  IF NOT EXISTS Review_rating(
  `Review_Id` 		int(11) NOT NULL,
  `MIS` 			bigint(11) UNSIGNED NOT NULL,
  `Menu_id` 		int(11) NOT NULL,
  `Rating` 			int(11) NOT NULL,
  `Comments` 		int(11) NOT NULL,
  PRIMARY KEY (Review_Id),
  FOREIGN KEY (MIS) REFERENCES Student(MIS),
  FOREIGN KEY (Menu_id) REFERENCES Menu(Menu_id)
);

CREATE TABLE  IF NOT EXISTS Menu_Review (
  `Menu_id` int(11) NOT NULL,
  `Avg_rating` int(11) NOT NULL,
  `Comment_overview` varchar(500) NOT NULL,
  FOREIGN KEY (Menu_id) REFERENCES Menu(Menu_id)
);

CREATE TABLE  IF NOT EXISTS Staff_Salary (
  `staff_id` int(11) NOT NULL,
  `Nos_of leaves` int(11) NOT NULL,
  `Month` int(11) NOT NULL,
  `Salary` int(11) NOT NULL,
  PRIMARY KEY (staff_id, Month),
  FOREIGN KEY (staff_id) REFERENCES Mess_staff(staff_id)
);

CREATE TABLE IF NOT EXISTS Snacks_token(
  `Datetime` 		datetime NOT NULL,
  `MIS` 			bigint(20) UNSIGNED NOT NULL,
  `Snacks_id` 		int(11) NOT NULL,
  `Id` 				int(11) NOT NULL,
  `Price` 			int(11) NOT NULL,
   PRIMARY KEY(Datetime, MIS, Snacks_Id, Id),
   FOREIGN KEY(MIS) REFERENCES Student(MIS),
   FOREIGN KEY(Snacks_id) REFERENCES Snacks_menu(Snacks_id)  
) ;
