CREATE TABLE [ IF NOT EXISTS ] Coords
(
  longitude double  NOT NULL,
  latitude   double NOT NULL,
  distance    double  NOT NULL,
  time_stamp    timestamp      NOT NULL,
  CONSTRAINT PRIMARY KEY (time_stamp),
)