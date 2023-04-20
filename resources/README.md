## Homework 9 - The photo album in MVC structure

### Overview
- This project aims to implement a photo album application using the Model-View-Controller (MVC) structure.
- The application provides various functions to the user, including adding shapes, moving coordinates, changing size and color of shapes, taking selfies, getting a list of snapshots, removing shapes, resetting the album, and exiting the application.

### Design
- The Model package is responsible for managing the application's data and logic. It works in conjunction with the View and Controller to provide efficient management of the application's components. The Shape package, located inside the Model package, provides an Interface named IShape and concrete classes that implement IShape, allowing the addition of only two types of shapes, oval and rectangle, to the photo album.
- The application implements two more interfaces for its functionality.
    - IShapeModel, implemented by ShapeModel, carries out the album's functions.
    - IController, implemented by ShapeController, responds to input messages and implements the functions designed in ShapeModel.
- ShapeController acts as the main controller of the photo album, allowing the user to interact with the album and receive corresponding outputs by providing input and output.
- For convenience, the user can interact with the photo album using the Main file.
- The application accepts user input commands and generates outputs in the terminal.
- Unit tests are written in the test file to ensure the methods and functions run smoothly.
- Overall, this project demonstrates an efficient implementation of an MVC structure in creating a photo album application. The design allows for organized management of data and logic, providing a user-friendly experience for interacting with the photo album.

### Amendment