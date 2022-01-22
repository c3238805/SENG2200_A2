/*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 2 (100 marks, 15%) - Due 9/05, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */
public class FactoryImplementation {

    public static PlanarShape make(String ShapeType) throws Exception{
        if(ShapeType.equals("P")){
            return new Polygon();
        }
        else if(ShapeType.equals("C")){
            return new Circle();
        }
        else if(ShapeType.equals("S")){
            return new SemiCircle();
        }
        else 
            throw new Exception("ShapeType Factory cannot create " + ShapeType);
    }

    
}
