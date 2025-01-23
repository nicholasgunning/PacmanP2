package pacman.model.entity.staticentity.collectable.decorator;

import javafx.scene.image.Image;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.staticentity.StaticEntityImpl;

/**
* Abstract base class for implementing the Decorator pattern for Pellet objects.
* This allows for dynamic addition of behaviors/properties to pellets at runtime.
* Decorators can modify or enhance the basic pellet functionality like points value,
* special effects, or visual appearance.
*/
public abstract class PelletDecorator extends StaticEntityImpl implements Collectable {

   /**
    * The wrapped Collectable object that this decorator is enhancing.
    * This allows for layering of multiple decorators while maintaining the base interface.
    */
   protected Collectable collectable;

   /**
    * Creates a new PelletDecorator wrapping the given Collectable.
    * The decorator inherits the basic properties (bounding box, layer, image) 
    * from the wrapped collectable while allowing for additional functionality.
    *
    * @param collectable The base Collectable object to be decorated
    */
   public PelletDecorator(Collectable collectable) {
       // Initialize the base StaticEntityImpl with properties from the wrapped collectable
       super(collectable.getBoundingBox(), collectable.getLayer(), collectable.getImage());
       this.collectable = collectable;
   }
}