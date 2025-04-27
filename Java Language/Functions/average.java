import java.util.*;
public class average {

    public static float avg(int a, int b, int c){
        float average = (a+b+c)/3;
        return average;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        System.out.println(avg(num1,num2,num3));
        


        sc.close();

    }
    
}