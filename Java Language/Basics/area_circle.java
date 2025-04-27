import java.util.*;
public class area_circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of radius = ");
        float radius = sc.nextFloat();
        float area = 3.14f*radius*radius;
        System.out.print("Area of the circle = ");
        System.out.println(area);

        sc.close();



    }
    
}
