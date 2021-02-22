package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * a class that increases the player score upon contact.
 */

public class Star extends DynamicBody {

    private static SoundClip starSound;
    
    static {
        try {
            starSound = new SoundClip("data/Star.mp3");
            System.out.println("Loading star sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    
    private static final Shape shape = new PolygonShape(0.007f, 0.982f, 1.048f, 0.341f, 0.791f, -0.894f, -0.725f, -0.923f, -1.07f, 0.344f);
    private static final BodyImage image
            = new BodyImage("data/Star.gif", 2);

    public Star(World world) {
        super(world, shape);
        addImage(image);
    }

    @Override
    public void destroy() {
        starSound.play();
        super.destroy();
    }
}
