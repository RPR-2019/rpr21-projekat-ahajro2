BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `korisnik` (
    `id` INTEGER,
    `ime` TEXT,
    `prezime` TEXT,
    `email` TEXT,
    `username` TEXT,
    `lozinka` TEXT,
    `visina` INTEGER,
    `tezina` INTEGER,
    `treningOpcija` TEXT,
    `url` TEXT,
    PRIMARY KEY(`id`)
);
INSERT INTO `korisnik` VALUES(1, 'Adnan', 'Hajro', 'gmail', 'ahajro2', 'tatamata', '187', '84', 'Napredni', '');
CREATE TABLE IF NOT EXISTS `ponedjeljak` (
    `id` INTEGER,
    `pon` TEXT
);
INSERT INTO `ponedjeljak` VALUES(1, 'Barbell row');
CREATE TABLE IF NOT EXISTS `utorak` (
    `id` INTEGER,
    `uto` TEXT
);
CREATE TABLE IF NOT EXISTS `srijeda` (
    `id` INTEGER,
    `sri` TEXT
);
CREATE TABLE IF NOT EXISTS `cetvrtak` (
    `id` INTEGER,
    `cet` TEXT
);
CREATE TABLE IF NOT EXISTS `petak` (
    `id` INTEGER,
    `pet` TEXT
);
CREATE TABLE IF NOT EXISTS `subota` (
    `id` INTEGER,
    `sub` TEXT
);
CREATE TABLE IF NOT EXISTS `nedjelja` (
    `id` INTEGER,
    `ned` TEXT
);
CREATE TABLE IF NOT EXISTS `napredni_trening` (
    `ponedjeljak` TEXT,
    `utorak` TEXT,
    `srijeda` TEXT,
    `cetvrtak` TEXT,
    `petak` TEXT,
    `subota` TEXT,
    `nedjelja` TEXT
);
CREATE TABLE IF NOT EXISTS `pocetnik_trening` (
    `ponedjeljak` TEXT,
    `utorak` TEXT,
    `srijeda` TEXT,
    `cetvrtak` TEXT,
    `petak` TEXT,
    `subota` TEXT,
    `nedjelja` TEXT
);
INSERT INTO `napredni_trening` VALUES('Bench press/dips', 'Zgibovi', 'odmor', 'Dips', 'Zgibovi', 'odmor', 'odmor');
INSERT INTO `napredni_trening` VALUES('Incline dumbell press', 'Barbell row', 'odmor', 'Incline dumbell press', 'Barbell row', 'odmor', 'odmor');
INSERT INTO `napredni_trening` VALUES('Weighted push ups', 'Deadlift', 'odmor', 'Weighted push ups', 'Deadlift', 'odmor', 'odmor');
INSERT INTO `napredni_trening` VALUES('Incline bench press', 'T-Bar row', 'odmor', 'Incline bench press', 'T-Bar row', 'odmor', 'odmor');
INSERT INTO `napredni_trening` VALUES('Straight bar dips', 'Chin-ups', 'odmor', 'Straight bar dips', 'Chin-ups', 'odmor', 'odmor');
COMMIT;