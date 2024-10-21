package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Vector2D;

public interface ChaseBehaviour {
    Vector2D chase(ChaseContext context);
}
