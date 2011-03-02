 /* Comp132Lab9
  * This program demonstrates the ability to properly work with the following features of Java:
  * Arrays, Classes, Loops, chars, and Strings.
  * 
  * This program takes in text input from input (A JPasswordField), and uses it to create an
  * an object aptly named "hangman", from there it takes input from the array of buttons which
  * represent the alphabet and checks to see if user input matches the input'd string.
  * It then increases the amount of tries the user has man and displays current progress.
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class comp132Lab9 extends JFrame implements ActionListener {

    private JButton[] alphabet;		//Array of buttons representing alphabet letters
    private JPasswordField input; //used to input secret word
    private JTextField output;
    private Hangman hangman;

    public static void main(String arg[]) {
        comp132Lab9 frame = new comp132Lab9();
        frame.setSize(600, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    /* This method creates necessary GUI components, including a minimal
     * QWERTY keyboard of buttons for some reason.
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        Label prompt = new Label("Enter secret word");
        input = new JPasswordField(20); //used to secret enter word
        input.addActionListener(this);

        output = new JTextField(50);   //displays dashes and letters
        window.add(prompt);
        window.add(input);
        window.add(output);
        alphabet = new JButton[26];
        char letter = 'A';

        //creates buttons representing letters
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = new JButton("" + letter);
            letter++;
            window.add(alphabet[i]);
            alphabet[i].addActionListener(this);
        }
        input.setEchoChar('*');   //Sets the echo character to an '*' for this
                                  //text field

    }
    
    /* This method recieves an ActionEvent object, and preforms actions based
     * on which type of input was produced. If the source of the actionEvent
     * was the input JPasswordField,  the object hangman is initialized with
     * the specified secretWord. If the source of the ActionEvent is any one
     * of our JButtons then we check to make sure a hangman class has been
     * initialized and if so then performed calls to hangman to check for any
     * further progess on the word then displays the progess so far in the
     * output JTextfield.
     */
    public void actionPerformed(ActionEvent e) {
        String secretWord = "";  //stores secret word
        String arg;             //stores alphbet letter
        if (e.getSource() == input) {
            secretWord = input.getText();//read secret word
            secretWord = secretWord.toLowerCase();
            hangman = new Hangman(secretWord);

        } else if (e.getSource() instanceof JButton) {
            arg = e.getActionCommand(); //read alphabet letter
            hangman.triesIncrease();
            if (secretWord.equals("")) {
                hangman.checkEntry(arg);
                output.setText("Attempts: " + hangman.triesDisplay() +
                        " So far: " + hangman.display());
            } else {
                JOptionPane.showMessageDialog(null, "Ok, so we can't play"
                        + " hangman till you enter a word!");
            }
        }
    }
}

 /* The hangman class stores two char[], one (secretArray) for the secret word entered by
  * the user, and one (foundArray) for the storage of currently found chars. As the
  * object is constructed the foundArray char[] is filled with '-' and as the user
  * progesses through the word they are gradually replaces with characters pulled from
  * the secretArray.
  */
class Hangman {

    protected char[] secretArray;
    protected char[] foundArray;
    protected char button;
    protected int tries;

    /* Default Constructor. The numer of tries the user has took is set to 0, 
     * the received secretWord is converted into an array and stored. The
     * foundArray is initialized to the same length as the secretArray and is
     * filled with '-'
     *
     * Receives:
     *  String secretWord -- the word the user inputs that is to be found
     */
    public Hangman(String secretWord) {
        tries = 0;
        secretArray = secretWord.toCharArray();
        foundArray = new char[secretArray.length];
        for (int i = 0; i < foundArray.length; i++) {
            foundArray[i] = '-';
        }
    }
    
    /* This method returns the foundArray as a string, with each index
     * separated by a comma.
     * Returns:
     *    String outputString -- The array indexs separated by commas
     */
    public String display() {
        String outputString = "";
        for (int i = 0; i < foundArray.length; i++) {
            outputString += foundArray[i] + ", ";
        }
        return outputString;
    }

    /*  This method receives String arg (must be a single character) and
     * checks through the secretArray and if any indexes match the arg it
     * adds them in the same position to foundArray.
     * Receives:
     *  String arg -- A single digit button input
     */
    public void checkEntry(String arg) {
        String newArg = arg.toLowerCase();
        button = newArg.charAt(0);
        for (int i = 0; i < secretArray.length; i++) {
            if (button == secretArray[i]) {
                foundArray[i] = secretArray[i];
            }
        }
    }

    /* This method increases the tries variable */
    public void triesIncrease() {
        tries++;
    }

    /* This method displays the value of the tries variable.
     *    Returns:
     *    int tries -- The number of tries the user took
     */
    public int triesDisplay() {
        return tries;
    }
}
