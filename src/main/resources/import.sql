
-- INSERT INTO Batch (id, batch) VALUES (2, '2025 Batch');
INSERT INTO Course (id, course_name, course_full_name, course_credit, duration, description, title, course_img)
VALUES
    (1, 'CS101', 'Introduction to Computer Science', 3, 12, 'A foundational course in computer science covering programming basics, algorithms, and data structures.', 'Intro to CS', 'https://cdn.dribbble.com/userupload/8068333/file/original-109b0709a84c56900d282554359ff97f.png?resize=752x564&vertical=center'),
    (2, 'MATH201', 'Calculus II', 4, 16, 'An advanced calculus course focusing on integrals, sequences, and series.', 'Advanced Calculus', 'https://cdn.dribbble.com/userupload/8068333/file/original-109b0709a84c56900d282554359ff97f.png?resize=752x564&vertical=centerg'),
    (3, 'PHY150', 'General Physics I', 4, 14, 'Covers the fundamentals of physics including mechanics, motion, and energy.', 'Physics Basics', 'https://cdn.dribbble.com/userupload/8068333/file/original-109b0709a84c56900d282554359ff97f.png?resize=752x564&vertical=center'),
    (4, 'ENG101', 'English Composition', 3, 10, 'Teaches the fundamentals of academic writing, including grammar and essay structure.', 'Academic Writing', 'https://cdn.dribbble.com/userupload/8068333/file/original-109b0709a84c56900d282554359ff97f.png?resize=752x564&vertical=center'),
    (5, 'HIST210', 'World History', 3, 12, 'Explores significant events and themes in world history from ancient to modern times.', 'Global History', 'https://cdn.dribbble.com/userupload/8068333/file/original-109b0709a84c56900d282554359ff97f.png?resize=752x564&vertical=center');


INSERT INTO Course (id, course_name, course_full_name, department_id) VALUES (1, 'CS101', 'Introduction to Computer Science');

INSERT INTO Course (id, course_name, course_full_name, department_id) VALUES (2, 'MATH201', 'Advanced Calculus', 2);


INSERT INTO Student_Courses (student_id, courses_id) VALUES (1, 1);
INSERT INTO Student_Courses (student_id, courses_id) VALUES (1, 2);
INSERT INTO Student_Courses (student_id, courses_id) VALUES (2, 1);
INSERT INTO user_details(username,password) values ('rohithk','$2a$12$sRXv17Aj73Dob.Qc8s.sr.Quxy0DyDrcmGmehLMUva223o1iOV4N6');
INSERT INTO user_details(username,password) values ('dad','$2a$12$gjWNFDwQVISZ170.IHnjL.eALH1we4ycidBaCHo9WIbYnnUvgGPfC')