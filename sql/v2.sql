CREATE TABLE Coords
(
  ID INTEGER NOT NULL AUTO_INCREMENT,
  longitude double  NOT NULL,
  latitude   double NOT NULL,
  distance    double  NOT NULL,
  PRIMARY KEY (ID)  
);




CREATE TABLE Time_table
(
  T_ID INTEGER NOT NULL AUTO_INCREMENT,
  time_stamp TIMESTAMP NOT NULL,
  PRIMARY KEY (T_ID)
);





INSERT INTO Coords (longitude, latitude, distance)
VALUES ($long, $lat, $dist);

INSERT INTO Time_table (time_stamp)
values (CURRENT_TIMESTAMP);

SELECT Coords.ID, Coords.longitude, Coords.latitude, Coords.distance, Time_table.time_stamp FROM Coords INNER JOIN Time_table ON Coords.ID = Time_table.T_ID;