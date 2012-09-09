package controllers;

import java.util.ArrayList;
import java.util.Properties;

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
    createTable();
    return ok(index.render(geoForm));
  }
  public static void closeConnection(Connection connection)
  {
    try 
    {   
        connection.close();  
    } 
    catch (Exception e) 
    {  
        e.printStackTrace();  
    }  

  }

  private static Connection getConnection() throws URISyntaxException,SQLException,ClassNotFoundException
  {
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://ec2-107-22-164-195.compute-1.amazonaws.com:5432/d2dasu4ca5veii?user=nisdlcmvfylcjx&password=pjgTyHBzZ0ntb_VgC1teNadeFw&ssl=true"; 
      Connection conn = DriverManager.getConnection(url);
      return conn;
  }
  
  public static void createTable()
  {
     String tableCreate  = "CREATE TABLE IF NOT EXISTS Coords ("+
                          "longitude decimal  NOT NULL,"+
                          "latitude   decimal NOT NULL,"+
                          "distance    decimal  NOT NULL,"+
                          "time_stamp  timestamp PRIMARY KEY);";

    ResultSet resultSet = null;  
    Statement statement = null;  
    Connection connection = null;

    try
    {
      connection = getConnection();  
      if (connection != null)
      {
        System.out.println("connection successful");
      }
      else
      {
        System.out.println("Unsuccessful. Try again");      
      }  
      statement = connection.createStatement();
      statement.executeUpdate(tableCreate);  
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
    catch(SQLException eSQL)
    {
      System.out.println(eSQL.getMessage());
        //eSQL.printStackTrace();
    }
    catch(URISyntaxException eUR)
    {
          eUR.printStackTrace();
    }
    catch(ClassNotFoundException eClass)
    {
          eClass.printStackTrace();
    } 
    
  }
  public  static void insert(double latitude,double longitude)
  {
    Connection connection = null;

    try
    {
      connection = getConnection();  
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
        System.err.println("Insert query errors: " + e.toString());
    }
    catch(URISyntaxException eURL)
    {

    }
    catch(ClassNotFoundException eClass)
    {

    } 
  }
  
  public static ResultSet selectAll()
  {
    ResultSet result = null;
    Statement statement = null;
    Connection connection = null;
    
    try
    {
      connection = getConnection();  
      String sql = "select * from Coords";
      statement = connection.createStatement();
      result = statement.executeQuery(sql);
    }
    catch(SQLException e)
    {
        System.err.println("Error creating or running statement: " + e.toString());
    }
    catch(URISyntaxException eURL)
    {

    }
    catch(ClassNotFoundException eClass)
    {

    } 

    return result;
  }

  public static Result showDBpage()
  {
    createTable();
    //insert(20.0,111);
    //ResultSet res = selectAll();

    
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
