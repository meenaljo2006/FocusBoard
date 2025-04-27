import java.util.*;
public class bill {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the cost of pencil = ");
        float pencil = sc.nextFloat();
        System.out.print("Enter the cost of pen = ");
        float pen = sc.nextFloat();
        System.out.print("Enter the cost of eraser = ");
        float eraser = sc.nextFloat();


        float bill = pencil+pen+eraser;
        System.out.println("Total bill without GST = "+bill);
        
        float bill_GST = (pencil+pen+eraser+(bill*0.18f));
        System.out.print("Total bill with GST = " +bill_GST );
        
        sc.close();
    }
    
}
