package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.Vector2D;

public class PinkyChaseBehaviour implements ChaseBehaviour {
    private static final int futureTileDistance = 4;
    private static final int tileSize = 16;

    @Override
    public Vector2D chase(ChaseContext context) {
        Vector2D pacmanPosition = context.getPacmanPosition();
        Direction pacmanCurrentDirection = context.getPacmanDirection();

        // Pinky's target is 4 tiles ahead of the player's current position
        double posX = pacmanPosition.getX();
        double posY = pacmanPosition.getY();

        if (pacmanCurrentDirection == Direction.UP) {
            posY -= futureTileDistance * tileSize; // 4 tiles up
        } else if (pacmanCurrentDirection == Direction.DOWN) {
            posY += futureTileDistance * tileSize; // 4 tiles down
        } else if (pacmanCurrentDirection == Direction.LEFT) {
            posX -= futureTileDistance * tileSize; // 4 tiles to the left
        } else if (pacmanCurrentDirection == Direction.RIGHT) {
            posX += futureTileDistance * tileSize; // 4 tiles to the right
        }

        return new Vector2D(posX, posY);
    }
}
