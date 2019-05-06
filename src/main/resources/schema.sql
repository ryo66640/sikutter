CREATE TABLE IF NOT EXISTS messages(
	id			INTEGER PRIMARY KEY AUTO_INCREMENT,
	text		VARCHAR(200) NOT NULL,
	talker		VARCHAR(200) NOT NULL	
);

CREATE TABLE IF NOT EXISTS users(
	id			INTEGER PRIMARY KEY AUTO_INCREMENT,
	username	VARCHAR(255) NOT NULL UNIQUE,
	password	VARCHAR(255) NOT NULL,
	admin		BOOLEAN NOT NULL
);