//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Course: CS 300 Spring 2022
//
// Author: Ishan Rungta
// Email: imrungta@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION /////////////////// 
// Author: Sreya Sarathy 
// Email: Sarathy2@wisc.edu 
// Lecturer: Prof Mouna Kacem 
// 
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**

 * 

 * This interface is responsible for managing the user's mouse movements

 */

public interface Clickable {

  public void draw(); // draws this Clickable object to the screen



  public void mousePressed(); // defines the behavior of this Clickable object

  // each time the mouse is pressed



  public void mouseReleased(); // defines the behavior of this Clickable object

  // each time the mouse is released



  public boolean isMouseOver(); // returns true if the mouse is over this clickable object



}