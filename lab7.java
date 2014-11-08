import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab7 extends JFrame implements ActionListener {

    private JButton button;
    private Student s1 = new Student(); // Initialize our custom class
    private JTextArea output = new JTextArea(10, 15);

    public static void main(String[] args) {
        lab7 frame = new lab7();
        frame.setSize(255, 255);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        window.add(output);
        button = new JButton("Start");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        s1.setName("Mark"); // Setting the student's name
        s1.setScore(1, 80); // Setting the student's 1st test score
        s1.setScore(2, 89); // Setting the student's 2nd test score
        s1.setScore(3, 92); // Setting the student's 3rd test score
        output.setText("Student Name: " + s1.getName() + "\n"
                + "Test 1 score: " + s1.getScore(1) + "\n"
                + "Test 2 score: " + s1.getScore(2) + "\n"
                + "Test 3 score: " + s1.getScore(3) + "\n"
                + "Average score: " + s1.getAverage() + "\n"
                + "Highest score: " + s1.getHighScore());
    } // Display the required output in our textArea
}


// ---------------------Begin new file Student.java

/* Class student contains 4 variables, the student name, and 3 test scores.
 * It contains the following methods:
 *    setName(String aname), getName(), setScore(int whichTest, int score),
 *    getScore(int whichTest), getAverage(), getHighScore()
 * These methods manipulate 4 variables, String name, and int test1, test2
 * and test3.
 */

/*public class Student {
    private String name;
    private int test1, test2, test3;

    public Student() {
        name = "Unset";
        test1 = 0;
        test2 = 0;
        test3 = 0;
    }
    // Sets the name of the Student to the parameter given.
    public void setName(String aname) {
        name = aname;
    }
    // Returns the name of the student
    public String getName() {
        return name;
    }
    // Sets the score of the given test to the given score.
    public void setScore(int whichTest, int score) {
        if (whichTest == 1) {
            test1 = score;
        }else if (whichTest == 2) {
            test2 = score;
        }else if (whichTest == 3) {
            test3 = score;
        }
    }
    // Returns the score of the specified test.
    public int getScore(int whichTest) {
        if (whichTest == 1) {
            return test1;
        }else if (whichTest == 2) {
            return test2;
        }else if (whichTest == 3) {
            return test3;
        }else {
            return 0;
        }
    }
    // Gets the average of all three tests and returns it.
    public int getAverage() {
        int average = (test1 + test2 + test3) / 3;
        return average;
    }
    // Finds the highest marks of all three tests and returns it.
    public int getHighScore() {
        if (test1 >= test2 && test1 >= test3) {
            return test1;
        }else if (test2 >= test1 && test2 >= test3) {
            return test2;
        }else {
            return test3;
        }
    }
} */
