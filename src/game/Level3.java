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
 * initiates Level 3.
 */
public class Level3 extends GameLevel{
    
    private static final int NUM_STARS = 4;
    private static final int NUM_KEYS = 0;
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
        platform1.setPosition(new Vec2(25, -8));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(-25, -8));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(15, -3));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(-15, -3));
        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(0, 2));
        Body platform6 = new StaticBody(this, boxShape);
        platform6.setPosition(new Vec2(20, 10));
        
        DynamicBody boss = new Boss(this);
        boss.setPosition(new Vec2(0, 10));
        boss.addCollisionListener(new Pickup(getPlayer()));

        DynamicBody enemy1 = new Enemy(this);
        enemy1.setPosition(new Vec2(-25, 0));
        enemy1.addCollisionListener(new Pickup(getPlayer()));
        enemy1.addCollisionListener(new KillEnemy(enemy));

        DynamicBody enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(25, 0));
        enemy2.addCollisionListener(new Pickup(getPlayer()));
        enemy2.addCollisionListener(new KillEnemy(enemy));

       
        for (int i = 0; i < 2; i++) {
            Body star = new Star(this);
            star.setPosition(new Vec2(i * 3 - 17, 8));
            star.addCollisionListener(new Pickup(getPlayer()));
        }
        for (int i = 0; i < 2; i++) {
            Body star = new Star(this);
            star.setPosition(new Vec2(i * 3 + 14, 8));
            star.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(22, 12);
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