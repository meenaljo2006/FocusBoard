public class palindrome {

    public static void main(String[] args) {
        
        String word = "madam";
        int count = 1;
        for(int i=0;i<word.length()/2;i++){
            if(word.charAt(i)!=word.charAt(word.length()-i-1)){
                System.out.println("Not Palindrome");
                count =0;
                break;
            }
            count++;
        }
        if(count>1){
            System.out.println("Palindrome");
        }
        
        
    }
    
}
