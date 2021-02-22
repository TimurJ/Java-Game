package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * initiates Level 1.
 */

public class Level1 extends GameLevel {

    private static final int NUM_STARS = 3;
    private static final int NUM_KEYS = 0;
    private Enemy enemy;

    @Override
    public void populate(Game game) {
        super.populate(game);

        Shape groundShape = new BoxShape(31, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -14.8f));
        Shape topShape = new BoxShape(32, 0.5f);
        Body top = new StaticBody(this, topShape);
        top.setPosition(new Vec2(0, 14.8f));

        Shape leftWallShape = new BoxShape(0.5f, 15, new Vec2(-31.8f, 14.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 15, new Vec2(31.8f, 14.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        Shape boxShape = new BoxShape(5, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(5, 6));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(22, -4));
        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(13, 1));
        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(-10, 7));
        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(-25, 0));
        Body platform6 = new StaticBody(this, boxShape);
        platform6.setPosition(new Vec2(-13, -7));

        DynamicBody enemy1 = new Enemy(this);
        enemy1.setPosition(new Vec2(-10, 10));
        enemy1.addCollisionListener(new Pickup(getPlayer()));
        enemy1.addCollisionListener(new KillEnemy(enemy));

        DynamicBody enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(-12, 0));
        enemy2.addCollisionListener(new Pickup(getPlayer()));
        enemy2.addCollisionListener(new KillEnemy(enemy));

        DynamicBody enemy3 = new Enemy(this);
        enemy3.setPosition(new Vec2(-25, 10));
        enemy3.addCollisionListener(new Pickup(getPlayer()));
        enemy3.addCollisionListener(new KillEnemy(enemy));

        DynamicBody heart1 = new Heart(this);
        heart1.setPosition(new Vec2(-8, 10));
        heart1.addCollisionListener(new Pickup(getPlayer()));

        DynamicBody heart2 = new Heart(this);
        heart2.setPosition(new Vec2(-23, 10));
        heart2.addCollisionListener(new Pickup(getPlayer()));

        DynamicBody heart3 = new Heart(this);
        heart3.setPosition(new Vec2(20, 10));
        heart3.addCollisionListener(new Pickup(getPlayer()));

        for (int i = 0; i < 3; i++) {
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(i * 3 + 10, 4));
            enemy.addCollisionListener(new Pickup(getPlayer()));
            enemy.addCollisionListener(new KillEnemy(enemy));
        }
        for (int i = 0; i < NUM_STARS; i++) {
            Body star = new Star(this);
            star.setPosition(new Vec2(i * 3 + 2, 13));
            star.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(25, -2);
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
