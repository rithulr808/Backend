-- Inserting data into the Department table
INSERT INTO Department (id, dept_name) VALUES (1, 'Computer Science');
INSERT INTO Department (id, dept_name) VALUES (2, 'Mathematics');

-- Inserting data into the Exam table
INSERT INTO Exam (id, exam_name) VALUES (1, 'Midterm Exam');
INSERT INTO Exam (id, exam_name) VALUES (2, 'Final Exam');
INSERT INTO Batch (id, batch) VALUES (1, '2024 Batch');
INSERT INTO Batch (id, batch) VALUES (2, '2025 Batch');


INSERT INTO Course (id, course_name, course_full_name, department_id) VALUES (1, 'CS101', 'Introduction to Computer Science', 1);

INSERT INTO Course (id, course_name, course_full_name, department_id) VALUES (2, 'MATH201', 'Advanced Calculus', 2);
-- Inserting data into the Student table
INSERT INTO Student (id, first_name, last_name, age, email, roll_no, dob, batch_id) VALUES (1, 'John', 'Doe', 20, 'john.doe@example.com', '1001', '2004-01-15', 1);
INSERT INTO Student (id, first_name, last_name, age, email, roll_no, dob, batch_id) VALUES (2, 'Jane', 'Smith', 21, 'jane.smith@example.com', '1002', '2003-03-22', 2);

INSERT INTO Student_Courses (student_id, courses_id) VALUES (1, 1);
INSERT INTO Student_Courses (student_id, courses_id) VALUES (1, 2);
INSERT INTO Student_Courses (student_id, courses_id) VALUES (2, 1);
INSERT INTO user_details(username,password) values ('rohithk','$2a$12$sRXv17Aj73Dob.Qc8s.sr.Quxy0DyDrcmGmehLMUva223o1iOV4N6')