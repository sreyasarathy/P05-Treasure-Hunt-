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

import processing.core.PImage;

import processing.core.PApplet;

import java.util.ArrayList;

import java.util.NoSuchElementException;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;



/**

 * 

 * This class models a clickable interactive object used in cs300 Spring 2022 p05 Treasure Hunt

 * application.

 *

 */

public class InteractiveObject implements Clickable // is-a relationship

{

  // reference to the PApplet where this object will be drawn

  protected static TreasureHunt processing;



  // name of this interactive object

  private final String NAME;



  // reference to the image of this object

  protected PImage image;



  // x-position of this interactive object in the screen

  private int x;



  // y-position of this interactive object in the screen

  private int y;



  // tells us whether or not this object is clicked

  private boolean isActive;



  // tells whether or not this object is active

  private boolean wasClicked;



  // message to be displayed when this object is clicked

  private String message;



  // message to be displayed when this object is clicked

  private InteractiveObject nextClue;





  @Override

  public void draw() {

    // TODO Auto-generated method stub

    // processing.set(x, y, image);

    // this.processing.set(x, y, this.image);

    processing.image(this.image, this.x, this.y);

  }



  @Override

  public void mousePressed() {

    if (isMouseOver()) {

      System.out.println(message());



      if (this.wasClicked == false && (nextClue != null)) {

        this.wasClicked = true;

        activateNextClue();

      }

    }

  }



  @Override

  public void mouseReleased() {

    // TODO Auto-generated method stub



  }



  @Override

  public boolean isMouseOver() {

    // TODO Auto-generated method stub

    if (processing.mouseX <= this.getX() + image.width && processing.mouseX >= this.getX()

        && processing.mouseY <= this.getY() + image.height && processing.mouseY >= this.getY()) {

      return true;

    }

    return false;

  }



  /**

   * Creates a new interactive object with no next clue (nextClue == null) and sets its image, name,

   * x and y positions, its message, and activation status.

   * 

   * @param name    - name of Interactive Object

   * @param x       - position (x-coordinate)

   * @param y       - position (y-coordinate)

   * @param message - message corresponding to object's field

   */

  public InteractiveObject(String name, int x, int y, String message) {

    this.message = message;

    this.isActive = true;

    this.wasClicked = false;

    this.NAME = name;

    this.nextClue = null;

    this.x = x;

    this.y = y;

    this.image = processing.loadImage("images" + File.separator + name + ".png");



  }



  /**

   * 

   * @param name     - name of Interactive Object

   * @param x        - position (x-coordinate)

   * @param y        - position (y-coordinate)

   * @param message  - message corresponding to object's field

   * @param nextClue - preceding clue

   */

  public InteractiveObject(String name, int x, int y, String message, InteractiveObject nextClue) {

    this(name, x, y, message);



    this.isActive = true;

    this.wasClicked = false;



    this.nextClue = nextClue;

    this.image = processing.loadImage("images" + File.separator + name + ".png");

    this.nextClue.deactivate();



  }



  /**

   * Sets the PApplet object of the treasure hunt application where all the interactive objects will

   * be drawn. Note that a graphic application has ONLY one display window of type PApplet where all

   * graphic objects interact. In p05, the TreasureHunt class is of type PApplet.

   * 

   * @param processing - represents the reference to the TreasureHunt PApplet object where all the

   *                   interactive objects will be drawn.

   */

  public static void setProcessing(TreasureHunt processing) {

    InteractiveObject.processing = processing;

  }



  /**

   * Gets the x-position of this interactive object

   * 

   * @return the x-position of this interactive object

   */

  public int getX() {

    return this.x;

  }



  /**

   * Gets the y-position of this interactive object

   * 

   * @return the y-position of this interactive object

   */

  public int getY() {

    return this.y;

  }



  /**

   * Moves the current x and y positions of this interactive object with dx and dy, respectively

   * 

   * @param dx - move to be added to the x position of this interactive object

   * @param dy - move to be added to the y position of this interactive object

   */

  public void move(int dx, int dy) {

    this.x += dx;

    this.y += dy;

  }



  /**

   * Checks whether the name of this interactive object equals to the name passed as input

   * parameter. We consider a case-sensitive comparison.

   * 

   * @param name - name to compare to

   * @return - true if the name of this interactive object equals the provided name, false

   *         otherwise.

   */

  public boolean hasName(String name) {

    if (this.NAME.equals(name)) {

      return true;

    }

    return false;

  }



  /**

   * Checks whether this interactive object is active. This should be a getter of the isActive data

   * field.

   * 

   * @return true if this interactive object is active and false otherwise.

   */

  public boolean isActive() {

    if (this.isActive)

      return true;

    return false;

  }



  /**

   * Activates this interactive object, meaning setting its isActive data field to true.

   */

  public void activate() {

    this.isActive = true;

  }



  /**

   * Deactivates this interactive object, meaning setting its isActive data field to false.

   */

  public void deactivate() {

    this.isActive = false;

  }



  /**

   * Gets the message of this interactive object.

   * 

   * @return the message to be displayed each time this interactive object is clicked.

   */

  public String message() {

    return this.message;

  }



  /**

   * Sets the next clue associated to this interactive object

   * 

   * @param nextClue - the next clue to be assigned to this interactive object

   */

  public void setNextClue(InteractiveObject nextClue) {

    this.nextClue = nextClue;

  }



  /**

   * Activates the next clue of this interactive object and adds it to the treasure hunt application

   * 

   * @throws NoSuchElementException - with a descriptive error message if the nextClue of this

   *                                interactive object is null

   */

  protected void activateNextClue() throws NoSuchElementException {

    if (this.nextClue == null) {

      throw new NoSuchElementException("The next clue is null");

    }

    this.nextClue.isActive = true;

    processing.add(this.nextClue);

  }



}