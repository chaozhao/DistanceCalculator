package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;


public class Geo extends Model
  {
  	
    public String longitute;
    public String latitute;
    
    public Geo()
    {

    }

    public Geo(String longitude,String latitute)
    {
    	this.longitute = longitute;
    	this.latitute = latitute;
    }
  }