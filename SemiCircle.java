/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 2 (100 marks, 15%) - Due 9/05, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */
public class SemiCircle extends PlanarShape{

    private double area; // variable area
    private Point[] SemiCirclepoint; // create an memory array for points, in SemiCircl, there are only two points needed.
    // public methods
    public SemiCircle() {
        SemiCirclepoint = new Point[2]; //cause circle only need two points input 
        area = 0;
        
    }

    public void addPoint(int pointNo,double x, double y) {      
            //int pointNo can only be 0 and 1. when pasing the parameter in.
            SemiCirclepoint[pointNo] = new Point(x, y);
            setPoint(SemiCirclepoint[pointNo], x, y);      
    }

    public void setPoint(Point SemiCirclepoint, double x, double y) {
        SemiCirclepoint.setX(x);
        SemiCirclepoint.setY(y);
    }

    //declares abstract methods 
    public String toString() {
                    
        return "SEMI=[" + SemiCirclepoint[0].toString() +SemiCirclepoint[1].toString()+ "]: " + String.format("%5.2f", area);
    }

    public double area() {
        area = 0;
        // Calculate radius of SemiCircle 
        double r = Math.sqrt((SemiCirclepoint[1].getX() - SemiCirclepoint[0].getX())*(SemiCirclepoint[1].getX() - SemiCirclepoint[0].getX()) + 
                             (SemiCirclepoint[1].getY() - SemiCirclepoint[0].getY())*(SemiCirclepoint[1].getY() - SemiCirclepoint[0].getY()));       
        area = Math.PI * (r * r) / 2;    // area of the semi-circle πr^2/2
        // Return absolute value
        return area;

    }

    public double originDistance() {
        // the is only two point for circle.
        double min = SemiCirclepoint[0].distanceCalculate(SemiCirclepoint[0].getX(), SemiCirclepoint[0].getY());
        double d1 = SemiCirclepoint[1].distanceCalculate(SemiCirclepoint[1].getX(), SemiCirclepoint[1].getY());
            if (min > d1) {
                min = d1;

            } else if (min == d1) {
                //set min to any of the point
                min = SemiCirclepoint[0].distanceCalculate(SemiCirclepoint[0].getX(), SemiCirclepoint[0].getY());
            }
        return min;
    }
}
