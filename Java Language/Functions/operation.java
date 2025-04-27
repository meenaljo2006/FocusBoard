public class operation{

    public static int add(int a,int b){
        return a+b;
    }
    public static int product(int a,int b){
        return a*b;
    }
    public static void main(String[] args) {
        int num1=3;
        int num2=5;
        System.out.println(add(num1,num2));
        System.out.println(product(num1,num2));
    }
}