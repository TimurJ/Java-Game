package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Handles the player body and the star health values.
 */

public class Player extends Walker {

    private static final Shape shape = new PolygonShape(
            0.18f,1.5f, 0.68f,0.3f, 0.73f,-1.41f, -0.63f,-1.44f, -0.8f,0.86f);
    private static final BodyImage image
            = new BodyImage("data/scorp.gif", 3);

    private int starCount;
    private int lifeCount;
    private int keyCount;

    public Player(World world) {
        super(world, shape);
        addImage(image);
        starCount = 0;
        lifeCount = 3;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    public void decreaseLifeCount() {
        lifeCount--;
        System.out.println("Lost Life = " + lifeCount);
    }

    public void increaseLifeCount() {
        lifeCount++;
        System.out.println("Gained Life = " + lifeCount);
    }

    public int getStarCount() {
        return starCount;
    }

    public void incrementStarCount() {
        starCount++;
        System.out.println("Energy Increased = " + starCount);
    }
    public int getKeyCount(){
        return keyCount;
    }
     public void incrementKeyCount() {
        keyCount++;
        System.out.println("  Key Aquired  ");
    }
     public void setLifeCount(int lifeCount){
         this.lifeCount = lifeCount;
     }
     public void setStarCount(int starCount){
         this.starCount = starCount;
     }
}
