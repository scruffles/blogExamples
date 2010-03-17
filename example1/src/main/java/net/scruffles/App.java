package net.scruffles;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Example 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(new JLabel("Hello World"));
        frame.setVisible(true);
    }
}
