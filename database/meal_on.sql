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
  `mess_id`			INT(11) AUTO_INCREMENT,
  `name` 			VARCHAR(50) NOT NULL,
  `password` 		VARCHAR(100) NOT NULL,
  `mess_admin` 		VARCHAR(50) NOT NULL,
  `rate` 			INT(11) NOT NULL,
   PRIMARY KEY (mess_id)
);

CREATE TABLE IF NOT EXISTS student (
  `mis` 			BIGINT(20) UNSIGNED NOT NULL,
  `name` 			VARCHAR(40) NOT NULL,
  `room_no` 		VARCHAR(20) NOT NULL,
  `year_of_study` 	tinyint(4) NOT NULL,
  `contact` 		int(10) NOT NULL,
  `email` 			VARCHAR(50) NOT NULL,
  `password` 		VARCHAR(100) NOT NULL,
  `mess_id` 		int(11) NOT NULL,
   PRIMARY KEY (mis),
   FOREIGN KEY (mess_id) REFERENCES mess(mess_id) ON DELETE CASCADE
); 

CREATE TABLE IF NOT EXISTS mess_staff (
  `staff_id` 		int(11) NOT NULL AUTO_INCREMENT,
  `name` 			varchar(30) NOT NULL,
  `mess_id` 		int(11) NOT NULL,
  `account_no` 		bigint(20) NOT NULL,
  `contact` 		bigint(20) NOT NULL,
  `address` 		varchar(50) NOT NULL,
   PRIMARY KEY (staff_id),
   FOREIGN KEY (mess_id) REFERENCES mess(mess_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS menu (
  `menu_id` 		int(11) NOT NULL AUTO_INCREMENT,
  `name` 			varchar(30) NOT NULL,
  `mess_id` 		int(11) NOT NULL,
   PRIMARY KEY (menu_id),
   FOREIGN KEY (mess_id) REFERENCES mess(mess_id) ON DELETE CASCADE
);


CREATE TABLE  IF NOT EXISTS snacks_menu (
  `snacks_id` 		int(11) NOT NULL,
  `name`			varchar(30) NOT NULL,
  `price` 			int(11) NOT NULL,
  `mess_id` 		int(11) NOT NULL,
   PRIMARY KEY (snacks_id),
   FOREIGN KEY (mess_id) REFERENCES mess(mess_id) ON DELETE CASCADE
); 

CREATE TABLE  IF NOT EXISTS inventory (
  `inventory_id` 	int(11) NOT NULL,
  `name` 			varchar(30) NOT NULL,
  `stock` 			int(11) NOT NULL,
  `avg_Price` 		int(11) NOT NULL,
  `mess_id` 		int(11) NOT NULL,
   PRIMARY KEY (inventory_id),
   FOREIGN KEY (mess_id) REFERENCES mess(mess_id) ON DELETE CASCADE
);
  
CREATE TABLE  IF NOT EXISTS student_bill (
  `mis` bigint(20) UNSIGNED NOT NULL,
  `month` varchar(20) NOT NULL,
  `nos_of_meals` tinyint(4) NOT NULL DEFAULT '62',
  `curr_bill` int(11) NOT NULL,
  `pay_status` tinyint(1) NOT NULL,
  `prev_bill` int(11) NOT NULL,
   PRIMARY KEY (mis, month),
   FOREIGN KEY (mis) REFERENCES student(mis) ON DELETE CASCADE
   
);

CREATE TABLE  IF NOT EXISTS stud_absentee (
  `mis` bigint(20) UNSIGNED NOT NULL,
  `from` date NOT NULL,
  `to` date NOT NULL,
  `type` char(1) NOT NULL,
   FOREIGN KEY (mis) REFERENCES student(mis),
   FOREIGN KEY (mis) REFERENCES student_bill(mis)
);

CREATE TABLE  IF NOT EXISTS review_rating(
  `review_id` 		int(11) NOT NULL,
  `mis` 			bigint(11) UNSIGNED NOT NULL,
  `menu_id` 		int(11) NOT NULL,
  `rating` 			int(11) NOT NULL,
  `comments` 		varchar(500) NOT NULL,
  PRIMARY KEY (reviewId),
  FOREIGN KEY (mis) REFERENCES student(mis),
  FOREIGN KEY (menu_id) REFERENCES menu(menu_id)
);

CREATE TABLE  IF NOT EXISTS menu_review (
  `menu_id` int(11) NOT NULL,
  `avg_rating` int(11) NOT NULL,
  `comment_overview` varchar(500) NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menu(menu_id)
);

CREATE TABLE  IF NOT EXISTS staff_salary (
  `staff_id` int(11) NOT NULL,
  `nos_of_leaves` int(11) NOT NULL,
  `month` varchar(11) NOT NULL,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (staff_id, month),
  FOREIGN KEY (staff_id) REFERENCES mess_staff(staff_id)
);

CREATE TABLE IF NOT EXISTS snacks_token(
  `date_time` 		datetime NOT NULL,
  `mis` 			bigint(20) UNSIGNED NOT NULL,
  `snacks_id` 		int(11) NOT NULL,
  `id` 				int(11) NOT NULL,
  `price` 			int(11) NOT NULL,
   PRIMARY KEY(date_time, mis, snacks_id, id),
   FOREIGN KEY(mis) REFERENCES student(mis),
   FOREIGN KEY(snacks_id) REFERENCES snacks_menu(snacks_id)  
) ;
