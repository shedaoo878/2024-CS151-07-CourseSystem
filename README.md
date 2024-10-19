School Course - Student Management System in Java

Authors: [Your Name] (Your Email) ; [Co-author's Name] (Co-author's Email) ; [Another Co-author's Name] (Another Co-author's Email)

Project Specification - Major Practical Introduction
The School Course project is a student management system designed to facilitate the organization and management of course offerings, student enrollments, and faculty assignments. The system consists of several classes, including Department, Course, Student, and Professor. This management system allows users to perform operations such as adding and viewing courses, enrolling students, and managing faculty assignments.

The project leverages Object-Oriented Programming principles, including inheritance and polymorphism, to create a structured and reusable codebase. Comprehensive testing ensures functionality and reliability throughout the system.

Design Description
Assessment Concepts
Classes: The primary classes include Department, Course, Student, and Professor. Each class encapsulates specific functionalities and attributes related to the system.
Objects: Instances of the classes represent individual departments, courses, students, and professors.
User Input and Output
I/O of Different Data Types:
Command-line interface for user interaction.
The system prompts users for input to navigate menus and perform actions, such as enrolling in courses or adding new faculty members.
Object-Oriented Programming and Design
Inheritance:

The project employs inheritance to model relationships between classes, such as Professor and Student, both of which can be associated with a Department.
Polymorphism:

The system utilizes polymorphism to allow methods to operate on objects of different classes through a common interface.
Abstract Classes and Interfaces:

Abstract classes can be used to define common behaviors for related classes (e.g., a base class for all users with common attributes).

Class Diagram

![cs151diagram](https://github.com/user-attachments/assets/e3a2735e-984f-4f4c-8eee-a96b18aeabfe)

Class Descriptions


Department:

This class represents an academic department, containing courses, students, and professors. It provides methods for adding and managing courses and students.

Course:

The Course class represents an academic course, detailing attributes such as course title, credits, and the associated department.

Student:

This class simulates student profiles, including attributes like name, student ID, and enrolled courses. It manages course enrollment and student-specific functionalities.

Professor:

The Professor class represents faculty members, including their names, subjects taught, and the department they belong to. It allows professors to interact with the courses and students in their department.

User Interface:

Users interact with the system via a command-line interface, where they can select options to view department info, enroll in courses, and manage student records.


Main Function Test Cases:
1.Start the program and view department info.
2.Add a new course to the department.
3.Enroll a student in a course and verify enrollment.
4.Add a professor and ensure they are linked to the correct department.
5.Remove a student and verify their removal from the department.
