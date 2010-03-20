package net.scruffles;

import java.awt.Component;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class DragFrameByComponentListener
        extends MouseAdapter
{
    private Point clickStartPoint;
    private Point frameStartPoint;
    private Window window;

    @Override
    public void mousePressed(MouseEvent e) {
        if (window == null) {
            window = SwingUtilities.getWindowAncestor((Component)e.getSource());
        }
        clickStartPoint = e.getLocationOnScreen();
          frameStartPoint = window.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        frameStartPoint = null;
        clickStartPoint = null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (window == null) {
            window = SwingUtilities.getWindowAncestor((Component)e.getSource());
        }
        if (frameStartPoint != null) {
            int changeInY = e.getLocationOnScreen().y - clickStartPoint.y;
            int changeInX = e.getLocationOnScreen().x - clickStartPoint.x;
            window.setLocation(frameStartPoint.x + changeInX, frameStartPoint.y + changeInY);
        }
    }

    public void applyListener(JComponent component) {
        component.addMouseListener(this);
        component.addMouseMotionListener(this);
    }
}
