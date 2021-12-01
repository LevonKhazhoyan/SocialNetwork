CREATE TABLE person (
    uuid UUID NOT NULL PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(7) NOT NULL CHECK (gender = 'Female' OR gender = 'Male'),
    dob DATE NOT NULL,
    age INT NOT NULL
);


