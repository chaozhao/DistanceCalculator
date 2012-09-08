package controllers;

import java.util.ArrayList;

import java.net.URI;
import java.net.URISyntaxException;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement; 
import java.sql.PreparedStatement;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.DB;
import play.db.jpa.*;
import models.Geo;
import models.*;

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

  private static Connection getConnection() throws URISyntaxException, SQLException 
  {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
  }
  
  public static void createTable()
  {
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
  public  static void insert(double latitude,double longitude)
  {
    Connection connection = DB.getConnection();

    try
    {
      connection = DB.getConnection();  
      
      String insertQuery = "Insert into Coords (longitude,latitude,distance,time_stamp) VALUES ( ?, ? ,? ,?)"; 
      PreparedStatement pstmt = connection.prepareStatement(insertQuery);
      pstmt.setDouble(1, latitude);
      pstmt.setDouble(2, longitude);
      pstmt.setDouble(3, 100000);
      java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
      pstmt.setTimestamp(4, sqlDate);
      
      pstmt.executeUpdate();
    }
    catch(SQLException e)
    {
        System.err.println("Inser query errors: " + e.toString());
        
        try
        {
          connection.close();
        }
        catch(Exception ee)
        {
          ee.printStackTrace();
        }
    }
  }
 
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
      Geo created = filledForm.get();
      return ok(database.render(created));  
    }
  }

  //TODO calculate Distance
  public double calculateDistance(Geo input)
  {
    

    return 0.0;
  }
}
