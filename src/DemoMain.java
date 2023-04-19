import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Controller.ModelController;
import Model.IShapeModel;
import Model.ShapeModel;
import View.Graphic;
import View.Web;

public class DemoMain {

  public static void main(String[] args) throws IOException {
    File file = new File("C:\\Users\\jenni\\Documents\\23spring\\5004\\hw_ans\\CS5004Object-Oriented-Design\\homework9\\buildings.txt");
    IShapeModel model = new ShapeModel();
    try{
      model = ReadFile.readFile(new BufferedReader(new FileReader(file)),new ModelController());

    } catch (FileNotFoundException e){
      e.printStackTrace();
    }

    Graphic GUI = new Graphic(model,1000,1000);
    GUI.display();

    Web webview = new Web(1000,1000,model);
    webview.display();
    webview.writeFile("demo.html");

  }
}
