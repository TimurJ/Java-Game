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
 * Handles the heart objects in game.
 */

public class Heart extends DynamicBody {

    private static SoundClip healthSound;

    static {
        try {
            healthSound = new SoundClip("data/Health.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final Shape shape = new PolygonShape(-0.021f, -0.896f, 0.948f, -0.258f, 0.851f, 0.893f, -0.959f, 0.89f, -0.889f, -0.411f);
    private static final BodyImage image
            = new BodyImage("data/Heart.gif", 2);

    public Heart(World world) {
        super(world, shape);
        addImage(image);
    }
    @Override
    public void destroy() {
        healthSound.play();
        super.destroy();
    }
}
