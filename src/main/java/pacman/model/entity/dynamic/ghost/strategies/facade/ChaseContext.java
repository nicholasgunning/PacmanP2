package pacman.model.entity.dynamic.ghost.strategies.facade;

import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.Vector2D;

/**
 * ChaseContext class encapsulates all the necessary position and direction information
 * needed for ghost chase behavior in Pac-Man.
 * This class acts as a facade, providing a simplified interface to access various
 * position-related data needed for ghost chase strategies.
 */
public class ChaseContext {
    // Current position of Pac-Man
    private Vector2D pacmanPosition;
    
    // Current direction Pac-Man is moving in
    private Direction pacmanDirection;
    
    // Current position of the ghost using this context
    private Vector2D ghostPosition;
    
    // Static reference to Blinky's position (shared across all instances)
    // Used for ghost chase strategies that depend on Blinky's position
    private static Vector2D blinkyPosition;

    /**
     * Constructs a new ChaseContext with the current game state information
     * 
     * @param pacmanPosition Current position of Pac-Man
     * @param pacmanDirection Current direction of Pac-Man's movement
     * @param ghostPosition Current position of the ghost using this context
     */
    public ChaseContext(Vector2D pacmanPosition, Direction pacmanDirection, Vector2D ghostPosition) {
        this.pacmanPosition = pacmanPosition;
        this.pacmanDirection = pacmanDirection;
        this.ghostPosition = ghostPosition;
    }

    /**
     * Updates Blinky's position which is shared across all chase contexts
     * This is needed for ghost behaviors that reference Blinky's position
     * 
     * @param TempBlinkyPosition New position of Blinky ghost
     */
    public static void addBlinkyPosition(Vector2D TempBlinkyPosition) {
        blinkyPosition = TempBlinkyPosition;
    }

    /**
     * @return Current position of Pac-Man
     */
    public Vector2D getPacmanPosition() {
        return pacmanPosition;
    }

    /**
     * @return Current direction of Pac-Man's movement
     */
    public Direction getPacmanDirection() {
        return pacmanDirection;
    }

    /**
     * @return Current position of the ghost using this context
     */
    public Vector2D getGhostPosition() {
        return ghostPosition;
    }

    /**
     * @return Current position of Blinky ghost
     */
    public Vector2D getBlinkyPosition() {
        return blinkyPosition;
    }
}