package pacman.model.factories;

import javafx.scene.image.Image;
import pacman.ConfigurationParseException;
import pacman.model.entity.Renderable;
import pacman.model.entity.dynamic.ghost.GhostImpl;
import pacman.model.entity.dynamic.ghost.GhostMode;
import pacman.model.entity.dynamic.ghost.strategies.*;
import pacman.model.entity.dynamic.physics.*;

import java.util.Arrays;
import java.util.List;

/**
 * Concrete renderable factory for Ghost objects
 */
public class GhostFactory implements RenderableFactory {

    private static final int RIGHT_X_POSITION_OF_MAP = 448;
    private static final int TOP_Y_POSITION_OF_MAP = 16 * 3;
    private static final int BOTTOM_Y_POSITION_OF_MAP = 16 * 34;

    private static final Image BLINKY_IMAGE = new Image("maze/ghosts/blinky.png");
    private static final Image INKY_IMAGE = new Image("maze/ghosts/inky.png");
    private static final Image CLYDE_IMAGE = new Image("maze/ghosts/clyde.png");
    private static final Image PINKY_IMAGE = new Image("maze/ghosts/pinky.png");
    private final Image GHOST_IMAGE;
    private final ChaseBehaviour chaseBehaviour;
    private Vector2D targetCorner;
    private char GhostType;

    public GhostFactory(char renderableType) {

        List<Vector2D> targetCorners = Arrays.asList(
                new Vector2D(0, TOP_Y_POSITION_OF_MAP),
                new Vector2D(RIGHT_X_POSITION_OF_MAP, TOP_Y_POSITION_OF_MAP),
                new Vector2D(0, BOTTOM_Y_POSITION_OF_MAP),
                new Vector2D(RIGHT_X_POSITION_OF_MAP, BOTTOM_Y_POSITION_OF_MAP)
        );


        switch (renderableType) {
            case RenderableType.BLINKY:
                chaseBehaviour = new BlinkyChaseBehaviour();
                GHOST_IMAGE = BLINKY_IMAGE;
                this.targetCorner = targetCorners.get(1);
                GhostType = RenderableType.BLINKY;
                break;
            case RenderableType.INKY:
                chaseBehaviour = new InkyChaseBehaviour();
                GHOST_IMAGE = INKY_IMAGE;
                this.targetCorner = targetCorners.get(3);
                GhostType = RenderableType.INKY;
                break;
            case RenderableType.CLYDE:
                chaseBehaviour = new ClydeChaseBehaviour();
                GHOST_IMAGE = CLYDE_IMAGE;
                this.targetCorner = targetCorners.get(2);
                GhostType = RenderableType.CLYDE;
                break;
            case RenderableType.PINKY:
                chaseBehaviour = new PinkyChaseBehaviour();
                GHOST_IMAGE = PINKY_IMAGE;
                this.targetCorner = targetCorners.get(0);
                GhostType = RenderableType.PINKY;
                break;
            default:
                throw new ConfigurationParseException(
                        String.format("Invalid ghost configuration | %s ", renderableType));
        }
    }




    @Override
    public Renderable createRenderable(
            Vector2D position
    ) {

        try {
            position = position.add(new Vector2D(4, -4));

            BoundingBox boundingBox = new BoundingBoxImpl(
                    position,
                    GHOST_IMAGE.getHeight(),
                    GHOST_IMAGE.getWidth()
            );

            KinematicState kinematicState = new KinematicStateImpl.KinematicStateBuilder()
                    .setPosition(position)
                    .build();




            return new GhostImpl(
                    GHOST_IMAGE,
                    boundingBox,
                    kinematicState,
                    GhostMode.SCATTER,
                    targetCorner,
                    chaseBehaviour,
                    GhostType
            );

        } catch (Exception e) {
            throw new ConfigurationParseException(
                    String.format("Invalid ghost configuration | %s ", e));
        }
    }


}
