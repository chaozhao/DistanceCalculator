package controllers;

import java.util.*;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;

public class Application extends Controller {
  
  public static Result index() 
  {
    return ok(
    	index.render(
    		"HIT3311 Assignment 1",90
    	)
    );
  }
  
}