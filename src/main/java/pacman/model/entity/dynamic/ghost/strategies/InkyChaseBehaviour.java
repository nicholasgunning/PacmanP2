package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.dynamic.physics.Direction;

public class InkyChaseBehaviour implements ChaseBehaviour {
    private static double BlinkyPositionX;
    private static double BlinkyPositionY;

    private static Vector2D targetPosition;

    private static final int futureTileDistance = 2;
    private static final int tileSize = 16;

    public static void addBlinkyPosition(Vector2D blinkyPosition) {
        BlinkyPositionX = blinkyPosition.getX();
        BlinkyPositionY = blinkyPosition.getY();
    }

    @Override
    public Vector2D chase(ChaseContext context) {
        Vector2D blinkyPosition = new Vector2D(BlinkyPositionX, BlinkyPositionY);
        Vector2D pacmanPosition = context.getPacmanPosition();
        Vector2D ghostPosition = context.getGhostPosition();
        Direction pacmanDirection = context.getPacmanDirection();

        if (blinkyPosition != null) {

            // Calculate the position two tiles ahead of Pacman
            Vector2D twoAheadOfPacman = pacmanPosition.add(getOffsetForDirection(pacmanDirection).multiply(2));

            // Calculate the vector from Blinky to the position two tiles ahead of Pacman
            Vector2D blinkyToTwoAhead = twoAheadOfPacman.subtract(blinkyPosition);

            // Double this vector
            Vector2D targetVector = blinkyToTwoAhead.multiply(2);

            // Add this doubled vector to Blinky's position to get the target
            targetPosition = blinkyPosition.add(targetVector);
            return targetPosition;
        }

        return targetPosition;
    }

    private Vector2D getOffsetForDirection(Direction direction) {
        return switch (direction) {
            case UP -> new Vector2D(0, -1);
            case DOWN -> new Vector2D(0, 1);
            case LEFT -> new Vector2D(-1, 0);
            case RIGHT -> new Vector2D(1, 0);
        };
    }
}
