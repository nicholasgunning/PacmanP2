package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.dynamic.physics.Direction;

/**
 * Implements the chase behavior for Inky (the blue ghost) in Pac-Man.
 * Inky has the most complex targeting scheme, using both Pac-Man's
 * position/direction
 * and Blinky's position to determine his target tile.
 */
public class InkyChaseBehaviour implements ChaseBehaviour {
    // Store Blinky's position components for target calculation
    private static double BlinkyPositionX;
    private static double BlinkyPositionY;

    // Cache the calculated target position
    private static Vector2D targetPosition;

    // Constants for Inky's targeting calculations
    private static final int futureTileDistance = 2; // Number of tiles ahead of Pac-Man to target
    private static final int tileSize = 16; // Size of each maze tile in pixels

    /**
     * Updates Blinky's position which is needed for Inky's targeting calculations
     * 
     * @param blinkyPosition Current position of Blinky ghost
     */
    public static void addBlinkyPosition(Vector2D blinkyPosition) {
        BlinkyPositionX = blinkyPosition.getX();
        BlinkyPositionY = blinkyPosition.getY();
    }

    /**
     * Implements Inky's complex chase behavior which involves:
     * 1. Finding a point 2 tiles ahead of Pac-Man
     * 2. Drawing a vector from Blinky to this point
     * 3. Doubling this vector to get Inky's target
     *
     * This creates Inky's characteristic behavior of working in tandem with Blinky
     * to potentially trap Pac-Man between them.
     *
     * @param context Contains game state including Pac-Man's position/direction and
     *                ghost positions
     * @return Vector2D representing Inky's target tile
     */
    @Override
    public Vector2D chase(ChaseContext context) {
        Vector2D blinkyPosition = new Vector2D(BlinkyPositionX, BlinkyPositionY);
        Vector2D pacmanPosition = context.getPacmanPosition();
        Vector2D ghostPosition = context.getGhostPosition();
        Direction pacmanDirection = context.getPacmanDirection();

        if (blinkyPosition != null) {
            // Step 1: Calculate position 2 tiles ahead of Pac-Man based on his direction
            Vector2D twoAheadOfPacman = pacmanPosition.add(getOffsetForDirection(pacmanDirection).multiply(2));

            // Step 2: Calculate vector from Blinky to the position ahead of Pac-Man
            Vector2D blinkyToTwoAhead = twoAheadOfPacman.subtract(blinkyPosition);

            // Step 3: Double this vector to get Inky's actual target
            Vector2D targetVector = blinkyToTwoAhead.multiply(2);

            // Final target is Blinky's position plus the doubled vector
            targetPosition = blinkyPosition.add(targetVector);
            return targetPosition;
        }

        return targetPosition;
    }

    /**
     * Converts a direction into a unit vector for position calculations
     *
     * @param direction The current direction of Pac-Man
     * @return Vector2D representing one tile of movement in the given direction
     */
    private Vector2D getOffsetForDirection(Direction direction) {
        return switch (direction) {
            case UP -> new Vector2D(0, -1);
            case DOWN -> new Vector2D(0, 1);
            case LEFT -> new Vector2D(-1, 0);
            case RIGHT -> new Vector2D(1, 0);
        };
    }
}