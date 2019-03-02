# E-Learning-System
This is E-Learing System for Three2One test.

Manual guide:
-------------
1-Clone this repository to your local machine and import project as a maven.
2-Clean install for the imported project. and make a Maven update to insure that you have all needed JARs.

3-Configure a server _for example Apache Tomcat_. "you don't need to add the project into the server while configuring it".
4-In package "com.task" you find "E_learningStarter" class, right click and select run java application. _you will find the server is started_

5-Install postman to test the rest services.
6-Open any browser and type http://localhost:8080/h2-console" and insure that:
 - Setting Name: Generic H2 (Embedded)
 - Driver Class: org.h2.Driver
 - JDBC URL: jdbc:h2:mem:E_LEARNING
 - User name: sa
 - Password:
 "The above step is optional. just to see the changes in mem DB if you want.
 
7- Open Postman and type these:
-------------------------------

*To add new Student:
	- Request type: POST
	- URI: localhost:8080/e-learning/student
	- Body in JSON format:
	 {
	"name": "Mohamed",
	"gender": "Male",
	"email": "mohamed@gmail.com"}
	
*To add new Course:
	- Request type: POST
	- URI: localhost:8080/e-learning/course
	- Body in JSON format:
	{
	"courseName": "MES",
	"instructor": "dr.Waleed",
	"total_hours": 10,
	"description": "this is to learn management systems"}

*To make student register in course:
	- Request type: POST
	- URI: localhost:8080/e-learning/student/course/1/1  _where first '1' is courseId and 	second '1' is StudentId_
	- Body in JSON format:

*To get All student courses:
	- Request type: GET
	- URI: localhost:8080/e-learning/student/courses/1  _where '1' is studentId_
	- Body in JSON format:
	
*To unregister form course:
	- Request type: DELETE
	- URI: localhost:8080/e-learning/student/course/1/1   _where first '1' is courseId and 	second '1' is StudentId_
	- Body in JSON format:
	
*To get All courses:
	- Request type: GET
	- URI: localhost:8080/e-learning/courses
	- Body in JSON format:
	
*To get specific course by id:
	- Request type: GET
	- URI: localhost:8080/e-learning/course/1  _where first '1' is courseId_
	- Body in JSON format:
	
*To get specific student by id:
	- Request type: GET
	- URI: localhost:8080/e-learning/student/1  _where first '1' is studentId_
	- Body in JSON format:
	
-----------------------------------------------------

HINT: When you are running, if u got error that the port is already one use, Write this command -> netstat -a -n -o | find "8080" then you will see the PID. then write this command -> taskkill /F /PID "PID_THAT_APPEARS"

 
