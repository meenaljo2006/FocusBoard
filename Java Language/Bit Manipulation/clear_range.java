public class clear_range {
    public static void main(String[] args) {
        int num = 10;
        int i =2;
        int j =4;

        int a = ~0<<j+1;
        int b = (1<<i)-1;
        
        int bitmask = a|b;
        int result = num&bitmask;

        System.out.println(result);

    }
    
}
