package org.newdawn.slick.state.transition;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class EmptyTransition implements Transition
{
    public boolean isComplete() {
        return true;
    }
    
    public void postRender(final StateBasedGame game, final GameContainer container, final Graphics g) throws SlickException {
    }
    
    public void preRender(final StateBasedGame game, final GameContainer container, final Graphics g) throws SlickException {
    }
    
    public void update(final StateBasedGame game, final GameContainer container, final int delta) throws SlickException {
    }
    
    public void init(final GameState firstState, final GameState secondState) {
    }
}
