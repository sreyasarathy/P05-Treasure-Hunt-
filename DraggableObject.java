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

import java.io.File;



/**
 * 
 * 
 * 
 * This class models a draggable object. A draggable object is a clickable interactive object which
 * 
 * can follow the mouse moves when being dragged.
 *
 * 
 * 
 */

public class DraggableObject extends InteractiveObject {

  // indicates whether this object is being dragged or not

  private boolean isDragging;



  // old x-position of the mouse

  private int oldMouseX;



  // old y-position of the mouse

  private int oldMouseY;



  /**
   * 
   * Creates a new Draggable object with a given name, x and y position, and "Drag Me!" as a default
   * 
   * message.
   * 
   * 
   * 
   * @param name - name of object
   * 
   * @param x    - position (x-coordinate)
   * 
   * @param y    - position (y-coordinate)
   * 
   */

  DraggableObject(String name, int x, int y) {

    super(name, x, y, "Drag Me");

    this.isDragging = false;

  }



  /**
   * 
   * Creates a new Draggable object with a given name, x and y position, and a specific message.
   * 
   * 
   * 
   * @param name    - name of object
   * 
   * @param x       - position (x-coordinate)
   * 
   * @param y       - position (y-coordinate)
   * 
   * @param message - message corresponding to object's field
   * 
   */

  DraggableObject(String name, int x, int y, String message) {

    super(name, x, y, message);

    this.isDragging = false;

  }



  /**
   * 
   * Draws this draggable object to the display window. If this object is dragging, this method sets
   * 
   * its position to follow the mouse moves. Then, it draws its image to the its current position.
   * 
   */

  @Override

  public void draw() {

    if (this.isDragging()) {

      this.move(processing.mouseX - this.getX(), processing.mouseY - this.getY());

    }

    processing.image(this.image, this.getX(), this.getY());

  }



  /**
   * 
   * Checks whether this draggable object is being dragged.
   * 
   * 
   * 
   * @return true if this object is being dragged, false otherwise
   * 
   */

  public boolean isDragging() {

    if (this.isDragging)

      return true;



    return false;

  }



  /**
   * 
   * Starts dragging this object when it is clicked (meaning when the mouse is over it)
   * 
   */

  @Override

  public void mousePressed() {

    if (this.isMouseOver()) {

      this.startDragging();

    }

  }



  /**
   * 
   * Stops dragging this object if the mouse is released
   * 
   */

  @Override

  public void mouseReleased() {

    if (this.isMouseOver() == false) {

      this.stopDragging();

    }

  }



  /**
   * 
   * Starts dragging this draggable object and updates the oldMouseX and oldMouseY positions to the
   * 
   * current position of the mouse.
   * 
   */

  public void startDragging() {

    this.isDragging = true;



    this.oldMouseX = processing.mouseX;

    this.oldMouseY = processing.mouseY;

  }



  /**
   * 
   * Stops dragging this draggable object
   * 
   */

  public void stopDragging() {

    this.isDragging = false;

  }



}
