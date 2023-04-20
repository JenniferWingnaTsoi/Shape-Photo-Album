import org.junit.Test;

import java.io.FileReader;
import java.util.List;

import Controller.ModelController;
import Controller.WebController;
import Model.IShapeModel;

import static org.junit.Assert.*;

/**
 * This is the test file of Webview
 */
public class WebTest {
  private WebController webController;
  private List<String> IDList;

  @org.junit.Before
  public void setUp() throws Exception {
    Readable inputFile = new FileReader("demo_input.txt");
    IShapeModel model = ReadFile.readFile(inputFile, new ModelController() {
    });
    webController = new WebController("test.html", model);
    webController.exhibit(1000,1000);
    IDList = webController.getWebview().getIDList();
  }

  /**
   * Test for all the commands/ implementation of ShapeModel.
   */
  @Test
  public void testAll(){
    String actual ="<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\" style=\"border:" +
            " solid 2px red; background-color:rgb(173,216,230)\"" +
            " xmlns=\"http://www.w3.org/2000/svg\"><g>\n" +
            "<rect id=\"myrect\" x=\"200.00\" y=\"200.00\" width=\"50.00\" height=\"100.00\"" +
            " fill=\"rgb(255.000000,0.000000,0.000000)\" visibility=\"visible\"/>\n" +
            "<ellipse id=\"myoval\" cx=\"500.00\" cy=\"100.00\" rx=\"60.00\" ry=\"30.00\"" +
            " fill=\"rgb(0.000000,255.000000,1.000000)\" visibility=\"visible\"/>\n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" +
            IDList.get(0)+ "</text>\n" +
            "<text x=\"10\" y=\"65\" font-size=\"20\">Description: After first selfie</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\" style=\"border: solid 2px red;" +
            " background-color:rgb(173,216,230)\" xmlns=\"http://www.w3.org/2000/svg\"><g>\n" +
            "<rect id=\"myrect\" x=\"100.00\" y=\"300.00\" width=\"25.00\" height=\"100.00\"" +
            " fill=\"rgb(255.000000,0.000000,0.000000)\" visibility=\"visible\"/>\n" +
            "<ellipse id=\"myoval\" cx=\"500.00\" cy=\"100.00\" rx=\"60.00\" ry=\"30.00\" fill=\"" +
            "rgb(0.000000,255.000000,1.000000)\" visibility=\"visible\"/>\n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" +
            IDList.get(1)+"</text>\n" +
            "<text x=\"10\" y=\"65\" font-size=\"20\">Description: 2nd selfie</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\" style=\"border: solid 2px red;" +
            " background-color:rgb(173,216,230)\" xmlns=\"http://www.w3.org/2000/svg\"><g>\n" +
            "<rect id=\"myrect\" x=\"100.00\" y=\"300.00\" width=\"25.00\" height=\"100.00\"" +
            " fill=\"rgb(0.000000,0.000000,255.000000)\" visibility=\"visible\"/>\n" +
            "<ellipse id=\"myoval\" cx=\"500.00\" cy=\"400.00\" rx=\"60.00\" ry=\"30.00\"" +
            " fill=\"rgb(0.000000,255.000000,1.000000)\" visibility=\"visible\"/>\n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" +
            IDList.get(2)+"</text>\n" +
            "<text x=\"10\" y=\"65\" font-size=\"20\">Description: </text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\" style=\"border: solid 2px red;" +
            " background-color:rgb(173,216,230)\" xmlns=\"http://www.w3.org/2000/svg\"><g>\n" +
            "<ellipse id=\"myoval\" cx=\"500.00\" cy=\"400.00\" rx=\"60.00\" ry=\"30.00\"" +
            " fill=\"rgb(0.000000,255.000000,1.000000)\" visibility=\"visible\"/>\n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" +
            IDList.get(3)+"</text>\n" +
            "<text x=\"10\" y=\"65\" font-size=\"20\">" +
            "Description: Selfie after removing the rectangle from the picture</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "</body>\n" +
            "</html>";
    String expected = webController.getWebview().getResult();
    assertEquals(actual,expected);
  }
}