package pacman.model.entity.staticentity.collectable.decorator;

import javafx.scene.image.Image;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.BoundingBoxImpl;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.staticentity.StaticEntityImpl;

public class PowerPellet extends StaticEntityImpl implements Collectable {

    private static final Image pelletImage = new Image("maze/pellet.png");
    private static final double sizeMultiplier = 2.0;
    private static final int points = 50;
    private static final Vector2D offset = new Vector2D(-8, -8);
    private boolean isCollectable;

    public PowerPellet(Collectable collectable) {
        super(collectable.getBoundingBox(), collectable.getLayer(), collectable.getImage());
    }

    @Override
    public void collect() {
        this.isCollectable = false;
        setLayer(Layer.INVISIBLE);
    }

    @Override
    public boolean isCollectable() {
        return true;
    }

    @Override
    public boolean canPassThrough() {
        return this.isCollectable();
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public Image getImage() {
        return pelletImage;
    }

    @Override
    public double getWidth() {
        return super.getWidth() * sizeMultiplier;
    }

    @Override
    public double getHeight() {
        return super.getHeight() * sizeMultiplier;
    }

    @Override
    public Vector2D getPosition() {
        Vector2D basePosition = super.getPosition();
        return basePosition.add(offset);
    }

    @Override
    public BoundingBox getBoundingBox() {
        BoundingBox baseBoundingBox = super.getBoundingBox();
        Vector2D newPosition = getPosition();
        return new BoundingBoxImpl(newPosition, getHeight(), getWidth());
    }

    @Override
    public void reset() {
        this.isCollectable = true;
        setLayer(Layer.BACKGROUND);
    }
}