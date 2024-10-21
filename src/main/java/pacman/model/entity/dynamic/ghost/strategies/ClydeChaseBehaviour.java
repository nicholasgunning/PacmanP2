package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Vector2D;

public class ClydeChaseBehaviour implements ChaseBehaviour {
    public static final double chaseThresold = 8 * 16;

    @Override
    public Vector2D chase(ChaseContext context) {
        Vector2D playerPosition = context.getPacmanPosition();
        Vector2D ghostPosition = context.getGhostPosition();
        Vector2D targetCorner =  new Vector2D(0, 16 * 34);
        return calculatePosition(playerPosition, ghostPosition, targetCorner);
    }

    private Vector2D calculatePosition(Vector2D playerPosition, Vector2D ghostPosition, Vector2D targetCorner) {
        double distance = Vector2D.calculateEuclideanDistance(playerPosition, ghostPosition);
        if (distance > chaseThresold) {
            return playerPosition;
        } else {
            return targetCorner;
        }
    }




}
