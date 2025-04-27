import java.util.*;
public class break_L {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter a number = ");
            int num = sc.nextInt();
            if(num%10==0){
                break;
            }
            else{
                System.out.println(num);
            }

        }while(true);
        System.out.println("You entered multiple of 10");

        sc.close();
    }
    
}
