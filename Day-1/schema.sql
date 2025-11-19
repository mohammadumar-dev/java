CREATE TABLE departments (
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

CREATE TABLE courses (
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

CREATE TABLE faculty (
    faculty_id SERIAL PRIMARY KEY,
    faculty_name VARCHAR(100) NOT NULL,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

CREATE TABLE attendance (
    attendance_id SERIAL PRIMARY KEY,
    student_id INT REFERENCES students(student_id),
    course_id INT REFERENCES courses(course_id),
    date DATE NOT NULL,
    status VARCHAR(10) CHECK (status IN ('Present', 'Absent'))
);

CREATE TABLE marks (
    mark_id SERIAL PRIMARY KEY,
    student_id INT REFERENCES students(student_id),
    course_id INT REFERENCES courses(course_id),
    marks_obtained INT
);

-- INSERT Queries
-- departments
INSERT INTO departments (department_name) VALUES
('Computer Science'),
('Mechanical Engineering'),
('Electrical Engineering'),
('Civil Engineering'),
('Electronics'),
('Information Technology'),
('Biotechnology'),
('Physics'),
('Chemistry'),
('Mathematics');

-- students
INSERT INTO students (student_name, department_id) VALUES
('Alice Johnson', 1),
('Bob Smith', 2),
('Charlie Brown', 3),
('Diana Prince', 4),
('Ethan Clark', 5),
('Fiona Adams', 6),
('George Miller', 7),
('Hannah White', 8),
('Ian Scott', 9),
('Julia Roberts', 10);

-- courses
INSERT INTO courses (course_name, department_id) VALUES
('Data Structures', 1),
('Thermodynamics', 2),
('Circuit Theory', 3),
('Structural Analysis', 4),
('Digital Electronics', 5),
('Database Systems', 6),
('Genetics', 7),
('Quantum Mechanics', 8),
('Organic Chemistry', 9),
('Linear Algebra', 10);

-- faculty
INSERT INTO faculty (faculty_name, department_id) VALUES
('Dr. Samantha Green', 1),
('Dr. Thomas Reed', 2),
('Dr. Olivia Brooks', 3),
('Dr. Henry Cooper', 4),
('Dr. Sophia Patel', 5),
('Dr. Michael Evans', 6),
('Dr. Linda Rivera', 7),
('Dr. Patrick Hall', 8),
('Dr. Emily Turner', 9),
('Dr. Robert Lewis', 10);

-- attendance
INSERT INTO attendance (student_id, course_id, date, status) VALUES
(1, 1, '2024-01-10', 'Present'),
(2, 2, '2024-01-10', 'Absent'),
(3, 3, '2024-01-10', 'Present'),
(4, 4, '2024-01-10', 'Present'),
(5, 5, '2024-01-10', 'Absent'),
(6, 6, '2024-01-10', 'Present'),
(7, 7, '2024-01-10', 'Present'),
(8, 8, '2024-01-10', 'Absent'),
(9, 9, '2024-01-10', 'Present'),
(10, 10, '2024-01-10', 'Present');

-- marks
INSERT INTO marks (student_id, course_id, marks_obtained) VALUES
(1, 1, 85),
(2, 2, 78),
(3, 3, 92),
(4, 4, 74),
(5, 5, 88),
(6, 6, 90),
(7, 7, 81),
(8, 8, 69),
(9, 9, 95),
(10, 10, 87);


-- SELECT Queries
SELECT * FROM students;
SELECT student_name, department_id FROM students;
SELECT * FROM students WHERE department_id = 5;
SELECT student_name FROM students WHERE student_name LIKE 'A%';
SELECT * FROM marks WHERE marks_obtained BETWEEN 40 AND 80;

-- ORDER BY Queries
SELECT * FROM students ORDER BY student_name;
SELECT * FROM marks ORDER BY marks_obtained DESC;

-- GROUP BY Queries
SELECT department_id, COUNT(*) AS total_students FROM students GROUP BY department_id;
SELECT course_name, COUNT(*) AS total_students FROM courses GROUP BY course_name HAVING COUNT(*) > 2;


-- JOIN QUERIES
-- INNER JOIN
SELECT s.student_name, d.department_name FROM students s INNER JOIN departments d ON s.department_id = d.department_id;
SELECT c.course_name, d.department_name FROM courses c INNER JOIN departments d ON s.department_id = d.department_id;
SELECT f.faculty_name, d.department_name FROM faculty f INNER JOIN departments d ON f.department_id = d.department_id;
SELECT f.faculty_name, c.course_name FROM faculty f INNER JOIN courses c ON f.department_id = c.department_id;

-- LEFT JOIN
SELECT c.course_name, f.faculty_name FROM courses c LEFT JOIN faculty f ON c.department_id = f.department_id;
SELECT s.student_name, m.marks_obtained FROM students s LEFT JOIN marks m ON s.student_id = m.student_id;
SELECT s.student_name, a.status FROM students s LEFT JOIN attendance a ON s.student_id = a.student_id;

-- RIGHT JOIN
SELECT s.student_name, m.marks_obtained FROM marks m RIGHT JOIN students s ON m.student_id = s.student_id;
SELECT c.course_name, a.status FROM attendance a RIGHT JOIN courses c ON a.course_id = c.course_id;
SELECT d.department_name, f.faculty_name FROM faculty f RIGHT JOIN departments d ON f.department_id = d.department_id;
