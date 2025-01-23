package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Vector2D;

/**
 * Implements the chase behavior for Clyde (the orange ghost) in Pac-Man.
 * Clyde has a unique "shy" personality where he alternates between chasing
 * Pac-Man
 * and retreating to his corner based on his distance from Pac-Man.
 */
public class ClydeChaseBehaviour implements ChaseBehaviour {

    /**
     * Distance threshold that determines when Clyde switches between chasing and
     * retreating.
     * When Clyde is further than 8 tiles (8 * 16 pixels) from Pac-Man, he will
     * chase.
     * When closer than this distance, he will retreat to his corner.
     */
    public static final double chaseThresold = 8 * 16;

    /**
     * Implements Clyde's chase behavior which alternates between targeting Pac-Man
     * and retreating to his corner based on distance.
     *
     * @param context Contains the current game state including Pac-Man's and ghost
     *                positions
     * @return Vector2D representing Clyde's target tile (either Pac-Man or his
     *         corner)
     */
    @Override
    public Vector2D chase(ChaseContext context) {
        Vector2D playerPosition = context.getPacmanPosition();
        Vector2D ghostPosition = context.getGhostPosition();
        // Clyde's corner is the bottom-left corner of the maze
        Vector2D targetCorner = new Vector2D(0, 16 * 34);
        return calculatePosition(playerPosition, ghostPosition, targetCorner);
    }

    /**
     * Calculates Clyde's target position based on his distance from Pac-Man.
     * - If Clyde is further than 8 tiles from Pac-Man, he will chase Pac-Man
     * - If Clyde is within 8 tiles of Pac-Man, he will retreat to his corner
     *
     * @param playerPosition Current position of Pac-Man
     * @param ghostPosition  Current position of Clyde
     * @param targetCorner   Position of Clyde's corner (bottom-left)
     * @return Vector2D representing where Clyde should target
     */
    private Vector2D calculatePosition(Vector2D playerPosition, Vector2D ghostPosition, Vector2D targetCorner) {
        double distance = Vector2D.calculateEuclideanDistance(playerPosition, ghostPosition);
        if (distance > chaseThresold) {
            // Chase Pac-Man if far away
            return playerPosition;
        } else {
            // Retreat to corner if too close
            return targetCorner;
        }
    }
}