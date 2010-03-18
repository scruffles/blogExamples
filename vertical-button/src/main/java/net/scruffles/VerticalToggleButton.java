package net.scruffles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JToggleButton;

public class VerticalToggleButton
        extends JToggleButton
{

    public enum Rotation {
        CLOCKWISE, COUNTER_CLOCKWISE
    }

    private Rotation rotation = Rotation.COUNTER_CLOCKWISE;

    public VerticalToggleButton(String text, Rotation rotation) {
        super(text);
        this.rotation = rotation;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        setSize(getHeight(), getWidth());

        Graphics2D g2 = (Graphics2D)g.create();

        Dimension d = getSize();
        if (rotation == Rotation.CLOCKWISE) {
            g2.rotate(Math.PI / 2.0);
            g2.translate(0, -getSize().height);
        }
        else {
            g2.translate(0, getSize().width);
            g2.rotate(-Math.PI / 2.0);
        }
        super.paintComponent(g2);
        g2.dispose();

        setSize(getHeight(), getWidth());
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension p = super.getPreferredSize();
        return new Dimension(p.height, p.width);
    }
}