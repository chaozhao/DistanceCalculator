package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
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

  public static Result showDBpage()
  {

    Form<Geo> filledForm = geoForm.bindFromRequest();

    if(filledForm.hasErrors()) 
    {
      //System.out.println("hasErrors");
      return badRequest(index.render(filledForm));
    } 
    else 
    {
      //System.out.println("no Errors");
      Geo created = filledForm.get();
      return ok(database.render(created));  
    }
  }

  public double calculateDistance(Geo input)
  {
    //TODO calculate Distance


    return 100.0;
  }
  
}
