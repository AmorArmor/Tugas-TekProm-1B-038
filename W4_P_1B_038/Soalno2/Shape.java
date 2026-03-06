abstract class Shape {
    private String shapeName;


    public Shape (String name){
        shapeName = name;
    }

    abstract double area();

    public String toString() {
        return "Type of shape is" + shapeName;
        //super.toString() + " of radius " + radius + " and height " + height;
    }
}

