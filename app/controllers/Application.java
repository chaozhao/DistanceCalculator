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

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement; 

public class Application extends Controller {

final static Form<Geo> geoForm = form(Geo.class);

/*
 * Display a blank form
 */
  public static Result index() 
  {
    return ok(index.render(geoForm));
  }

  public static void createTable()
  {
      System.out.println("try to create a tabel;");
      Connection connection = DB.getConnection();
      
     
      String table  = "CREATE TABLE IF NOT EXISTS Coords ("+
                              "longitude decimal  NOT NULL,"+
                              "latitude   decimal NOT NULL,"+
                              "distance    decimal  NOT NULL,"+
                              "time_stamp  timestamp PRIMARY KEY)";

      ResultSet resultSet = null;  
      Statement statement = null;  

        if (connection != null)
        {
          System.out.println("connection successful");
        }
        else{
          System.out.println("Unsuccessful. Try again");      
        }
    
    try
      {
        statement = connection.createStatement();
        statement.executeUpdate(table);  
        
        if(statement != null)
        {
          statement.close();
          System.out.println("executed query");
        }
        else
        {
          System.out.println("not executed query");
        }
    }
      catch (SQLException e) {
        e.printStackTrace();
    }

    try 
    {   
        connection.close();  
    } 
    catch (Exception e) 
    {  
        e.printStackTrace();  
    }  

  }
  public  static void insert()
  {
    
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
  
  public static ResultSet selectAll()
  {
    ResultSet result = null;
    Statement statement = null;
    Connection connection = null;
     
    try
    {
      connection = DB.getConnection();  
      String sql = "select * from Coords";
      statement = connection.createStatement();
      result = statement.executeQuery(sql);
    }
    catch(SQLException e)
    {
        System.err.println("Error creating or running statement: " + e.toString());
        try
        {
          connection.close();
        }
        catch(Exception ee)
        {
          ee.printStackTrace();
        }
    }
    return result;
  }



  public static Result showDBpage()
  {
    createTable();
    ResultSet res = selectAll();
    try
    {
        while (res.next()) 
        {  
            System.out.println("time_stamp:"  + res.getString("time_stamp"));  
        }
    }
    catch (Exception e) 
    {  
        e.printStackTrace();  
    }


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
