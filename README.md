

Authors: Joshua Gonzalez, Shivansh Hedaoo, Santhosh Ravindrabharathy, Henry To

Project Overiview
The School Course project is a campus management system designed to organize and manage courses, student enrollments, and faculty in one organized OOP system. The system consists of several classes, the main ones including Department, Course, Student, and Professor. This management system allows users to perform operations such as adding and viewing courses, enrolling for classes, and managing admin privelages.

The project leverages Object-Oriented Programming principles, including inheritance and polymorphism, to create a structured and reusable codebase. Comprehensive testing ensures functionality and reliability throughout the system.





Design ------------------------

Classes: The classes involved are Campus, Department, Course, Club, Student, and Professor. 

The campus class contains organized lists of the departments, clubs, courses, and people on the campus and makes it extremely easy to find these objects within the campus system. 

The department class contains information on the courses, students, and professors in the department. It makes it easy to add/remove these objects as well as change the department of a course or student.

The student class contains information on the student's name, id, email, and the courses they are enrolled in. It makes it easy to add/remove courses and view all courses a student is enrolled in.

The professor class contains similar basic info, as well as the courses they teach. They are also able to set grades for students as well as schedule office hours.

The course and club classes contain basic information along with ways to register and drop students from the course or club.


A Person abstract class is also included, which is utilized by the Student and Professor classes to simplify common methods and attributes such as name, id, email, and department, all of which any individual in the system should have.

A Registrable interface is utilized by the Course and Club classes to reduce redundancy when students need to register for one of these events. They incorporate a register and a drop method.

A second Admin interface is utilized to provide common privalges to any Person in the system who is set as an admin. All professor are set as admins by default, but can assign other students as admins as well. These admins are given the privaleges to set student grades, and add other admins.









Class Diagram representing the relationships between classes (also included in the repo):

![image]([https://github.com/user-attachments/assets/b470f04b-2183-4333-ab6a-95ab9a218331](https://github.com/shedaoo878/2024-CS151-07-CourseSystem/blob/1daed41f56907cec9170e0afdbbe8609ca1763a2/image.png))










To run the program, certain test objects have already been created. Simply run the main method, and follow the prompts to navigate through the system. 
A campus object has been created, with two departments, and several courses, clubs, students, and professors. 


Joshua - Worked on the Professor and Main method testing.
Santhosh - Worked on the Course/club classes and Unit Testing.
Shivansh - Worked on the Interfaces and the Department class.
Henry - Worked on the Campus and the Student classes.

