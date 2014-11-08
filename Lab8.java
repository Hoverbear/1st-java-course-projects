/*
 * Lab8
 * This program is mean to demonstrate working with arrays, handling multiple
 * inputs, using classes, using loops, and using if statements. It accepts use
 * input through buttons and text fields.
 *
 * @date: Nov. 26, 2010
 * @author: Andrew Hobden
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Lab8 extends JFrame implements ActionListener {

    private JButton fillButton, resetButton, displayButton, displayBackButton,
            setElementButton, findSmallestButton, findLargestButton,
            getElementButton, replaceButton, sumButton, countBelowButton;
    private JLabel elemLabel1, elemLabel2, getLabel1, repLabel1, repLabel2,
            countLabel1;
    private JTextField field1, field2, field3, field4, field5, field6;
    /* These are initialized outside of createGUI because there is only one */
    private JTextArea output = new JTextArea(10, 45);
    private Lab8Array array = new Lab8Array();

    public static void main(String[] args) {
        Lab8 frame = new Lab8();
        frame.setSize(520, 500);
        frame.createGUI();
        frame.setVisible(true);
    }

    /* This method initializes the vast swath of objects that will be present
     * within this project.
     * In total: 11 buttons, 6 labels, and 6 textfields.
     * Horizontal struts are used to create linebreaks.
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout(FlowLayout.LEFT));
        window.add(output);

        elemLabel1 = new JLabel("Element:");
        elemLabel2 = new JLabel("Value:");
        getLabel1 = new JLabel("Element:");
        repLabel1 = new JLabel("Old Value:");
        repLabel2 = new JLabel("New Value:");
        countLabel1 = new JLabel("Value:");

        field1 = new JTextField(10);
        field2 = new JTextField(10);
        field3 = new JTextField(10);
        field4 = new JTextField(10);
        field5 = new JTextField(10);
        field6 = new JTextField(10);

        fillButton = new JButton("Fill Array"); // 1
        resetButton = new JButton("Reset Array"); // 2
        displayButton = new JButton("Display Array"); // 3
        displayBackButton = new JButton("Display Backwards"); // 4
        setElementButton = new JButton("Set Element"); // 5
        findSmallestButton = new JButton("Find Smallest"); // 6
        findLargestButton = new JButton("Find Largest"); // 7
        getElementButton = new JButton("Get Element"); // 8
        replaceButton = new JButton("Replace"); // 9
        sumButton = new JButton("Find Sum"); // 10
        countBelowButton = new JButton("Find Count Below"); // 11

        window.add(Box.createHorizontalStrut(20000));
        window.add(fillButton); // 1
        window.add(resetButton); // 2
        window.add(findSmallestButton); // 6
        window.add(findLargestButton); // 7
        window.add(displayButton); // 3
        window.add(displayBackButton); // 4
        window.add(sumButton); // 10
        window.add(Box.createHorizontalStrut(20000));

        window.add(setElementButton); // 5
        window.add(elemLabel1);
        window.add(field1);
        window.add(elemLabel2);
        window.add(field2);

        window.add(Box.createHorizontalStrut(20000));
        window.add(getElementButton); // 8
        window.add(getLabel1);
        window.add(field3);

        window.add(Box.createHorizontalStrut(20000));
        window.add(replaceButton); // 9
        window.add(repLabel1);
        window.add(field4);
        window.add(repLabel2);
        window.add(field5);

        window.add(Box.createHorizontalStrut(20000));
        window.add(countBelowButton); // 11
        window.add(countLabel1);
        window.add(field6);
        window.add(Box.createHorizontalStrut(20000));

        fillButton.addActionListener(this); // 1
        resetButton.addActionListener(this); // 2
        displayButton.addActionListener(this); // 3
        displayBackButton.addActionListener(this); // 4
        setElementButton.addActionListener(this); // 5
        findSmallestButton.addActionListener(this); // 6
        findLargestButton.addActionListener(this); // 7
        getElementButton.addActionListener(this); // 8
        replaceButton.addActionListener(this); // 9
        sumButton.addActionListener(this); // 10
        countBelowButton.addActionListener(this); // 11
    }

    /* Almost this entire method is contained within a large if statement
     * which checks to see which button has been pressed by the user.
     * If necessary it grabs textfield inputs and passes them into the method.
     */
    public void actionPerformed(ActionEvent e) {
        Object input = e.getSource();
        if (input == fillButton) { // 1
            array.fillArray();
        }else if (input == resetButton){ // 2
            array.resetArray();
        }else if (input == displayButton){ // 3
            array.display(output);
        }else if (input == displayBackButton){ // 4
            array.displayBackwards(output);
        }else if (input == setElementButton){ // 5
            int fieldOne = Integer.parseInt(field1.getText());
            int fieldTwo = Integer.parseInt(field2.getText());
            array.setElementAt(fieldOne,fieldTwo);
        }else if (input == findSmallestButton) { // 6
            output.append("The Smallest is: " + array.findSmallest() + "\n");
        }else if (input == findLargestButton) { // 7
            output.append("The largest is: " + array.findLargest() + "\n");
        }else if (input == getElementButton) { // 8
            int fieldOne = Integer.parseInt(field3.getText());
            output.append("" + array.getElementAt(fieldOne) + "\n");
        }else if (input == replaceButton) { // 9
            int fieldOne = Integer.parseInt(field4.getText());
            int fieldTwo = Integer.parseInt(field5.getText());
            array.replace(fieldOne, fieldTwo);
        }else if (input == sumButton) { // 10
            output.append("The sum is: " + array.findSum() + "\n");
        }else if (input == countBelowButton) { // 11
            int fieldOne = Integer.parseInt(field6.getText());
            output.append("" + array.countBelow(fieldOne) +
                    " numbers are below " + fieldOne + ".\n");
        }
    }
}

