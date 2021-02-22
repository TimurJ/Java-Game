/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;
/**
 * initiates Level 2.
 */
public class Level2 extends GameLevel {

    private static final int NUM_STARS = 6;
    private static final int NUM_KEYS = 1;
    private Enemy enemy;

    @Override
    public void populate(Game game) {
        super.populate(game);

        Shape groundShape = new BoxShape(31, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -14.5f));
        Shape topShape = new BoxShape(32, 0.5f);
        Body top = new StaticBody(this, topShape);
        top.setPosition(new Vec2(0, 14.8f));

        Shape leftWallShape = new BoxShape(0.5f, 15, new Vec2(-31.5f, 14.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 15, new Vec2(31.5f, 14.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        Shape boxShape = new BoxShape(5, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(22, 10));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(22, -7));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(8, 2));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(-20, -7));
        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(-6, -3));
        Body platform6 = new StaticBody(this, boxShape);
        platform6.setPosition(new Vec2(-20, 7));

        DynamicBody key = new Key(this);
        key.setPosition(new Vec2(30, -10));
        key.addCollisionListener(new Pickup(getPlayer()));

        DynamicBody enemy3 = new Enemy(this);
        enemy3.setPosition(new Vec2(7, 5));
        enemy3.addCollisionListener(new Pickup(getPlayer()));
        enemy3.addCollisionListener(new KillEnemy(enemy));

        DynamicBody enemy1 = new Enemy(this);
        enemy1.setPosition(new Vec2(-7, 5));
        enemy1.addCollisionListener(new Pickup(getPlayer()));
        enemy1.addCollisionListener(new KillEnemy(enemy));

        DynamicBody enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(-22, 5));
        enemy2.addCollisionListener(new Pickup(getPlayer()));
        enemy2.addCollisionListener(new KillEnemy(enemy));

        //for (int i = 0; i < 2; i++) {
        //   enemy = new Enemy(this);
        //    enemy.setPosition(new Vec2(i * 3 + 10, 4));
        //   enemy.addCollisionListener(new Pickup(getPlayer()));
        //   enemy.addCollisionListener(new KillEnemy(enemy));
        // }
        for (int i = 0; i < 3; i++) {
            Body star = new Star(this);
            star.setPosition(new Vec2(i * 3 + 19, 0));
            star.addCollisionListener(new Pickup(getPlayer()));
        }
        for (int i = 0; i < 3; i++) {
            Body star = new Star(this);
            star.setPosition(new Vec2(i * 3 - 23, 12));
            star.addCollisionListener(new Pickup(getPlayer()));
        }
        for (int i = 0; i < 3; i++) {
            Body heart = new Heart(this);
            heart.setPosition(new Vec2(i * 15 - 20, 5));
            heart.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-30, -12);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(25, 12);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getStarCount() == NUM_STARS;
    }

    @Override
    public boolean keyAquired() {
        return getPlayer().getKeyCount() == NUM_KEYS;
    }
}
