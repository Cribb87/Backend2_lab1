CREATE TABLE user(id INT, name VARCHAR(50), age INT, PRIMARY KEY(id));
CREATE TABLE account(id INT, userId INT, balance DOUBLE, PRIMARY KEY(id), FOREIGN KEY(userId) REFERENCES user(id));