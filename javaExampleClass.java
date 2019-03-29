/**
 * The basic class syntax.
 */

public class BasicClass {

    public BasicClass() {
        // This is the constructor.
    }

    public static void main(String []args) {
        // This is the main method.
    }

    private int something() {
        // This is a private method that returns an integer.
        return 1;
    }
}


/**
 * Inheritance. Use "extends".
 */
public class Bicycle {

    public byte gear;
    public float speed;

    public Bicycle(byte startGear, float startSpeed) {
        gear = startGear;
        speed = startSpeed;
    }

    public void speedUp(float increment) {
        speed += increment;
    }

}

public class MountainBike extends Bicycle {

    // the MountainBike subclass adds one field
    public int seatHeight;

    public MountainBike(int startHeight, int startSpeed, int startGear) {
        super(startSpeed, startGear);
        seatHeight = startHeight;
    }

    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
}


/**
 * Interfaces contain the least amount of information.
 * All of their methods must be blank.
 * All attributes must be static and final.
 *
 * Interfaces are the simplest OO building block.
 * Consider using them when you know you will need to
 * change your implementation in the future.
 * Or if you expect some future classes may want to
 * implement multiple interfaces.
 */

public interface MyInterface {
   // Any number of final, static fields.
   // Any number of abstract method declarations.
   // Can not be instantiated directly.
   // Must be "implemented" not "extended"
   // Can implement multiple interfaces
}

interface Animal {
   public void eat();
   public void travel();
}

public class Mammal implements Animal {

   public void eat() {
      System.out.println("Mammal eats");
   }

   public void travel(){
      System.out.println("Mammal travels");
   }

   public boolean hasHair() {
      return true;
   }
}


/**
 * Abstract classes in Java are pretty classic.
 * They can contain empty and filled methods.
 * They provide partially-built functionality
 * on which other classes can be built.
 * Consider these when you want to share code
 * among several closely-related classes.
 */

abstract class GraphicObject {
    int x, y;
    // other attributes

    void moveTo(int newX, int newY) {
        // a fully implemented method
    }

    abstract void draw();
    abstract void resize();
}

class Circle extends GraphicObject {
    void draw() {
        // implementing the abstract method
    }
    void resize() {
        // implementing the abstract method
    }
}


/**
 * Inner Classes are those that are defined entirely
 * within another class. They are usually helper
 * classes and never have their own *.java file.
 */

public class SomeClass {

   // Constructor. Attributes. Methods. Etc.

   public class MyInnerClass {
      // Some class content
   }
}


/**
 * Anonymous classes allow you to implement a one-off class.
 * Hopefully simple, this class won't need to be re-used later.
 * The anonymous class is a subclass of something else.
 */

class ProgrammerInterview {
    public void read() {
        System.out.println("Programmer Interview!");
    }
}

class Website {
    # This creates an anonymous inner class
    ProgrammerInterview pInstance = new ProgrammerInterview() {
        public void read() {
            System.out.println("anonymous ProgrammerInterview");
        }
    };
}
