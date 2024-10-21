package pacman.model.entity.staticentity.collectable.decorator;

import javafx.scene.image.Image;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.Vector2D;


public abstract class PelletDecorator implements Collectable {
    protected Collectable collectable;

    public PelletDecorator(Collectable collectable) {
        this.collectable = collectable;
    }

    @Override
    public void collect() {
        collectable.collect();
    }

    @Override
    public boolean isCollectable() {
        return collectable.isCollectable();
    }

    @Override
    public int getPoints() {
        return collectable.getPoints();
    }

    @Override
    public Image getImage() {
        return collectable.getImage();
    }

    @Override
    public double getWidth() {
        return collectable.getWidth();
    }

    @Override
    public double getHeight() {
        return collectable.getHeight();
    }

    @Override
    public Vector2D getPosition() {
        return collectable.getPosition();
    }

    @Override
    public Layer getLayer() {
        return collectable.getLayer();
    }

    @Override
    public BoundingBox getBoundingBox() {
        return collectable.getBoundingBox();
    }

    @Override
    public void reset() {
        collectable.reset();
    }
}