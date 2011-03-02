/*
 * Comp132Lab4
 * Purpose: This program emulates the popular Rock paper scissors game. It
 * uses the random function as well as if statements. Once the player enter
 * their choice via button, we find a random choice for the computer and
 * compare choices to discover the winner, then return it in a textbox.
 * @date =  Oct 8 2010
 * @author = Andrew Hobden
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Comp132Lab4 extends JFrame implements ActionListener {

    private JButton rockButton, paperButton, scissorsButton;
    private JTextField textField, textField2;

    public static void main(String[] args) {
        Comp132Lab4 paper = new Comp132Lab4();
        paper.setSize(250,150); // Setting up the pane
        paper.createGUI();
        paper.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textField = new JTextField(15); // Setting up the buttons/fields
        window.add(textField);

        textField2 = new JTextField(15);
        window.add(textField2);

        rockButton = new JButton("Rock");
        window.add(rockButton);
        rockButton.addActionListener(this);

        paperButton = new JButton("Paper");
        window.add(paperButton);
        paperButton.addActionListener(this);

        scissorsButton = new JButton("Scissors");
        window.add(scissorsButton);
        scissorsButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        int playerChoice; // Set up return required variables
        int compChoice;   // For player, computer, and winner
        String winner;
        Random randomSeed = new Random(); // Set up our random seed
        if (source == rockButton) { // Check to see if player picks rock
            playerChoice = 0;
        }
        else if (source == paperButton){ // Check to see if player picks paper
            playerChoice = 1;
        } else {
            playerChoice = 2; // Check to see if player picks scissors
        }
        compChoice = randomSeed.nextInt(3); // Find computer choice
        winner = findWinner(playerChoice, compChoice);
        textField.setText("Winner is " + winner + "!"); // Display Winner

        if (compChoice == 0) { // Show what the computer picked and display
            textField2.setText("Computer choice is rock");
        } else if (compChoice == 1) {
            textField2.setText("Computer choice is paper");
        } else {
            textField2.setText("Computer choice is scissors");
        }

    }
    /* This method uses if statements to determine the victor of the epic
     * rock paper scissors match. It checks for a tie, then if computer wins
     * and if none of those are true it declares the player then winner.
     */
    private String findWinner(int playerChoice, int compChoice) {
        String winner;
        if (playerChoice == compChoice) { // Make sure it's not a tie
            winner = "Noone, it's a tie";
        } else if (playerChoice == 0 && compChoice == 1) {
            winner = "Computer"; // Paper beats rock
        } else if (playerChoice == 1 && compChoice == 2) {
            winner = "Computer"; // Scissors beats Paper
        } else if (playerChoice == 2 && compChoice == 0) {
            winner = "Computer"; // Rock beats Scissors
        } else {
            winner = "Player"; // Player wins if computer doesn't beat them
        } return winner; // Space/cost saving measure
    }
}