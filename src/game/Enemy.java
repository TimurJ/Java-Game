/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A enemy class that handles enemy bodies.
 */ 

public class Enemy extends DynamicBody {
    private static SoundClip enemySound;
    
    static {
        try {
            enemySound = new SoundClip("data/Enemy.wav");
            System.out.println("Loading star sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final Shape shape = new PolygonShape(0.007f, 0.982f, 1.048f, 0.341f, 0.791f, -0.894f, -0.725f, -0.923f, -1.07f, 0.344f);
    private static final BodyImage image
            = new BodyImage("data/Enemy.gif", 2);

    public Enemy(World world) {
        super(world, shape);
        addImage(image);
    }
     @Override
    public void destroy() {
        enemySound.play();
        super.destroy();
    }

}
