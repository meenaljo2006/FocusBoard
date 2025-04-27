import java.util.*;
public class factorial {

    public static int fact(int num){

        int fact=1;
        for(int i=num;i>=1;i--){
            fact=fact*i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println(fact(num));

        sc.close();
        
    }
    
}
