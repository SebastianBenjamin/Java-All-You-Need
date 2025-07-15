import javax.swing.*;
import java.awt.event.*;

public class ComboBoxExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("ComboBox Example");

        String[] options = {"Item 1", "Item 2", "Item 3"};

        JComboBox <String> comboBox = new JComboBox<>(options);              

        comboBox.setBounds(50, 50, 150, 30);

        JButton button = new JButton("Show Selected");

        button.setBounds(50, 100, 150, 30);

        button.addActionListener(e -> {

            String selected ="You selected: " ;

		selected+= (String) comboBox.getSelectedItem();

            JOptionPane.showMessageDialog(frame,  selected);

        });

        frame.add(comboBox);
        frame.add(button);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}


