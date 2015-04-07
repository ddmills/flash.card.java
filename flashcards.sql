CREATE TABLE `user` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `type` ENUM('principal','teacher','student') NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username` (`username`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

CREATE TABLE `deck` (
    `deckID` INT(11) NOT NULL,
    `ownerID` INT(11) NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `description` VARCHAR(256) NOT NULL,
    PRIMARY KEY (`deckID`),
    INDEX `FK__user` (`ownerID`),
    CONSTRAINT `FK__user` FOREIGN KEY (`ownerID`) REFERENCES `user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
ENGINE=InnoDB;

CREATE TABLE `card` (
    `cardID` INT(11) NOT NULL,
    `deckID` INT(11) NOT NULL,
    `front` VARCHAR(256) NOT NULL,
    `back` VARCHAR(256) NOT NULL,
    PRIMARY KEY (`cardID`),
    INDEX `FK_card_deck` (`deckID`),
    CONSTRAINT `FK_card_deck` FOREIGN KEY (`deckID`) REFERENCES `deck` (`deckID`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

CREATE TABLE `quiz` (
    `quizID` INT(11) NOT NULL,
    `deckID` INT(11) NOT NULL,
    `ownerID` INT(11) NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `description` VARCHAR(256) NOT NULL,
    PRIMARY KEY (`quizID`),
    INDEX `FK___deck` (`deckID`),
    INDEX `FK___user` (`ownerID`),
    CONSTRAINT `FK___deck` FOREIGN KEY (`deckID`) REFERENCES `deck` (`deckID`) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT `FK___user` FOREIGN KEY (`ownerID`) REFERENCES `user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
ENGINE=InnoDB;

CREATE TABLE `result` (
	`resultID` INT(11) NOT NULL AUTO_INCREMENT,
	`quizID` INT(11) NOT NULL DEFAULT '0',
	`userID` VARCHAR(50) NOT NULL DEFAULT '0',
	`answer` VARCHAR(50) NOT NULL DEFAULT '0',
	PRIMARY KEY (`resultID`),
	INDEX `FK___1` (`quizID`),
	INDEX `FK_result_user` (`userID`),
	CONSTRAINT `FK___1` FOREIGN KEY (`quizID`) REFERENCES `quiz` (`quizID`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `FK_result_user` FOREIGN KEY (`userID`) REFERENCES `user` (`username`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

CREATE TABLE `course_relation` (
	`rowID` INT(11) NOT NULL AUTO_INCREMENT,
	`courseID` INT(11) NULL DEFAULT '0',
	`userID` VARCHAR(50) NULL DEFAULT '0',
	PRIMARY KEY (`rowID`),
	INDEX `FK1` (`userID`),
	INDEX `FK_course_relation_course` (`courseID`),
	CONSTRAINT `FK1` FOREIGN KEY (`userID`) REFERENCES `user` (`username`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `FK_course_relation_course` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON UPDATE CASCADE ON DELETE CASCADE
)
COMMENT='relational table for students to courses'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

CREATE TABLE `course` (
	`courseID` INT(11) NOT NULL,
	`title` VARCHAR(50) NULL DEFAULT NULL,
	`ownerID` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`courseID`),
	INDEX `FK___user` (`ownerID`),
	CONSTRAINT `FK___user` FOREIGN KEY (`ownerID`) REFERENCES `user` (`username`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;


