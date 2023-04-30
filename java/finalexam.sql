DROP DATABASE IF EXISTS final_exam;
CREATE DATABASE IF NOT EXISTS final_exam;
USE final_exam;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id 			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name 	VARCHAR(50) NOT NULL,
    email 		VARCHAR(50) UNIQUE NOT NULL,
    `password` 	VARCHAR(12) NOT NULL ,
	ex_in_year TINYINT UNSIGNED,
    pro_skill 	VARCHAR(50) ,
    project_id TINYINT UNSIGNED,
    `role`		ENUM('EMPLOYEE','MANAGER') 
);
    
INSERT INTO `user` (full_name,email,`password`, ex_in_year,pro_skill,project_id, `role`) 
VALUES				 ('Tùng', 'tung@gmail.com', '123456789', 10,null,2, 'MANAGER'),
					('Hà', 'ha@gmail.com', '123456789', null,"Java",3, 'EMPLOYEE')


