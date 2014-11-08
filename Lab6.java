
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Lab6 extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;
    private Random random;
    private int paperWidth = 251, paperHeight = 251;
    // 251 so we can see the borders on each box.

    public static void main(String[] args) {
        Lab6 frame = new Lab6();
        frame.setSize(325, 350);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new MyPanel();
        panel.setPreferredSize(new Dimension(paperWidth, paperHeight));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Start");
        window.add(button);
        button.addActionListener(this);
        random = new Random();
    }

    public void actionPerformed(ActionEvent e) {
        Graphics g = panel.getGraphics();  // Declaring our variables
        int xpos = 120;
        int ypos = 120;
        String message;
        g.setColor(Color.white); // Here we erase any previous grids/drunks
        g.fillRect(0, 0, 251, 251);
      //  drawGrid(g); // Draw our first grid.
        int distance = drunkSaunter(g, xpos, ypos);
        // Here we create an appropriate message for our popup.
        if (distance == 50) {
            message = "Your alchoholic travelled a whole 5000 meters and"
                    + "\n still got stuck in the city... he's now zombie food!";
        } else {
            message = "Your alchoholic travlled only " + distance + "00 meters"
                    + " and made it out of the city before the zombies came!"
                    + " Good job!";
        }
        JOptionPane.showMessageDialog(null, message); // Distance and message
    }
    /* This method does all the main work of the program itself. It draws,
     moves, and erases the drunk. It returns his distance travelled. */
    private int drunkSaunter(Graphics g, int xpos, int ypos) {
        int direction;
        int distance = 0;
        while (distance < 50 && xpos >= 0 && xpos <= 250
                && ypos <= 250 && ypos >= 0) {
            /* This loop does most of the work, it erases the old drunk, fixes
            up our grid, creates a random direction, moves the drunk,
            redraws him, increases the distance (max 50) and waits before
            rerunning. */
            drunkMan(g, xpos, ypos, Color.red);
            delay(80);
            drunkMan(g, xpos, ypos, Color.white);
            drawGrid(g);
            direction = random.nextInt(4);
            if (direction == 3) {
                xpos += 25;
            } else if (direction == 2) {
                xpos -= 25;
            } else if (direction == 1) {
                ypos += 25;
            } else {
                ypos -= 25;
            }
          //  drunkMan(g, xpos, ypos, Color.red);
            distance++;
           // delay(80);
        }
        drunkMan(g, xpos, ypos, Color.red);
        return distance;
    }

    /* This method simply redraws our drunkard. Taking in the Graphics object
    and positions. */
    private void drunkMan(Graphics g, int xpos, int ypos, Color c) {
        g.setColor(c);
        g.fillOval(xpos, ypos, 10, 10);
    }

    /* This method draws our grid. It creates a 10x10 grid on the graphics
    object specified. */
    public void drawGrid(Graphics g) {
        int xpos = 0;
        int ypos = 0;
        g.setColor(Color.black);
        for (int row = 1; row <= 10; row++) {
            for (int column = 1; column <= 10; column++) {
                g.drawRect(xpos, ypos, 25, 25);
                xpos = xpos + 25;
            }
            ypos = ypos + 25;
            xpos = 0;
        }
    }

    // This method simply makes the program wait the specified time.
    private void delay(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
        }
    }
}
// Here we override the panel to draw the grid automagically. I don't really
// Understand it.
class MyPanel extends JPanel {

    Lab6 o = new Lab6();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        o.drawGrid(g);
    }
}