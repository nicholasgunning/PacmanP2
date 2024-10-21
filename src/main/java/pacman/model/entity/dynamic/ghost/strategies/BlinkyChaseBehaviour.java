package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Vector2D;

public class BlinkyChaseBehaviour implements ChaseBehaviour {

    @Override
    public Vector2D chase(ChaseContext context) {
        return context.getPacmanPosition();
    }
}
