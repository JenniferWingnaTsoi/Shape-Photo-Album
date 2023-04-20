package Controller;

import java.io.IOException;

import View.Web;

/**
 * Interface for displaying visual elements for screen and web.
 */
public interface IWebGraphicController {

  /**
   * Way to for web controller or graphic controller to display photo album.
   * @param height the height of the canvas/drawing panel
   * @param wid the width of the canvas/drawing panel
   * @throws IOException if there is an error in reading the input
   */
  void exhibit(int height, int wid) throws IOException;
}
