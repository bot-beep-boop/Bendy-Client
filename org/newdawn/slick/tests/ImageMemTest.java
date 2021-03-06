package org.newdawn.slick.tests;

import org.newdawn.slick.*;

public class ImageMemTest extends BasicGame
{
    public ImageMemTest() {
        super("Image Memory Test");
    }
    
    @Override
    public void init(final GameContainer container) throws SlickException {
        try {
            Image img = new Image(2400, 2400);
            img.getGraphics();
            img.destroy();
            img = new Image(2400, 2400);
            img.getGraphics();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void render(final GameContainer container, final Graphics g) {
    }
    
    @Override
    public void update(final GameContainer container, final int delta) {
    }
    
    public static void main(final String[] argv) {
        try {
            final AppGameContainer container = new AppGameContainer(new ImageMemTest());
            container.setDisplayMode(800, 600, false);
            container.start();
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
