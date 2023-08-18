

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResturantbillGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
	private JCheckBox pizzaCheckBox, burgerCheckBox, teaCheckBox;
    private JLabel label;
    private JButton orderButton;

    public ResturantbillGUI() {
        setTitle("Food Ordering System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        label = new JLabel("Food Ordering System");
        pizzaCheckBox = new JCheckBox("Pizza @100");
        burgerCheckBox = new JCheckBox("Burger @30");
        teaCheckBox = new JCheckBox("Tea @10");
        orderButton = new JButton("Order");

        orderButton.addActionListener(this);

        add(label);
        add(pizzaCheckBox);
        add(burgerCheckBox);
        add(teaCheckBox);
        add(orderButton);

        setVisible(true);
        setLocationRelativeTo(null);
//        pack();
    }

    public void actionPerformed(ActionEvent e) {
        double amount = 0;
        StringBuilder msg = new StringBuilder();

        if (pizzaCheckBox.isSelected()) {
            msg.append("Pizza: 100\n");
            amount += 100;
        }
        if (burgerCheckBox.isSelected()) {
            msg.append("Burger: 30\n");
            amount += 30;
        }
        if (teaCheckBox.isSelected()) {
            msg.append("Tea: 10\n");
            amount += 10;
        }
        msg.append("--------------------\n");
        msg.append(String.format("Total: %.2f", amount));

        JOptionPane.showMessageDialog(this, msg.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ResturantbillGUI::new); //maintain proper synchronization and avoid potential threading issues in Swing applications.
    }
}
