import java.util.*;
public class continue_L {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter a number = ");
            int num = sc.nextInt();
            sc.close();
            if(num%10==0){
                continue;
            }
            else{
                System.out.println(num);
            }
        } while(true);
       
        

        
    }
    
}
