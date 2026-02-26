public class Cylinder extends Circle { 
    private double height; // private variable

    // Constructor with default color, radius and height
    public Cylinder() {
        super(); // call superclass no-arg constructor Circle()
        this.height = 1.0;
    }

    // Constructor with default radius, color but given height
    public Cylinder(double height) {
        super(); // call superclass no-arg constructor Circle()
        this.height = height;
    }

    // Constructor with default color, but given radius, height
    public Cylinder(double radius, double height) {
        super(radius); // call superclass constructor Circle(radius)
        this.height = height;
    }

    // Constructor with specified color, radius, and height
    public Cylinder(double radius, double height, String color) {
        super(radius, color); // call superclass constructor Circle(radius)
        this.height = height;
    }

    // A public method for retrieving the height //Getter
    public double getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(double height) {
        if (height >= 0){
            this.height = height;
        } else {
            System.out.println("Height value not valid!");
        }
    }

    // A public method for computing the volume of cylinder
    // use superclass method getArea() to get the base area
    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public double getArea(){
        // Rumus Luas Permukaan Tabung: 2 * π * r * h + 2 * Luas_Alas
        return 2 * Math.PI * getRadius() * height + 2 * super.getArea();
    }

    @Override
    public String toString(){
        return "Cylinder: subclass of " + super.toString() + " height = " + height;
    }
}
