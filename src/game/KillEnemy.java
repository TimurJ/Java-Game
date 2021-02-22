/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * allows the player to kill enemies with projectiles.
 */

public class KillEnemy implements CollisionListener {

    private Orb orb;
    private Enemy enemy;

    public KillEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == enemy) {
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
        }
    }
}
