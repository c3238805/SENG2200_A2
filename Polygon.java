/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 2 (100 marks, 15%) - Due 9/05, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */
//Subclass (inherit from PlanarShape)
public class Polygon extends PlanarShape {
    // representation of the objects

    private double area; // variable area
    private Point[] points; // create an memory array for points
    private int i = 0; // keep track of points
    private int side;   // for the user to input the side of the Polygon

    public Polygon(){
    }
    public Polygon(int side) {
        this.side = side;
        points = new Point[side];
        i = 0;
        area = 0;
    }

    public void addPoint(double x, double y) throws IndexOutOfBoundsException{

        if (i < points.length) {
            points[i] = new Point(x, y);
            setPoint(points[i], x, y);
            i++;
        }
        if (i > points.length) {
            throw new IndexOutOfBoundsException(
            "error");
        }

    }

    public void setPoint(Point p, double x, double y) {
        p.setX(x);
        p.setY(y);
    }
  
//declares abstract methods 
    public String toString() {
        String allPoints = "";
        for (int s = 0; s < points.length; s++) {
            points[s].toString();
            allPoints = allPoints + points[s].toString();
        }

        return "POLY=[" + allPoints + "]: " + String.format("%5.2f", area);
    }

    public double area() {
        area = 0;
        // Calculate value of shoelace formula
        int j = side - 1;
        for (int f = 0; f < side; f++) {
            area += (points[j].getX() + points[f].getX()) * (points[j].getY() - points[f].getY());

            // j is previous vertex to i
            j = f;
        }
        area = Math.abs(area / 2.0);

        // Return absolute value
        return area;
    
    }

    public double originDistance() {

        double min = points[0].distanceCalculate(points[0].getX(), points[0].getY());

        for (int c = 0; c < points.length; c++) {

            double d1 = points[c].distanceCalculate(points[c].getX(), points[c].getY());
            if (min > d1) {
                min = d1;

            } else if (min == d1) {
                min = points[0].distanceCalculate(points[0].getX(), points[0].getY());
            }

        }
        return min;
    }


}
