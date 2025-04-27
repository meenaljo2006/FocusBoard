import java.util.*;
public class odd_even {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);;
        int num = sc.nextInt();
        int bitmask = 1;
        if((num & bitmask)==0){
            System.out.println("Even Number");
        }
        else{
            System.out.println("Odd Number");
        }

        sc.close();
    }

    
    
}
