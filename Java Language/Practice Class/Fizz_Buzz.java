public class Fizz_Buzz {

    public static void main(String[] args) {
        
        int n =30;

        if(n%3==0 && n%5==0){
            System.out.println("Fizz-Buzz");
        }

        else if(n%3==0){
                System.out.println("Fizz");
        }
        else if(n%5==0){
                System.out.println("Buzz");
        }
        else{
                System.out.println(n);
        }

        

       
    }
    
}
