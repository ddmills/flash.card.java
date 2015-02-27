# flash.card.java
Command-line flash card application in Java with focus on OOP and Design for CS 362.


### code for creating user table 
plaintext passwords... please never do this ever.
```mysql
CREATE TABLE `user` (
    `id` VARCHAR(50) NOT NULL,
    `username` VARCHAR(50) NOT NULL,
    `type` ENUM('principal','teacher','student') NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username` (`username`)
)
ENGINE=InnoDB;
```