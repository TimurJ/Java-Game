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
 * A booster pickup which gives the player heightened speed and jumping ability.
 */
public class Booster extends DynamicBody {
    private static final Shape shape = new PolygonShape(0.003f,0.922f, 0.773f,0.548f, 0.775f,-0.437f, 0.55f,-0.775f, -0.805f,-0.762f, -0.807f,0.553f);
    private static final BodyImage image
            = new BodyImage("data/pickup.gif", 2);
    
     public Booster(World world) {
        super(world, shape);
        addImage(image);
    }
}
