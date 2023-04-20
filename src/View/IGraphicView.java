package View;

import javax.swing.*;

public interface IGraphicView {

  /**
   * Sets up a list of snapshot IDs that will be used for the select button and head bar.
   */
  void setupIDList();


  /**
   * Creates a "previous" button that displays the previous snapshot when clicked.
   *
   * @return the "previous" button
   */
  JButton createPrevButton();


  /**
   * Creates a "next" button that displays the next snapshot when clicked.
   *
   * @return the "next" button
   */
  JButton createNextButton();


  /**
   * Creates a "select" button that allows the user to select a snapshot from a drop-down menu.
   *
   * @return the "select" button
   */
  JButton selectButton();


  /**
   * Create a 'quit' button to leave the page.
   *
   * @return the "exit" button
   */
  JButton quitButton();


  /**
   * Sets up the menu bar and its buttons for navigating the snapshots.
   */
  void setupMenu();


  /**
   * Sets up the head bar with the ID and description label for each snapshot.
   */
  void setUpHead();


  /**
   * Sets up the canvas for drawing the shapes and initializes it with the first snapshot.
   */
  void setUpCanvas();

}
