import java.util.*;
public class tax_cal {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your income = ");
        int income = sc.nextInt();
        float tax;
        if( income<=500000){
            tax = 0;
        }
        else if (income>5000000 || income <=10000000){
            tax = income*0.20f;          
        }
        else{
            tax = income*0.30f;
        }
        System.out.println("Tax = Rs. "+tax);
        sc.close();
        
    }
    
}
