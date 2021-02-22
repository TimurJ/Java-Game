package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * A class that handles the different inputs for player controls.
 */

public class Controller extends KeyAdapter {

    private  float JUMPING_SPEED = 13;
    private  float WALKING_SPEED = 6;
    private SoundClip jumpSound;
    
    
    private Walker body;

    public Controller(Walker body) {
        this.body = body;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE) { // Escape = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE) { // Space = jump
            Vec2 v = body.getLinearVelocity();
             try {
            jumpSound = new SoundClip("data/Jump.mp3");
            jumpSound.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
            System.out.println(a);
        }
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // A = walk left
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // B = walk right
        }
    }
    public float setWalkingSpeed(float walkingSpeed){
        walkingSpeed = WALKING_SPEED;
        return WALKING_SPEED;
    }
    public float setJumpingSpeed(float jumpingSpeed){
        jumpingSpeed = JUMPING_SPEED;
        return JUMPING_SPEED;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
        }
    }
    public void setBody(Walker body) {
        this.body = body;
    }
}