/* Default constructor. Creates a new default instance of Lab8Array The
 * default size is 10. The default value is zero (each element of the array
 * will be initialized to zero). */
class Lab8Array {
    private int[] array = new int[10];
    Random random = new Random();

    /* Default constructor. Creates a new default instance Lab8Array
     * The default size is 10. The default value is zero (each
     * element of the array will be initialized to zero). */
    public Lab8Array() {
        for (int i=0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    /* Count the number of elements in the internal array that are less thana
     * given value.
     *   Parameters:
     *       limit - The upper limit of values to be counted. The number of
     *       elements less than this value will be counted.
     *   Returns:
     *       The number of elements with a value less than the parameter. */
    public int countBelow(int limit) {
        int count = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] < limit) {
                count++;
            }
        }
        return count;
    }

    /* Display the contents of the internal array in order of lowest index to
     * highest index.  */
    public void display(JTextArea t) {
        //t.setText("");
        for (int i = 0;i < array.length; i++) {
            t.append("" + array[i] + " ");
        }
        t.append("\n");
    }

    /* Display the contents of the internal array in order of highest indexto
     * lowest index. */
    public void displayBackwards(JTextArea t) {
        //t.setText("");
        for (int i = (array.length -1); i >= 0; i--) {
            t.append("" + array[i] + " ");
        }
        t.append("\n");
    }

    /* Puts random values into this Array object. Each element of the
     * internal array will be filled with a random number between 0 and 100;*/
    public void fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }
    }

    /* Search the array for the largest value
     *   Returns:
     *   The largest value of all elements in the internal array. */
    public int findLargest() {
        int largest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }

    /* Search the array for the largest value.
     *   Returns:
     *   The largest value of all elements in the internal array. */
    public int findSmallest() {
        int smallest = array[0];
        for (int i = 1; i < array.length; i++) { // We don't need to check [0]
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    /* Search the array for the largest value
     *   Returns:
     *   the largest value of all elements in the internal array. */
    public int findSum() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /* Search the array for the largest value
     *   Returns:
     *   the largest value of all elements in the internal array. */
    public int getElementAt(int position) {
        return array[position];
    }

    /* Replace all occurances of a given value within the internal array.
     *   Parameters:
     *   key - value which will be replaced.
     *   newValue - value which will replace the key. */
    public void replace(int  key, int newValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                array[i] = newValue;
            }
        }
    }
    /* Initializes every element of the array to zero. */
    public void resetArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    /* Puts a given value into a specified position of this Array
     * object. The element at the specified postion of the internal arraywill
     * be set to the value provided in the parameter num.
     *
     *  Parameters:
     *  position - the index of the array element that is to be changed.
     *  num - the int value which will be placed in element position. */
    public void setElementAt(int position, int num) {
        array[position] = num;
    }
}
