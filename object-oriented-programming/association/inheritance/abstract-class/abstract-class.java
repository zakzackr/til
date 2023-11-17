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

abstract class Shape2D{
    protected double scale = 1;
    protected String borderColor = "black";
    protected String backgroundColor = "white";
    protected Date createdTime;

    public Shape2D(){
        this.createdTime = new Date();
    }

    public double getScale(){
        return this.scale;
    }

    public void setScale(double scale){
        this.scale = scale;
    }

    public String getBorderColor(){
        return this.borderColor;
    }

    public void setBorderColor(String borderColor){
        this.borderColor = borderColor;
    }

    public String getBackgroundColor(){
        return this.backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor){
        this.backgroundColor = backgroundColor;
    }

    public String getDateCreated(){
        return new SimpleDateFormat("yyyy/mm/dd HH:mm:ss").format(createdTime);
    }

    public String toString(){
        return getDescription() + ", created at " + getDateCreated();
    }

    public abstract String getDescription();
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Square extends Shape2D{
    private double l;

    public Square(double l){
        super();
        this.l = l;
    }

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

class Rectangle extends Shape2D{
    private double l;
    private double h;

    public Rectangle(double l, double h){
        super();
        this.l = l;
        this.h = h;
    }

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
