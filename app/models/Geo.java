package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.*;
import models.*;
import com.avaje.ebean.*;

@Entity
public class Geo// extends Models 
  {
    
  	@Required
    public Double longitude;
    @Required
    public Double latitude;
    public Double distance;
    public int timestamp;

    public Geo()
    {

    }

    public Geo(Double longitude,Double latitude)
    {
    	this.longitude = longitude;
    	this.latitude = latitude;
    }

    public Geo(Double longitude,
                Double latitude,
                Double distance,
                int timestamp)
    {
      this.longitude = longitude;
      this.latitude = latitude;
      this.distance = distance;
      this.timestamp = timestamp;
    }
}