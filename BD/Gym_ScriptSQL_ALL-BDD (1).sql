drop database if exists projecte2;
create database projecte2;

use projecte2;


CREATE TABLE `Sales` (
	`ID_Sala` INT NOT NULL,
	`Aforament` INT NOT NULL DEFAULT '0',
	`Descripció` varchar(255) DEFAULT '0',
	PRIMARY KEY (`ID_Sala`)
);

CREATE TABLE `Activitats` (
	`ID_Act` INT(255) NOT NULL AUTO_INCREMENT,
	`Descipció` varchar(255),
	`Durada` TIME NOT NULL,
    `Color` varchar(255),
	`Hora_Fi` TIME NOT NULL,
	`Hora_i` TIME NOT NULL,
	PRIMARY KEY (`ID_Act`)
);

CREATE TABLE `Individuals` (
	`ID_Act` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`ID_Act`)
);

CREATE TABLE `Col·lectives` (
	`ID_Act` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`ID_Act`)
);

CREATE TABLE `Té` (
	`ID_Sala` INT NOT NULL,
	`ID_Act` INT NOT NULL,
	`Dia` int NOT NULL,
	PRIMARY KEY (`ID_Sala`,`ID_Act`)
);

CREATE TABLE `Clients` (
	`DNI` varchar(9) NOT NULL,
	`Nom` VARCHAR(255) NOT NULL,
	`Cognom` VARCHAR(255) NOT NULL,
	`Data_naixement` DATE NOT NULL,
	`Tel` INT NOT NULL,
	`Correu_e` varchar(255) NOT NULL,
	`Sexe` VARCHAR(1) NOT NULL,
	`Condicio_Fisica` varchar(255) NOT NULL,
	`Comunicació_comercial` BOOLEAN NOT NULL,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Registres` (
	`ID_Registre` int(255) NOT NULL auto_increment,
	`DNI` varchar(9) NOT NULL,
	`Data_Alta` DATETIME NOT NULL,
	`Data_Baixa` DATETIME,
	PRIMARY KEY (`ID_Registre`)
);

CREATE TABLE `Monitors` (
	`DNI` varchar(9) NOT NULL,
	`ID_Sala` INT NOT NULL,
	`Nom` VARCHAR(25) NOT NULL,
	`Cognom` VARCHAR(25) NOT NULL,
	`Data_naixement` DATE NOT NULL,
	`Tel` INT(255) NOT NULL,
	`Sou` DECIMAL NOT NULL,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Reserva` (
	`DNI` varchar(9) NOT NULL,
	`ID_Act` INT(255) NOT NULL,
	`Data_reserva` DATETIME NOT NULL,
	`Data` DATE NOT NULL,
	PRIMARY KEY (`DNI`,`ID_Act`)
);

CREATE TABLE `Usuari` (
	`Usuari` varchar(25) NOT NULL,
	`Contrasenya` varchar(32) NOT NULL,
	`DNI` varchar(255) NOT NULL,
	PRIMARY KEY (`Usuari`)
);

CREATE TABLE `Curses` (
	`ID_cursa` INT NOT NULL AUTO_INCREMENT,
	`Durada` TIME NOT NULL,
	`Localitat` varchar(255) NOT NULL,
	`Modalitat` varchar(255) NOT NULL,
	PRIMARY KEY (`ID_cursa`)
);

CREATE TABLE `Inscriure` (
	`ID` int NOT NULL AUTO_INCREMENT,
	`DNI` varchar(9) NOT NULL,
	`Data` datetime NOT NULL,
	`ID_cursa` int NOT NULL,
	PRIMARY KEY (`ID`)
);

ALTER TABLE `Individuals` ADD CONSTRAINT `Individuals_fk0` FOREIGN KEY (`ID_Act`) REFERENCES `Activitats`(`ID_Act`);

ALTER TABLE `Col·lectives` ADD CONSTRAINT `Col·lectives_fk0` FOREIGN KEY (`ID_Act`) REFERENCES `Activitats`(`ID_Act`);

ALTER TABLE `Té` ADD CONSTRAINT `Té_fk0` FOREIGN KEY (`ID_Sala`) REFERENCES `Sales`(`ID_Sala`);

ALTER TABLE `Té` ADD CONSTRAINT `Té_fk1` FOREIGN KEY (`ID_Act`) REFERENCES `Activitats`(`ID_Act`);

ALTER TABLE `Registres` ADD CONSTRAINT `Registres_fk0` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Monitors` ADD CONSTRAINT `Monitors_fk0` FOREIGN KEY (`ID_Sala`) REFERENCES `Sales`(`ID_Sala`);

ALTER TABLE `Reserva` ADD CONSTRAINT `Reserva_fk0` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Reserva` ADD CONSTRAINT `Reserva_fk1` FOREIGN KEY (`ID_Act`) REFERENCES `Activitats`(`ID_Act`);

ALTER TABLE `Usuari` ADD CONSTRAINT `Usuari_fk0` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Inscriure` ADD CONSTRAINT `Inscriure_fk0` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Inscriure` ADD CONSTRAINT `Inscriure_fk1` FOREIGN KEY (`ID_cursa`) REFERENCES `Curses`(`ID_cursa`);


#-----------------
#Sales
#-----------------

INSERT INTO Sales VALUES (1, 25, 'Sala de Yoga');
INSERT INTO Sales VALUES (2, 12, 'Sala de Bici');
INSERT INTO Sales VALUES (3, 15, 'Sala de Maquines');
INSERT INTO Sales VALUES (4, 25, 'Sala de Pilates');
INSERT INTO Sales VALUES (5, 25, 'Sala de Bici');
INSERT INTO Sales VALUES (6, 25, 'Sala de Yoga');



#-----------------
#Activitats
#-----------------

INSERT INTO Activitats VALUES (1, 'Piscina','01:30:00', 'blue', '10:30:00', '12:00:00');
INSERT INTO Activitats VALUES (default, 'Fitness','01:30:00', 'red', '10:30:00', '12:00:00');
INSERT INTO Activitats VALUES (default, 'Bici','01:30:00', 'brown', '9:30:00', '11:00:00');
INSERT INTO Activitats VALUES (default, 'Pilates','01:30:00', 'green', '10:30:00', '12:00:00');
INSERT INTO Activitats VALUES (default, 'Zumba','01:30:00', 'yellow', '10:30:00', '12:00:00');
INSERT INTO Activitats VALUES (default, 'Natació','01:30:00', 'purple', '9:30:00', '11:00:00');
INSERT INTO Activitats VALUES (default, 'Aquagym','01:30:00', 'pink', '15:30:00', '17:00:00');


	#-----------------
	#Individuals
	#-----------------
    INSERT INTO individuals VALUES (1);
    INSERT INTO individuals VALUES (2);
    INSERT INTO individuals VALUES (3);
    
    #-----------------
	#Col·lectives
	#-----------------
	INSERT INTO Col·lectives VALUES (4);
    INSERT INTO Col·lectives VALUES (5);
    INSERT INTO Col·lectives VALUES (6);
	INSERT INTO Col·lectives VALUES (7);



#-----------------
#Té
#-----------------

INSERT INTO Té VALUES (4,3,1);
INSERT INTO Té VALUES (3,6,2);
INSERT INTO Té VALUES (2,1,3);
INSERT INTO Té VALUES (5,7,4);
INSERT INTO Té VALUES (6,5,5);
INSERT INTO Té VALUES (1,2,6);
INSERT INTO Té VALUES (1,4,7);



#-----------------
#Clients
#-----------------

INSERT INTO Clients VALUES ('49259653R', 'Sergi', 'Florensa' , '2003-02-03', 66331337, 'sergifr.dam1@alumnescostafreda.cat', 'M', 'Cap', false);
INSERT INTO Clients VALUES ('93843945E', 'Marc', 'Rius' , '2002-08-13', 68912344, 'marcr.dam1@alumnescostafreda.cat', 'M', 'Cap', false);
INSERT INTO Clients VALUES ('56567346F', 'Paula', 'Angera' , '2000-07-09', 69371283, 'pola.dam1@alumnescostafreda.cat', 'F', 'Cap', true);
INSERT INTO Clients VALUES ('58249180J', 'Maria', 'Rojo' , '2003-04-12', 64534523, 'jordir.dam1@alumnescostafreda.cat', 'F', 'Cap', false);	
INSERT INTO Clients VALUES ('45623459K', 'Sergi', 'Pont' , '2009-09-24', 63244561, 'sergip.dam1@alumnescostafreda.cat', 'M', 'Asma', true);
INSERT INTO Clients VALUES ('02893492S', 'Eric', 'Martin' , '2004-02-21', 64343245, 'ericm.dam1@alumnescostafreda.cat', 'M', 'Cap', true);



#-----------------
#Registres
#-----------------

INSERT INTO Registres VALUES (1, '49259653R', '2020-08-24 12:32:34', null);
INSERT INTO Registres VALUES (default, '93843945E', '2012-04-24 10:38:27', null);
INSERT INTO Registres VALUES (default, '56567346F', '2020-08-24 16:32:16', null);
INSERT INTO Registres VALUES (default, '58249180J', '2020-08-24 18:48:21', null);
INSERT INTO Registres VALUES (default, '02893492S', '2020-08-24 11:20:45', null);
INSERT INTO Registres VALUES (default, '45623459K', '2020-08-24 14:06:32', null);

#-----------------
#Monitors
#-----------------

INSERT INTO Monitors VALUES ('02893492S', 1, 'Manel', 'Oliveria', '1996-02-21', 64343245, 990.65);
INSERT INTO Monitors VALUES ('34723847G', 2, 'David', 'Oliveria', '1996-02-21', 64343315, 990.65);
INSERT INTO Monitors VALUES ('81362870W', 3, 'Sandra', 'Oliveria', '1998-02-21', 64342145, 990.65);
INSERT INTO Monitors VALUES ('83180906A', 4, 'Jospe', 'Oliveria', '1999-02-21', 64334235, 990.65);
INSERT INTO Monitors VALUES ('05531276Y', 5, 'Marc', 'Oliveria', '1996-12-21', 642423445, 990.65);
INSERT INTO Monitors VALUES ('77228799C', 6, 'Dani', 'Oliveria', '1986-08-21', 644234121, 990.65);



#-----------------
#Reserva
#-----------------

INSERT INTO Reserva VALUES ('49259653R', 1, '2022-02-24 8:38:00', '2022-02-24');
INSERT INTO Reserva VALUES ('93843945E', 2, '2022-02-24 8:15:00', '2022-02-24');
INSERT INTO Reserva VALUES ('58249180J', 3, '2022-02-24 7:43:20', '2022-02-24');
INSERT INTO Reserva VALUES ('45623459K', 4, '2022-02-24 8:38:00', '2022-02-24');
INSERT INTO Reserva VALUES ('45623459K', 6, localtime(), '2022-03-05');
INSERT INTO Reserva VALUES ('56567346F', 7, localtime(), '2022-03-05');
INSERT INTO Reserva VALUES ('93843945E', 7, localtime(), '2022-03-05');
INSERT INTO Reserva VALUES ('45623459K', 1, localtime(), '2022-03-05');



#-----------------
#Usuari
#-----------------

INSERT INTO Usuari VALUES ('Waxii', MD5('1234'),'49259653R');
INSERT INTO Usuari VALUES ('Marquitoz', MD5('7352'), '93843945E');
INSERT INTO Usuari VALUES ('Maria85', MD5('3456'), '58249180J');
INSERT INTO Usuari VALUES ('Ponche', MD5('8234'), '45623459K');
INSERT INTO Usuari VALUES ('PaAwA', MD5('9345'), '02893492S');
INSERT INTO Usuari VALUES ('Erich', MD5('8213'), '56567346F');



#-----------------
#Curses
#-----------------

INSERT INTO Curses VALUES (1, '02:30:00', 'Cervera', 'Bici');
INSERT INTO Curses VALUES (default, '01:30:00', 'Tarragona', 'Atletisme');
INSERT INTO Curses VALUES (default, '02:00:00', 'Ponts', 'Triatlo');
INSERT INTO Curses VALUES (default, '02:30:00', 'Igualada', 'Bici');



#-----------------
#Inscriure
#-----------------

INSERT INTO Inscriure VALUES (1, '49259653R', '2022-02-24 8:38:00', 3);
INSERT INTO Inscriure VALUES (default, '93843945E', '2022-02-24 8:38:00', 2);
INSERT INTO Inscriure VALUES (default, '58249180J', '2022-02-24 8:38:00', 4);
INSERT INTO Inscriure VALUES (default,  '45623459K', '2022-02-24 8:38:00', 1);




