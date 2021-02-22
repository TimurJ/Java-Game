/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * Allows the player to move to next level upon contact with portal.
 */

public class PortalListener implements CollisionListener{
    private Game game;
    
    public PortalListener(Game game) {
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        Player player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted() && game.isKeyAquired()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}
