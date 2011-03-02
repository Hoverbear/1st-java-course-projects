/*
 * author: Andrew Hobden
 * Created on October 1st, 2010
 * Purpose: A program which draws a cross-section of a swimming pool and
 * which calculates and displays volume of the pool given its dimensions.
 * Fixed Parameters: Width of Pool is 5, Length is 20.
 * The user of this program controls the depth of the shallow and deep end of
 * the pool by using input dialog boxes.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Comp132Lab3 extends JFrame
  implements ActionListener {
  private JPanel panel;
  private JButton button;

  public static void main(String[] args) {
    Comp132Lab3 frame = new Comp132Lab3();
    frame.setSize(350, 400);
    frame.createGUI();
    frame.setVisible(true);
  }

  private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(new FlowLayout() );
    panel = new JPanel();
    panel.setPreferredSize(new Dimension(300,300));
    panel.setBackground(Color.white);
    window.add(panel);
    button = new JButton("Press me");
    window.add(button);
    button.addActionListener(this);
  }
  public void actionPerformed(ActionEvent event) {
    int deepEnd;
    int shallowEnd;
    Graphics paper = panel.getGraphics();

    String inputString;//used to read an input

    inputString = JOptionPane.showInputDialog("Deep End: ");
    deepEnd = Integer.parseInt(inputString);
    inputString = JOptionPane.showInputDialog("Shallow End: ");
    shallowEnd = Integer.parseInt(inputString);

    JOptionPane.showMessageDialog(null,"Volume: " + calculateVolume
            (20,5,deepEnd,shallowEnd)); // Here we call for the volume.
    drawPool(paper, 10, 10, deepEnd, shallowEnd, 20); // Draw the pool.

  }

/*
 * Draws the shape of the swimming pool
 * Receives: Graphics object, x and y coordinates for the top-left
 * corner,depths of the deep and shallow ends and length of the pool
 */
private void drawPool(Graphics paper, int x, int y, int deepEnd,
         int shallowEnd, int length) {
    length = length * 10;   // The following 3 variables are scaled up by
    deepEnd = deepEnd * 10; // By a factor of 10 for easy viewing.
    shallowEnd = shallowEnd * 10; // We assume small dimensions are given
    paper.drawLine(x,y,x + length,y); // Draw the top rim of the pool
    paper.drawLine(x,y,x,(y + deepEnd)); // Draw deep end wall
    paper.drawLine((x + length),y,(x + length),(y + shallowEnd));
        // Above we draw the shallow end wall.
    paper.drawLine((x + length),(y + shallowEnd), x ,(y + deepEnd));
        // Above we draw the line between the bottoms of the walls.
    }

/*
 * Calculates pool's volume
 * Receives: length, width, depths of deep and shallow ends of the pool
 * Returns: calculated volume
 */
private double calculateVolume(int length, int width, int deepEnd,
        int shallowEnd) {
    double volume; // The volume may be a decimal.
    double average; // The average we calculate below may be a decimal.
    average = (deepEnd + shallowEnd) / 2.0; // Determine average of depth
    volume = (length * width) * average; // Calculate the volume
    return volume; // Return the volume calculated above
    }
}