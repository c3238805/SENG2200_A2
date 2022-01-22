/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 2 (100 marks, 15%) - Due 9/05, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */

// The Abstract Class
public abstract class PlanarShape implements Comparable<PlanarShape> {
    
    // Define the toString here
    public abstract String toString();     //question : do i have to have // abstract toString() ? or leave it as it is ?
    
    //abstract area() method
    public abstract double area();     // input paramerter int n = side of the polygon.

    //For compare PlanarShape objects
    public abstract double originDistance();  


    //standard Comparable<T> interface   
    public int compareTo(PlanarShape obj){
            
            //===============================
            if(Math.abs(this.area() - obj.area()) <=0.0005 ){

                if( this.originDistance()>obj.originDistance())   {
    
                    return 1; // true, insert before 
                } else
                    return -1; // false
            }
             else if (this.area()  < obj.area() && (Math.abs(this.area() - obj.area()) > 0.0005 ))
                return 1; // ture
    
            else if (this.area() > obj.area() && (Math.abs(this.area() - obj.area()) > 0.0005 ))
                return -1; // false
    
            else
                return 1; // ture
        }

        

}


