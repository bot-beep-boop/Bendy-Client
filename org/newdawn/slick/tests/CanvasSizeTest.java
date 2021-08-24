package org.newdawn.slick.tests;

import org.newdawn.slick.*;
import java.awt.*;
import java.awt.event.*;
import org.newdawn.slick.util.*;

public class CanvasSizeTest extends BasicGame
{
    public CanvasSizeTest() {
        super("Test");
    }
    
    @Override
    public void init(final GameContainer container) throws SlickException {
        System.out.println(container.getWidth() + ", " + container.getHeight());
    }
    
    public void render(final GameContainer container, final Graphics g) throws SlickException {
    }
    
    @Override
    public void update(final GameContainer container, final int delta) throws SlickException {
    }
    
    public static void main(final String[] args) {
        try {
            final CanvasGameContainer container = new CanvasGameContainer(new CanvasSizeTest());
            container.setSize(640, 480);
            final Frame frame = new Frame("Test");
            frame.setLayout(new GridLayout(1, 2));
            frame.add(container);
            frame.pack();
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(final WindowEvent e) {
                    System.exit(0);
                }
            });
            frame.setVisible(true);
            container.start();
        }
        catch (Exception e) {
            Log.error(e);
        }
    }
}
