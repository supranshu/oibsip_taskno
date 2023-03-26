import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JFrame implements ActionListener
{
    private JLabel instruction, result;
    private JTextField inputField;
    private JButton submitButton;
    private int randomNum, attemptsLeft;
    public void initialize(){

        randomNum = (int) (Math.random() * 100) + 1;
        attemptsLeft = 10;

        instruction = new JLabel("Guess a number between 1 and 100:");
        instruction.setFont(new Font("Arial", Font.PLAIN, 16));
        instruction.setBounds(50, 60, 300, 20);

        inputField = new JTextField();
        inputField.setBounds(50, 90, 200, 30);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 130, 100, 30);
        submitButton.addActionListener(this);

        result = new JLabel("");
        result.setFont(new Font("Arial", Font.PLAIN, 16));
        result.setBounds(50, 170, 400, 20);

        

        
        add(instruction);
        add(inputField);
        add(submitButton);
        add(result);

        setTitle("Number Guessing Game");
        setSize(500, 300);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                int guess = Integer.parseInt(inputField.getText());
                attemptsLeft--;
                if (guess == randomNum) {
                    // result.setText("Congratulations! You guessed the number in " + (10 - attemptsLeft) + " attempts.");
                    submitButton.setEnabled(false);
                    JOptionPane.showMessageDialog(Game.this,
                "Congratulations! You guessed the number in " + (10 - attemptsLeft) + " attempts.",
                "Successful",
                JOptionPane.PLAIN_MESSAGE);
                    dispose();
                } else if (guess < randomNum) {
                    result.setText("Too low. Attempts left: " + attemptsLeft);
                } else {
                    result.setText("Too high. Attempts left: " + attemptsLeft);
                }
                if (attemptsLeft == 0) {
                    result.setText("You ran out of attempts. The number was " + randomNum + ".");
                    submitButton.setEnabled(false);
                }
                inputField.setText("");
            } catch (NumberFormatException ex) {
                result.setText("Please enter a valid integer.");
            }
        }
    }


    
}

