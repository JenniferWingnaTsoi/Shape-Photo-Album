package View;

import java.io.IOException;

import Model.Snapshot;

/**
 * This is the interface of View which display the web and graphic view.
 */
public interface IWebView {

  /**
   * Create a photo album by reading each Snapshot.
   * Append the content for creating an HTML file later on
   */
  void merge();


  /**
   * Return the contents written on html file.
   * @return a string
   */
  String getResult();

  /**
   * Method to generate an SVG for the web view of photo album.
   *
   * @param snapshot a Snapshot object
   */
  void generateSVG(Snapshot snapshot);


  /**
   * Saves the current SVG drawing to a file at the given file path.
   *
   * @param path the file path where the SVG file will be saved
   * @throws IOException if there is an error while writing to the file
   */
  void writeFile(String path) throws IOException;
}
