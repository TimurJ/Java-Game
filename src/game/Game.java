package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;
/**
 * A game class where everything comes together.
 */
public class Game {

    private GameLevel world;
    private UserView view;
    private int level;
    private Controller controller;
    private SoundClip gameMusic;
    private JFrame frame;
    private Player player;

    public Game() {
        level = 1;
        world = new Level1();
        world.populate(this);

        try {
            gameMusic = new SoundClip("data/sound.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        frame = new JFrame("Multi-level game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view = new MyView(world, world.getPlayer(), Game.this, 1250, 570);

        frame.setLocationByPlatform(true);
        frame.add(view);
        ControlPanel controlPanel = new ControlPanel();
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.requestFocus();
        view.addMouseListener(new GiveFocus(frame));
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        view.addMouseListener(new Projectile(view, world.getEnemy()));

        // uncomment to make the view track the bird
        //world.addStepListener(new Tracker(view, world.getPlayer()));
        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 1500, 800);
        world.start();
    }

    public JFrame getFrame() {

        return frame;
    }

    public SoundClip getMusic() {
        return gameMusic;
    }

    public GameLevel getWorld() {
        return world;
    }

    public int getLevel() {
        return level;
    }

    public int setLevel(int level) {
        this.level = level;
        return 1;
    }

    public Player getPlayer() {
        return world.getPlayer();
    }

    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    public boolean isKeyAquired() {
        return world.keyAquired();
    }

    public void goNextLevel() {
        world.stop();
        if (level == 1) {
            level++;
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
            player.setLifeCount(3);
            player.setStarCount(0);
        } else if (level == 2) {
            level++;
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
            player.setLifeCount(3);
            player.setStarCount(0);
        } else if (level == 3) {
            level++;
            world = new Level4();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
            player.setLifeCount(3);
            player.setStarCount(0);
        } else if (level == 4) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
