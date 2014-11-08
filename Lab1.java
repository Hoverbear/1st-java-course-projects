/*
 * Lab1.java
 * @author  Andrew Hobden
 * Created on September 17th, 2010 11:37 AM
 * Purpose: Draw a Happy face.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab1 extends JFrame implements ActionListener{

  private JButton button;
  private JPanel panel;

  public static void main(String[] args) {
    Lab1 frame = new Lab1();
    frame.setSize(420,510);
    frame.createGUI();
    frame.setVisible(true);
  }

  private void createGUI(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(new FlowLayout());

    panel = new JPanel();
    panel.setPreferredSize(new Dimension(400,400));
    panel.setBackground(Color.gray);
    window.add(panel);

    button = new JButton("Happy Time!");
    window.add(button);
    button.addActionListener(this);

  }

  public void actionPerformed(ActionEvent e){
    Graphics paper = panel.getGraphics();
    paper.setColor(Color.yellow); // Create the face
    paper.fillOval(25,25,350,350);
    paper.setColor(Color.black); // Draw Face outline
    paper.drawOval(25,25,350,350);
    paper.setColor(Color.blue); // Create the eyes
    paper.fillOval(125,125,50,50);
    paper.fillOval(225,125,50,50);
    paper.setColor(Color.black); // Draw eye outline
    paper.drawOval(125,125,50,50);
    paper.drawOval(225,125,50,50);
    paper.setColor(Color.red); // Create the Arc for the mouth
    paper.fillArc(150,250,100,80,180,180);
    paper.setColor(Color.black); // Draw Mouth outline
    paper.drawLine(150,290,250,290);
    paper.drawArc(150,250,100,80,180,180);
    // Note 6th variable is degrees from 5th variable, not from origin.
  }


}
