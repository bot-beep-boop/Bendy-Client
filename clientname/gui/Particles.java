package clientname.gui;

import java.util.*;
import java.awt.*;
import net.minecraft.client.gui.*;

public class Particles
{
    private final List<Particle> particles;
    private int width;
    private int height;
    private int count;
    
    public Particles(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.count = 70;
        this.particles = new ArrayList<Particle>();
        for (int count = 0; count <= this.count; ++count) {
            this.particles.add(new Particle(new Random().nextInt(width), new Random().nextInt(height)));
        }
    }
    
    public void drawParticles() {
        this.particles.forEach(particle -> particle.drawParticle());
    }
    
    public class Particle
    {
        private int xPos;
        private int yPos;
        
        public Particle(final int xPos, final int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }
        
        public void drawParticle() {
            ++this.xPos;
            ++this.yPos;
            final int particleSize = 1;
            if (this.xPos > Particles.this.width) {
                this.xPos = -1;
            }
            if (this.yPos > Particles.this.height) {
                this.yPos = -1;
            }
            Gui.drawRect(this.xPos, this.yPos, this.xPos + 1, this.yPos + 1, Color.white.getRGB());
        }
    }
}
