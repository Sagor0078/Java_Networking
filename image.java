

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class image extends JFrame {
    private JLabel label1, label2;
    public image() throws IOException {
        setLayout(new GridLayout(2, 1)); // Two rows, one column
        // First Image
        File file = new File("/home/sagor/Pictures/Screenshots/img.png");
        BufferedImage imageRead = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(imageRead);
        label1 = new JLabel(imageIcon);
        add(label1);

        // Second Image
        File file2 = new File("/home/sagor/Pictures/Screenshots/imageScreen.png");
        BufferedImage imageRead2 = ImageIO.read(file2);
        ImageIcon imageIcon2 = new ImageIcon(imageRead2);
        label2 = new JLabel(imageIcon2);
        add(label2);

        setTitle("Image Processing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            try {
                new image();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
