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

// 
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
/**
 * 
 *
 * This class models a droppable object designed for the cs300 spring 2022 p05 Treasure Hunt
 * adventure style game application.
 *
 */

public class DroppableObject extends DraggableObject {
  private InteractiveObject target;

  /**

   * Creates a new Droppable object with specific name, x and y positions, message, target, and sets

   * its next clue.

   * 

   * @param name     - name of Droppable object

   * @param x        - position (x-coordinate)

   * @param y        - position (y-coordinate)

   * @param message  - message corresponding to object's field

   * @param target   - target/winning location

   * @param nextClue - preceding clue

   */

  public DroppableObject(String name, int x, int y, String message, InteractiveObject target,

      InteractiveObject nextClue) {

    super(name, x, y, message);

    this.target = target;

    this.setNextClue(nextClue);

  }



  /**

   * Checks whether this object is over another interactive object.

   * 

   * @param other - reference to another iteractive object. We assume that other is NOT null.

   * @return reference to another iteractive object. We assume that other is NOT null.

   */

  public boolean isOver(InteractiveObject other) {

    return ((this.getX() + this.image.width > other.getX())

        && (this.getX() < other.getX() + other.image.width)

        && (this.getY() + this.image.height > other.getY())

        && (this.getY() < other.getY() + other.image.height));

  }



  /**

   * Stops dragging this droppable object. Also, if this droppable object is over its target and the

   * target is activated, this method (1) deactivates both this object and its target, (2) activates

   * the next clue, and (3) prints the message of this draggable object to the console.

   */

  @Override

  public void mouseReleased() {

    this.stopDragging();



    if (this.isOver(this.target) && this.target.isActive()) {

      this.target.deactivate();

      this.deactivate();

      this.activateNextClue();

      System.out.println(this.message());

    }



  }

}