


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class teacherRegistration extends JFrame implements ActionListener {
    JLabel nameLabel, emailLabel, phoneLabel;
    JTextField nameField, emailField, phoneField;
    JButton submitButton;
    
    Connection con;
    PreparedStatement pstmt;

    teacherRegistration() {
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        phoneLabel = new JLabel("Phone:");

        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Set up the GUI layout
        setLayout(new GridLayout(4, 2));
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(phoneLabel);
        add(phoneField);
        add(submitButton);

        setTitle("Teacher Registration Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Establish the database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherreg", "main", "sagor0078");
            pstmt = con.prepareStatement("INSERT INTO teacherinfo (name, email, phone) VALUES (?, ?, ?)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            try {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, phone);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Record inserted successfully!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new teacherRegistration();
    }
}