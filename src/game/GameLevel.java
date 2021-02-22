/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;
/**
 * A game level class that has the generals of all levels.
 */

public abstract class GameLevel extends World {

    private Player player;
    private Enemy enemy;

    public Player getPlayer() {
        return player;
    }
    public Enemy getEnemy(){
        return enemy;
    }

    public void populate(Game game) {
        player = new Player(this);
        player.setPosition(startPosition());
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalListener(game));
    }

    public abstract Vec2 startPosition();

    public abstract Vec2 portalPosition();

    public abstract boolean isCompleted();
    
    public abstract boolean keyAquired();

}
