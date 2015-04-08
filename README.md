# flash.card.java
Command-line flash card application in Java with focus on OOP and Design for CS 362.

## Database info
We are using a localhost for this project. The database is called "flashcards"

### user table
Plaintext passwords... please never do this ever.
```mysql
CREATE TABLE `user` (
	`username` VARCHAR(50) NOT NULL,
	`type` ENUM('principal','teacher','student') NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`username`),
	UNIQUE INDEX `username` (`username`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;
```

### deck table:
```mysql
CREATE TABLE `deck` (
	`deckID` INT(11) NOT NULL,
	`ownerID` VARCHAR(50) NOT NULL,
	`title` VARCHAR(50) NOT NULL,
	`description` VARCHAR(256) NOT NULL,
	PRIMARY KEY (`deckID`),
	INDEX `FK__user` (`ownerID`),
	CONSTRAINT `FK_deck_user` FOREIGN KEY (`ownerID`) REFERENCES `user` (`username`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;
```

### card table:
```mysql
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
```

### quiz table:
```mysql
CREATE TABLE `quiz` (
	`quizID` INT(11) NOT NULL,
	`deckID` INT(11) NOT NULL,
	`ownerID` VARCHAR(50) NOT NULL,
	`title` VARCHAR(50) NOT NULL,
	`description` VARCHAR(256) NOT NULL,
	PRIMARY KEY (`quizID`),
	INDEX `FK___deck` (`deckID`),
	INDEX `FK___user` (`ownerID`),
	CONSTRAINT `FK` FOREIGN KEY (`ownerID`) REFERENCES `user` (`username`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `FK___deck` FOREIGN KEY (`deckID`) REFERENCES `deck` (`deckID`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;
```
### quiz-student relational table
```mysql
CREATE TABLE `quiz_relation` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `quizID` INT(11) NOT NULL DEFAULT '0',
    `studentID` VARCHAR(50) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    INDEX `FK__quiz` (`quizID`),
    INDEX `FK__user` (`studentID`),
    CONSTRAINT `FK__quiz` FOREIGN KEY (`quizID`) REFERENCES `quiz` (`quizID`) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT `FK__user` FOREIGN KEY (`studentID`) REFERENCES `user` (`username`) ON UPDATE CASCADE ON DELETE CASCADE
)
ENGINE=InnoDB;
```

### result table
```mysql
CREATE TABLE `result` (
    `resultID` INT(11) NOT NULL AUTO_INCREMENT,
    `cardID` INT(11) NOT NULL DEFAULT '0',
    `quizID` INT(11) NOT NULL DEFAULT '0',
    `userID` VARCHAR(50) NOT NULL DEFAULT '0',
    `answer` VARCHAR(50) NOT NULL DEFAULT '0',
    PRIMARY KEY (`resultID`),
    INDEX `FK____card` (`cardID`),
    INDEX `FK____quiz` (`quizID`),
    INDEX `FK____user` (`userID`),
    CONSTRAINT `FK____card` FOREIGN KEY (`cardID`) REFERENCES `card` (`cardID`) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT `FK____quiz` FOREIGN KEY (`quizID`) REFERENCES `quiz` (`quizID`) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT `FK____user` FOREIGN KEY (`userID`) REFERENCES `user` (`username`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;
```

### course table
```mysql

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
```
### course_relation table
```mysql
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
```
