public class MainShape {
    public static void main(String[] args) {
        
        // ==========================================
        // 1. MENGUJI CLASS SHAPE
        // ==========================================
        System.out.println("--- TEST SHAPE ---");
        Shape shape = new Shape("blue", false);
        System.out.println("Kondisi Awal  : " + shape.toString());
        
        // Test Getter & Setter Shape
        shape.setColor("yellow");
        shape.setFilled(true);
        System.out.println("Warna Baru    : " + shape.getColor());
        System.out.println("Status Filled : " + shape.isFilled());
        System.out.println("Kondisi Akhir : " + shape.toString() + "\n");


        // ==========================================
        // 2. MENGUJI CLASS CIRCLE
        // ==========================================
        System.out.println("--- TEST CIRCLE ---");
        Circle2 circle = new Circle2(3.5, "red", true);
        System.out.println("Kondisi Awal  : " + circle.toString());
        
        // Test Getter & Setter Circle
        System.out.println("Radius Awal   : " + circle.getRadius());
        circle.setRadius(5.0);
        System.out.println("Radius Baru   : " + circle.getRadius());
        
        // Test Area & Perimeter Circle
        System.out.println("Luas Circle     : " + circle.getArea());
        System.out.println("Keliling Circle : " + circle.getPerimeter());
        System.out.println("Kondisi Akhir : " + circle.toString() + "\n");


        // ==========================================
        // 3. MENGUJI CLASS RECTANGLE
        // ==========================================
        System.out.println("--- TEST RECTANGLE ---");
        Rectangle rectangle = new Rectangle(2.0, 4.0, "green", false);
        System.out.println("Kondisi Awal  : " + rectangle.toString());
        
        // Test Getter & Setter Rectangle
        System.out.println("Width Awal    : " + rectangle.getWidth());
        System.out.println("Length Awal   : " + rectangle.getLength());
        rectangle.setWidth(3.0);
        rectangle.setLength(6.0);
        System.out.println("Width Baru    : " + rectangle.getWidth());
        System.out.println("Length Baru   : " + rectangle.getLength());
        
        // Test Area & Perimeter Rectangle
        System.out.println("Luas Rectangle     : " + rectangle.getArea());
        System.out.println("Keliling Rectangle : " + rectangle.getPerimeter());
        System.out.println("Kondisi Akhir : " + rectangle.toString() + "\n");

        // ==========================================
        // 4. MENGUJI CLASS SQUARE
        // ==========================================
        System.out.println("--- TEST SQUARE ---");
        Square square = new Square(4.0, "purple", true);
        System.out.println("Kondisi Awal  : " + square.toString());
        
        // Test Getter & Setter khusus Square
        System.out.println("Sisi Awal     : " + square.getSide());
        square.setSide(5.0);
        System.out.println("Sisi Baru (setSide) : " + square.getSide());
        
        // Test Area & Perimeter Square
        System.out.println("\nLuas Square (5x5)     : " + square.getArea()); // Harus 25.0
        System.out.println("Keliling Square ((5+5)x2) : " + square.getPerimeter()); // Harus 20.0
        System.out.println("Kondisi Akhir : " + square.toString()); 
    }
}