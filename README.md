# Faculty App

<h3>To launch app:</h3>
- pull this file<br>
- open terminal and run mvn clean package <br>
- open browser: http://localhost:8085/swagger-ui/#/<br>
- I added some scripts for creating tables and filling them with data, so...<br>
  everything prepared to work<br>

<h3>Project description:</h3>
In Faculty app I implemented basic CRUD operations. I chose H2 for storing data and with hand of <br>
liquibase I save some scripts to make some test requests as soon as the app starts. All the data <br>
storing in three tables: students table, teachers table and student_teacher table. By legend, every <br>
student has list of teachers and every teacher has list of students. In this schema data storing <br>
I implemented bidirectional binding and chose the students table as the main. <br>

<h3>Description of StudentController:</h3>
GET: /students : to get list of all students from DB. Pagination and sorting were implemented. You'll <br>
get 20 rows from DB per page by default. Using sorting you can put any specify field from entity and <br>
assign asc or desc way of representation data. For example [age:DESC]. By the way, I set [id:ASC] by default. <br>

GET: /students/by-teacher : you can get list of students by specific teacher`s id. Pagination and sorting <br>
organized the saim way as in the previous endpoint. But be careful while putting id because if there isn't <br>
any teacher in the DB by id, exception will be thrown. <br>

POST: /students : to create student, all the fields are compulsory. Moreover, data validation implemented <br>
and you'll receive a detailed message if your input fails validation. <br>

PUT: /students : you can update student by specific id. As in the previous endpoint, all data are <br>
compulsory. All input will pass validation. <br>

DELETE: /students : you can delete student by id. <br>

PUT: /students/add-teacher : you can add teacher to student's list of teachers. Be careful while putting <br>
student or teacher ids, because if specific id is absent in DB, the exception will be thrown. <br>

PUT: /students/remove-teacher : you can remove teacher from student's list of teachers. As in the previous <br>
endpoint, be careful while putting student or teacher ids, because if specific id is absent in DB, the <br>
exception will be thrown. <br>

GET: /students/search : search students by name and surname. In rare cases you can have more than one person <br>
with the same name and surname in DB. Thus, this endpoint may return list of rows. <br>

<h3>Description of TeacherController:</h3>
GET: /teachers : to get list of all teachers from DB. Pagination and sorting were implemented. You'll <br>
get 20 rows from DB per page by default. Using sorting you can put any specify field from entity and <br>
assign asc or desc way of representation data. For example [age:DESC]. By the way, I set [id:ASC] by default. <br>

GET: /teachers/by-student : you can get list of teachers by specific student`s id. Pagination and sorting <br>
organized the saim way as in the previous endpoint. But be careful while putting id because if there isn't <br>
any student in the DB by id, exception will be thrown. <br>

POST: /teachers : to create teacher, all the fields are compulsory. Moreover, data validation implemented <br>
and you'll receive a detailed message if your input fails validation. <br>

PUT: /teachers : you can update teacher by specific id. As in the previous endpoint, all data are <br>
compulsory. All input will pass validation. <br>

DELETE: /teachers : you can delete teacher by id. <br>

PUT: /teachers/add-student : you can add student to teacher's list of students. Be careful while putting <br>
student or teacher ids, because if specific id is absent in DB, the exception will be thrown. <br>

PUT: /teachers/remove-student : you can remove student from teacher's list of students. As in the previous <br>
endpoint, be careful while putting student or teacher ids, because if specific id is absent in DB, the <br>
exception will be thrown. <br>

GET: /teachers/search : search teachers by name and surname. In rare cases you can have more than one person <br>
with the same name and surname in DB. Thus, this endpoint may return list of rows. <br>

<h3>In this APP were used such technologies like:</h3>
- org.apache.maven, version 4.0.0 <br>
- java, version 17 <br>
- org.hibernate <br>
- spring boot <br>
- liquibase <br>
- H2
