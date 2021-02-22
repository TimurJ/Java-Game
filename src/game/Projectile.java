/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.WorldView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.jbox2d.common.Vec2;
/**
 * handles projectile that can kill enemies.
 */

public class Projectile extends MouseAdapter {

    private WorldView view;
    private Enemy enemy;

    public Projectile(WorldView view, Enemy enemy) {
        this.view = view;
        this.enemy = enemy;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        DynamicBody orb = new Orb(view.getWorld());
        orb.setPosition(view.viewToWorld(e.getPoint()));
        orb.setLinearVelocity(new Vec2(100f, 0f));
        orb.addCollisionListener(new KillEnemy(enemy));
    }
}
