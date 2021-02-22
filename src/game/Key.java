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
 * handles the key objects in game.
 */

public class Key extends DynamicBody {

    private static final Shape shape = new PolygonShape(0.248f,0.864f, 0.928f,-0.012f, 0.264f,-0.844f, -0.764f,-0.388f, -0.668f,0.616f);
    private static final BodyImage image
            = new BodyImage("data/Key.gif", 2);

    public Key(World world) {
        super(world, shape);
        addImage(image);
    }
}