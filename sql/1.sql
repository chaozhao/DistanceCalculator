CREATE TABLE IF NOT EXISTS Coords
(
  longitude decimal  NOT NULL,
  latitude   decimal NOT NULL,
  distance    decimal  NOT NULL,
  time_stamp  timestamp NOT NULL,
  CONSTRAINT PRIMARY KEY (time_stamp)
  );



INSERT INTO Coords VALUES (0, 7, 1, current_timestamp);
INSERT INTO Coords VALUES (0, 6, 2, current_timestamp);
INSERT INTO Coords VALUES (0, 5, 3, current_timestamp);
INSERT INTO Coords VALUES (0, 4, 4, current_timestamp);
INSERT INTO Coords VALUES (0, 3, 5, current_timestamp);
INSERT INTO Coords VALUES (0, 2, 6, current_timestamp);
INSERT INTO Coords VALUES (0, 1, 7, current_timestamp);

