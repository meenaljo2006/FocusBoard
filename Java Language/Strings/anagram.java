import java.util.Arrays;

public class anagram {

    public static void main(String[] args) {
        
        // anagram  string = having same alphabets in different order

        String str1 = "Earth";
        String str2 = "Heart";

        // Convert the string in Lowercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Length of both string should be same
        if(str1.length()==str2.length()){

            // convert string into character array
            char ch_str1[] = str1.toCharArray();
            char ch_str2[] = str2.toCharArray();

            // sort the character array
            Arrays.sort(ch_str1);
            Arrays.sort(ch_str2);

            boolean result = Arrays.equals(ch_str1, ch_str2);
            if(result==true){
                System.out.println("Anagram");
            }
            else{
                System.out.println("Not Anagram");
            }

        }
        else{
            System.out.println("Not Anagram");
        }



        
    }
    
}
