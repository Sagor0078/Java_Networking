import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;
    JTextField display;
    int num1, num2, result;
    char operator;

    public Calculator() {
        setTitle("Calculator");
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5)); // Larger grid with spacing
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
            numberButtons[i].addActionListener(this);
        }
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);

        display = new JTextField(30);
        display.setFont(display.getFont().deriveFont(Font.BOLD, 20f)); // Increase font size
        display.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right

        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setSize(400, 500); // Larger window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String buttonText = clickedButton.getText();

        if (buttonText.matches("[0-9]")) {
            display.setText(display.getText() + buttonText);
        } else if (buttonText.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
        } else if (buttonText.matches("[+\\-*/]")) {
            num1 = Integer.parseInt(display.getText());
            operator = buttonText.charAt(0);
            display.setText("");
        } else if (buttonText.equals("=")) {
            num2 = Integer.parseInt(display.getText());
            calculateResult();
            display.setText(String.valueOf(result));
        }
    }

    private void calculateResult() {
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error");
                    num1 = num2 = result = 0;
                    return;
                }
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
