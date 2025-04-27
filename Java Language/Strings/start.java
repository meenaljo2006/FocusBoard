public class start{

    public static void printLetters(String str){

        for(int i =0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }

    }

    public static void main(String[] args) {
        
        String firstName = "Meenal";
        String LastName = "Joshi";
        String FullName = firstName +" " +LastName;
        System.out.println(FullName);

        printLetters(FullName);
        
    }
}