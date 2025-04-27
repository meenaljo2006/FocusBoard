public class power_2 {

    public static void main(String[] args) {
        
        int num = 32;
        if((num&num-1)==0){
            System.out.println("Power of 2");
        }
        else{
            System.out.println("Not a power of 2");
        }
    }
    
}
