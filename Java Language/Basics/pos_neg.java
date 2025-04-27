import java.util.*;
public class pos_neg {
    public static void main(String Args[]){
        Scanner sc = new Scanner (System.in);
        int num = sc.nextInt();
        if (num<0){
            System.out.println("Negative Number");
        }
        else{
            System.out.println("Positive Number");
        }
        sc.close();

    }
    
}
