package models;

import java.util.*;
import javax.validation.*;
import play.data.validation.Constraints.*;

public class Geo
  {
  	@Required
    public String longitute;
    @Required
    public String latitute;
    
    public Geo()
    {

    }

    public Geo(String longitude,String latitute)
    {
    	this.longitute = longitute;
    	this.latitute = latitute;
    	//this.length = length;
    }
  }