package View;

import java.io.IOException;
import java.util.List;

import Model.Snapshot;

/**
 * This is the interface of View which display the web view.
 */
public interface IWebView {

  /**
   * Create a photo album by reading each Snapshot.
   * Append the content for creating an HTML file later on
   */
  void merge();

  /**
   * Returnt a list of ID of snapshot
   * @return a list of string
   */
  List<String> getIDList();

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
