package View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import Model.IShapeModel;
import Model.Snapshot;

/**
 * The Graphic class is responsible for displaying the snapshots of shapes and their descriptions
 * in a graphical interface. It is controller by the graphicController.
 * It implements the IGraphicView interface and extends the JFrame class.
 */
public class Graphic extends JFrame implements IGraphicView {

  private JLabel label;
  private final List<Snapshot> snapshotList;
  private List<String> SnapIDList;
  private Canvas canvas; // subclass of JPanel
  private int idx = 0;
  private final int wid;
  private final int height;
  private static final int BAR_HEIGHT = 200;


  /**
   * Constructs a Graphic object with the specified shape model and dimensions.
   *
   * @param model the shape model that contains the implementation of photo album
   *             and snapshots to be displayed
   * @param wid the width of the graphical interface
   * @param height the height of the graphical interface
   */
  public Graphic(IShapeModel model, int wid, int height){
    this.wid = wid;
    this.height = height;
    this.snapshotList = model.getSnapshotList();

    this.setSize(wid,height);
    setupIDList();
    setUpCanvas();
    setUpHead();
    setupMenu(); // buttons included
    this.pack();
  }


  @Override
  public void setupIDList(){
    this.SnapIDList = new ArrayList<>();
    for(Snapshot each:snapshotList) {
      SnapIDList.add(each.getID());
    }
  }

  @Override
  public JButton createPrevButton(){
    JButton prev = new JButton("<< Prev <<");
    prev.addActionListener(e-> {
      if(idx==0){
        JOptionPane.showMessageDialog(new JFrame(),"No previous available.\n");
      } else {
        // decrement the index to get the previous snapshot
        idx = idx -1;
        // draw the previous snapshot
        canvas.drawShape(snapshotList.get(idx).getShapeList());
        // Change the info of the snapshot at top left-hand corner
        label.setText("<html><body>"+snapshotList.get(idx).getID()+"<br/>"
                      + snapshotList.get(idx).getDescription()+"<body></html>");
      }
    });
    return prev;
  }

  @Override
  public JButton createNextButton(){
    int size = snapshotList.size();
    int lastSnap = size -1;

    JButton Next = new JButton(">> Next >>");
    Next.addActionListener(e -> {
      // if the index is now reaching the end of snapshot, show a message
      if (idx == lastSnap) {
        JOptionPane.showMessageDialog(new JFrame(), "End of the photo album." +
                " No snapshot to show beyond this one.\n");
      } else {
        idx += 1;
        canvas.drawShape(snapshotList.get(idx).getShapeList());
        label.setText("<html><body>" + snapshotList.get(idx).getID() + "<br/>" +
                snapshotList.get(idx).getDescription() + "<body></html>");
      }
    });
    return Next;
  }

  @Override
  public JButton selectButton(){
    JButton select = new JButton("^^ Select ^^");
    select.addActionListener(e -> {
      // provide options for user to choose
      String s = (String) JOptionPane.showInputDialog(null,
              "Choose", "Menu", JOptionPane.PLAIN_MESSAGE,
              null, SnapIDList.toArray(), SnapIDList.toArray()[0]);

      // index of the selected snapshot
      idx = SnapIDList.indexOf(s);
      canvas.drawShape(snapshotList.get(idx).getShapeList());
      label.setText("<html><body>" + snapshotList.get(idx).getID() + "<br/>" +
              snapshotList.get(idx).getDescription() + "<body></html>");
    });
    return select;

  }


  @Override
  public JButton quitButton(){
    JButton quit = new JButton("XX Quit XX");
    // 0 mean end of system
    quit.addActionListener(e->System.exit(0));
    return quit;
  }

  @Override
  public void setupMenu(){
    JButton prev = createPrevButton();
    JButton next = createNextButton();
    JButton select = selectButton();
    JButton quit = quitButton();

    JPanel menu = new JPanel(new FlowLayout());
    menu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    menu.setBackground(Color.ORANGE);

    // Add button(Component) to the menu
    menu.add(prev);
    menu.add(next);
    menu.add(select);
    menu.add(quit);

    // add manu bar to the graphic at the bottom of the screen
    this.add(menu,BorderLayout.AFTER_LAST_LINE);
  }


  @Override
  public void setUpHead(){
    // make sure the bar will not flow freely
    JPanel head = new JPanel(new BorderLayout());
    head.setBackground(Color.PINK);

    // the head bar contains the ID and description label for each snapshot
    this.label = new JLabel("<html><body>" + snapshotList.get(idx).getID() + "<br/>" +
            snapshotList.get(idx).getDescription() + "<body></html>");

    // add label to the head bar
    head.add(label);

    // make sure the head bar is added at the top of the screen
    this.add(head,BorderLayout.NORTH);
  }

  @Override
  public void setUpCanvas(){
    canvas = new Canvas();

    // Default snapshot will be the first snapshot
    canvas.drawShape(snapshotList.get(0).getShapeList());

    //set the size of the drawing canvas
    Dimension size = new Dimension(wid,height-BAR_HEIGHT);
    this.setPreferredSize(size);
    this.add(canvas,BorderLayout.CENTER);
  }
}
