public class TestCylinder { 
    public static void main(String[] args) {
        
        // Declare and allocate a new instance of cylinder
        // with default color, radius, and height
        Cylinder c1 = new Cylinder();
        System.out.println("Cylinder:" 
            + " radius=" + c1.getRadius() 
            + " height=" + c1.getHeight() 
            + " surface area=" + c1.getArea() 
            + " volume=" + c1.getVolume()
            + " color=" + c1.getColor());

        // Declare and allocate a new instance of cylinder
        // specifying height, with default color and radius
        Cylinder c2 = new Cylinder(10.0);
        System.out.println("Cylinder:" 
            + " radius=" + c2.getRadius() 
            + " height=" + c2.getHeight() 
            + " surface area=" + c2.getArea() 
            + " volume=" + c2.getVolume()
            + " color=" + c2.getColor());

        // Declare and allocate a new instance of cylinder
        // specifying radius and height, with default color
        Cylinder c3 = new Cylinder(2.0, 20.0);
        System.out.println("Cylinder:" 
            + " radius=" + c3.getRadius() 
            + " height=" + c3.getHeight() 
            + " surface area=" + c3.getArea() 
            + " volume=" + c3.getVolume()
            + " color=" + c3.getColor());

        // Declare and allocate a new instance of cylinder
        // specifying radius, height and color
        Cylinder c4 = new Cylinder(3.0, 40.0, "purple");
        System.out.println("Cylinder:" 
            + " radius=" + c4.getRadius() 
            + " height=" + c4.getHeight() 
            + " surface area=" + c4.getArea() 
            + " volume=" + c4.getVolume()
            + " color=" + c4.getColor());
    }
}
