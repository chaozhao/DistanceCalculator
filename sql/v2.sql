CREATE TABLE [ IF NOT EXISTS ] Coords
(
  ID int NOT NULL AUTO_INCREMENT,
  longitude double  NOT NULL,
  latitude   double NOT NULL,
  distance    double  NOT NULL,
  PRIMARY KEY (ID),
  
)

CREATE TABLE [ IF NOT EXISTS ] Time
(
  T_ID int NOT NULL AUTO_INCREMENT,
  time_stamp    timestamp      NOT NULL,
  PRIMARY KEY (T_ID),
)


SELECT Coords.ID, Coords.longitude, Coords.latitude, Coords.distance, Time.time_stamp FROM Coords INNER JOIN Time ON Coords.ID = Time.T_ID