public class up_to_low {

    public static void main(String[] args) {
        
        for(char alpha='A'; alpha<='Z';alpha++){
            System.out.println((char)(alpha | ' '));
        }
    }
    
}
