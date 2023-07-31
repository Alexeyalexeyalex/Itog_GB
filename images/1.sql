USE HumanFriends;

CREATE TABLE IF NOT EXISTS animals(
animals_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(25) NOT NULL,
title VARCHAR(25) NOT NULL,
birthday DATE NOT NULL,
animalType VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT EXISTS petCommands(
petCommands_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT EXISTS petCommandsAnimals(
petCommandsAnimals_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
petCommands_ID INT NOT NULL,
animals_ID INT NOT NULL,

FOREIGN KEY (petCommands_ID) REFERENCES petCommands(petCommands_ID)
ON UPDATE CASCADE ON DELETE RESTRICT,

FOREIGN KEY (animals_ID) REFERENCES animals(animals_ID)
ON UPDATE CASCADE ON DELETE RESTRICT
);

INSERT INTO animals(name, title, birthday, animalType)
VALUES
('Рыжик','Собака','2010-03-13','Домашние'),
('Пушок','Кошка','2022-01-01','Домашние'),
('Хома','Хомяк','2023-07-23','Домашние'),
('Ракета','Лошадь','2000-01-03','Вьючные'),
('Леви','Верблюд','1999-12-01','Вьючные'),
('Кракен','Осел','2020-05-29','Вьючные');


INSERT INTO petCommands(name)
VALUES
('GO'),
('STOP'),
('RUN_AWAY'),
('JUMP'),
('STAND_UP');


INSERT INTO petCommandsAnimals(animals_ID, petCommands_ID)
VALUES
('1','1'),
('1','2'),
('2','4'),
('2','5'),
('3','3'),
('4','4'),
('4','5'),
('5','1'),
('5','2'),
('6','1'),
('6','2'),
('6','3'),
('6','4');

DELETE FROM petCommandsAnimals WHERE animals_ID = (SELECT animals_ID FROM animals WHERE title = 'Верблюд') ;

DELETE FROM animals WHERE title = 'Верблюд';



CREATE TABLE IF NOT EXISTS youngAnimals(
youngAnimals INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(25) NOT NULL,
title VARCHAR(25) NOT NULL,
birthday DATE NOT NULL,
animalType VARCHAR(25) NOT NULL
);

CREATE VIEW youngAnimals AS 

SELECT name, title, birthday, animalType, DATEDIFF(NOW(), birthday) DIV 30 AS mounthFromBorning  FROM animals WHERE DATEDIFF(NOW(), birthday) DIV 30 > 12 AND DATEDIFF(NOW(), birthday) DIV 30 < 36;
























