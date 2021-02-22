package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;
/**
 * Handles the orb body that is a projectile.
 */

public class Orb extends DynamicBody {

    private static final Shape shape = new PolygonShape(-0.015f, 0.451f, 0.433f, 0.241f, 0.434f, -0.222f, 0.128f, -0.406f, -0.175f, -0.41f, -0.48f, 0.061f);
    private static final BodyImage image
            = new BodyImage("data/purpleorb.gif", 1);
    

    public Orb(World world) {
        super(world, shape);
        addImage(image);
    }
}
