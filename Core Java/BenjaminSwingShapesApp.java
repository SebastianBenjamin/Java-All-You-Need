import javax.swing.*;
import java.awt.*;

public class BenjaminSwingShapesApp extends JPanel {

    public static void main(String[] args) {
        // Create a JFrame window
        JFrame frame = new JFrame("Drawing Shapes for 'Benjamin'");

        // Set up the frame
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create the custom JPanel and add it to the frame
        BenjaminSwingShapesApp panel = new BenjaminSwingShapesApp();
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set rendering hints for smooth graphics (optional)
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw a circle to represent 'B' visually
        g2d.setColor(Color.BLUE);
        g2d.fillOval(50, 100, 100, 100);

        // Draw text "Benjamin" near the shape
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Benjamin", 200, 150);

        // Example: Add additional geometric elements
        g2d.setColor(Color.GREEN);
        g2d.fillRect(300, 100, 100, 100); // Draw a rectangle
    }
}
