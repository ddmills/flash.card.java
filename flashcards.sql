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