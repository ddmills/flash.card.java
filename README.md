# flash.card.java
Command-line flash card application in Java with focus on OOP and Design for CS 362.

## Database info
We are using a localhost for this project. The database is called "flashcards"

### user table
Plaintext passwords... please never do this ever.
```mysql
CREATE TABLE `user` (
    `id` INT(11) NOT NULL,
    `username` VARCHAR(50) NOT NULL,
    `type` ENUM('principal','teacher','student') NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username` (`username`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;
```

### Deck table:
```mysql
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
```

### Card table:
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

### Quiz table:
```mysql
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
```


