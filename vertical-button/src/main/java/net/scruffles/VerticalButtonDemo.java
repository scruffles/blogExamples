package net.scruffles;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Hello world!
 */
public class VerticalButtonDemo {
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Vertical Toggle Buttons");
        frame.setJMenuBar(createLookAndFeelMenu());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.add(new VerticalToggleButton("Counter ClockWise", VerticalToggleButton.Rotation.COUNTER_CLOCKWISE));
        panel.add(new JToggleButton("JToggleButton"));
        panel.add(new VerticalToggleButton("ClockWise", VerticalToggleButton.Rotation.CLOCKWISE));

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static JMenuBar createLookAndFeelMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Look and Feel");
        menu.add(createLnfAction("NimbusLookAndFeel", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"));
        menu.add(createLnfAction("Metal", "javax.swing.plaf.metal.MetalLookAndFeel"));
        menu.add(createLnfAction("System", UIManager.getSystemLookAndFeelClassName()));
        menu.add(createLnfAction("GTKLookAndFeel", "com.sun.java.swing.plaf.gtk.GTKLookAndFeel"));
        menu.add(createLnfAction("MotifLookAndFeel", "com.sun.java.swing.plaf.motif.MotifLookAndFeel"));
        menuBar.add(menu);
        return menuBar;
    }

    private static Action createLnfAction(String title, final String className) {
        return new AbstractAction(title) {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(className);
                    SwingUtilities.updateComponentTreeUI(frame);
                    frame.pack();
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        };
    }
}
