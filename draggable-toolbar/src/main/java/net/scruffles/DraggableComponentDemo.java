package net.scruffles;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

/**
 * Hello world!
 */
public class DraggableComponentDemo {
    public static void main(String[] args) {
        openInFrame();
        openInDialog();
    }

    private static void openInDialog() {
        JMenuBar menuBar = createMenuBar();
        new DragFrameByComponentListener().applyListener(menuBar);
        JToolBar toolBar = createToolBar();
        new DragFrameByComponentListener().applyListener(toolBar);
        displayInDialog(menuBar, toolBar, "Dialog");
    }

    private static void openInFrame() {
        JMenuBar menuBar = createMenuBar();
        new DragFrameByComponentListener().applyListener(menuBar);
        JToolBar toolBar = createToolBar();
        new DragFrameByComponentListener().applyListener(toolBar);
        displayInFrame(menuBar, toolBar, "Frame");
    }

    private static void displayInDialog(JMenuBar menuBar, JToolBar toolBar, String title) {
        JDialog dialog = new JDialog();
        dialog.setTitle(title);
        dialog.setJMenuBar(menuBar);
        dialog.add(new JLabel(title, JLabel.CENTER), BorderLayout.CENTER);
        dialog.add(toolBar, BorderLayout.NORTH);
        dialog.setSize(400, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    private static void displayInFrame(JMenuBar menuBar, JToolBar toolBar, String title) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setJMenuBar(menuBar);
        frame.add(toolBar, BorderLayout.NORTH);
        frame.add(new JLabel(title, JLabel.CENTER), BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JMenu("File"));
        menuBar.add(new JMenu("Edit"));
        menuBar.add(new JMenu("View"));
        menuBar.add(new JMenu("Help"));
        return menuBar;
    }

    private static JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(new JButton("Save"));
        return toolBar;
    }
}