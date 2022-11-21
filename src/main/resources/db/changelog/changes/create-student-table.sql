CREATE TABLE IF NOT EXISTS students (
    id bigint auto_increment,
    name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
    age integer NOT NULL,
    email varchar(255) NOT NULL,
    specialization character varying(256) NOT NULL,
    CONSTRAINT student_pk PRIMARY KEY (id)
    );

--rollback DROP TABLE students;