import javax.swing.*;
import java.awt.event.*;

public class CheckBoxExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("CheckBox Example");
        JCheckBox cb1 = new JCheckBox("Option 1");
        JCheckBox cb2 = new JCheckBox("Option 2");

        cb1.setBounds(50, 50, 150, 30);
        cb2.setBounds(50, 100, 150, 30);

        JButton button = new JButton("Show Selected");
        button.setBounds(50, 150, 150, 30);

        button.addActionListener(e -> {
            String message = "Selected: ";
            if (cb1.isSelected()) message += "Option 1 ";
            if (cb2.isSelected()) message += "Option 2 ";

            JOptionPane.showMessageDialog(frame, message);
        });

        frame.add(cb1);
        frame.add(cb2);
        frame.add(button);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
