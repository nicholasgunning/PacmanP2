package pacman.model.entity.staticentity.collectable.decorator;

import javafx.scene.image.Image;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.BoundingBoxImpl;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.staticentity.StaticEntityImpl;

/**
 * Concrete decorator for creating Power Pellets - special pellets that grant
 * Pac-Man the ability to eat ghosts. Power Pellets are larger than normal
 * pellets,
 * worth more points, and have special gameplay effects.
 */
public class PowerPellet extends PelletDecorator implements Collectable {

    /**
     * Visual and gameplay constants for Power Pellets
     */
    private static final Image pelletImage = new Image("maze/pellet.png");
    private static final double sizeMultiplier = 2.0; // Power pellets are 2x normal size
    private static final int points = 50; // Points awarded for collecting
    private static final Vector2D offset = new Vector2D(-8, -8); // Position offset to center larger pellet

    private boolean isCollectable;
    private final Vector2D originalPosition;

    /**
     * Creates a new Power Pellet by decorating a base pellet
     * 
     * @param collectable The base pellet to be enhanced into a Power Pellet
     */
    public PowerPellet(Collectable collectable) {
        super(collectable);
        this.collectable = collectable;
        this.isCollectable = true;
        this.originalPosition = collectable.getPosition();
    }

    /**
     * Handles collection of the Power Pellet by making it invisible
     */
    @Override
    public void collect() {
        this.isCollectable = false;
        setLayer(Layer.INVISIBLE);
    }

    @Override
    public boolean isCollectable() {
        return this.isCollectable;
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }

    /**
     * @return Points awarded for collecting this Power Pellet
     */
    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public Image getImage() {
        return pelletImage;
    }

    /**
     * @return Width scaled by size multiplier for larger appearance
     */
    @Override
    public double getWidth() {
        return super.getWidth() * sizeMultiplier;
    }

    /**
     * @return Height scaled by size multiplier for larger appearance
     */
    @Override
    public double getHeight() {
        return super.getHeight() * sizeMultiplier;
    }

    /**
     * @return Position adjusted by offset to center the larger pellet
     */
    @Override
    public Vector2D getPosition() {
        Vector2D basePosition = super.getPosition();
        return basePosition.add(offset);
    }

    /**
     * Creates a new bounding box adjusted for the Power Pellet's larger size
     */
    @Override
    public BoundingBox getBoundingBox() {
        BoundingBox baseBoundingBox = super.getBoundingBox();
        Vector2D newPosition = getPosition();
        return new BoundingBoxImpl(newPosition, getHeight(), getWidth());
    }

    /**
     * Resets the Power Pellet to its initial collectable state
     */
    @Override
    public void reset() {
        this.isCollectable = true;
        setLayer(Layer.BACKGROUND);
    }
}