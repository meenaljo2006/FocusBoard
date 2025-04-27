import java.util.*;
public class area_sq {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the side of the square = ");
        float side = sc.nextFloat();
        float area = side*side;
        System.out.print("Area of a square = " +area);
        sc.close();

    }
    
}
