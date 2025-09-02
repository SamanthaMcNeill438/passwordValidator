import javax.swing.JFrame;

public class getInput {

    // Load JFrame that takes user input
    public getInput() {
        JFrame frame = new JFrame("Input Validation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        // add textbox and write a string beneth it
        frame.setLayout(null);
        javax.swing.JTextField textField = new javax.swing.JTextField();
        textField.setBounds(50, 50, 300, 30);
        frame.add(textField);
        javax.swing.JLabel label = new javax.swing.JLabel("Enter your input:");
        label.setBounds(50, 20, 200, 30);
        frame.add(label);
        javax.swing.JButton button = new javax.swing.JButton("Submit");
        button.setBounds(150, 100, 100, 30);
        frame.add(button);
        button.addActionListener(e -> {
            String input = textField.getText();
            inputValidation validation = new inputValidation();
            if (validation.checkCharacters(input)) {
                javax.swing.JOptionPane.showMessageDialog(frame, "Input is valid!");
            } else {
                javax.swing.JOptionPane.showMessageDialog(frame, "Input is invalid. Please try again.");
            }
        });
    }
}
