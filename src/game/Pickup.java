package game;

import city.cs.engine.*;
/**
 * Handles all the pickups in the game.
 */

public class Pickup implements CollisionListener {

    private Player player;
    private Controller controller;

    public Pickup(Player player) {
        this.player = player;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == player) {
            if (e.getReportingBody() instanceof Star) {
                player.incrementStarCount();
            } else if (e.getReportingBody() instanceof Enemy) {
                player.decreaseLifeCount();
            } else if (e.getReportingBody() instanceof Heart) {
                player.increaseLifeCount();
            } else if (e.getReportingBody() instanceof Key) {
                player.incrementKeyCount();
            } else if (e.getReportingBody() instanceof Boss) {
                System.out.println("GAME OVER");
                System.exit(0);
            }else if (e.getReportingBody() instanceof Booster){
            controller.setWalkingSpeed(12);
            controller.setJumpingSpeed(20);
        }
            e.getReportingBody().destroy();
        }
    }
}
