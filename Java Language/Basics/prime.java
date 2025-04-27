import java.util.*;
public class prime {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("ENter a number = ");
        int num = sc.nextInt();
        boolean isPrime = true;
        for(int i =2;i<=num-1;i++){
            if(num==0 || num==1){
                isPrime = false;
            }
            else if (num%i==0){
                isPrime = false;
            }
            
        }

        if(isPrime==true){
            System.out.println("Prime Number");
        }
        else{
            System.out.println("Nott Prime");
        }

        sc.close();

    }
    
}
