INSERT INTO books(title,author) VALUES('title', 'author'),('Harry Potter i Komnata Tajemnic', 'J.K. Rowling'),
( 'To Kill a Mockingbird', 'Harper Lee'), ( 'Brave New World', 'Aldous Huxley');
INSERT INTO users(id, name, password, first_name, last_name, city, country) VALUES(NULL, 'Jonas', '$2a$10$uFouhr392epnO2YkfQ8f1uUNZmmXq04riDpdDN2bC4zOq34FA60YO', 'John', NULL, NULL, NULL),
(NULL, 'Jack','$2a$10$uFouhr392epnO2YkfQ8f1uUNZmmXq04riDpdDN2bC4zOq34FA60YO', NULL,NULL, 'London',NULL);
INSERT INTO user_books(id, user_id, book_id, count) VALUES(NULL, 1,1,2), (NULL, 1,2,0), (NULL,2,2,1);
