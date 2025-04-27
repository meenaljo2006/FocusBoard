import java.util.*;
public class calculator {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the num1 = ");
        int num1 = sc.nextInt();
        System.out.print("Enter the num2 = ");
        int num2 = sc.nextInt();
        System.out.print("Enter the operator + - * / = ");
        char op = sc.next().charAt(0);
        switch(op){
            case '+' : System.out.println(num1 +num2);
                        break;
            case '-' : System.out.println(num1-num2);
                        break;
            case '*' : System.out.println(num1*num2);
                        break;
            case '/' : System.out.println(num1/num2);
                        break;
            default : System.out.println("Invalid Character");
        }

        sc.close();
    }
    
}
