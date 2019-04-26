INSERT INTO books(title,author) VALUES('title', 'author'),('Harry Potter i Komnata Tajemnic', 'J.K. Rowling'),
( 'To Kill a Mockingbird', 'Harper Lee'), ( 'Brave New World', 'Aldous Huxley');
INSERT INTO users(id, name, first_name, last_name, city, country) VALUES(NULL, 'AegonTargaryen', 'John', NULL, NULL, NULL),
(NULL, 'Jack', NULL,NULL, 'London',NULL);
INSERT INTO user_books(id, user_id, book_id, count) VALUES(NULL, 1,1,2), (NULL, 1,2,0), (NULL,2,2,1);
