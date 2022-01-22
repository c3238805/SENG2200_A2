/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 2 (100 marks, 15%) - Due 9/05, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */
public class Circle extends PlanarShape {

    private double area; // variable area
    private Point[] centerpoint; // create an memory array for points, in circle, there is only one point needed.
    private double r; //  radius of the circle
    
    // public methods
    public Circle(){
    }
    public Circle(double r) {
        centerpoint = new Point[1]; //cause circle only need one point 
        area = 0;
        this.r = r;     //set the readius of the circle
    }

    public void addPoint(double x, double y) {
       
            centerpoint[0] = new Point(x, y);
            setPoint(centerpoint[0], x, y);
    }

    public void setPoint(Point centerpoint, double x, double y) {

        centerpoint.setX(x);
        centerpoint.setY(y);
    }

    //declares abstract methods 
    public String toString() {
                    
        return "CIRC=[" + centerpoint[0].toString() +String.format("%5.2f", r) +"]: " + String.format("%5.2f", area);
    }

    public double area() {
        area = 0;
        // Calculate area of circle
        area = Math.PI * (r * r);
        // Return absolute value
        return area;

    }

    public double originDistance() {
        // the is only one point for circle.
        double min = centerpoint[0].distanceCalculate(centerpoint[0].getX(), centerpoint[0].getY());
        return min;
    }
}
