-- CREATE/INSERT USERS
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id NUMBER AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
);

INSERT INTO users (username, password) VALUES
  ('vstamos', '$2a$10$WBEITr/4B/MnBdE4eZ9FOOsBduR6at4WjP8y6tpVP3WQanLxsBAuy');


-- CREATE/INSERT UNITS
DROP TABLE IF EXISTS units;

CREATE TABLE units (
  id NUMBER AUTO_INCREMENT  PRIMARY KEY,
  image VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL,
  region VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  cancellation_policy NUMBER NOT NULL,
  price NUMBER NOT NULL,
  score NUMBER
);

INSERT INTO units (image, title, region, description, cancellation_policy, price ,score) VALUES
  ('photos/Greece/Athens/BlueMoon.png', 'Blue Moon', 'Attica', 'Cozy place', 1, 10000, 4.4),
  ('photos/Greece/Athens/AcropolisView.png', 'Acropolis view', 'Attica', 'Greatest Retire of Kolonaki', 1, 20000, 3.8),
  ('photos/Greece/Mykonos/ParadiseVilla.png', 'Paradise on Earth', 'Aegean', 'Villa close to the beach', 1, 30000, 4.8),
  ('photos/Greece/Santorini/Caldera.png', 'Caldera', 'Aegean', 'The greatest sunset', '0', 35000, 4.7),
  ('photos/Italy/Rome/Colloseo.png', 'Colloseo', 'Aegean', 'Perfect location', '0', 12000, 4),
  ('photos/Italy/Rome/Trastevere.png', 'The Room', 'Aegean', 'Best place in Rome', '1', 12000, 4),
  ('photos/Italy/Florence/Argentina.png', 'Argentina', 'Aegean', 'Third bridge view', '1', 14000, 4),
  ('photos/Spain/Madrid/Center_1.png', 'Spanish apartment', 'Aegean', 'Perfect location', '0', 12000, 4),
  ('photos/Italy/Rome/Colloseo1.png', 'Italian beauty', 'Aegean', 'Colosseo View', '01', 13000, 4),
  ('photos/Italy/Rome/Colloseo2.png', 'Cozy italian place', 'Aegean', 'Cozy place', '0', 14000, 4.3),
  ('photos/Spain/Madrid/Vallecano.png', 'The roof place', 'Aegean', 'The best roof place of Madrid', '1', 18000, 4),
  ('photos/Spain/Barcelona/Gaudi_Place.png', 'Influence of Gaudi', 'Aegean', 'The place is inspired by Gaudi', '1', 20000, 4),
  ('photos/Spain/Barcelona/SF.png', 'Sagrada Familia', 'Aegean', 'The best of view of Barcelona', '1', 22000, 4.8),
  ('photos/Spain/Barcelona/The_Catalanian.png', 'Catalunya', 'Aegean', 'Traditional place', '0', 17000, 3.2),
  ('photos/Switzerland/Zurich/The_Student.png', 'The Student - Cozy place', 'Central Europe', 'Small aparatment close to ETH', '1', 30000, 4),
  ('photos/USA/Ney_York/Downtown.png', 'NY style', 'N.America', 'NY center but quiet', '1', 32000, 4),
  ('photos/USA/Ney_York/Liberty.png', 'Liberty Place', 'N.America', 'Statue of Liberty View', '0',28000, 4),
  ('photos/USA/Ney_York/Downtown_2.png', 'NY style 2', 'N.America', 'NY center but quiet', '0',29000, 4),
  ('photos/Greece/Athens/Mets.png', 'Mets place', 'Aegean', 'Apartment close to Kalimarmaro', '1', 15000, 4),
  ('photos/Greece/Athens/Marousi.png', 'Gardenhouse', 'Aegean', 'Home with beautiful garden', '0', 17000, 4),
  ('photos/Greece/Athens/Halandri.png', 'The roof', 'Aegean', 'Great roof placed on Halandri', '1', 18000, 4),
  ('photos/Greece/Athens/Kifisia.png', 'Villa', 'Aegean', 'Beautiful villa', '1', 16000, 4);


-- CREATE/INSERT REVIEWS
DROP TABLE IF EXISTS reviews;

 CREATE TABLE reviews (
 id NUMBER AUTO_INCREMENT  PRIMARY KEY,
 comment VARCHAR(250),
 score NUMBER NOT NULL,
 units_id NUMBER,

 foreign key (units_id) references units(id)
 );

INSERT INTO reviews (id, comment, score, units_id) VALUES
(900, 'Great Place, I will visit it again!', 4, 2 ),
(901,'Great Place, I will visit it again!', 4, 1 ),
(902,'What a view!', 4, 2),
(903,'Metro was 5 minutes ago, the best location', 4, 3),
(904,'Hope I could live there forever',5,4);
