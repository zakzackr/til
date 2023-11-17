## Abstract Class
An abstract class is declared with an abstract keyword and cannot be instantiated (it must be inherited from another class). It may have both abstract and non-abstract methods. An abstract method does not have a body, so it should be implemented in the subclass(concrete class).

### Basic rules
1. Declare with abstract keyword.
2. Cannot create an instance from an abstract class. (Note: it is possible to declare a constructor in an abstract class, but it should be called from its subclass(concrete class) using super().)
4. Abstract methods in an abstract class should be implemented in concrete classes.

## Example
```
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main{
    public static void main(String[] args) {
        Shape2D square = new Square(5);
        Shape2D rectangle = new Rectangle(5, 10);

        shapePrinter(square);
        shapePrinter(rectangle);
    }

    public static void shapePrinter(Shape2D shape2D){
        System.out.println(shape2D);
        System.out.println("Area: " + shape2D.getArea() + ", perimeter: " + shape2D.getPerimeter());
    }
}

// declaring an abstract class with abstract keyword
abstract class Shape2D{
    // providing default values to instance variables
    protected double scale = 1;
    protected String borderColor = "black";
    protected String backgroundColor = "white";
    protected Date createdTime;

    // possible to declare a constructor that should be called from a subclass using super()
    public Shape2D(){
        this.createdTime = new Date();
    }

    public String getDateCreated(){
        return new SimpleDateFormat("yyyy/mm/dd HH:mm:ss").format(createdTime);
    }

    public String toString(){
        return getDescription() + ", created at " + getDateCreated();
    }

    // area and perimeter differ from each shape and they should be implemented in concrete classes(Square and Rectangle classes)
    // declaring abstract methods with abstract keyword
    // these methods should be implemented in their subclass (concrete class)
    public abstract String getDescription();
    public abstract double getArea();
    public abstract double getPerimeter();
}

// Concrete class
class Square extends Shape2D{
    private double l;

    public Square(double l){
        super();
        this.l = l;
    }

    // implementing abstract methods that are specific to Square objects.
    public String getDescription(){
        return "This is a square";
    }

    public double getArea(){
        return l * l;
    }

    public double getPerimeter(){
        return 4 * l;
    }
}

// Concrete class
class Rectangle extends Shape2D{
    private double l;
    private double h;

    public Rectangle(double l, double h){
        super();
        this.l = l;
        this.h = h;
    }

    // implementing abstract methods that are specific to Rectangle objects.
    public String getDescription(){
        return "This is a rectangle";
    }

    public double getArea(){
        return l * h;
    }

    public double getPerimeter(){
        return 2 * l + 2 * h;
    }
}
```
