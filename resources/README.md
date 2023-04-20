## Homework 9 - The photo album in MVC structure

### Overview
- This project aims to implement a photo album application using the Model-View-Controller (MVC) structure.
- The application provides various functions to the user, including adding shapes, moving coordinates, changing size and color of shapes, taking selfies, getting a list of snapshots, removing shapes, resetting the album, and exiting the application.

### Design
#### Model
- The Model package is responsible for managing the application's data and logic. It works in conjunction with the View and Controller to provide efficient management of the application's components.
- This package mainly contains the shapeModel that implements various action on the photo album, such as add shapes, resize, remove etc.
- Files includes:
  1. IShapeModel: An interface that defines the methods that will be implemented in the ShapeModel class to carry out the functions of the photo album application.
  2. ShapeModel: A concrete class that implements IShapeModel, manages the collection of IShape objects and provides methods to modify and access the shapes.
  3. Snapshot: A concrete class represents a snapshot of the current state of the drawing canvas, including the shapes on the canvas and a unique identifier and description.

#### Shape
- The Shape package is responsible for creating shapes so that the ShapeModel can interact with.
- Files includes:
  1. IShape: An interface that tells the implementation of creating a shape.
  2. Oval: A concrete class that defines methods for getting and setting oval's properties.
  3. Rectangle: A concrete class that defines methods for getting and setting rectangle's properties.

#### Controller
- The Controller package is responsible for controlling the major implementation and display of photo album.
- It acts as the main controller of the photo album, allowing the user to interact with the album (i.e. the ShapeModel) and receive corresponding outputs by providing in a way of web view or graphic view.
- Files includes:
  1. IModelController: An interface defines the method for controlling the ShapeModel.
  2. ModelController: A controller for Model class and its implementation.
  3. IWebGraphicController: An interface for displaying visual elements for screen and web.
  4. GraphicController: A controller for one of the view class, Graphic class and its implementation.
  5. WebController: A controller for one of the view class, Web class and its implementation.

#### View
- The View package is mainly responsible for rendering the user interface for displaying the photos in form of graphic or web.
- Files includes:
  1. IWebView: An interface of View which display the web view.
  2. Web: Web class is responsible for displaying the snapshots of shapes and their descriptions in a web interface. It is controller by the WebController.
  3. IGraphicView: An interface that defines the implementation of displaying a photo album in a graphical format.
  4. Graphic: The Graphic class is responsible for displaying the snapshots of shapes and their descriptions in a graphical interface. It is controller by the graphicController.
  5. Canvas: This class represents a canvas that draws and displays a list of shapes. Mainly tell the system how to draw the shapes.

- Overall, this project demonstrates an efficient implementation of an MVC structure in creating a photo album application. The design allows for organized management of data and logic, providing a user-friendly experience for interacting with the photo album.

### Usage
- There are four available run configurations for the photo album application, which include:
  1. PhotoAlbum_Demo_Web: displays the demo_input.txt photo album in a web view.
  2. PhotoAlbum_Demo_Graphic: displays the demo_input.txt photo album in a graphical view.
  3. PhotoAlbum_Buildings_Web: displays the buildings.txt photo album in a web view.
  4. PhotoAlbum_Buildings_Graphic: displays the buildings.txt photo album in a graphical view.
- You are encouraged to run the file and see firsthand how the photo albums are presented.

### Amendment
1. For convenience, I create a new class object named snapshot instead of using instance variables like descriptionList and shapeList to store the current state of album for each snapshot. Wrapping all the details including the shapes on the canvas and a unique identifier and description is way more efficient and error-prone than the old way used in last homework.
2. Besides, I add a getType() method in ShapeModel which returns the type of the shape class. It assists me to create shapes to the photo album.