/*
-- Query: SELECT * FROM students.student
LIMIT 0, 1000

-- Date: 2021-10-23 23:56
*/
INSERT INTO `` (`number`,`name`,`surname`) VALUES (1276,'Ludmila','Popova');
INSERT INTO `` (`number`,`name`,`surname`) VALUES (1321,'Ivan','Petrov');
INSERT INTO `` (`number`,`name`,`surname`) VALUES (1643,'Maria','Semenova');
INSERT INTO `` (`number`,`name`,`surname`) VALUES (3274,'Artem','Pogodin');
INSERT INTO `` (`number`,`name`,`surname`) VALUES (3450,'Ekaterina','Bruk');
INSERT INTO `` (`number`,`name`,`surname`) VALUES (3487,'Sergey','Bogdanov');
INSERT INTO `` (`number`,`name`,`surname`) VALUES (5623,'Anna','Zhukova');
INSERT INTO `` (`number`,`name`,`surname`) VALUES (6421,'Liza','Ilina');
INSERT INTO `` (`number`,`name`,`surname`) VALUES (9432,'Mark','Ivanov');


CREATE DEFINER=`root`@`localhost` PROCEDURE `new_procedure`(a INT)
BEGIN
SELECT 
sr.ave_rating 
FROM students.rating sr
WHERE sr.number LIKE a;
END

/*
-- Query: call students.new_procedure(1643)
-- Date: 2021-10-24 17:29
*/
INSERT INTO `` (`ave_rating`) VALUES (4.1);
