/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;
/**
 * A boss DynamicBody which is present in level 3 and is able to kill the player upon contact.
 */

public class Boss extends DynamicBody {

    private static final Shape shape = new PolygonShape(0.36f,3.92f, 2.64f,-0.01f, 1.71f,-3.6f, -2.8f,-3.77f, -2.95f,1.66f);
    private static final BodyImage image
            = new BodyImage("data/boss.gif", 8);

    public Boss(World world) {
        super(world, shape);
        addImage(image);
    }

}