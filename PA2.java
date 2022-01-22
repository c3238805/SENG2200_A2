 /*
 * SENG2200 Programming Languages & Paradigms
 * Assignment 2 (100 marks, 15%) - Due 9/05, 23:59
 * 
 * Student Name: NI ZENG
 * Student Number: C3238805
 */
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
public class PA2{
	public static void main( String[] args) throws IOException {

        LinkedList<PlanarShape> list1 = new LinkedList<PlanarShape>();
        LinkedList<PlanarShape> list2 = new LinkedList<PlanarShape>();

        String fileName = args[0]; 
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
		 
		String inputStream = "";
        
		try {
			while (scan.hasNext()) { 
				inputStream = scan.next();

				if (inputStream.equals("P")) {  

                    int polNo = scan.nextInt(); 
                    Polygon p = new Polygon(polNo);                               
                    int i = 1;

                   while (i <= polNo) {
                        double x = scan.nextDouble();
                        double y = scan.nextDouble();
                       p.addPoint(x, y);
                      
                       i++;
                   }
                   p.area();        // calculate the area in Polygon class
                   PlanarShape ps1 = FactoryImplementation.make("P") ; 
                   ps1 = p;        // set PlannarShape ps1 = Polygon           
                   list1.append(ps1);  // add PlannaShape Polygon to LinkedList
                  
                   list2.insertInOrder(ps1);
				}
                else if (inputStream.equals("C")) {  
                                   
                    double x = scan.nextDouble();
                    double y = scan.nextDouble();
                    double r = scan.nextInt();

                    Circle c = new Circle(r);
                    c.addPoint(x, y);
                                             
                   c.area();        // calculate the area in Circle class  
                   PlanarShape circle = FactoryImplementation.make("C");                  
                   circle = c;        // set PlannarShape c = Circle           
                   list1.append(circle);  // add PlannaShape Circle to LinkedList                
                   list2.insertInOrder(circle);
               }

               else if (inputStream.equals("S")) {  

                    SemiCircle s = new SemiCircle();
                                   
                for(int i = 0;i<2;i++){
                    double x = scan.nextDouble();
                    double y = scan.nextDouble();
                    s.addPoint(i,x, y);
                    
                }    
                   
                   s.area();        // calculate the area in SemiCircle class
                   PlanarShape semicircle = FactoryImplementation.make("S"); 
                   semicircle = s;        // set PlannarShape s = SemiCircle           
                   list1.append(semicircle);  // add PlannaShape SemiCircle to LinkedList
                   list2.insertInOrder(semicircle);
                }
			
            }
		} catch ( Exception e) {
			System.out.println("File Not Found");
		}
//===============================================================
        Iterator<PlanarShape> l1 = list1.iterator();
        System.out.println("\nUnsorted list");
        while (l1.hasNext()){
            System.out.println(l1.next()); 
           
        }

        Iterator<PlanarShape> l2 = list2.iterator();
        System.out.println("\nSorted list");
        while (l2.hasNext()){
            System.out.println(l2.next());            
        }


        

		
	}


}