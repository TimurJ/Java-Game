/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Handles the portal body which enables the player to progress.
 */

public class Portal extends StaticBody {

    private static SoundClip portalSound;

    static {
        try {
            portalSound = new SoundClip("data/portal.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Portal(World world) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/portal.gif", 2.8f));
        portalSound.play();
    }
}
