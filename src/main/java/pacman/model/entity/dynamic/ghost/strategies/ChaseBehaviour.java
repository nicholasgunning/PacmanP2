package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Vector2D;

/**
* Defines the contract for ghost chase behaviors in Pac-Man.
* This interface is part of the Strategy pattern implementation for ghost movement,
* allowing different ghosts to have unique chase behaviors while sharing a common interface.
*/
public interface ChaseBehaviour {

   /**
    * Calculates the target position for a ghost based on its specific chase strategy.
    * Each ghost implements this differently to create unique movement patterns:
    * - Blinky (Red): Directly targets Pac-Man
    * - Pinky (Pink): Targets 4 tiles ahead of Pac-Man
    * - Inky (Blue): Uses both Pac-Man and Blinky's position
    * - Clyde (Orange): Alternates between chasing and retreating
    *
    * @param context Contains relevant game state information needed for chase calculations
    *                including Pac-Man's position, direction, and ghost positions
    * @return Vector2D representing the tile position the ghost should target
    */
   Vector2D chase(ChaseContext context);
}