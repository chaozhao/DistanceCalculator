CREATE TABLE IF NOT EXISTS Coords
(
  longitude decimal  NOT NULL,
  latitude   decimal NOT NULL,
  distance    decimal  NOT NULL,
  time_stamp  timestamp NOT NULL,
  CONSTRAINT PRIMARY KEY (time_stamp)
  );