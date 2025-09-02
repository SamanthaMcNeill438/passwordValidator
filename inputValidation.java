import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class inputValidation {

    public static boolean checkCharacters(String input){
        // check input contains 1 uppercase letter, 1 lowercase letter, 1 number and 1 special character
        if (input.length() < 8) {
            showErrors("Input must be at least 8 characters long.");
            return false;
        }
        else if (!input.matches(".*[A-Z].*")) {
            showErrors("Input must contain at least one uppercase letter.");
            return false;
        }
        else if (!input.matches(".*[a-z].*")) {
            showErrors("Input must contain at least one lowercase letter.");
            return false;
        }
        else if (!input.matches(".*[0-9].*")) {
            showErrors("Input must contain at least one number.");
            return false;
        }
        else if (!input.matches(".*[!@#$%^&*()-+].*")) {
            showErrors("Input must contain at least one special character.");
            return false;
        }
        else {
            return true;
        }
    }

    public static void showErrors(String message){
        // Redirect System.out to a JTextArea
        // Create JFrame
        JFrame frame = new JFrame("Console Output");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 300);
            frame.setLayout(new java.awt.BorderLayout());

        // Create JTextArea
        JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
            frame.add(scrollPane, java.awt.BorderLayout.CENTER);

        // Redirect System.out to JTextArea
        PrintStream printStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                textArea.append(String.valueOf((char) b));
                textArea.setCaretPosition(textArea.getDocument().getLength()); // Auto-scroll
            }
        });
            System.setOut(printStream);
            System.setErr(printStream);

        // Make JFrame visible
            frame.setVisible(true);

        // Example output
            System.out.println(message);
    }

}
