import javax.swing.*;
import java.awt.*;

public class AppletExample extends JApplet {

    public void init() {

        JLabel label = new JLabel("Welcome to Swing Applet");

        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label);
    }
}
