DROP TABLE MEMBER1;
SELECT * FROM MEMBER1;
CREATE TABLE MEMBER1(
	ID VARCHAR(20),
	PASSWORD VARCHAR(30) NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	AGE NUMBER,
	GENDER VARCHAR(20),
	EMAIL VARCHAR(50),
	PRIMARY KEY(ID)
);
commit
SELECT * FROM MEMBER1 WHERE ID='admin' AND PASSWORD='aa'