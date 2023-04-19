package Controller;

import java.io.IOException;

import Model.IShapeModel;
import View.Web;

public class WebController implements IWebGraphicController{
  private String outputPath;
  private IShapeModel model;
  private Web webview;

  public WebController(String outputPath, IShapeModel model){
    this.model = model;
    this.outputPath = outputPath;
  }
  @Override
  public void exhibit(int height, int wid){
    webview = new Web(height,wid,model);
    webview.display();
    try{
      webview.writeFile(outputPath);
    } catch (IOException e){
      e.printStackTrace();
    }
  }
}
