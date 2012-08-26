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
    //Form<Geo> filledForm = geoForm.bindFormRequest();

  	//Geo loc = filledForm.get();
    //return ok(database.render(loc));
    /*
    
    Form<Geo> filledForm = geoForm.bindFormRequest();

    if(filledForm.hasErrors()) 
    {
            return badRequest(index.render(filledForm));
    } 
    else 
    {
            Geo created = filledForm.get();
            return ok(summary.render(created));
    }*/
    return TODO;
  }
  
}
