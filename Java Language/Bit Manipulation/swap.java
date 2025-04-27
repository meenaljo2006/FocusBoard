public class swap {

    public static void main(String[] args) {
        
        int x = 10;
        int y = 3;

        System.out.println("Before swap x = "+x +" and y = "+y);
        // swap

        x=x^y;
        y=x^y;
        x=x^y;

        System.out.println("After swap x = "+x +" and y = "+y);
    }
    
}
