import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel success;
    private JLabel label1, label2, label3;
    private JTextField userText1, userText2, userText3;
    private JButton button;

    public static void main(String[] args) {
    	//maintain proper synchronization and avoid potential threading issues in Swing applications
        SwingUtilities.invokeLater(Registration::new);
    }

    public Registration() {
        frame = new JFrame("Registration Form");
        panel = new JPanel();
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for better component arrangement

        createLabels();
        createTextFields();
        createButton();
        createSuccessLabel();

        frame.setVisible(true);
    }

    private void createLabels() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 0, 0);

        label1 = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(label1, constraints);

        label2 = new JLabel("Roll:");
        constraints.gridy = 1;
        panel.add(label2, constraints);

        label3 = new JLabel("Department:");
        constraints.gridy = 2;
        panel.add(label3, constraints);
    }

    private void createTextFields() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 0, 0);

        userText1 = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(userText1, constraints);

        userText2 = new JTextField(20);
        constraints.gridy = 1;
        panel.add(userText2, constraints);

        userText3 = new JTextField(20);
        constraints.gridy = 2;
        panel.add(userText3, constraints);
    }

    private void createButton() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 0, 10, 0);

        button = new JButton("Save");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2; // Span across two columns
        button.addActionListener(this);
        panel.add(button, constraints);
    }

    private void createSuccessLabel() {
        success = new JLabel("Not Submitted Yet");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2; // Span across two columns
        panel.add(success, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        success.setText("Saved Successfully!");
    }
}
