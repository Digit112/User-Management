CREATE TABLE IF NOT EXISTS users (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_emails (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT FOREIGN KEY REFERENCES users(id),
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL
);