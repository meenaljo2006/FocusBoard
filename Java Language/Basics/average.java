import java.util.*;
public class average {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter num1 = ");
        int num1 = sc.nextInt();
        System.out.print("Enter num2 = ");
        int num2 = sc.nextInt();
        System.out.print("Enter num3 = ");
        int num3 = sc.nextInt();
        float average = (num1+num2+num3)/3;
        System.out.print("Average = ");
        System.out.println(average);
        sc.close();
        

    }
}