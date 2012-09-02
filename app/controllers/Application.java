package controllers;

import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;

import play.*;
import play.mvc.*;
import play.data.*;
import models.Geo;
import models.*;
import play.db.DB;
import play.db.jpa.*;

import views.html.*;

public class Application extends Controller {

final static Form<Geo> geoForm = form(Geo.class);

/*
 * Display a blank form
 */
  public static Result index() 
  {
    return ok(index.render(geoForm));
  }

  // Let the Play framework help out by modifying your
  // database configuration in the application.conf file
  /*public static ArrayList selectAll()
  {
    ArrayList<Geo> geoList = new ArrayList();
    ResultSet resultset = null;
    //Connection conn = DB.getConnection();
    //conn.createStatement().execute("SELECT * from Coords");

    //EntityManager em = JPA.em();

    //resultset = DB.executeQuery("SELECT * from Coords");
    
    try 
    {
      while(resultset.next())
      {
        geoList.add( 
          new Geo(resultset.getString("longitude"),
                  resultset.getString("latitude"),
                  resultset.getString("distance"),
                  resultset.getString("time_stamp") ));
      }
    }catch (SQLException e)
    {
      e.printStackTrace();
    }
    return geoList;
  }*/


  public static Result showDBpage()
  {

    Form<Geo> filledForm = geoForm.bindFromRequest();

    if(filledForm.hasErrors()) 
    {
      return badRequest(index.render(filledForm));
    } 
    else 
    {
      //ArrayList<Geo> geoList = selectAll();
      Geo created = filledForm.get();
      return ok(database.render(created));  

      //return ok(database.render());
    }
  }

  public double calculateDistance(Geo input)
  {
    //TODO calculate Distance


    return 100.0;
  }
}
