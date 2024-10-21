package pacman.model.entity.dynamic.ghost.strategies.facade;

import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.Vector2D;

public class ChaseContext {
    private Vector2D pacmanPosition;
    private Direction pacmanDirection;
    private Vector2D ghostPosition;
    private Vector2D blinkyPosition;

    public ChaseContext(Vector2D pacmanPosition, Direction pacmanDirection, Vector2D ghostPosition) {
        this.pacmanPosition = pacmanPosition;
        this.pacmanDirection = pacmanDirection;
        this.ghostPosition = ghostPosition;
    }

    public static void addBlinkyPosition(Vector2D blinkyPosition) {
        blinkyPosition = blinkyPosition;
    }

    public Vector2D getPacmanPosition() {
        return pacmanPosition;
    }

    public Direction getPacmanDirection() {
        return pacmanDirection;
    }

    public Vector2D getGhostPosition() {
        return ghostPosition;
    }

    public Vector2D getBlinkyPosition() {
        return blinkyPosition;
    }
}
