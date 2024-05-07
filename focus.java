import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SetEventOnClickInInputBoxExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Set Event on Click in Input Box Example");
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JTextField
        JTextField textField = new JTextField();
        textField.setBounds(20, 20, 200, 30);
        frame.add(textField);

        // Add a FocusListener to the text field
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Triggered when the text field gains focus (i.e. when the user clicks in it)
                System.out.println("Text field gained focus");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Triggered when the text field loses focus (i.e. when the user clicks out of it)
                System.out.println("Text field lost focus");
            }
        });

        // Display the JFrame
        frame.setVisible(true);
    }
}
