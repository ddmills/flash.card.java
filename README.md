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


