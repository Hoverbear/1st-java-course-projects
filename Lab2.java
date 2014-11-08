/*
 * Lab2.java
 * @author  Andrew Hobden
 * Created on September 17th, 2010 11:37 AM
 * Purpose: Pretend to be a vending machine.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab2 extends JFrame
implements ActionListener {

  private JButton button;  // We like to make people do extra work

  public static void main(String[] args) {
    Lab2 frame = new Lab2();
    frame.setSize(400, 300);
    frame.createGUI();
    frame.setVisible(true);
  }

  private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(new FlowLayout() );

    button = new JButton("Press to start.");
    window.add(button);
    button.addActionListener(this);
  }
  public void actionPerformed(ActionEvent event) {
    int snackPrice;
    int moneyInserted;
    int changeLeft;
    int quarters;
    int dimes;
    int nickels;
    int pennies;
    String snackPriceString;
    String moneyInsertedString;

    snackPriceString = JOptionPane.showInputDialog
            ("Enter price of your snack:"); // Grabs snack price
    snackPrice = Integer.parseInt(snackPriceString);  // Makes it workable

    moneyInsertedString = JOptionPane.showInputDialog
            ("Enter money inserted in cents:"); // Grabs money inserted
    moneyInserted = Integer.parseInt(moneyInsertedString); // Make it workable

    changeLeft = moneyInserted - snackPrice;
    // Calculate how much we're giving back

    quarters = changeLeft / 25; // Find out how many quarters fit
    changeLeft = changeLeft % 25; // Pass the remaining cents along

    dimes = changeLeft / 10; // Find out how many dimes fit in the rest
    changeLeft = changeLeft % 10; // Pass the remaining cents along

    nickels = changeLeft / 5; // Find out how many nickels fit in the rest
    changeLeft = changeLeft % 5; // Pass the remaining cents along

    pennies = changeLeft; // Find out how many pennies fit in the rest

     JOptionPane.showMessageDialog(null, "Here's what you get back: \n" +
             quarters + " Quarters\n" + dimes + " Dimes\n" + nickels +
             " Nickels\n" + "and "+ pennies + " Pennies!");
      // Print it all out for the user
  }

}
