package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Vector2D;

/**
 * Implements the chase behavior for Blinky (the red ghost) in Pac-Man.
 * Blinky's chase strategy is the simplest among the ghosts - he directly
 * targets Pac-Man's
 * current position, making him the most aggressive and predictable ghost.
 */
public class BlinkyChaseBehaviour implements ChaseBehaviour {

    /**
     * Implements Blinky's chase behavior where he directly targets Pac-Man's
     * position.
     * This makes Blinky the most straightforward and aggressive ghost, as he always
     * tries to take the shortest path to Pac-Man's current location.
     *
     * @param context Contains the current game state including Pac-Man's and ghost
     *                positions
     * @return Vector2D representing Blinky's target tile (Pac-Man's current
     *         position)
     */
    @Override
    public Vector2D chase(ChaseContext context) {
        // Blinky simply returns Pac-Man's current position as his target
        // This makes him constantly pursue Pac-Man directly
        return context.getPacmanPosition();
    }
}