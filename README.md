# Shape Photo Album
This project aims to implement a photo album application using the Model-View-Controller (MVC) structure.

## Design pattern
Model-View-Controller (MVC): The project follows the MVC architectural pattern, which helps in organizing the code into separate components responsible for data management, user interface, and control flow.

## Function and Usage
  - Add shapes
  - Edit location of shapes by changing coordinates
  - Change size and color of shapes
  - Take selfies
  - Get a list of snapshots
  - Remove shapes
  - Reset the album

## Usage
  1. Navigate to /src directory
  2. Open PhotoAlbumMain.java file.
  3. There are four available run configurations for the photo album application, which include:
     - PhotoAlbum_Demo_Web: displays the demo_input.txt photo album in a web view.
     - PhotoAlbum_Demo_Graphic: displays the demo_input.txt photo album in a graphical view.
     - PhotoAlbum_Buildings_Web: displays the buildings.txt photo album in a web view.
     - PhotoAlbum_Buildings_Graphic: displays the buildings.txt photo album in a graphical view.
     
     <div align="center">  
       <img width="174" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/0b9cfe32-3922-4237-8126-1deb33d75994">
     </div>


## Output
### Web view
#### building_output.html
<div align="center">
  <img width="433" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/2bf4a1a0-adac-4a09-b643-42af0a79adae">
  <img width="426" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/59a4d974-6b85-4d5c-9f90-4499d05c4382">
  <img width="431" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/c8674df8-06cc-430e-a15d-aaebb05acadd">
</div>

#### demo_output.html
<div align="center">
  <img width="394" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/935d77ba-1b58-49f7-89ea-ad4eb2f2e754">
  <img width="385" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/e3dc2cef-8701-4def-a5fc-9e9bf8ebb1f6">
  <img width="385" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/8a30f965-9534-495e-b842-a8f87ee92fac">
</div>

### Graphic view
#### demo_output
<div align="center">
  <img width="460" alt="1695173887225" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/82cfab75-8b63-4fd8-86d3-a623d362fd25">
  <img width="459" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/c0eeb20b-3b63-4b38-8d4f-c3c46fd8a8d6">
</div>

#### building_output
<div align="center">
  <img width="458" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/9ebf7026-4cd1-407f-9516-e35369357e11">
  <img width="459" alt="image" src="https://github.com/JenniferWingnaTsoi/Shape-Photo-Album/assets/139680820/44bfa9ec-23c7-4f3f-8aca-731d6141fc03">
</div>

## Design components
### Model:
- IShapeModel (IShape Model Interface): Defines methods for managing album data.
- ShapeModel (Shape Model): Implements the IShapeModel interface and manages shape data and operations.
- Snapshot: Represents snapshots of the album's state, including shapes and descriptions.
### Shape:
- IShape (IShape Interface): Defines methods for creating shapes of different types.
- Oval: Implements the IShape interface and represents oval shapes.
- Rectangle: Implements the IShape interface and represents rectangle shapes.
### Controller:
- IModelController (Model Controller Interface): Defines methods for controlling the ShapeModel.
- ModelController (Model Controller): Controller for the Model class and its implementation.
- IWebGraphicController (Web and Graphic View Controller Interface): Used for displaying visual elements for the screen and web.
- GraphicController (Graphic View Controller): Controller for the graphic view class, Graphic, and its implementation.
- WebController (Web View Controller): Controller for the web view class, Web, and its implementation.
### View:
- IWebView (Web View Interface): Used for displaying the web view.
- Web (Web View Class): Responsible for displaying snapshots of shapes and their descriptions in a web interface.
- IGraphicView (Graphic View Interface): Defines implementations for displaying an album in graphical format.
- Graphic (Graphic Class): Responsible for displaying snapshots of shapes and their descriptions in a graphical interface.
- Canvas: Represents a canvas that draws and displays a list of shapes.
- Command-Line Argument Parsing: Command-line arguments are used to specify input, output, view types, and canvas dimensions.

#### File Reading and Writing: 
- Java's file reading and writing capabilities, such as BufferedWriter and FileReader, are used to read input files and generate output files.

#### Exception Handling: 
- Exception handling mechanisms are used to capture and handle potential error scenarios, such as file reading errors and command parsing errors.

#### GUI Components: 
- The project includes graphical user interface (GUI) components, such as buttons and canvases in the graphic view, for user interaction.
 


