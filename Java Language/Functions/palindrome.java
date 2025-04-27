public class palindrome {

    public static boolean Palindrome (int num ){
        int original = num;
        int reverse = 0;
        while(num>0){       //121
            int last_digit = num%10;
            num/=10;
            reverse = reverse*10+last_digit;
        }

        System.out.println(reverse);
        if(original==reverse){
            return true;
        }
        else{
            return false;
        }
        
    }

    public static void main(String[] args) {

        System.out.println(Palindrome(123));
        
    }
    
}
