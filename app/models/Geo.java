package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import play.data.validation.Constraints.*;


import com.avaje.ebean.*;

public class Geo
  {
    
  	@Required
    public Double longitude;
    @Required
    public Double latitude;
    
    public Geo()
    {

    }

    public Geo(Double longitude,Double latitude)
    {
    	this.longitude = longitude;
    	this.latitude = latitude;
    }
  }