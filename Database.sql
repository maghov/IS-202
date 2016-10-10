use slitdb; 

CREATE TABLE Users 
( 
	id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(128) NOT NULL, 
    mail VARCHAR(128) NOT NULL, 
    password VARCHAR(64) NOT NULL, 
    userName VARCHAR(64) NOT NULL
); 

INSERT INTO Users VALUES (null, 'John Martin', 'test@outlok.com', 'Test123', 'Nyranith'); 

SELECT * FROM USERS;

SELECT * FROM Users WHERE userName = 'Magnus' OR mail = 'test@outlook.com'