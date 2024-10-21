package pacman.model.factories;

import javafx.scene.image.Image;
import pacman.ConfigurationParseException;
import pacman.model.entity.Renderable;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.BoundingBoxImpl;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.staticentity.collectable.decorator.Collectable;
import pacman.model.entity.staticentity.collectable.decorator.Pellet;
import pacman.model.entity.staticentity.collectable.decorator.PowerPellet;

/**
 * Concrete renderable factory for Pellet objects
 */
public class PelletFactory implements RenderableFactory {
    private static final Image PELLET_IMAGE = new Image("maze/pellet.png");
    private static final int PELLET_POINTS = 10;
    private final Renderable.Layer layer = Renderable.Layer.BACKGROUND;
    private char type;

    public PelletFactory(char type) {
        this.type = type;
    }

    @Override
    public Renderable createRenderable(Vector2D position) {
        try {
            BoundingBox boundingBox = new BoundingBoxImpl(
                    position,
                    PELLET_IMAGE.getHeight(),
                    PELLET_IMAGE.getWidth()
            );
            Collectable pellet = new Pellet(
                    boundingBox,
                    layer,
                    PELLET_IMAGE,
                    PELLET_POINTS
            );

            if (type == 'z') {
                Collectable powerPellet = new PowerPellet(pellet);
                return powerPellet;
            } else {
                return pellet;
            }
        } catch (Exception e) {
            throw new ConfigurationParseException(
                    String.format("Invalid pellet configuration | %s", e));
        }
    }
}