public class fibonacci {

    public static void fib(int num){

        int num1 = 0;
        int num2 = 1;
        System.out.print("Series - ");
        System.out.print(num1+" "+num2+" ");
        for(int i =1;i<=num-2;i++){
            int num3 = num1+num2;
            System.out.print(num3+" ");
            num1 = num2;
            num2 = num3;
        }
        

    }
    public static void main(String[] args) {

        fib(5);
        
    }
    
}
