import javax.swing.*;
import java.awt.event.*;

public class RadioButtonExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("RadioButton Example");
        JRadioButton rb1 = new JRadioButton("Option A");
        JRadioButton rb2 = new JRadioButton("Option B");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        rb1.setBounds(50, 50, 150, 30);
        rb2.setBounds(50, 100, 150, 30);

        JButton button = new JButton("Show Selected");
        button.setBounds(50, 150, 150, 30);

        button.addActionListener(e -> {
         
		 String message = "Selected: ";
            if (rb1.isSelected()) message += "Option 1 ";
            if (rb2.isSelected()) message += "Option 2 ";

            JOptionPane.showMessageDialog(frame, message);

        });

        frame.add(rb1);
        frame.add(rb2);
        frame.add(button);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
