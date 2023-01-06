//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Course: CS 300 Spring 2022
//
// Author: Ishan Rungta
// Email: imrungta@wisc.edu
// Lecturer: Mouna Kacem

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

import processing.core.PApplet;

import processing.core.PImage;

import java.util.ArrayList;

import java.util.NoSuchElementException;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;



/**
 * 
 * 
 * 
 * Defines the behavior of this button when the mouse is pressed.
 *
 * 
 * 
 */

public class RestartGameButton extends Button {



  /**
   * 
   * Creates a new RestartGameButton object labeled "Restart Game" at a specific position on the
   * 
   * screen
   * 
   * 
   * 
   * @param x - position (x-coordinate)
   * 
   * @param y - position (y-coordinate)
   * 
   */

  public RestartGameButton(int x, int y) {

    super("Restart Game", x, y);

  }



  /**
   * 
   * Defines the behavior of this button when the mouse is pressed.
   * 
   */

  public void mousePressed() {

    if (this.isMouseOver()) {

      ((TreasureHunt) Button.processing).initGame();

    }

  }



}
