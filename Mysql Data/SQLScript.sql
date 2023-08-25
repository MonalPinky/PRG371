Create database StudentPortalDB;

use StudentPortalDB;
Create table Student(
student_id int AUTO_INCREMENT Primary Key,
student_name varchar(30),
student_address varchar(100),
student_email varchar(100),
student_password varchar(100)
);

Create table Register(
register_id int AUTO_INCREMENT Primary Key,
student_name varchar(50),
student_address varchar(50),
student_email varchar(50),
student_password varchar(50),
course_name varchar(50)
);

Create table Administrator(
Admin_id int AUTO_INCREMENT Primary Key,
Admin_name varchar(50),
password varchar(50),
contact varchar(50)
);