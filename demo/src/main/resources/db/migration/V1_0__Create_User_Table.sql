CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    userpassword VARCHAR(255) NOT NULL,
    zipcode VARCHAR(255) DEFAULT NULL,
    peopleinhouse INT DEFAULT NULL,
    heating BOOL DEFAULT NULL,
    electricity BOOL DEFAULT NULL,
    car VARCHAR(255) DEFAULT NULL,
    kilometers INT DEFAULT NULL,
    holidaycar INT DEFAULT NULL,
    holidayplane INT DEFAULT NULL,
    holidaytrain INT DEFAULT NULL,
    food VARCHAR(255) DEFAULT NULL,
    pvsystem BOOL DEFAULT NULL,
    recyclingglass BOOL DEFAULT NULL,
    recyclingplastic BOOL DEFAULT NULL,
    recyclingpaper BOOL DEFAULT NULL,
    recyclingmetal BOOL DEFAULT NULL,
    recyclingfoodwaste BOOL DEFAULT NULL,
    washing VARCHAR(255) DEFAULT NULL,
    footprint INT DEFAULT NULL,
    userscore INT DEFAULT NULL,
    UNIQUE (username)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS carbonfootprints (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    footprint INT NOT NULL
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS challenges (
    id INT AUTO_INCREMENT PRIMARY KEY,
    challenge MEDIUMTEXT NOT NULL,
    category VARCHAR(255) NOT NULL,
    score INT NOT NULL
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS recommondations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    recommondation MEDIUMTEXT NOT NULL,
    basedon VARCHAR(255) DEFAULT NULL,
    zipcode VARCHAR(255) DEFAULT NULL
) ENGINE=INNODB;

