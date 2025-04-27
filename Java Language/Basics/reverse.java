import java.util.*;
public class reverse {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // while(num>0){
        //     int rem = num%10;          // to find last digit use modulo by 10
        //     num/=10;                   // to remove last digit use division by 10
        //     System.out.print(rem);

        // }

        int rev=0;
        while(num>0){
            int last_digit = num%10;
            rev = (rev*10)+ last_digit;
            num/=10;
        }

        System.out.println(rev);

        sc.close();
    }
    
}
