/**
 * The Circle class models a circle with a radius and color.
 */
public class Circle { 
    // private instance variable, not accessible from outside this class
    private double radius;
    private String color;

    // Constructors (overloaded)
    /** Constructs a Circle instance with default value for radius and color */ //OK
    public Circle() { // 1st (default) constructor
        radius = 1.0;
        color = "red";
    }

    /** Constructs a Circle instance with the given radius and default color */ //OK
    public Circle(double r) { // 2nd constructor
        radius = r;
        color = "red";
    }

    /** Constructs a Circle instance with the given radius and color */ //OK
    public Circle(double r, String colorname) { // 3rd constructor
        radius = r;
        this.color = colorname;
    }

    /** Returns the radius */ //OK
    public double getRadius() {
        return radius;
    }

    /** Returns the area of this Circle instance */ //OK
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Returns the radius */ //OK
    public String getColor() {
        return color;
    }

    /** Setter color */ //OK
    public void setColor(String colorname){ 
        this.color = colorname;
    } 

    /** * Return a self-descriptive string of this instance in the form of
     * Circle[radius=?,color=?] 
     */ //OK
    public String toString() {
        return "Circle[radius=" + radius + " color=" + color + "]";
    }
}
