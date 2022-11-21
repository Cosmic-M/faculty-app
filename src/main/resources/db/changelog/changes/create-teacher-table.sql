CREATE TABLE IF NOT EXISTS teachers (
    id bigint auto_increment,
    name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
    age integer NOT NULL,
    email varchar(255) NOT NULL,
    subject character varying(256) NOT NULL,
    CONSTRAINT teacher_pk PRIMARY KEY (id)
    );

--rollback DROP TABLE teachers;