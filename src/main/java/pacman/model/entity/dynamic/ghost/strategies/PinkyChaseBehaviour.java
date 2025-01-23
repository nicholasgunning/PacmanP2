package pacman.model.entity.dynamic.ghost.strategies;

import pacman.model.entity.dynamic.ghost.strategies.facade.ChaseContext;
import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.Vector2D;

/**
* Implements the chase behavior for Pinky (the pink ghost) in Pac-Man.
* Pinky's strategy is to ambush Pac-Man by targeting four tiles ahead 
* of Pac-Man's current position and direction.
*/
public class PinkyChaseBehaviour implements ChaseBehaviour {
   
   /**
    * Number of tiles ahead of Pac-Man that Pinky targets.
    * This creates Pinky's ambush behavior by trying to cut off Pac-Man's path.
    */
   private static final int futureTileDistance = 4;
   
   /**
    * Size of each maze tile in pixels, used to calculate actual target coordinates.
    */
   private static final int tileSize = 16;

   /**
    * Implements Pinky's chase behavior which targets 4 tiles ahead of Pac-Man's
    * current position in the direction Pac-Man is moving.
    * 
    * This creates Pinky's characteristic behavior of trying to ambush Pac-Man
    * by getting in front of him rather than chasing directly.
    *
    * @param context Contains the current game state including Pac-Man's position and direction
    * @return Vector2D representing Pinky's target tile (4 tiles ahead of Pac-Man)
    */
   @Override
   public Vector2D chase(ChaseContext context) {
       Vector2D pacmanPosition = context.getPacmanPosition();
       Direction pacmanCurrentDirection = context.getPacmanDirection();

       // Calculate target position based on Pac-Man's current position
       double posX = pacmanPosition.getX();
       double posY = pacmanPosition.getY();

       // Adjust target position 4 tiles ahead in Pac-Man's current direction
       if (pacmanCurrentDirection == Direction.UP) {
           posY -= futureTileDistance * tileSize; // 4 tiles up
       } else if (pacmanCurrentDirection == Direction.DOWN) {
           posY += futureTileDistance * tileSize; // 4 tiles down
       } else if (pacmanCurrentDirection == Direction.LEFT) {
           posX -= futureTileDistance * tileSize; // 4 tiles to the left
       } else if (pacmanCurrentDirection == Direction.RIGHT) {
           posX += futureTileDistance * tileSize; // 4 tiles to the right
       }

       // Return the calculated ambush position
       return new Vector2D(posX, posY);
   }
}