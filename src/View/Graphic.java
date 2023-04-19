package View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import Model.IShapeModel;
import Model.Snapshot;

public class Graphic extends JFrame implements IView {

  private JPanel menu;
  private JPanel head;
  private JLabel label;
  private List<Snapshot> snapshotList;
  private List<String> SnapIDList;
  private Canvas canvas; // subclass of JPanel
  private int idx = 0;
  private int wid;
  private int height;
  private static final int BAR_HEIGHT = 200;


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


  private void setupIDList(){
    this.SnapIDList = new ArrayList<>();
    for(Snapshot each:snapshotList) {
      SnapIDList.add(each.getID());
    }
  }

  private JButton createPrevButton(){
    JButton prev = new JButton("<< Prev <<");
    prev.setActionCommand("prev");
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

  private JButton createNextButton(){
    int size = snapshotList.size();
    int lastSnap = size -1;

    JButton Next = new JButton(">> Next >>");
    Next.setActionCommand("next");
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

  private JButton selectButton(){
    JButton select = new JButton("^^ Select ^^");
    select.setActionCommand("select");
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

  private JButton quitButton(){
    JButton quit = new JButton("XX Quit XX");
    quit.setActionCommand("quit");
    // 0 mean end of system
    quit.addActionListener(e->System.exit(0));
    return quit;
  }


  public void setupMenu(){
    JButton prev = createPrevButton();
    JButton next = createNextButton();
    JButton select = selectButton();
    JButton quit = quitButton();

    this.menu = new JPanel(new FlowLayout());
    this.menu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    this.menu.setBackground(Color.ORANGE);
    // Add button(Component) to the menu
    this.menu.add(prev);
    this.menu.add(next);
    this.menu.add(select);
    this.menu.add(quit);
    // add manu bar to the graphic at the bottom of the screen
    this.add(menu,BorderLayout.AFTER_LAST_LINE);
  }

  private void setUpHead(){
    // make sure the bar will not flow freely
    this.head = new JPanel(new BorderLayout());
    this.head.setBackground(Color.PINK);
    // the head bar contains the ID and description label for each snapshot
    this.label = new JLabel("<html><body>" + snapshotList.get(idx).getID() + "<br/>" +
            snapshotList.get(idx).getDescription() + "<body></html>");
    // make sure the label is at the top of head
    this.head.add(label,BorderLayout.NORTH);
    // put add at the top of the screen
    this.add(head,BorderLayout.NORTH);
  }

  private void setUpCanvas(){
    canvas = new Canvas();
    // Default snapshot will be the first snapshot
    canvas.drawShape(snapshotList.get(0).getShapeList());
    //set the size of the drawing canvas
    Dimension size = new Dimension(wid,height-BAR_HEIGHT);
    this.setPreferredSize(size);
    this.add(canvas,BorderLayout.CENTER);
  }


  @Override
  public void display() {
    try{
      // properly resize all the components before displayed
      this.setVisible(true);
    } catch (Exception e){
      e.printStackTrace();
    }
  }



}
